package gui_reporte;

import java.awt.BorderLayout;
import gui.Menu;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;
import colecciones.ArrayAlumnos;
import colecciones.ArrayCursos;
import colecciones.ArrayMatricula;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SortOrder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class Reporte_MPC extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnGenerarReporte;
	private JScrollPane scrollPane; 
	private JTable Tabla_MPC;
	private DefaultTableModel tb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Reporte_MPC dialog = new Reporte_MPC();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Reporte_MPC() {
		setBounds(100, 100, 726, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.addActionListener(this);
		btnGenerarReporte.setBounds(288, 11, 118, 34);
		contentPanel.add(btnGenerarReporte);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 690, 341);
		contentPanel.add(scrollPane);
		
		Tabla_MPC = new JTable();
		scrollPane.setViewportView(Tabla_MPC);
		
		
		//Creacion de la tabla
		tb = new DefaultTableModel();
		
		//Establecer identificadores de colunnas
		String[] nombresColumnas = { "CURSO", "CODIGO", "NOMBRES", "APELLIDOS", "DNI", "EDAD", "CELULAR" };
		tb.setColumnIdentifiers(nombresColumnas);
		
		//Poner la tabla en scroll
		Tabla_MPC = new JTable(tb);
		//No editable
		Tabla_MPC.setEnabled(false);
		
		scrollPane.setViewportView(Tabla_MPC);
		
		//Creacion del sorter para ordenar la tabla
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tb);
		Tabla_MPC.setRowSorter(sorter);
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

		ArrayMatricula am = new ArrayMatricula();
		ArrayAlumnos aa = new ArrayAlumnos();
		ArrayCursos ac = new ArrayCursos();

		for (int i = 0; i < am.tamaño(); i++) {
			Matricula m = am.obtener(i);
			Alumno a = aa.buscar(m.getCodAlumno());
			Curso c = ac.buscar(m.getCodCurso());

			if (a != null && c != null && a.getEstado() == 1) {
				Object[] fila = {
					c.getAsignatura(),
					a.getCodAlumno(),
					a.getNombres(),
					a.getApellidos(),
					a.getDni(),
					a.getEdad(),
					a.getCelular()
				};
				tb.addRow(fila);
			}
		}
	}
}