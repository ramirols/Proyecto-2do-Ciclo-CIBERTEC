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

public class ConsultaMatriculasRetiros extends JDialog implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField txtNumMatricula, txtNumRetiro;
    private JButton btnBuscarMatricula, btnBuscarRetiro;

    private JTable tablaResultado;
    private DefaultTableModel modeloTabla;

    ArrayMatricula matriculas = new ArrayMatricula();
    ArrayRetiro retiros = new ArrayRetiro();
    ArrayAlumnos alumnos = new ArrayAlumnos();
    ArrayCursos cursos = new ArrayCursos();

    public ConsultaMatriculasRetiros() {
        setTitle("Consulta Matrículas y Retiros");
        setSize(550, 460);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblMatricula = new JLabel("Número de matrícula:");
        lblMatricula.setBounds(30, 20, 150, 25);
        add(lblMatricula);

        txtNumMatricula = new JTextField();
        txtNumMatricula.setBounds(180, 20, 150, 25);
        add(txtNumMatricula);

        btnBuscarMatricula = new JButton("Buscar Matrícula");
        btnBuscarMatricula.setBounds(340, 20, 150, 25);
        btnBuscarMatricula.addActionListener(this);
        add(btnBuscarMatricula);

        JLabel lblRetiro = new JLabel("Número de retiro:");
        lblRetiro.setBounds(30, 60, 150, 25);
        add(lblRetiro);

        txtNumRetiro = new JTextField();
        txtNumRetiro.setBounds(180, 60, 150, 25);
        add(txtNumRetiro);

        btnBuscarRetiro = new JButton("Buscar Retiro");
        btnBuscarRetiro.setBounds(340, 60, 150, 25);
        btnBuscarRetiro.addActionListener(this);
        add(btnBuscarRetiro);

        String[] columnas = {"Campo", "Valor"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaResultado = new JTable(modeloTabla);
        tablaResultado.setEnabled(false);
		//Evitar que se puedan mover las columnas de lugar
        tablaResultado.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll = new JScrollPane(tablaResultado);
        scroll.setBounds(30, 110, 480, 280);
        add(scroll);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscarMatricula) {
            consultarMatricula();
        }
        if (e.getSource() == btnBuscarRetiro) {
            consultarRetiro();
        }
    }

    private void consultarMatricula() {
        modeloTabla.setRowCount(0); // limpieza de tabla

        int num;
        try {
            num = Integer.parseInt(txtNumMatricula.getText().trim());
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
            num = Integer.parseInt(txtNumRetiro.getText().trim());
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
