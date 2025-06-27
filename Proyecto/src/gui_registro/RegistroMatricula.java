package gui_registro;

import java.awt.EventQueue;
import clases.*;
import colecciones.*;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class RegistroMatricula extends JDialog implements ActionListener, ItemListener, MouseListener {

	DefaultTableModel modelo;
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cboOpciones;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCodigoAlumno;
	private JLabel lblNewLabel_2;
	private JComboBox<Integer> cboNumMatricula;
	private JLabel lblNewLabel_3;
	private JComboBox<Integer> cboCodAlumno;
	private JLabel lblNewLabel_4;
	private JTextField txtAlumno;
	private JLabel lblNewLabel_5;
	private JTextField txtEstadoAlumno;
	private JLabel lblNewLabel_6;
	private JComboBox<Integer> cboCodCurso;
	private JLabel lblNewLabel_7;
	private JTextField txtNombreCurso;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JTable tblRegistroMatri;

	//DECLARACION GLOBAL - MOVIDO AL INICIO
	ArrayAlumnos aa = new ArrayAlumnos();
	ArrayCursos ac = new ArrayCursos();
	ArrayMatricula am = new ArrayMatricula();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroMatricula dialog = new RegistroMatricula();
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
	public RegistroMatricula() {
		setResizable(false);
		getContentPane().setEnabled(false);
		setTitle("REGISTRO MATRICULA");
		setBounds(100, 100, 900, 520);
		getContentPane().setLayout(null);
		
		// CREAR COMBOBOX UNA SOLA VEZ
		cboOpciones = new JComboBox<String>();
		cboOpciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		cboOpciones.setModel(new DefaultComboBoxModel<String>(new String[] {"-----------------", "Adicionar", "Consultar", "Modificar", "Eliminar"}));
		cboOpciones.setBounds(712, 53, 131, 22);
		getContentPane().add(cboOpciones);
		
		lblNewLabel = new JLabel("Seleccione una Acción");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(702, 14, 150, 28);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Codigo Alumno:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(605, 86, 120, 22);
		getContentPane().add(lblNewLabel_1);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setBounds(713, 86, 140, 20);
		getContentPane().add(txtCodigoAlumno);
		txtCodigoAlumno.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Número de Matricula:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 19, 140, 20);
		getContentPane().add(lblNewLabel_2);
		
		cboNumMatricula = new JComboBox<Integer>();
		cboNumMatricula.setEnabled(false);
		cboNumMatricula.setBounds(140, 18, 160, 22);
		getContentPane().add(cboNumMatricula);
		
		lblNewLabel_3 = new JLabel("Codigo de Alumno     :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 56, 140, 20);
		getContentPane().add(lblNewLabel_3);
		
		cboCodAlumno = new JComboBox<Integer>();
		cboCodAlumno.setBounds(140, 52, 160, 22);
		getContentPane().add(cboCodAlumno);
		
		lblNewLabel_4 = new JLabel("Nombre de Alumno   :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 88, 140, 20);
		getContentPane().add(lblNewLabel_4);
		
		txtAlumno = new JTextField();
		txtAlumno.setEditable(false);
		txtAlumno.setBounds(140, 88, 250, 20);
		getContentPane().add(txtAlumno);
		txtAlumno.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Estado                          :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(10, 119, 140, 20);
		getContentPane().add(lblNewLabel_5);
		
		txtEstadoAlumno = new JTextField();
		txtEstadoAlumno.setEditable(false);
		txtEstadoAlumno.setBounds(140, 119, 160, 20);
		getContentPane().add(txtEstadoAlumno);
		txtEstadoAlumno.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Codigo del Curso        :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(10, 150, 140, 20);
		getContentPane().add(lblNewLabel_6);
		
		cboCodCurso = new JComboBox<Integer>();
		cboCodCurso.setBounds(140, 150, 160, 22);
		getContentPane().add(cboCodCurso);
		
		lblNewLabel_7 = new JLabel("Nombre del Curso      :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 183, 140, 20);
		getContentPane().add(lblNewLabel_7);
		
		txtNombreCurso = new JTextField();
		txtNombreCurso.setEditable(false);
		txtNombreCurso.setColumns(10);
		txtNombreCurso.setBounds(140, 183, 250, 20);
		getContentPane().add(txtNombreCurso);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAceptar.setBounds(60, 226, 110, 28);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(190, 226, 110, 28);
		getContentPane().add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 265, 853, 205);
		getContentPane().add(scrollPane);
		
		tblRegistroMatri = new JTable();
		tblRegistroMatri.setModel(new DefaultTableModel(
		new Object[][] {},
		new String[] {"COD. ALU.", "NOMBRES", "APELLIDOS", "COD. CURSO.", "CURSO", "FECHA", "HORA", "ESTADO"}) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblRegistroMatri.getColumnModel().getColumn(0).setResizable(false);
		tblRegistroMatri.getColumnModel().getColumn(0).setPreferredWidth(62);
		tblRegistroMatri.getColumnModel().getColumn(1).setResizable(false);
		tblRegistroMatri.getColumnModel().getColumn(2).setResizable(false);
		tblRegistroMatri.getColumnModel().getColumn(2).setPreferredWidth(80);
		tblRegistroMatri.getColumnModel().getColumn(3).setResizable(false);
		tblRegistroMatri.getColumnModel().getColumn(3).setPreferredWidth(70);
		tblRegistroMatri.getColumnModel().getColumn(3).setMinWidth(30);
		tblRegistroMatri.getColumnModel().getColumn(4).setResizable(false);
		tblRegistroMatri.getColumnModel().getColumn(4).setPreferredWidth(150);
		tblRegistroMatri.getColumnModel().getColumn(5).setResizable(false);
		tblRegistroMatri.getColumnModel().getColumn(5).setPreferredWidth(50);
		tblRegistroMatri.getColumnModel().getColumn(6).setResizable(false);
		tblRegistroMatri.getColumnModel().getColumn(6).setPreferredWidth(50);
		tblRegistroMatri.getColumnModel().getColumn(7).setResizable(false);
		tblRegistroMatri.getColumnModel().getColumn(7).setPreferredWidth(50);
		modelo = (DefaultTableModel) tblRegistroMatri.getModel();
		scrollPane.setViewportView(tblRegistroMatri);
		// AGREGAR LISTENERS
		btnAceptar.addActionListener(this);
		btnCancelar.addActionListener(this);
		cboOpciones.addActionListener(this);
		cboNumMatricula.addItemListener(this);
		cboCodAlumno.addItemListener(this);
		cboCodCurso.addItemListener(this);
		tblRegistroMatri.addMouseListener(this);
		// INICIALIZAR
		listar();
		deshabilitarTodo();
	}
	// IMPLEMENTAR TODOS LOS MÉTODOS DE LAS INTERFACES
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboOpciones) {
			actionPerformedCboOpciones(e);
		} else if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		} else if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodAlumno && e.getStateChange() == ItemEvent.SELECTED) {
			itemStateChangedCboCodAlumno(e);
		} else if (e.getSource() == cboCodCurso && e.getStateChange() == ItemEvent.SELECTED) {
			itemStateChangedCboCodCurso(e);
		} else if (e.getSource() == cboNumMatricula && e.getStateChange() == ItemEvent.SELECTED) {
			itemStateChangedCboNumMatricula(e);
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblRegistroMatri) {
			mouseClickedTblRegistroMatri(e);
		}
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	// MÉTODOS DE EVENTOS
	protected void actionPerformedCboOpciones(ActionEvent e) {
		String accion = cboOpciones.getSelectedItem().toString();
	    switch (accion) {
	      case "Adicionar":
	        prepararAdicionar();
	        break;
	      case "Modificar":
	        prepararModificar();
	        break;
	      case "Consultar":
	    	  prepararConsultar();
	    	  break;
	      case "Eliminar":
	        ejecutarEliminar();
	        break;
	      default:
	        deshabilitarTodo();
	    }
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
	    try {
	        String accion = cboOpciones.getSelectedItem().toString();

	        if (accion.equals("Adicionar")) {
	            int numMatricula = leerNumeroMatricula();
	            int codAlumno = leerCodigoAlumno();
	            int codCurso = leerCodigoCurso();

	            Alumno alumno = aa.buscar(codAlumno);
	            if (alumno == null) throw new Exception("Alumno no encontrado");

	            if (alumno.getEstado() == 0) {
	                Matricula nueva = new Matricula(
	                        numMatricula,
	                        codAlumno,
	                        codCurso,
	                        Calendario.horaActual(),
	                        Calendario.fechaActual()
	                );
	                alumno.setEstado(1);
	                aa.ActualizarArchivo();
	                am.adicionar(nueva);
	                listar();
	                mensaje("Nueva matrícula añadida exitosamente");
	            } else {
	                error("El alumno ya se encuentra matriculado", cboCodAlumno);
	            }

	        } else if (accion.equals("Modificar")) {
	            int numMatricula = leerNumeroMatricula();
	            int codCurso = leerCodigoCurso();
	            Matricula mat = am.buscar(numMatricula);
	            mat.setCodCurso(codCurso);
	            am.ActualizarArchivo();
	            listar();
	            mensaje("Matrícula modificada exitosamente");

	        } else if (accion.equals("Eliminar")) {
	            int confirmacion = confirmar();
	            if (confirmacion == 0) {
	                int numMatricula = leerNumeroMatricula();
	                int codAlumno = leerCodigoAlumno();
	                Matricula buscado = am.buscar(numMatricula);
	                if (buscado != null && aa.buscar(codAlumno).getEstado() == 1) {
	                    am.eliminar(buscado);
	                    aa.buscar(codAlumno).setEstado(0);
	                    aa.ActualizarArchivo();
	                    listar();
	                    mensaje("Matrícula eliminada exitosamente");
	                } else {
	                    error("No se puede eliminar. El alumno ya está retirado o no existe.", cboNumMatricula);
	                }
	            }

	        } else if (accion.equals("Consultar")) {
	            try {
	                int cod = Integer.parseInt(txtCodigoAlumno.getText().trim());
	                Alumno alumno1 = aa.buscar(cod);

	                if (alumno1 == null) {
	                    mensaje("El código ingresado no corresponde a ningún alumno");
	                } else {

	                    txtAlumno.setText(alumno1.getNombres() + " " + alumno1.getApellidos());
	                    txtEstadoAlumno.setText(nombreEstado(alumno1.getEstado()));

	                    Matricula mat = null;
	                    for (int i = 0; i < am.tamaño(); i++) {
	                        if (am.obtener(i).getCodAlumno() == cod) {
	                            mat = am.obtener(i);
	                            break;
	                        }
	                    }

	                    if (mat != null) {
	                        cboNumMatricula.setSelectedItem(mat.getNumMatricula());
	                        cboCodCurso.setSelectedItem(mat.getCodCurso());
	                        Curso curso = ac.buscar(mat.getCodCurso());
	                        if (curso != null)
	                            txtNombreCurso.setText(curso.getAsignatura());
	                    }
	                }
	                // 🔴 NO deshabilitar aquí, espera hasta que termine
	                return; // <- Salimos del método para evitar deshabilitar
	            } catch (Exception ex) {
	                mensaje("Ingrese un código válido");
	                return;
	            }
	        }
	        deshabilitarTodo();
	        cboOpciones.setSelectedIndex(0);

	    } catch (Exception ex) {
	        error("Datos incompletos o incorrectos", cboNumMatricula);
	    }
	}


	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
		cboOpciones.setSelectedIndex(0);
	}

	protected void itemStateChangedCboCodAlumno(ItemEvent e) {
		try {
			int codAlumno = leerCodigoAlumno();
			Alumno alumno = aa.buscar(codAlumno);
			if (alumno != null) {
				txtAlumno.setText(alumno.getNombres() + " " + alumno.getApellidos());
				txtEstadoAlumno.setText(nombreEstado(alumno.getEstado()));
			}
		} catch (Exception ex) {
			// Manejar error silenciosamente
		}
	}

	protected void itemStateChangedCboCodCurso(ItemEvent e) {
		try {
			int codCurso = leerCodigoCurso();
			Curso curso = ac.buscar(codCurso);
			if (curso != null) {
				txtNombreCurso.setText(curso.getAsignatura());
			}
		} catch (Exception ex) {
			// Manejar error silenciosamente
		}
	}

	protected void itemStateChangedCboNumMatricula(ItemEvent e) {
		try {
			int numMatricula = leerNumeroMatricula();
			Matricula matricula = am.buscar(numMatricula);
			if (matricula != null) {
				cboCodAlumno.setSelectedItem(matricula.getCodAlumno());
				cboCodCurso.setSelectedItem(matricula.getCodCurso());
			}
		} catch (Exception ex) {
			// Manejar error silenciosamente
		}
	}

	protected void mouseClickedTblRegistroMatri(MouseEvent e) {
		int filaSeleccionada = tblRegistroMatri.getSelectedRow();
		if (filaSeleccionada >= 0) {
			int codAlumno = (Integer) modelo.getValueAt(filaSeleccionada, 0);
			// Buscar la matrícula correspondiente
			for (int i = 0; i < am.tamaño(); i++) {
				if (am.obtener(i).getCodAlumno() == codAlumno) {
					cboNumMatricula.setSelectedItem(am.obtener(i).getNumMatricula());
					break;
				}
			}
		}
	}

	// MÉTODOS AUXILIARES
	void deshabilitarTodo() {
		listarCboNumMatricula();
		listarCboCodAlumno();
		listarCboCodCurso();
		habilitar(false, false, false, false, false, false, false, false, true, true, true,false);
		limpiar();
	}

	void listarCboNumMatricula() {
		cboNumMatricula.removeAllItems();
		for (int i = 0; i < am.tamaño(); i++) {
			cboNumMatricula.addItem(am.obtener(i).getNumMatricula());
		}
	}

	void listarCboCodAlumno() {
		cboCodAlumno.removeAllItems();
		for (int i = 0; i < aa.tamanio(); i++) {
			cboCodAlumno.addItem(aa.obtener(i).getCodAlumno());
		}
	}

	void listarCboCodCurso() {
		cboCodCurso.removeAllItems();
		for (int i = 0; i < ac.tamanio(); i++) {
			cboCodCurso.addItem(ac.obtener(i).getCodigo());
		}
	}
	void limpiar() {
	        cboNumMatricula.setSelectedIndex(-1);
	        cboCodAlumno.setSelectedIndex(-1);
	        txtAlumno.setText("");
	        txtEstadoAlumno.setText("");
	        cboCodCurso.setSelectedIndex(-1);
	        txtNombreCurso.setText("");
	        txtCodigoAlumno.setText("");
	    }
	void habilitar(boolean numMatricula, boolean codigoAlumno, boolean alumno, boolean estadoAlumno, boolean codigoCurso,
            boolean curso, boolean aceptar, boolean cancelar, boolean adicionar, boolean modificar, boolean eliminar, boolean codAlumno) {
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		txtCodigoAlumno.setEditable(codAlumno);

		cboNumMatricula.setEnabled(numMatricula);
		cboCodAlumno.setEnabled(codigoAlumno);
		cboCodCurso.setEnabled(codigoCurso);
	}
	
	void prepararAdicionar() {
	    limpiar();
	    habilitar(false, true, false, false, true, false, true, true, false, false, false,false);
	    cboNumMatricula.addItem(am.codigoCorrelativo());
	    cboNumMatricula.setSelectedIndex(am.tamaño());
	    cboCodAlumno.requestFocus();
	}
	void prepararConsultar() {
	    limpiar();
	    listarCboNumMatricula(); // <-- añade esto
	    listarCboCodCurso();     // <-- añade esto

	    // Habilitar solo lo necesario
	    txtCodigoAlumno.setEnabled(true);
	    txtCodigoAlumno.setEditable(true);
	    txtCodigoAlumno.requestFocus();

	    txtAlumno.setEnabled(true);
	    txtAlumno.setEditable(false);

	    txtEstadoAlumno.setEnabled(true);
	    txtEstadoAlumno.setEditable(false);

	    txtNombreCurso.setEnabled(true);
	    txtNombreCurso.setEditable(false);

	    cboNumMatricula.setEnabled(false);
	    cboCodAlumno.setEnabled(false);
	    cboCodCurso.setEnabled(false);

	    btnAceptar.setEnabled(true);
	    btnCancelar.setEnabled(true);
	}

	void error(String mensaje, JComboBox<?> combo) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
		combo.requestFocus();
	}

	void prepararModificar() {
		tblRegistroMatri.setRowSelectionInterval(0, 0);
		int codAlumno = (Integer) modelo.getValueAt(0, 0);
		 for (int i = 0; i < am.tamaño(); i++) {
		        if (am.obtener(i).getCodAlumno() == codAlumno) {
		            cboNumMatricula.setSelectedItem(am.obtener(i).getNumMatricula());
		            break;
		        }
		    }
	    habilitar(true, false, false, false, true, false, true, true, false, false, false,false);
	    cboCodAlumno.requestFocus();
	}

	void listar() {
		modelo.setRowCount(0);

		for (int i = 0; i < am.tamaño(); i++) {
			Object[] fila = {
				am.obtener(i).getCodAlumno(),
				aa.buscar(am.obtener(i).getCodAlumno()).getNombres(),
				aa.buscar(am.obtener(i).getCodAlumno()).getApellidos(),
				am.obtener(i).getCodCurso(),
				ac.buscar(am.obtener(i).getCodCurso()).getAsignatura(),
				am.obtener(i).getHora(),
				am.obtener(i).getFecha(),
				activo(aa.buscar(am.obtener(i).getCodAlumno()).getEstado())
			};
			modelo.addRow(fila);
		}
	}

	int leerNumeroMatricula() {
		return Integer.parseInt(cboNumMatricula.getSelectedItem().toString());
	}

	int leerCodigoAlumno() {
		return Integer.parseInt(cboCodAlumno.getSelectedItem().toString());
	}

	String leerAlumno() {
		return txtAlumno.getText().trim().toUpperCase();
	}

	int leerCodigoCurso() {
		return Integer.parseInt(cboCodCurso.getSelectedItem().toString());
	}

	int confirmar() {
		int valor = JOptionPane.showOptionDialog(null,
				"¿Estas seguro que deseas eliminar la Matricula?\n"
				+ "Alumno: " + leerAlumno() + "\n" + "Curso: " + leerCurso(),
				"Confirmar",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, null);
		return valor;
	}

	String leerCurso() {
		return txtNombreCurso.getText().trim().toUpperCase();
	}

	String leerEstadoAlumno() {
		return txtEstadoAlumno.getText();
	}

	String nombreEstado(int i) {
		switch (i) {
		case 0: return "REGISTRADO";
		case 1: return "MATRICULADO";
		case 2: return "RETIRADO";
		default:return null;
		}
	}

	String activo(int i) {
		return i == 1 ? "1" : "2";
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	void ejecutarEliminar() {
		 if (cboNumMatricula.getItemCount() == 0) {
		        mensaje("No hay matrículas para eliminar");
		        return;}
		    habilitar(true, false, false, false, false, false, true, true, false, false, false,false);
		    cboNumMatricula.requestFocus();
	}
}