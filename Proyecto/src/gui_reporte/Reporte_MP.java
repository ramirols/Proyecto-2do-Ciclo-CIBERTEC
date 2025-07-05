package gui_reporte;

import java.awt.BorderLayout;

import clases.Alumno;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SortOrder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import colecciones.ArrayAlumnos;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Font;

public class Reporte_MP extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnGenerarReporte;
	private JScrollPane scrollPane;
	private JTable Tabla_MP;
	private DefaultTableModel tb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reporte_MP dialog = new Reporte_MP();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reporte_MP() {
		setTitle("Matriculas pendientes");
		
		setIconImage(new ImageIcon(getClass().getResource("/imgs/favicon.png")).getImage());
		
		setBounds(100, 100, 726, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGenerarReporte.addActionListener(this);
		btnGenerarReporte.setBounds(266, 10, 180, 34);
		contentPanel.add(btnGenerarReporte);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 690, 341);
		contentPanel.add(scrollPane);
		
		
		
		//Creacion de la tabla
		tb = new DefaultTableModel();
		
		//Establecer identificadores de colunnas
		String [] nombresColumnas = {"CODIGO", "NOMBRES", "APELLIDOS", "DNI", "EDAD", "CELULAR", "ESTADO"};
		tb.setColumnIdentifiers(nombresColumnas);
		
		//Poner la tabla en scroll
		Tabla_MP = new JTable(tb);
		//No editable
		Tabla_MP.setEnabled(false);
		
		scrollPane.setViewportView(Tabla_MP);
		
		//Evitar que se puedan mover las columnas de lugar
		Tabla_MP.getTableHeader().setReorderingAllowed(false);
		
		Tabla_MP.getColumnModel().getColumn(1).setPreferredWidth(100); //Ancho de la columna 2
		Tabla_MP.getColumnModel().getColumn(2).setPreferredWidth(150); //Ancho de la columna 3
		
		//Creacion del sorter para ordenar la tabla
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tb);
		Tabla_MP.setRowSorter(sorter);
		// Nombrar al sorterKey
		ArrayList<TableRowSorter.SortKey> sorter_Orden = new ArrayList<>();
		sorter_Orden.add(new TableRowSorter.SortKey(0, SortOrder.ASCENDING)); // Añadir la tabla y poner el sorter ascendente
		sorter.setSortKeys(sorter_Orden);
	}
	ArrayAlumnos aa = new ArrayAlumnos();
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerarReporte) {
			actionPerformedBtnGenerarReporte(e);
		}
	}
	protected void actionPerformedBtnGenerarReporte(ActionEvent e) {
		generarTabla();
	}
	
	void generarTabla() {
		tb.setRowCount(0);
		
		for(int i=0; i<aa.tamanio(); i++) {
			Alumno alu = aa.obtener(i);
			
			//Agregar los alumnos con estado 0(Pendiente)
			if(alu.getEstado() == 0) {
				Object[] fila =  {
						alu.getCodAlumno(),
						alu.getNombres(),
						alu.getApellidos(),
						alu.getDni(),
						alu.getEdad(),
						alu.getCelular(),
						verificarEstado(alu.getEstado())
				};
				tb.addRow(fila);
			}
		}
	}
	// Metodo que verifica el estado al recorrer el array
	public String verificarEstado (int i) {
		switch(i) {
			case 0: return "Pendiente";
			case 1: return "Matriculado";
			default : return "Retirado";
		}
	}
}
