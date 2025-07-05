package gui_registro;

import java.awt.EventQueue;
import clases.*;
import colecciones.*;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//ITEM LISTENER  se encarga de manejar cambios en los cbo, ActionListener se encarga de botones y acciones
public class RegistroRetiro extends JDialog implements ItemListener, ActionListener {

	DefaultTableModel modelo;
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNumeroDeMatricula;
	private JLabel lblAlumno;
	private JLabel lblCodCurso;
	private JLabel lblCurso;
	private JLabel lblActivo;
	private JLabel lblNewLabel_1;
	private JComboBox<String> cboOpciones;
	private JComboBox<Integer> cboNumRetiro;
	private JComboBox<Integer> cboNumMatricula;
	private JTextField txtAlumno;
	private JComboBox<Integer> cboCodCurso;
	private JTextField txtCurso;
	private JTextField txtActivo;
	private JLabel lblCodAlumno;
	private JTextField txtCodMatricula;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTable tblRetiro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroRetiro dialog = new RegistroRetiro();
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
	public RegistroRetiro() {
		setTitle("REGISTRO RETIRO");
		setResizable(false);
		setBounds(100, 100, 850, 580);
		getContentPane().setLayout(null);
		lblNewLabel = new JLabel("Numero de Retiro       :");
		lblNewLabel.setBounds(10, 21, 140, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblNewLabel);

		lblNumeroDeMatricula = new JLabel("Numero de Matricula  :");
		lblNumeroDeMatricula.setBounds(10, 61, 140, 25);
		lblNumeroDeMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblNumeroDeMatricula);

		lblAlumno = new JLabel("Alumno                      :");
		lblAlumno.setBounds(10, 102, 140, 25);
		lblAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblAlumno);

		lblCodCurso = new JLabel("Cod. del Curso           :");
		lblCodCurso.setBounds(10, 138, 140, 25);
		lblCodCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblCodCurso);

		lblCurso = new JLabel("Curso                         :");
		lblCurso.setBounds(10, 174, 140, 25);
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblCurso);

		lblActivo = new JLabel("Activo                        :");
		lblActivo.setBounds(10, 210, 140, 25);
		lblActivo.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblActivo);

		lblNewLabel_1 = new JLabel("Seleccione una Acción");
		lblNewLabel_1.setBounds(630, 30, 150, 28);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblNewLabel_1);

		cboOpciones = new JComboBox<String>();
		cboOpciones.addActionListener(this);
		cboOpciones.addItemListener(this);
		cboOpciones.setBounds(626, 78, 180, 22);
		cboOpciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		cboOpciones.setModel(new DefaultComboBoxModel<String>(
				new String[] { "------------------------", "ADICIONAR", "CONSULTAR", "MODIFICAR", "ELIMINAR" }));
		getContentPane().add(cboOpciones);

		cboNumRetiro = new JComboBox<Integer>();
		cboNumRetiro.addActionListener(this);
		cboNumRetiro.addItemListener(this);
		cboNumRetiro.setBounds(160, 23, 180, 22);
		cboNumRetiro.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(cboNumRetiro);

		cboNumMatricula = new JComboBox<Integer>();
		cboNumMatricula.addItemListener(this);
		cboNumMatricula.setBounds(160, 63, 180, 22);
		cboNumMatricula.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(cboNumMatricula);

		txtAlumno = new JTextField();
		txtAlumno.setBounds(160, 105, 270, 20);
		getContentPane().add(txtAlumno);
		txtAlumno.setColumns(10);

		cboCodCurso = new JComboBox<Integer>();
		cboCodCurso.addItemListener(this);
		cboCodCurso.setBounds(160, 140, 180, 22);
		cboCodCurso.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(cboCodCurso);

		txtCurso = new JTextField();
		txtCurso.setBounds(160, 177, 270, 20);
		txtCurso.setColumns(10);
		getContentPane().add(txtCurso);

		txtActivo = new JTextField();
		txtActivo.setBounds(160, 213, 180, 20);
		txtActivo.setColumns(10);
		getContentPane().add(txtActivo);

		lblCodAlumno = new JLabel("Cod. Matricula     :");
		lblCodAlumno.setBounds(545, 125, 120, 25);
		lblCodAlumno.setFont(new Font("Tahoma", Font.BOLD, 12));
		getContentPane().add(lblCodAlumno);

		txtCodMatricula = new JTextField();
		txtCodMatricula.setEditable(false);
		txtCodMatricula.setBounds(665, 128, 140, 20);
		txtCodMatricula.setColumns(10);
		getContentPane().add(txtCodMatricula);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 289, 814, 241);
		getContentPane().add(scrollPane);

		tblRetiro = new JTable();
		tblRetiro.setModel(new DefaultTableModel(new Object[][] {}, // Cuerpo de la tabla
				// Encabezados
				new String[] { "N\u00B0 RETIRO", "N\u00B0 MAT.", "NOMBRES", "APELLIDOS", "CURSO", "FECHA", "HORA" }) {
			
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		// Deshabilitar la modificacion de tamanio de columnas
		for (int i = 0; i < tblRetiro.getColumnCount(); i++) {
			tblRetiro.getColumnModel().getColumn(i).setResizable(false);
		}

		modelo = (DefaultTableModel) tblRetiro.getModel();
		scrollPane.setViewportView(tblRetiro);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceptar.setBounds(51, 248, 100, 23);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setBounds(211, 246, 100, 23);
		getContentPane().add(btnCancelar);
		deshabilitarTodo();
		listar();
		cboNumRetiro.addItemListener(this);
		cboNumMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si estamos en modo eliminar (por ejemplo, si cboNumRetiro está
				// habilitado)
				if (cboNumRetiro.isEnabled()) {
					cargarRetirosDelAlumno();
				}
			}
		});
	}

	// DECLARACION GLOBAL
	ArrayAlumnos aa = new ArrayAlumnos();
	ArrayCursos ac = new ArrayCursos();
	ArrayMatricula am = new ArrayMatricula();
	ArrayRetiro ar = new ArrayRetiro();

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodCurso) {
			itemStateChangedCboCodCurso(e);
		}
		if (e.getSource() == cboNumMatricula) {
			itemStateChangedCboNumMatricula(e);
		}
		if (e.getSource() == cboNumRetiro) {
			itemStateChangedCboNumRetiro(e);
		}
	}

	protected void itemStateChangedCboNumRetiro(ItemEvent e) {
		try {
			int numRetiro = leerNumeroRetiro();
			Retiro buscadoR = ar.buscar(numRetiro);
			Matricula buscadoM = am.buscar(buscadoR.getNumMatricula());
			cboNumMatricula.setSelectedItem(buscadoR.getNumMatricula());
			cboCodCurso.setSelectedItem(buscadoM.getCodCurso());
			tblRetiro.setRowSelectionInterval(cboNumRetiro.getSelectedIndex(), cboNumRetiro.getSelectedIndex());
		} catch (Exception error) {
		}
	}

	protected void itemStateChangedCboNumMatricula(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			try {
				int numMatricula = leerNumeroMatricula();
				Matricula buscado = am.buscar(numMatricula);
				txtAlumno.setText(aa.buscar(buscado.getCodAlumno()).getNombres() + " "
						+ aa.buscar(buscado.getCodAlumno()).getApellidos());
				cboCodCurso.setSelectedItem(buscado.getCodCurso());
				txtActivo.setText(activo(aa.buscar(buscado.getCodAlumno()).getEstado()));
			} catch (Exception error) {
				JOptionPane.showMessageDialog(this,
						"Error al cargar los datos del curso. Verifique que el numero de matricula exista.",
						"Matricula no encontrada", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getStateChange() == ItemEvent.SELECTED) {
			// Solo actualiza si estás en MODIFICAR
			Object accionSeleccionada = cboOpciones.getSelectedItem();
			if (accionSeleccionada != null && accionSeleccionada.toString().equals("MODIFICAR")) {
				cargarRetirosDelAlumno();
			}
		}
	}

	protected void itemStateChangedCboCodCurso(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			try {
				int codCurso = leerCodigoCurso();
				Curso buscado = ac.buscar(codCurso);
				txtCurso.setText(buscado.getAsignatura());
			} catch (Exception error) {
				JOptionPane.showMessageDialog(this,
						"Error al cargar los datos del curso. Verifique que el código del curso exista.",
						"Curso no encontrado", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	void listarCboNumRetiro() {
		cboNumRetiro.removeAllItems();
		for (int i = 0; i < ar.tamanio(); i++) {
			cboNumRetiro.addItem(ar.obtener(i).getNumRetiro());
		}
	}

	void listarCboNumMatricula() {
		cboNumMatricula.removeAllItems();
		for (int i = 0; i < am.tamaño(); i++) {
			cboNumMatricula.addItem(am.obtener(i).getNumMatricula());
		}
	}

	void listarCboCodCurso() {
		cboCodCurso.removeAllItems();
		for (int i = 0; i < ac.tamanio(); i++) {
			cboCodCurso.addItem(ac.obtener(i).getCodigo());
		}
	}

	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < ar.tamanio(); i++) {
			Object[] fila = { ar.obtener(i).getNumRetiro(), ar.obtener(i).getNumMatricula(),
					aa.buscar(am.buscar(ar.obtener(i).getNumMatricula()).getCodAlumno()).getNombres(),
					aa.buscar(am.buscar(ar.obtener(i).getNumMatricula()).getCodAlumno()).getApellidos(),
					ac.buscar(am.buscar(ar.obtener(i).getNumMatricula()).getCodCurso()).getAsignatura(),
					ar.obtener(i).getFecha(), ar.obtener(i).getHora(), };
			modelo.addRow(fila);
		}
	}

	int leerCodMatricula() {
		return Integer.parseInt(txtCodMatricula.getSelectedText().toString());
	}

	int leerNumeroRetiro() {
		return Integer.parseInt(cboNumRetiro.getSelectedItem().toString());
	}

	int leerNumeroMatricula() {
		return Integer.parseInt(cboNumMatricula.getSelectedItem().toString());
	}

	String leerAlumno() {
		return txtAlumno.getText().trim().toUpperCase();
	}

	int leerCodigoCurso() {
		return Integer.parseInt(cboCodCurso.getSelectedItem().toString());
	}

	String leerCurso() {
		return txtCurso.getText().trim().toUpperCase();
	}

	String activo(int i) {
		return i == 1 ? "Sí" : "No";
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	void error(String s, JComboBox<?> cbo) {
		JOptionPane.showMessageDialog(this, s, "", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}

	int confirmar() {
		int valor = JOptionPane.showOptionDialog(this,
				"¿Estas seguro de eliminar este retiro?\n" + "Alumno: " + leerAlumno() + "\n" + "Curso: " + leerCurso(),
				"Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sí", "No" },
				null);
		return valor;
	}

	void habilitar(boolean numRetiro, boolean numMatricula, boolean alumno, boolean codigoCurso, boolean curso,
			boolean activoMatricula, boolean aceptar, boolean cancelar, boolean CodMatricula) {
		cboNumRetiro.setEnabled(numRetiro);
		cboNumMatricula.setEnabled(numMatricula);
		txtAlumno.setEditable(alumno);
		cboCodCurso.setEnabled(codigoCurso);
		txtCurso.setEditable(curso);
		txtActivo.setEditable(activoMatricula);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		txtCodMatricula.setEditable(CodMatricula);
	}

	void deshabilitarTodo() {
		listarCboNumRetiro();
		listarCboNumMatricula();
		listarCboCodCurso();
		habilitar(false, false, false, false, false, false, true, true, false);
		limpiar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}

		if (e.getSource() == cboOpciones) {
			actionPerformedCboOpciones(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}

	void limpiar() {
		cboNumRetiro.setSelectedIndex(-1);
		cboNumMatricula.setSelectedIndex(-1);
		txtAlumno.setText("");
		cboCodCurso.setSelectedIndex(-1);
		txtCurso.setText("");
		txtActivo.setText("");
		txtCodMatricula.setText("");
	}

	// METODOS PARA PREPARAR
	void prepararAdicionar() {
		limpiar();
		listarCboNumMatricula(); // solo matriculas activas (estado 1 o 2)
		habilitar(false, true, false, false, false, false, true, true, false);
		cboNumRetiro.addItem(ar.codigoCorrelativo());
		cboNumRetiro.setSelectedIndex(cboNumRetiro.getItemCount() - 1);
	}

	void prepararModificar() {
		limpiar();
		habilitar(false, true, false, true, false, false, true, true, false);
	}

	void prepararConsultar() {
		limpiar();
		habilitar(false, false, false, false, false, false, true, true, true);
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			String accion = cboOpciones.getSelectedItem().toString();
			switch (accion) {
			case "ADICIONAR":
				int numMatricula = leerNumeroMatricula();
				int codRetiro = leerNumeroRetiro();
				Matricula mat = am.buscar(numMatricula);
				if (mat == null) {
					error("La matrícula seleccionada no existe", cboNumMatricula);
					return;
				}
				Alumno alumno = aa.buscar(mat.getCodAlumno());
				if (alumno == null) {
					error("El alumno vinculado a la matrícula no existe", cboNumMatricula);
					return;
				}
				if (alumno.getEstado() == 1) {
					Retiro nuevo = new Retiro(codRetiro, numMatricula, Calendario.fechaActual(),
							Calendario.horaActual());
					ar.adicionar(nuevo);
					alumno.setEstado(2);
					aa.ActualizarArchivo();
					ar.grabar();
					listar();
					mensaje("Retiro registrado con éxito");
				} else {
					error("Solo se pueden retirar alumnos activos", cboNumMatricula);
				}
				break;
			case "MODIFICAR":
				cargarRetirosDelAlumno();
				int numRetiro = leerNumeroRetiro();
				Retiro retiroMod = ar.buscar(numRetiro);
				if (retiroMod == null) {
					error("Retiro no encontrado", cboNumRetiro);
					return;
				}
				Matricula matMod = am.buscar(retiroMod.getNumMatricula());
				if (matMod == null) {
					error("Matrícula vinculada no existe", cboNumMatricula);
					return;
				}
				Alumno alumnoMod = aa.buscar(matMod.getCodAlumno());
				if (alumnoMod == null) {
					error("Alumno vinculado no existe", cboNumMatricula);
					return;
				}
				if (alumnoMod.getEstado() != 2) {
					error("Solo se puede modificar el curso de una matrícula retirada", cboNumMatricula);
					return;
				}
				int nuevoCodCurso = leerCodigoCurso();
				matMod.setCodCurso(nuevoCodCurso);
				am.ActualizarArchivo();
				listar();
				mensaje("Curso de la matrícula modificada con éxito");
				break;
			case "CONSULTAR":
				try {
					int codMatricula = Integer.parseInt(txtCodMatricula.getText().trim());
					Matricula matCon = am.buscar(codMatricula);
					if (matCon == null) {
						mensaje("La matrícula no existe.");
						return;
					}
					Alumno aluCon = aa.buscar(matCon.getCodAlumno());
					if (aluCon == null) {
						mensaje("El alumno no existe.");
						return;
					}
					Curso cur = ac.buscar(matCon.getCodCurso());
					txtAlumno.setText(aluCon.getNombres() + " " + aluCon.getApellidos());
					cboNumMatricula.setSelectedItem(matCon.getNumMatricula());
					cboCodCurso.setSelectedItem(matCon.getCodCurso());
					if (cur != null)
						txtCurso.setText(cur.getAsignatura());

					for (int i = 0; i < ar.tamanio(); i++) {
						if (ar.obtener(i).getNumMatricula() == codMatricula) {
							cboNumRetiro.setSelectedItem(ar.obtener(i).getNumRetiro());
							break;
						}
					}
				} catch (NumberFormatException ex) {
					mensaje("Ingrese un número de matrícula válido.");
				}
				break;
			case "ELIMINAR":
	        	if (txtAlumno.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                        this, // o null si no estás en JFrame/JDialog
                        "Debe ingresar el código del alumno",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    txtAlumno.requestFocus();
                    return; // detener el flujo
                }
				if (confirmar() == 0) {
					Retiro r = ar.buscar(leerNumeroRetiro());
					Matricula m = am.buscar(r.getNumMatricula());
					Alumno a = aa.buscar(m.getCodAlumno());

					ar.eliminar(r);
					a.setEstado(1);
					aa.ActualizarArchivo();
					ar.grabar();
					listar();
					mensaje("Retiro eliminado exitosamente");
					deshabilitarTodo();
					cboOpciones.setSelectedIndex(0);
					break;
				}
			}
		} catch (Exception ex) {
			error("Datos incompletos o incorrectos", cboNumMatricula);
		}
	}

	protected void actionPerformedCboOpciones(ActionEvent e) {
		String accion = cboOpciones.getSelectedItem().toString();
		switch (accion) {
		case "ADICIONAR":
			prepararAdicionar();
			break;
		case "MODIFICAR":
			prepararModificar();
			break;
		case "CONSULTAR":
			prepararConsultar();
			break;
		case "ELIMINAR":
			ejecutarEliminar();
			break;
		default:
			deshabilitarTodo();
		}
	}

	void ejecutarEliminar() {
		habilitar(true, true, false, false, false, false, true, true, false);
		cboNumMatricula.requestFocus();
		// Cargar retiros del primer alumno si hay uno seleccionado
		if (cboNumMatricula.getSelectedIndex() != -1) {
			cargarRetirosDelAlumno();
		}
	}

	void cargarRetirosDelAlumno() {
		cboNumRetiro.removeAllItems();
		Object selected = cboNumMatricula.getSelectedItem();
		if (selected == null) {
			return;
		}
		int numMatricula = Integer.parseInt(selected.toString());
		for (int i = 0; i < ar.tamanio(); i++) {
			Retiro retiro = ar.obtener(i);
			if (retiro.getNumMatricula() == numMatricula) {
				cboNumRetiro.addItem(retiro.getNumRetiro());
			}
		}
		if (cboNumRetiro.getItemCount() > 0) {
			cboNumRetiro.setSelectedIndex(0);
		}
	}

	void cargarRetiros() {
		cboNumRetiro.removeAllItems();
		for (int i = 0; i < ar.tamanio(); i++) {
			Retiro retiro = ar.obtener(i);
			cboNumRetiro.addItem(retiro.getNumRetiro());
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		limpiar();
		deshabilitarTodo();
		cboOpciones.setSelectedIndex(0);
	}
}
