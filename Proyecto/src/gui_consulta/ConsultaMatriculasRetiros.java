package gui_consulta;

import javax.swing.*;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNumMatricula, txtNumRetiro;
	private JTextArea txtResultado;
	private JButton btnBuscarMatricula, btnBuscarRetiro;

	ArrayMatricula matriculas = new ArrayMatricula();
	ArrayRetiro retiros = new ArrayRetiro();
	ArrayAlumnos alumnos = new ArrayAlumnos();
	ArrayCursos cursos = new ArrayCursos();

	public ConsultaMatriculasRetiros() {
		setTitle("Consulta Matrículas y Retiros");
		setSize(530, 460);
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

		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		JScrollPane scroll = new JScrollPane(txtResultado);
		scroll.setBounds(30, 110, 460, 280);
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
		txtResultado.setText("");
		int num;
		try {
			num = Integer.parseInt(txtNumMatricula.getText().trim());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Número inválido");
			return;
		}
		Matricula m = matriculas.buscar(num);
		if (m == null) {
			txtResultado.setText("No se encontró la matrícula.");
			return;
		}
		Alumno a = alumnos.buscar(m.getCodAlumno());
		Curso c = cursos.buscar(m.getCodCurso());

		StringBuilder sb = new StringBuilder();
		sb.append(">>> DATOS DE MATRÍCULA <<<\n\n");
		sb.append("N° Matrícula: ").append(m.getNumMatricula()).append("\n");
		sb.append("Fecha: ").append(m.getFecha()).append("\n");
		sb.append("Hora: ").append(m.getHora()).append("\n");

		sb.append("\n--- ALUMNO ---\n");
		sb.append("Código: ").append(a.getCodAlumno()).append("\n");
		sb.append("Nombre: ").append(a.getNombres()).append(" ").append(a.getApellidos()).append("\n");
		sb.append("DNI: ").append(a.getDni()).append("\n");

		sb.append("\n--- CURSO ---\n");
		sb.append("Código: ").append(c.getCodigo()).append("\n");
		sb.append("Asignatura: ").append(c.getAsignatura()).append("\n");

		txtResultado.setText(sb.toString());
	}

	private void consultarRetiro() {
		txtResultado.setText("");
		int num;
		try {
			num = Integer.parseInt(txtNumRetiro.getText().trim());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Número inválido");
			return;
		}
		Retiro r = retiros.buscar(num);
		if (r == null) {
			txtResultado.setText("No se encontró el retiro.");
			return;
		}
		Matricula m = matriculas.buscar(r.getNumMatricula());
		if (m == null) {
			txtResultado.setText("No se encontró la matrícula asociada.");
			return;
		}
		Alumno a = alumnos.buscar(m.getCodAlumno());
		Curso c = cursos.buscar(m.getCodCurso());

		StringBuilder sb = new StringBuilder();
		sb.append(">>> DATOS DE RETIRO <<<\n\n");
		sb.append("N° Retiro: ").append(r.getNumRetiro()).append("\n");
		sb.append("Fecha: ").append(r.getFecha()).append("\n");
		sb.append("Hora: ").append(r.getHora()).append("\n");

		sb.append("\n--- ALUMNO ---\n");
		sb.append("Código: ").append(a.getCodAlumno()).append("\n");
		sb.append("Nombre: ").append(a.getNombres()).append(" ").append(a.getApellidos()).append("\n");

		sb.append("\n--- CURSO ---\n");
		sb.append("Código: ").append(c.getCodigo()).append("\n");
		sb.append("Asignatura: ").append(c.getAsignatura()).append("\n");

		txtResultado.setText(sb.toString());
	}
}
