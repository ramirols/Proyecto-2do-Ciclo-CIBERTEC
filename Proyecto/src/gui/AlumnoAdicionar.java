package gui;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import clases.Alumno;

public class AlumnoAdicionar extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblEdad;
	private JLabel lblCelular;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtCelular;
	private JTextField txtEdad;
	private JButton btnAdicionar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlumnoAdicionar dialog = new AlumnoAdicionar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlumnoAdicionar() {
		setTitle("Adicionar");
		setBounds(100, 100, 450, 258);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombres.setBounds(10, 21, 79, 18);
		contentPanel.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(10, 59, 79, 18);
		contentPanel.add(lblApellidos);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(10, 98, 79, 18);
		contentPanel.add(lblDni);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEdad.setBounds(10, 139, 79, 18);
		contentPanel.add(lblEdad);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(10, 180, 79, 18);
		contentPanel.add(lblCelular);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(79, 23, 96, 19);
		contentPanel.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(79, 61, 96, 19);
		contentPanel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(79, 100, 96, 19);
		contentPanel.add(txtDni);
		txtDni.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(79, 182, 96, 19);
		contentPanel.add(txtCelular);
		txtCelular.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(79, 141, 96, 19);
		contentPanel.add(txtEdad);
		txtEdad.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdicionar.setBounds(254, 32, 130, 45);
		contentPanel.add(btnAdicionar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCerrar.setBounds(254, 99, 130, 45);
		contentPanel.add(btnCerrar);
		
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
		String dni = "";
		int edad = 0;
		int celular = 0;
		//Bloque nombres y apellidos
		String nombres = txtNombres.getText().trim();
		if (nombres.equals("") || nombres.equals(" ")) {
			errorMsg("El campo nombres no puede estar vacio");
			return;
		}
		String apellidos = txtApellidos.getText().trim();
		if (apellidos.equals("") || apellidos.equals(" ")) {
			errorMsg("El campo apellidos no puede estar vacio");
			return;
		}
		//Bloque DNI
		try {
			Integer.parseInt(txtDni.getText());
			dni = txtDni.getText();
			if (txtDni.getText().length() != 8) {
				errorMsg("La cantidad de digitos en el campo DNI debe ser ocho");
				return;
			}
		} catch (Exception e2) {
			errorMsg("El campo DNI tiene que contener solo valores numéricos");
			return;
		}
		//Bloque edad
		try {
			edad = Integer.parseInt(txtEdad.getText());
			if (edad > 65) {
				errorMsg("Introduce una edad adecuada");
				return;
			}
		} catch (Exception e2) {
			errorMsg("El campo edad tiene que contener solo valores numéricos");
			return;
		}
		//Bloque celular
		try {
			celular = Integer.parseInt(txtCelular.getText());
			
			if (txtCelular.getText().length() != 9) {
				errorMsg("La cantidad de digitos en el campo celular debe ser nueve");
				return;
			}
			/*
			if (txtCelular.getText().charAt(0) != '9') {
				errorMsg("Todos los números moviles deben iniciar con 9");
			}
			*/
		} catch (Exception e2) {
			errorMsg("El campo celular tiene que contener solo valores numéricos");
			return;
		}
		for (String clave : Alumno.alumnos.keySet()) {
			if (Alumno.alumnos.get(clave).getDni().equals(dni)) {
				errorMsg("Ya existe un estudiante registrado con ese DNI");
				return;
			}
		}
		
		int codAlumno=0;
		int estado=0;
		Alumno.alumnos.put(dni, new Alumno( codAlumno,  nombres,  apellidos,  dni,  edad,  celular,  estado));
		
		showMsg("Se agrego correctamente al estudiante " + nombres + " a la lista de alumnos");
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	//Metodos
	void errorMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	void showMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

}
