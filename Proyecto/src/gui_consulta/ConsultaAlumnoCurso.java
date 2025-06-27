package gui_consulta;

import javax.swing.*;
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
	private JTextArea txtResultado;
	private JButton btnBuscar;

	ArrayAlumnos alumnos = new ArrayAlumnos();
	ArrayMatricula matriculas = new ArrayMatricula();
	ArrayCursos cursos = new ArrayCursos();

	public ConsultaAlumnoCurso() {
		setTitle("Consulta Alumno y Curso");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setLayout(null);

		JLabel lblCodigo = new JLabel("Código del alumno:");
		lblCodigo.setBounds(30, 30, 150, 25);
		add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(180, 30, 150, 25);
		add(txtCodigo);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(340, 30, 100, 25);
		btnBuscar.addActionListener(this);
		add(btnBuscar);

		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		JScrollPane scroll = new JScrollPane(txtResultado);
		scroll.setBounds(30, 80, 410, 250);
		add(scroll);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			consultar();
		}
	}

	private void consultar() {
		txtResultado.setText("");
		int cod;
		try {
			cod = Integer.parseInt(txtCodigo.getText().trim());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Código inválido");
			return;
		}
		Alumno alu = alumnos.buscar(cod);
		if (alu == null) {
			txtResultado.setText("Alumno no encontrado.");
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("CÓDIGO: ").append(alu.getCodAlumno()).append("\n");
		sb.append("NOMBRES: ").append(alu.getNombres()).append("\n");
		sb.append("APELLIDOS: ").append(alu.getApellidos()).append("\n");
		sb.append("DNI: ").append(alu.getDni()).append("\n");
		sb.append("EDAD: ").append(alu.getEdad()).append("\n");
		sb.append("CELULAR: ").append(alu.getCelular()).append("\n");
		sb.append("ESTADO: ").append(switch (alu.getEstado()) {
			case 0 -> "REGISTRADO";
			case 1 -> "MATRICULADO";
			case 2 -> "RETIRADO";
			default -> "DESCONOCIDO";
		}).append("\n");

		if (alu.getEstado() == 1) {
			Matricula mat = matriculas.buscarCod(cod);
			if (mat != null) {
				Curso cur = cursos.buscar(mat.getCodCurso());
				if (cur != null) {
					sb.append("\n--- CURSO MATRICULADO ---\n");
					sb.append("Código Curso: ").append(cur.getCodigo()).append("\n");
					sb.append("Asignatura: ").append(cur.getAsignatura()).append("\n");
					sb.append("Ciclo: ").append(cur.getCiclo()).append("\n");
					sb.append("Créditos: ").append(cur.getCreditos()).append("\n");
					sb.append("Horas: ").append(cur.getHoras()).append("\n");
				}
			}
		}

		txtResultado.setText(sb.toString());
	}
}
