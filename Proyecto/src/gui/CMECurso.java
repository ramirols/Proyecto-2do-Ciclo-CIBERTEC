package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.Curso;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.table.TableRowSorter;
public class CMECurso extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblDatosDeLos;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable tablaCursos;
	private DefaultTableModel mt;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CMECurso dialog = new CMECurso();
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
	
	public CMECurso() {
		setTitle("Consultar, Modificar, Eliminar");
		setBounds(100, 100, 558, 488);
		getContentPane().setLayout(null);
		
		lblDatosDeLos = new JLabel("Datos de los cursos");
		lblDatosDeLos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDeLos.setFont(new Font("Papyrus", Font.PLAIN, 30));
		lblDatosDeLos.setBounds(91, 20, 374, 42);
		getContentPane().add(lblDatosDeLos);
		
		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 76, 524, 281);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 504, 261);
		panel.add(scrollPane);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnConsultar.setBounds(10, 383, 152, 42);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnModificar.setBounds(197, 383, 152, 42);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnEliminar.setBounds(382, 383, 152, 42);
		getContentPane().add(btnEliminar);
		
		/////////////////////
		//Creacion de tabla//
		/////////////////////
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
		String[] encabezados = {"Codigo", "Asignatura", "Ciclo", "Creditos", "Horas"};
		mt.setColumnIdentifiers(encabezados);
		//Creacion de la tabla
		tablaCursos = new JTable(mt);
		scrollPane.setViewportView(tablaCursos);
		tablaCursos.getColumnModel().getColumn(1).setPreferredWidth(400);
		// Creacion del TableRowSorter
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(mt); //creacion del sorter
        tablaCursos.setRowSorter(sorter); //adicion del sorter al JTable
        
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
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		generarTabla();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		String str = ""; //Variable comodin para evitar errores por el retorno de nulos con el input
		int codigo = 0;
		int ciclo = 0;
		int creditos = 0;
		int horas = 0;
		try {
			str = input("Ingresa el codigo del curso que desea modificar", "");
			if (str == null) {
				return;
			}
			codigo = Integer.parseInt(str);
		} catch (NumberFormatException e2) {
			errorMsg("Ingrese datos numericos y apropiados");
			return;
		}
		
		for (int clave : Curso.cursos.keySet()) {
			Curso varCurso = Curso.cursos.get(clave);
			
			if (codigo == varCurso.getCodigo()) {
				//Bloque asignatura
				String Asignatura = input("Ingresa el nombre de la asignatura", varCurso.getAsignatura());
				if (Asignatura == null) {
					return;
				}
				Asignatura = Asignatura.trim();
				if (Asignatura.equals("") || Asignatura.equals(" ")) { //Evitar nombres vacios
					errorMsg("El campo no puede estar vacio");
					return;
				}
				//Bloque ciclo
				str = input("Ingresa el ciclo del curso","" + varCurso.getCiclo());
				if (str == null) {
					return;
				}
				try {
					ciclo = Integer.parseInt(str);
					if (ciclo > 20 || ciclo < 1) {
						errorMsg("Ingrese un número de ciclo apropiado");
						return;
					}
				}catch (NumberFormatException e2) {
					errorMsg("Ingrese datos numericos y apropiados");
					return;
				}
				//Bloque creditos
				str = input("Ingresa la cantidad de creditos del curso",""+ varCurso.getCreditos());
				if (str == null) {
					return;
				}
				try {
					creditos = Integer.parseInt(str);
					if (creditos > 99 || creditos < 1) {
						errorMsg("Ingresa una cantidad apropiada de creditos");
						return;
					}
				}catch (NumberFormatException e2) {
					errorMsg("Ingresa datos apropiados");
					return;
				}
				str = input("Ingresa la cantidad de horas del curso",""+varCurso.getHoras());
				if (str == null) {
					return;
				}
				try {
					horas = Integer.parseInt(str);
					if (horas > 99 || horas < 1) {
						errorMsg("Ingresa una cantidad de horas apropiada");
						return;
					}
				}catch (NumberFormatException e2) {
					errorMsg("Ingresa datos apropiados");
					return;
				}
				setters(varCurso, Asignatura.trim(), ciclo, creditos, horas);
				generarTabla();
				return;
			}
		}
		errorMsg("El codigo ingresado no existe");
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		//Me falta el boton eliminar y ya :P
	}

	//Metodos
	void generarTabla() {
		mt.setRowCount(0);
		String[] datos = new String[5];
		for (int clave : Curso.cursos.keySet()) {
			datos[0] = "" + Curso.cursos.get(clave).getCodigo();
			datos[1] = Curso.cursos.get(clave).getAsignatura();
			datos[2] = "" + Curso.cursos.get(clave).getCiclo();
			datos[3] = "" + Curso.cursos.get(clave).getCreditos();
			datos[4] = "" + Curso.cursos.get(clave).getHoras();
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
		return JOptionPane.showConfirmDialog(null, msg);
	}
	void setters(Curso curso, String asignatura, int ciclo, int creditos, int horas) {
		curso.setAsignatura(asignatura);
		curso.setCiclo(ciclo);
		curso.setCreditos(creditos);
		curso.setHoras(horas);
	}
}
