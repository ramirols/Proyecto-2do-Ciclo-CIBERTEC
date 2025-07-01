package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import clases.Alumno;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CMEAlumno extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tablaAlumnos;
	private DefaultTableModel mt;
	private JPanel panel;
	private JButton btnConsultar;
	private JLabel lblTitulo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CMEAlumno dialog = new CMEAlumno();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public CMEAlumno() {
		setTitle("Consultar, Modificar, Eliminar");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 558, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnModificar.setBounds(208, 390, 134, 42);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnEliminar.setBounds(391, 390, 134, 42);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 89, 503, 260);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 82, 527, 277);
		contentPane.add(panel);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnConsultar.setBounds(22, 390, 134, 42);
		contentPane.add(btnConsultar);
		
		lblTitulo = new JLabel("Datos de los estudiantes");
		lblTitulo.setFont(new Font("Papyrus", Font.PLAIN, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(90, 21, 374, 42);
		contentPane.add(lblTitulo);
		/////////////////////
		//Creacion de tabla//
		/////////////////////
		
		//Modelo de la tabla
		mt = new DefaultTableModel() {
			//Sobreescritura del metodo isCellEditable para deshabilitar la edicion de celdas
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			@Override
			//Sobreescritura del metodo getColumnClass para establecer la primera columna como tipos de datos enteros
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) { // Si la columna ID debe ser int
                    return Integer.class;
                }
                return super.getColumnClass(columnIndex);
            }
		};
		//Array de encabezados
		String[] encabezados = {"Codigo", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "Estado" };
		mt.setColumnIdentifiers(encabezados);
		//Creacion de la tabla
		tablaAlumnos = new JTable(mt);
		scrollPane.setViewportView(tablaAlumnos);
		// Creacion del TableRowSorter
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(mt); //creacion del sorter
        tablaAlumnos.setRowSorter(sorter); //adicion del sorter al JTable
        
        ArrayList<TableRowSorter.SortKey> sortKeys = new ArrayList<>(); //creacion del sortKeys para cada columna deseada
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); //Creacion de un sortKey para la columna codigo 
        sorter.setSortKeys(sortKeys); //adicion del sortKey al sorter
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	//Eventos de los botones
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		generarTabla();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		String str = ""; //Variable comodin para evitar errores por el retorno de nulos con el input
		int codigo = 0;
		int edad = 0;
		int celular = 0;
		int estado = 0;
		try {
			str = input("Ingresa el codigo del alumno que desea modificar", "");
			if (str == null) {
				return;
			}
			codigo = Integer.parseInt(str);
		} catch (NumberFormatException e2) {
			errorMsg("Ingrese datos numericos y apropiados");
			return;
		}
		//Iterar sobre las claves del hashmap alumnos
		for (String clave : Alumno.alumnos.keySet()) {
			
			Alumno varAlumno = Alumno.alumnos.get(clave); //variable auxiliar que contiene a un Alumno
			
			if (codigo == varAlumno.getCodAlumno()) { //Condicion para identificar al alumno por su codigo
				//Bloque nombres
				String nombres = input("Ingresa el/los nombres del alumno", varAlumno.getNombres());
				if (nombres == null) {
					return;
				}
				nombres = nombres.trim();
				if (nombres.equals("") || nombres.equals(" ")) { //Evitar nombres vacios
					errorMsg("El campo no puede estar vacio");
					return;
				}
				//Bloque apellidos
				String apellidos = input("Ingresa los apellidos del alumno", varAlumno.getApellidos());
				if (apellidos == null) {
					return;
				}
				apellidos = apellidos.trim();
				if (apellidos.equals("") || apellidos.equals(" ")) { //Evitar apellidos vacios
					errorMsg("El campo no puede estar vacio");
					return;
				}
				//Bloque edad
				str = input("Ingresa la edad del alumno",""+varAlumno.getEdad());
				if (str == null) {
					return;
				}
				try {
					edad = Integer.parseInt(str);
					if (edad > 65 || edad < 3) {
						errorMsg("Ingrese una edad apropiada");
						return;
					}
				}catch (NumberFormatException e2) {
					errorMsg("Ingresa datos numéricos");
					return;
				}
				//Bloque celular
				str = input("Ingresa el numero telefonico del alumno",""+ varAlumno.getCelular());
				if (str == null) {
					return;
				}
				try {
				celular = Integer.parseInt(str);
					if (str.length() != 9) { 
						errorMsg("La cantidad de digitos ingresados debe ser nueve");
						return;
					}
				} catch (NumberFormatException e2) {
					errorMsg("La cantidad de digitos ingresados debe ser nueve");
					return;
				}
				//Bloque estado
				str = input("Ingresa el estado del alumno", ""+varAlumno.getEstado());
				if (str == null) {
					return;
				}
				try {
					estado = Integer.parseInt(str);
					if (estado < 0 || estado > 3) {
						errorMsg("el estado solo admite los valores: 0, 1, 2");
						return;
					}
				} catch (NumberFormatException e2) {
					errorMsg("el estado solo admite los valores: 0, 1, 2");
					return;
				}
				setters(varAlumno, nombres, apellidos, edad, celular, estado);
				generarTabla();
				return;
			}
		}
		errorMsg("El codigo ingresado no existe");
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int codigo = Integer.parseInt(input("Ingresa el codigo del alumno que desea eliminar", ""));
		for (String clave : Alumno.alumnos.keySet()) {
			
			Alumno varAlumno = Alumno.alumnos.get(clave);
			
			if (codigo == varAlumno.getCodAlumno()){
				if (varAlumno.getEstado() == 0) { 
					int rpta = confirmDialog("¿Seguro que quieres eliminar al alumno " + varAlumno.getNombres() + " ?");
					if (rpta == 0) {
						Alumno.alumnos.remove(clave);
						JOptionPane.showMessageDialog(null, "El Alumno ha sido borrado de la lista");
						generarTabla();
						return;
					}
					else {
						return;
					}
				}
				else {
					errorMsg("El alumno no tiene un estado 0 (registrado)");
					return;
				}
			}
		}
		errorMsg("El codigo no existe");
	}
	
	//Metodos
	void generarTabla() {
		mt.setRowCount(0);
		String[] datos = new String[7];
		for (String clave : Alumno.alumnos.keySet()) {
			datos[0] = "" + Alumno.alumnos.get(clave).getCodAlumno();
			datos[1] = Alumno.alumnos.get(clave).getNombres();
			datos[2] = Alumno.alumnos.get(clave).getApellidos();
			datos[3] = Alumno.alumnos.get(clave).getDni();
			datos[4] = "" + Alumno.alumnos.get(clave).getEdad();
			datos[5] = "" + Alumno.alumnos.get(clave).getCelular();
			datos[6] = "" + Alumno.alumnos.get(clave).getEstado();
			mt.addRow(datos);
		}
	}
	String input(String msg, String placeholder) {
		return JOptionPane.showInputDialog(msg, placeholder);
	}
	void errorMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	int confirmDialog(String msg) {
		return JOptionPane.showConfirmDialog(null, msg, "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
	}
	void setters(Alumno alumno, String nombres, String apellidos, int edad, int celular, int estado) {
		alumno.setNombres(nombres);
		alumno.setApellidos(apellidos);
		alumno.setEdad(edad);
		alumno.setCelular(celular);
		alumno.setEstado(estado);
	}
}
