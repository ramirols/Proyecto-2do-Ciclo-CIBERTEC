package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import clases.Alumno;
import colecciones.ArrayAlumnos;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class MantenimientoAlumno extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblEdad;
	private JLabel lblCelular;
	private JLabel lblDni;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtCelular;
	private JTextField txtDni;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JComboBox<String> cboOpciones;
	private JPanel inputs;
	private Border lineBorder;
	private JScrollPane scrollPane;
	private JTable tablaAlumnos;
	private DefaultTableModel mt;
	private JButton btnAceptar;
	private JLabel lblEstado;
	private JTextField txtEstado;
	private JButton btnListar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoAlumno dialog = new MantenimientoAlumno();
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

	@SuppressWarnings("serial")
	public MantenimientoAlumno() {
		setTitle("Mantenimiento | Persona");
		setBounds(100, 100, 900, 650);
		getContentPane().setLayout(null);
		
		lblCdigo = new JLabel("Código");
		lblCdigo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCdigo.setBounds(527, 35, 78, 36);
		getContentPane().add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(615, 40, 96, 34);
		getContentPane().add(txtCodigo);
		
		cboOpciones = new JComboBox<String>();
		cboOpciones.addActionListener(this);
		cboOpciones.setFont(new Font("Tahoma", Font.BOLD, 16));
		cboOpciones.setModel(new DefaultComboBoxModel<String>(new String[] {"Adicionar", "Consultar", "Modificar", "Eliminar"}));
		cboOpciones.setBounds(721, 39, 131, 35);
		getContentPane().add(cboOpciones);
		
		lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
		inputs = new JPanel();
		inputs.setBackground(new Color(244, 244, 244));
		inputs.setBounds(27, 27, 343, 203);
		getContentPane().add(inputs);
		inputs.setLayout(null);
		inputs.setBorder(lineBorder);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(105, 13, 159, 19);
		inputs.add(txtNombres);
		txtNombres.setColumns(10);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 10, 85, 21);
		inputs.add(lblNombres);
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(105, 45, 159, 19);
		inputs.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 42, 85, 21);
		inputs.add(lblApellidos);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtCelular = new JTextField();
		txtCelular.setBounds(105, 77, 108, 19);
		inputs.add(txtCelular);
		txtCelular.setColumns(10);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 74, 85, 21);
		inputs.add(lblCelular);
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtDni = new JTextField();
		txtDni.setBounds(105, 109, 108, 19);
		inputs.add(txtDni);
		txtDni.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 106, 85, 21);
		inputs.add(lblDni);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 138, 85, 21);
		inputs.add(lblEdad);
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtEdad = new JTextField();
		txtEdad.setBounds(104, 141, 60, 19);
		inputs.add(txtEdad);
		txtEdad.setColumns(10);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstado.setBounds(10, 169, 85, 21);
		inputs.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(104, 172, 60, 19);
		inputs.add(txtEstado);
		
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(527, 116, 149, 35);
        getContentPane().add(btnAceptar);
        btnAceptar.setBackground(new Color(222, 222, 222));
        btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        btnListar = new JButton("Listar");
        btnListar.addActionListener(this);
        btnListar.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnListar.setBackground(new Color(222, 222, 222));
        btnListar.setBounds(703, 116, 149, 35);
        getContentPane().add(btnListar);
        btnAceptar.addActionListener(this);
        
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 240, 866, 340);
		getContentPane().add(scrollPane);
		
		
		//Modelo de la tabla
		mt = new DefaultTableModel() {
            @Override //Sobreescritura del metodo isCellEditable para deshabilitar la posibilidad de editar celdas al seleccionarlas
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		//Array de encabezados
		String[] encabezados = {"Codigo", "Nombres", "Apellidos", "DNI", "Edad", "Celular", "Estado" };
		mt.setColumnIdentifiers(encabezados);
		
		//Creacion de la tabla
		tablaAlumnos = new JTable(mt);
		scrollPane.setViewportView(tablaAlumnos);
		//MOUSE LISTENER PARA SELECCIONAR DATOS EN LA PARTE DE MODIFICAR
		tablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        if (leerOpcion() == 2) { // Solo si está en "Modificar"
		            int fila = tablaAlumnos.getSelectedRow();
		            if (fila != -1) {
		                // Si estás usando un sorter, convierte la fila a su índice real:
		                int modeloFila = tablaAlumnos.convertRowIndexToModel(fila);
		                
		                txtCodigo.setText(mt.getValueAt(modeloFila, 0).toString());
		                txtNombres.setText(mt.getValueAt(modeloFila, 1).toString());
		                txtApellidos.setText(mt.getValueAt(modeloFila, 2).toString());
		                txtDni.setText(mt.getValueAt(modeloFila, 3).toString());
		                txtEdad.setText(mt.getValueAt(modeloFila, 4).toString());
		                txtCelular.setText(mt.getValueAt(modeloFila, 5).toString());
		                txtEstado.setText(mt.getValueAt(modeloFila, 6).toString());
		            }
		        }
		    }
		});

		//Evitar que se puedan mover las columnas de lugar
		tablaAlumnos.getTableHeader().setReorderingAllowed(false);
		//Evitar que se seleccionen mas de una fila
		tablaAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tablaAlumnos.getColumnModel().getColumn(1).setPreferredWidth(200); //Ancho de la columna 2
		tablaAlumnos.getColumnModel().getColumn(2).setPreferredWidth(200); //Ancho de la columna 3
		
		// Creacion del TableRowSorter
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(mt); //creacion del sorter
        tablaAlumnos.setRowSorter(sorter); //adicion del sorter al JTable
        
        ArrayList<TableRowSorter.SortKey> sortKeys = new ArrayList<>(); //creacion del sortKeys para manipular la columna deseada
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); //Creacion de un sortKey para la columna codigo 
        sorter.setSortKeys(sortKeys); //adicion del sortKey al sorter
        
        txtCodigo.setEditable(false);
        txtEstado.setEditable(false);
        listar();

	}
	ArrayAlumnos aa = new ArrayAlumnos();
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == cboOpciones) {
			actionPerformedCboOpciones(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedCboOpciones(ActionEvent e) {
		int opcion = cboOpciones.getSelectedIndex();
		switch(opcion){
			case 1: 
				switchTxtFields(opcion);
				txtCodigo.setText("");
				limpiarTxtFields();
				break;
			case 2:
				switchTxtFields(opcion);
				break;
			case 3:
				switchTxtFields(opcion);
				break;
			default:
				switchTxtFields(opcion);
				break;
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
	    int opcion = leerOpcion();
	    switch (opcion) {
	        case 0: // Adicionar
	            Alumno alumnoX = generarAlumno();
	            if (alumnoX == null) return;
	            aa.adicionarAlumno(alumnoX);
	            aa.ActualizarArchivo();
	            listar();
	            break;

	        case 1: // Consultar
	            for (int i = 0; i < aa.tamanio(); i++) {
	                Alumno alumno = aa.obtener(i);
	                if (leerCodigo() == alumno.getCodAlumno()) {
	                    txtNombres.setText(alumno.getNombres());
	                    txtApellidos.setText(alumno.getApellidos());
	                    txtCelular.setText(String.valueOf(alumno.getCelular()));
	                    txtDni.setText(alumno.getDni());
	                    txtEdad.setText(String.valueOf(alumno.getEdad()));
	                    txtEstado.setText(String.valueOf(alumno.getEstado()));
	                    listarAlum(alumno);
	                    return;
	                }else if (leerCodigo() == -1) {
	                	errorMsg("Ingrese un codigo");
	                	return;
	                }
	            }
	            errorMsg("El código ingresado no existe");
	            break;

	        case 2: // Modificar
	            for (int i = 0; i < aa.tamanio(); i++) {
	                Alumno alumno = aa.obtener(i);
	                if (leerCodigo() == alumno.getCodAlumno()) {
	                    if (!leerNombres().isEmpty()) {
	                        if (!leerApellidos().isEmpty()) {
	                            try {
	                                alumno.setCelular(leerCelular());
	                                alumno.setEdad(leerEdad());
	                                alumno.setEstado(leerEstado());
	                                alumno.setNombres(leerNombres());
	                                alumno.setApellidos(leerApellidos());
	                                aa.ActualizarArchivo();
	                                listar();
	                                showMsg("El alumno fue modificado con éxito"); 
	                                return;
	                            } catch (Exception e2) {
	                                errorMsg("Ingrese datos correctos en los campos numéricos");
	                                return;
	                            }
	                        } else {
	                            errorMsg("El campo apellidos no puede estar vacío");
	                            return;
	                        }
	                    } else {
	                        errorMsg("El campo nombres no puede estar vacío");
	                        return;
	                    }
	                }else if (leerCodigo() == -1){
	                	errorMsg("Ingrese un codigo");
	                	return;
	                }
	            }
	            errorMsg("El código ingresado no existe");
	            break;

	        case 3: // Eliminar
	            for (int i = 0; i < aa.tamanio(); i++) {
	                Alumno alumX = aa.obtener(i);
	                if (leerCodigo() == alumX.getCodAlumno()) {
	                    if (alumX.getEstado() == 0) {
	                        int rpta = confirmDialog("¿Seguro que quieres eliminar al alumno " + alumX.getNombres() + " ?");
	                        if (rpta == 0) {
	                            aa.eliminarAlumno(i);
	                            aa.ActualizarArchivo();
	                            JOptionPane.showMessageDialog(this, "El Alumno ha sido borrado de la lista");
	                            listar();
	                            return;
	                        } else {
	                            return;
	                        }
	                    } else {
	                        errorMsg("El alumno no tiene un estado 0 (registrado)");
	                        return;
	                    }
	                }else if (leerCodigo() == -1){
	                	errorMsg("Ingrese un codigo");
	                	return;
	                }
	            }
	            errorMsg("El código ingresado no existe");
	            break;

	        default:
	            errorMsg("Seleccione una opción válida");
	            break;
	    }
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		listar();
	}
	//Metodos con relacion a Alumnos
	Alumno generarAlumno(){
		try {
	        String nombres = leerNombres().trim().toUpperCase();
	        String apellidos = leerApellidos().trim().toUpperCase();
	        String dni = leerDNI().trim();

	        if (nombres.isEmpty()) {
	            errorMsg("El campo nombres no puede estar vacío");
	            return null;
	        }
	        if (apellidos.isEmpty()) {
	            errorMsg("El campo apellidos no puede estar vacío");
	            return null;
	        }
	        if (!dni.matches("\\d{8}")) {
	            errorMsg("El DNI debe contener exactamente 8 dígitos");
	            return null;
	        }

	        for (int i = 0; i < aa.tamanio(); i++) {
	            if (aa.obtener(i).getDni().equals(dni)) {
	                errorMsg("El DNI ingresado ya existe");
	                return null;
	            }
	        }

	        int edad = leerEdad();
	        if (edad < 4 || edad > 65) {
	            errorMsg("Introduce una edad entre 4 y 65");
	            return null;
	        }

	        int celular = leerCelular();

	        // Generar código de alumno automáticamente desde ArrayAlumnos
	        int codAlumno = aa.codigoCorrelativo();

	        // Estado inicial en 0 (REGISTRADO)
	        Alumno nuevo = new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, 0);
	        limpiarTxtFields();
	        return nuevo;

	    } catch (Exception e) {
	        errorMsg("Ingrese datos válidos en los campos numéricos");
	        return null;
	    }
	}
	//Metodos complementarios
	void listar() {
		mt.setRowCount(0);
		for (int i = 0; i < aa.tamanio(); i++) {
			Alumno x = aa.obtener(i);
			Object[] filas = {		  //Columnas// 	
					x.getCodAlumno(), // Codigo
					x.getNombres(),   // Nombres
					x.getApellidos(), // Apellidos
					x.getDni(),		  // DNI
					x.getEdad(),	  // Edad
					x.getCelular(),   // Celular
					x.getEstado()     // Estado
			};
			mt.addRow(filas);
		}
	}
	void listarAlum(Alumno alu) {
		mt.setRowCount(0);
			Object[] filas = {		  //Columnas// 	
					alu.getCodAlumno(), // Codigo
					alu.getNombres(),   // Nombres
					alu.getApellidos(), // Apellidos
					alu.getDni(),		  // DNI
					alu.getEdad(),	  // Edad
					alu.getCelular(),   // Celular
					alu.getEstado()     // Estado
			};
			mt.addRow(filas);
		}
	void switchTxtFields(int opcion) {
		if (opcion == 1 || opcion == 3) {
			txtNombres.setEditable(false);
			txtApellidos.setEditable(false);
			txtEdad.setEditable(false);
			txtDni.setEditable(false);
			txtCelular.setEditable(false);
			txtEstado.setEditable(false);
			txtCodigo.setEditable(true);
		}
		else {
			txtNombres.setEditable(true);
			txtApellidos.setEditable(true);
			txtEdad.setEditable(true);
			txtDni.setEditable(true);
			txtCelular.setEditable(true);
			txtEstado.setEditable(false);
			txtCodigo.setEditable(false);
			if (opcion == 2) {
				txtDni.setEditable(false);
				txtEstado.setEditable(true);
				txtCodigo.setEditable(true);
			}
		}
	}
	
	//Metodos de lectura de datos
	String leerNombres() {
		return txtNombres.getText().trim();
	}
	String leerApellidos() {
		return txtApellidos.getText().trim();
	}
	String leerDNI() {
		return txtDni.getText().trim();
	}
	int leerEdad() {
		return Integer.parseInt(txtEdad.getText().trim());
	}
	int leerCelular() {
		return Integer.parseInt(txtCelular.getText().trim());
	}
	int leerCodigo() {
		if (txtCodigo.getText().isEmpty()) {
			return -1;
		}
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	int leerEstado() {
		return Integer.parseInt(txtEstado.getText());
	}
	int leerOpcion() {
		return cboOpciones.getSelectedIndex();
	}

	void limpiarTxtFields(){
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		txtEstado.setText("");
		txtCelular.setText("");
		txtCodigo.setText("");
	}
	//Metodos de mensajes
	void errorMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	int confirmDialog(String msg) {
		return JOptionPane.showConfirmDialog(this, msg, "Confirmar eliminacion", JOptionPane.OK_CANCEL_OPTION);
	}
}
