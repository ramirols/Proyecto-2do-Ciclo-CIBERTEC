package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import clases.*;
import colecciones.*;

public class MantenimientoCurso extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblAsignatura;
	private JLabel lblCreditos;
	private JLabel lblHoras;
	private JTextField txtAsignatura;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JComboBox<String> cboOpciones;
	private JPanel inputs;
	private Border lineBorder;
	private JScrollPane scrollPane;
	private JTable tablaCursos;
	private DefaultTableModel mt;
	private JLabel lblCiclo;
	private JTextField txtCiclo;
	private JButton btnAceptar;
	private JButton btnListar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoCurso dialog = new MantenimientoCurso();
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
	public MantenimientoCurso() {
		setTitle("Mantenimiento | Curso");
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
		inputs.setBounds(27, 27, 343, 149);
		getContentPane().add(inputs);
		inputs.setLayout(null);
		inputs.setBorder(lineBorder);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(105, 13, 159, 19);
		inputs.add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(10, 10, 85, 21);
		inputs.add(lblAsignatura);
		lblAsignatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtHoras = new JTextField();
		txtHoras.setBounds(105, 45, 59, 19);
		inputs.add(txtHoras);
		txtHoras.setColumns(10);
		
		lblHoras = new JLabel("Horas");
		lblHoras.setBounds(10, 42, 85, 21);
		inputs.add(lblHoras);
		lblHoras.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblCreditos = new JLabel("Creditos");
		lblCreditos.setBounds(10, 74, 85, 21);
		inputs.add(lblCreditos);
		lblCreditos.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(104, 77, 60, 19);
		inputs.add(txtCreditos);
		txtCreditos.setColumns(10);
		
		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCiclo.setBounds(10, 105, 85, 21);
		inputs.add(lblCiclo);
		
		txtCiclo = new JTextField();
		txtCiclo.setColumns(10);
		txtCiclo.setBounds(104, 108, 60, 19);
		inputs.add(txtCiclo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 240, 866, 340);
		getContentPane().add(scrollPane);
		
		 btnAceptar = new JButton("Aceptar");
		 btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 16));
		 btnAceptar.addActionListener(this);
	     btnAceptar.setBounds(518, 116, 156, 36);
	     getContentPane().add(btnAceptar);
	        
	     btnListar = new JButton("Listar");
	     btnListar.setFont(new Font("Tahoma", Font.BOLD, 16));
	     btnListar.addActionListener(this);
	     btnListar.setBounds(696, 116, 156, 36);
	     getContentPane().add(btnListar);
		
		//Modelo de la tabla
		mt = new DefaultTableModel() {
		};
		//Array de encabezados
		String[] encabezados = {"Codigo", "Asignatura", "Ciclo", "Creditos", "Horas"};
		mt.setColumnIdentifiers(encabezados);
		
		//Creacion de la tabla
		tablaCursos = new JTable(mt);
		tablaCursos.setEnabled(false);
		tablaCursos.getColumnModel().getColumn(1).setPreferredWidth(500); //Ancho de la columna 2
		scrollPane.setViewportView(tablaCursos);
		
		//Evitar que se puedan mover las columnas de lugar
		tablaCursos.getTableHeader().setReorderingAllowed(false);
		
		// Creacion del TableRowSorter
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(mt); //creacion del sorter
        tablaCursos.setRowSorter(sorter);
        
        ArrayList<TableRowSorter.SortKey> sortKeys = new ArrayList<>(); //creacion del sortKeys para manipular la columna deseada
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING)); //Creacion de un sortKey para la columna codigo 
        sorter.setSortKeys(sortKeys); //adicion del sortKey al sorter
        
        
        //Listado de cursos
        
        listar();

	}
	ArrayAlumnos aa = new ArrayAlumnos();
    ArrayCursos ac = new ArrayCursos();
    ArrayMatricula am = new ArrayMatricula();
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == cboOpciones) {
			actionPerformedCboOpciones(e);
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
		switch(opcion){
			case 1: //Consultar
				for (int i = 0; i < ac.tamanio(); i++) {
					Curso curso = ac.obtener(i);
					if (leerCodigo() == curso.getCodigo()) {
						txtAsignatura.setText(curso.getAsignatura());
						txtCiclo.setText("" + curso.getCiclo());
						txtCreditos.setText("" + curso.getCreditos());
						txtHoras.setText("" + curso.getHoras());
						listarCurso(curso);
						return;
					} else if (leerCodigo() == -1) { //Si no ingresa codigo detiene la funcion
			        	errorMsg("Ingrese un codigo");
			        	return;
			        }
				}
				errorMsg("El código ingresado no existe");
				break;
			case 2: // Modificar
			    for (int i = 0; i < ac.tamanio(); i++) {
			        Curso curso = ac.obtener(i);
			        if (leerCodigo() == curso.getCodigo()) {
			            if (!leerAsignatura().isEmpty()) {
			                try {
			                    curso.setCiclo(leerCiclo());
			                    curso.setCreditos(leerCreditos());
			                    curso.setHoras(leerHoras());
			                    curso.setAsignatura(leerAsignatura());
			                    
			                    ac.ActualizarArchivo();
			                    showMsg("El curso fue modificado con éxito");
			                    listar();
			                    return;
			                } catch (Exception ex) {
			                    errorMsg("Ingrese datos correctos en los campos numéricos");
			                    return;
			                }
			            } else {
			                errorMsg("El campo asignatura no puede estar vacío");
			                return;
			            }
			        } else if (leerCodigo() == -1) {
			        	errorMsg("Ingrese un codigo");
			        	return;
			        }
			    }
			    errorMsg("El código ingresado no existe");

			    break;
			case 3: //Eliminar
				int codigo = leerCodigo();
				if (codigo == -1) { //Si no ingresa codigo detiene la funcion
					errorMsg("Ingrese un codigo");
					return;
				}
	        	for (int i = 0; i < am.tamaño(); i++) {
	        		int CodMatriCurso = am.obtener(i).getCodCurso();
	        		if (codigo == CodMatriCurso) {
	        			errorMsg("Hay alumnos registrados en el curso");
	        			return;
	        		}
	        	}
				
			    for (int i = 0; i < ac.tamanio(); i++) {
			        Curso curso = ac.obtener(i);
			        if (curso.getCodigo() == codigo) {
			            int rpta = confirmDialog("¿Seguro que quieres eliminar el curso " + curso.getAsignatura() + "?");
			            if (rpta == 0) {
			            	ac.eliminar(curso);
			                showMsg("El curso ha sido eliminado exitosamente.");
			                ac.ActualizarArchivo();
			                listar();
			            }
			            return;
			        }
			    }
			    errorMsg("El código ingresado no existe");
			    break;
			default: //Adicionar
				Curso cursoX = generarCurso();
				if (cursoX == null) {
					return;
				}
				ac.adicionar(cursoX);
				ac.ActualizarArchivo();
				listar();
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		listar();
	}
	//Metodos con relacion a Cursos
	Curso generarCurso(){
		//Inicializacion de las variables en 0
		int creditos = 0, codigo = 0, horas = 0, ciclo = 0;
		
		String asignatura = leerAsignatura();
		if (asignatura.equals("") || asignatura.equals(" ")) {
			errorMsg("El campo asignatura no puede estar vacio");
			return null;
		}
		try {
			codigo = leerCodigo();
			for (int i = 0; i < ac.tamanio(); i++) {
				Curso curso = ac.obtener(i);
				if(curso.getCodigo() == leerCodigo()) {
					errorMsg("El código ingresado ya existe");
					return null;
				}
			}
			if (Integer.toString(codigo).length() != 3) {
				errorMsg("La cantidad de digitos en el campo codigo debe ser cuatro");
				return null;
			}
			creditos = leerCreditos();
			if(creditos < 0) {
				errorMsg("Introduce una cantidad de creditos adecuada");
				return null;
			}
			horas = leerHoras();
			if(horas < 0) {
				errorMsg("Introduce una cantidad de horas adecuada");
				return null;
			}
			ciclo = leerCiclo();
			if(ciclo < 0) {
				errorMsg("Introduce un ciclo adecuado");
				return null;
			}
		}catch (Exception e) {
			errorMsg("Ingrese datos correctos en los campos numericos");
			return null;
		}
		limpiarTxtFields();
		Curso cur = new Curso(codigo, asignatura, ciclo, creditos, horas); 
		return cur;
	}
	//Metodos complementarios
	void listar() {
		mt.setRowCount(0);
		for (int i = 0; i < ac.tamanio(); i++) {
			Curso x = ac.obtener(i);
			Object[] filas = {		     //Columnas// 	
					x.getCodigo(),       // Codigo
					x.getAsignatura(),   // Asignatura
					x.getCiclo(),        // Ciclo
					x.getCreditos(),     // Creditos
					x.getHoras(),	     // Horas
			};
			mt.addRow(filas);
		}
	}
	void listarCurso(Curso cur) {
		mt.setRowCount(0);
			Object[] filas = {		     //Columnas// 	
					cur.getCodigo(),     // Codigo
					cur.getAsignatura(), // Asignatura
					cur.getCiclo(),      // Ciclo
					cur.getCreditos(),   // Creditos
					cur.getHoras(),	     // Horas
			};
			mt.addRow(filas);
		}
	void switchTxtFields(int opcion) {
		if (opcion == 1 || opcion == 3) {
			txtAsignatura.setEditable(false);
			txtCreditos.setEditable(false);
			txtHoras.setEditable(false);
			txtCiclo.setEditable(false);
			txtCodigo.setEditable(true);
		}
		else {
			txtAsignatura.setEditable(true);
			txtCreditos.setEditable(true);
			txtHoras.setEditable(true);
			txtCiclo.setEditable(true);
			txtCodigo.setEditable(true);
		}
	}
	
	//Metodos de lectura de datos
	String leerAsignatura() {
		return txtAsignatura.getText().trim();
	}
	int leerCreditos() {
		return Integer.parseInt(txtCreditos.getText().trim());
	}
	int leerCodigo() {
		if (txtCodigo.getText().isEmpty()) {
			return -1;
		}
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	int leerCiclo() {
		return Integer.parseInt(txtCiclo.getText());
	}
	int leerOpcion() {
		return cboOpciones.getSelectedIndex();
	}
	int leerHoras() {
		return Integer.parseInt(txtHoras.getText());
	}

	void limpiarTxtFields(){
		txtAsignatura.setText("");
		txtHoras.setText("");
		txtCreditos.setText("");
		txtCiclo.setText("");
		txtCodigo.setText("");
	}
	//Metodos de mensajes
	void errorMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	void showMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	int confirmDialog(String msg) {
		return JOptionPane.showConfirmDialog(null, msg, "Confirmar eliminacion", JOptionPane.OK_CANCEL_OPTION);
	}
}
