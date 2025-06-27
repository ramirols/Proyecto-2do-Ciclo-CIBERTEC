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
import clases.Curso;
import clases.Matricula;
import colecciones.ArrayAlumnos;
import colecciones.ArrayCursos;
import colecciones.ArrayMatricula;

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
		setBounds(100, 100, 726, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.addActionListener(this);
		btnGenerarReporte.setBounds(288, 11, 150, 34);
		contentPanel.add(btnGenerarReporte);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 690, 341);
		contentPanel.add(scrollPane);

		// Crear modelo de tabla
		tb = new DefaultTableModel();
		String[] nombresColumnas = { "CURSO", "CODIGO", "NOMBRES", "APELLIDOS", "DNI", "EDAD", "CELULAR" };
		tb.setColumnIdentifiers(nombresColumnas);

		// Crear tabla y asociarla al modelo
		Tabla_MV = new JTable(tb);
		scrollPane.setViewportView(Tabla_MV);

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
