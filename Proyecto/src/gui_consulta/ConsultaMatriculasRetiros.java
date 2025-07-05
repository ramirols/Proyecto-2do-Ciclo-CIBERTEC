package gui_consulta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import clases.Retiro;
import colecciones.ArrayAlumnos;
import colecciones.ArrayCursos;
import colecciones.ArrayMatricula;
import colecciones.ArrayRetiro;

public class ConsultaMatriculasRetiros extends JDialog implements ActionListener, ItemListener {
    private static final long serialVersionUID = 1L;
    
    private JComboBox<String> cbTipoConsulta;
    private JLabel lblNumero;
    private JTextField txtNumero;
    private JButton btnConsultar;

    private JTable tablaResultado;
    private DefaultTableModel modeloTabla;

    ArrayMatricula matriculas = new ArrayMatricula();
    ArrayRetiro retiros = new ArrayRetiro();
    ArrayAlumnos alumnos = new ArrayAlumnos();
    ArrayCursos cursos = new ArrayCursos();

    public ConsultaMatriculasRetiros() {
        setTitle("Consulta Matrículas y Retiros");
        
        setIconImage(new ImageIcon(getClass().getResource("/imgs/favicon.png")).getImage());
        
        setSize(550, 460);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTipo = new JLabel("Tipo de consulta:");
        lblTipo.setBounds(30, 20, 120, 25);
        add(lblTipo);

        cbTipoConsulta = new JComboBox<>(new String[]{"Matrícula", "Retiro"});
        cbTipoConsulta.setBounds(150, 20, 150, 25);
        cbTipoConsulta.addItemListener(this);
        add(cbTipoConsulta);

        lblNumero = new JLabel("Número de matrícula:");
        lblNumero.setBounds(30, 60, 150, 25);
        add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(180, 60, 150, 25);
        add(txtNumero);

        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(340, 60, 150, 25);
        btnConsultar.addActionListener(this);
        add(btnConsultar);

        String[] columnas = {"Campo", "Valor"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaResultado = new JTable(modeloTabla);
        tablaResultado.setEnabled(false);
        tablaResultado.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll = new JScrollPane(tablaResultado);
        scroll.setBounds(30, 110, 480, 280);
        add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = (String) cbTipoConsulta.getSelectedItem();
        if (opcion.equals("Matrícula")) {
            consultarMatricula();
        } else if (opcion.equals("Retiro")) {
            consultarRetiro();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cbTipoConsulta && e.getStateChange() == ItemEvent.SELECTED) {
            String opcion = (String) cbTipoConsulta.getSelectedItem();
            if (opcion.equals("Matrícula")) {
                lblNumero.setText("Número de matrícula:");
            } else {
                lblNumero.setText("Número de retiro:");
            }
            txtNumero.setText(""); // estado de limpieza del campo
        }
    }

    private void consultarMatricula() {
        modeloTabla.setRowCount(0); // limpieza de tabla
        int num;
        try {
            num = Integer.parseInt(txtNumero.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Número inválido");
            return;
        }

        Matricula m = matriculas.buscar(num);
        if (m == null) {
            JOptionPane.showMessageDialog(this, "No se encontró la matrícula.");
            return;
        }

        Alumno a = alumnos.buscar(m.getCodAlumno());
        Curso c = cursos.buscar(m.getCodCurso());

        modeloTabla.addRow(new Object[]{">>> DATOS DE MATRÍCULA <<<", ""});
        modeloTabla.addRow(new Object[]{"N° Matrícula", m.getNumMatricula()});
        modeloTabla.addRow(new Object[]{"Fecha", m.getFecha()});
        modeloTabla.addRow(new Object[]{"Hora", m.getHora()});
        modeloTabla.addRow(new Object[]{"--- ALUMNO ---", ""});
        modeloTabla.addRow(new Object[]{"Código", a.getCodAlumno()});
        modeloTabla.addRow(new Object[]{"Nombre", a.getNombres() + " " + a.getApellidos()});
        modeloTabla.addRow(new Object[]{"DNI", a.getDni()});
        modeloTabla.addRow(new Object[]{"--- CURSO ---", ""});
        modeloTabla.addRow(new Object[]{"Código", c.getCodigo()});
        modeloTabla.addRow(new Object[]{"Asignatura", c.getAsignatura()});
    }

    private void consultarRetiro() {
        modeloTabla.setRowCount(0); // limpieza de tabla
        int num;
        try {
            num = Integer.parseInt(txtNumero.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Número inválido");
            return;
        }

        Retiro r = retiros.buscar(num);
        if (r == null) {
            JOptionPane.showMessageDialog(this, "No se encontró el retiro.");
            return;
        }

        Matricula m = matriculas.buscar(r.getNumMatricula());
        if (m == null) {
            JOptionPane.showMessageDialog(this, "No se encontró la matrícula asociada.");
            return;
        }

        Alumno a = alumnos.buscar(m.getCodAlumno());
        Curso c = cursos.buscar(m.getCodCurso());

        modeloTabla.addRow(new Object[]{">>> DATOS DE RETIRO <<<", ""});
        modeloTabla.addRow(new Object[]{"N° Retiro", r.getNumRetiro()});
        modeloTabla.addRow(new Object[]{"Fecha", r.getFecha()});
        modeloTabla.addRow(new Object[]{"Hora", r.getHora()});
        modeloTabla.addRow(new Object[]{"--- ALUMNO ---", ""});
        modeloTabla.addRow(new Object[]{"Código", a.getCodAlumno()});
        modeloTabla.addRow(new Object[]{"Nombre", a.getNombres() + " " + a.getApellidos()});
        modeloTabla.addRow(new Object[]{"--- CURSO ---", ""});
        modeloTabla.addRow(new Object[]{"Código", c.getCodigo()});
        modeloTabla.addRow(new Object[]{"Asignatura", c.getAsignatura()});
    }
}
