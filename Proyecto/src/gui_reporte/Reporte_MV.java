package gui_reporte;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import clases.Alumno;
import colecciones.ArrayAlumnos;
import java.awt.Font;

public class Reporte_MV extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnGenerarReporte;
	private JTable Tabla_MV;
	private DefaultTableModel tb;

	public static void main(String[] args) {
		try {
			Reporte_MV dialog = new Reporte_MV();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Reporte_MV() {
		setTitle("Matriculas vigentes");
		setBounds(100, 100, 726, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGenerarReporte.addActionListener(this);
		btnGenerarReporte.setBounds(249, 10, 208, 34);
		contentPanel.add(btnGenerarReporte);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 690, 341);
		contentPanel.add(scrollPane);

		// Crear modelo de tabla
		tb = new DefaultTableModel();
		
		String [] nombresColumnas = {"CODIGO", "NOMBRES", "APELLIDOS", "DNI", "EDAD", "CELULAR", "ESTADO"};
		tb.setColumnIdentifiers(nombresColumnas);

		// Crear tabla y asociarla al modelo
		Tabla_MV = new JTable(tb);
		Tabla_MV.setEnabled(false);
		scrollPane.setViewportView(Tabla_MV);
		
		//Evitar que se puedan mover las columnas de lugar
		Tabla_MV.getTableHeader().setReorderingAllowed(false);
		
		Tabla_MV.getColumnModel().getColumn(1).setPreferredWidth(100); //Ancho de la columna 2
		Tabla_MV.getColumnModel().getColumn(2).setPreferredWidth(150); //Ancho de la columna 3
		// Crear y aplicar sorter
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tb);
		Tabla_MV.setRowSorter(sorter);
		ArrayList<TableRowSorter.SortKey> sorter_Orden = new ArrayList<>();
		sorter_Orden.add(new TableRowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sorter_Orden);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerarReporte) {
			actionPerformedBtnGenerarReporte(e);
		}
	}

	protected void actionPerformedBtnGenerarReporte(ActionEvent e) {
		generarTabla();
	}

	ArrayAlumnos aa = new ArrayAlumnos();
	
	void generarTabla() {
		tb.setRowCount(0);
		
		for(int i=0; i<aa.tamanio(); i++) {
			Alumno alu = aa.obtener(i);
			
			//Agregar los alumnos con estado 0(Pendiente)
			if(alu.getEstado() == 1) {
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
