package gui_consulta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import colecciones.ArrayAlumnos;
import colecciones.ArrayCursos;
import colecciones.ArrayMatricula;

public class ConsultaAlumnoCurso extends JDialog implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField txtCodigo;
    private JButton btnBuscar;
    private JTable tablaResultado;
    private DefaultTableModel modeloTabla;

    ArrayAlumnos alumnos = new ArrayAlumnos();
    ArrayMatricula matriculas = new ArrayMatricula();
    ArrayCursos cursos = new ArrayCursos();

    public ConsultaAlumnoCurso() {
        setTitle("Consulta Alumno y Curso");
        setSize(550, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblCodigo = new JLabel("Código del alumno:");
        lblCodigo.setBounds(30, 30, 150, 25);
        getContentPane().add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(180, 30, 150, 25);
        getContentPane().add(txtCodigo);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(340, 30, 100, 25);
        btnBuscar.addActionListener(this);
        getContentPane().add(btnBuscar);

        String[] columnas = {"Campo", "Valor"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaResultado = new JTable(modeloTabla);
        tablaResultado.setEnabled(false);
		//Evitar que se puedan mover las columnas de lugar
        tablaResultado.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll = new JScrollPane(tablaResultado);
        scroll.setBounds(30, 80, 480, 250);
        getContentPane().add(scroll);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            consultar();
        }
    }

    private void consultar() {
        modeloTabla.setRowCount(0); // limpieza de tabla
        int cod;
        try {
            cod = Integer.parseInt(txtCodigo.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido");
            return;
        }
        Alumno alu = alumnos.buscar(cod);
        if (alu == null) {
            JOptionPane.showMessageDialog(this, "Alumno no encontrado.");
            return;
        }

        String estado = switch (alu.getEstado()) {
            case 0 -> "REGISTRADO";
            case 1 -> "MATRICULADO";
            case 2 -> "RETIRADO";
            default -> "DESCONOCIDO";
        };

        modeloTabla.addRow(new Object[]{"CÓDIGO", alu.getCodAlumno()});
        modeloTabla.addRow(new Object[]{"NOMBRES", alu.getNombres()});
        modeloTabla.addRow(new Object[]{"APELLIDOS", alu.getApellidos()});
        modeloTabla.addRow(new Object[]{"DNI", alu.getDni()});
        modeloTabla.addRow(new Object[]{"EDAD", alu.getEdad()});
        modeloTabla.addRow(new Object[]{"CELULAR", alu.getCelular()});
        modeloTabla.addRow(new Object[]{"ESTADO", estado});

        if (alu.getEstado() == 1) {
            Matricula mat = matriculas.buscarCod(cod);
            if (mat != null) {
                Curso cur = cursos.buscar(mat.getCodCurso());
                if (cur != null) {
                    modeloTabla.addRow(new Object[]{"--- CURSO MATRICULADO ---", ""});
                    modeloTabla.addRow(new Object[]{"Código Curso", cur.getCodigo()});
                    modeloTabla.addRow(new Object[]{"Asignatura", cur.getAsignatura()});
                    modeloTabla.addRow(new Object[]{"Ciclo", cur.getCiclo()});
                    modeloTabla.addRow(new Object[]{"Créditos", cur.getCreditos()});
                    modeloTabla.addRow(new Object[]{"Horas", cur.getHoras()});
                }
            }
        }
    }
}
