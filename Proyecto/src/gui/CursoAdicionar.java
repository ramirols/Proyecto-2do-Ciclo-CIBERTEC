package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import clases.Curso;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CursoAdicionar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JLabel lblAsignatura;
	private JLabel lblCiclo;
	private JLabel lblNumeroDeCreditos;
	private JLabel lblCantidadDeHoras;
	private JTextField txtAsignatura;
	private JTextField txtCodigo;
	private JTextField txtCiclo;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JButton btnAdicionar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CursoAdicionar dialog = new CursoAdicionar();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public CursoAdicionar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Código:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 29, 91, 23);
		getContentPane().add(lblCodigo);
		
		lblAsignatura = new JLabel("Asignatura:");
		lblAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAsignatura.setBounds(10, 77, 91, 23);
		getContentPane().add(lblAsignatura);
		
		lblCiclo = new JLabel("Ciclo:");
		lblCiclo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCiclo.setBounds(10, 121, 91, 23);
		getContentPane().add(lblCiclo);
		
		lblNumeroDeCreditos = new JLabel("Número de creditos:");
		lblNumeroDeCreditos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDeCreditos.setBounds(10, 185, 131, 23);
		getContentPane().add(lblNumeroDeCreditos);
		
		lblCantidadDeHoras = new JLabel("Cantidad de horas:");
		lblCantidadDeHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadDeHoras.setBounds(10, 218, 131, 23);
		getContentPane().add(lblCantidadDeHoras);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAsignatura.setBounds(85, 81, 96, 19);
		getContentPane().add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(85, 33, 96, 19);
		getContentPane().add(txtCodigo);
		
		txtCiclo = new JTextField();
		txtCiclo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCiclo.setColumns(10);
		txtCiclo.setBounds(85, 125, 96, 19);
		getContentPane().add(txtCiclo);
		
		txtCreditos = new JTextField();
		txtCreditos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(151, 189, 47, 19);
		getContentPane().add(txtCreditos);
		
		txtHoras = new JTextField();
		txtHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHoras.setColumns(10);
		txtHoras.setBounds(151, 222, 47, 19);
		getContentPane().add(txtHoras);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdicionar.setBounds(248, 32, 131, 39);
		getContentPane().add(btnAdicionar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCerrar.setBounds(248, 94, 131, 39);
		getContentPane().add(btnCerrar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		int codigo = 0;
		int ciclo = 0;
		int creditos = 0;
		int horas = 0;
		//Bloque codigo
		try {
			codigo = Integer.parseInt(txtCodigo.getText());
			if (txtCodigo.getText().length() != 4) {
				errorMsg("El código debe ser de cuatro digitos");
				return;
			}
		}catch (Exception e2) {
			errorMsg("El campo código debe contener valores numéricos");
			return;
		}
		//Bloque asignatura
		String asignatura = txtAsignatura.getText().trim();
		if (asignatura.equals("") || asignatura.equals(" ")) {
			errorMsg("El campo asignatura no puede estar vacío");
			return;
		}
		//Bloque ciclo
		try {
			ciclo = Integer.parseInt(txtCiclo.getText());
			if (txtCiclo.getText().length() != 1) {
				errorMsg("Solo se admite un dígito para el campo ciclo");
				return;
			}
		}catch (Exception e2) {
			errorMsg("Ingresa datos numéricos en el campo ciclo");
			return;
		}
		//Bloque creditos
		try	{
			creditos = Integer.parseInt(txtCreditos.getText());
			if (txtCreditos.getText().length() > 2 && txtCreditos.getText().length() < 1) {
				errorMsg("El campo creditos debe tener 2 digitos como maximo");
				return;
			}
		} catch (Exception e2) {
			errorMsg("Ingresa datos numéricos en el campo creditos");
			return;
		}
		try {
			horas = Integer.parseInt(txtHoras.getText());
			if (txtHoras.getText().length() > 2 && txtHoras.getText().length() < 1) {
				errorMsg("El campo horas debe tener 2 digitos como maximo");
				return;
			}
		} catch (Exception e2) {
			errorMsg("Ingresa datos numéricos en el campo horas");
			return;
		}

		for (Integer clave : Curso.cursos.keySet()) {
			if (Curso.cursos.get(clave).getCodigo() == codigo) {
				errorMsg("Ya existe un curso con ese codigo");
				return;
			}
		}
		Curso.cursos.put(codigo, new Curso(codigo, asignatura, ciclo, creditos, horas));
		showMsg("Se agrego correctamente la asignatura " + asignatura + " a la lista de cursos");
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	void errorMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	void showMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

}
