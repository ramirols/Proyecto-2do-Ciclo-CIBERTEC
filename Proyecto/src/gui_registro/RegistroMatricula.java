package gui_registro;

import java.awt.EventQueue;
import clases.*;
import colecciones.*;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
	@SuppressWarnings("serial")
	public RegistroMatricula() {
		setResizable(false);
		getContentPane().setEnabled(false);
		setTitle("REGISTRO MATRICULA");
		
		setIconImage(new ImageIcon(getClass().getResource("/imgs/favicon.png")).getImage());
		
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
				new Object[][] {}, //Cuerpo de la tabla
				//Encabezados
				new String[] {"COD. ALU.", "NOMBRES", "APELLIDOS", "COD. CURSO.", "CURSO", "HORA", "FECHA", "ESTADO"}) {
				@Override //Sobreescritura del metodo isCellEditable para que retorne falso para evitar la edicion de las celdas
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
		
		//Ajustar tamanio igual
		for (int i = 0; i < tblRegistroMatri.getColumnCount(); i++) {
			tblRegistroMatri.getColumnModel().getColumn(i).setResizable(false);
			if (i >= 5) {
				tblRegistroMatri.getColumnModel().getColumn(i).setPreferredWidth(50);
			}
		}
		//Ajustar tamanio especifico 
		tblRegistroMatri.getColumnModel().getColumn(0).setPreferredWidth(62);
		tblRegistroMatri.getColumnModel().getColumn(2).setPreferredWidth(80);
		tblRegistroMatri.getColumnModel().getColumn(3).setPreferredWidth(70);
		tblRegistroMatri.getColumnModel().getColumn(3).setMinWidth(30);
		tblRegistroMatri.getColumnModel().getColumn(4).setPreferredWidth(150);
		modelo = (DefaultTableModel) tblRegistroMatri.getModel();
		scrollPane.setViewportView(tblRegistroMatri);
		
		//Evitar que se puedan mover las columnas de lugar
		tblRegistroMatri.getTableHeader().setReorderingAllowed(false);
		//Evitar que se seleccionen mas de una fila
		tblRegistroMatri.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
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
	    String accion = cboOpciones.getSelectedItem().toString();

	    switch (accion) {
	        case "Adicionar":
	        	if (leerCodigoAlumno() == -1) {
	        		mensaje("Selecciona un codigo de alumno");
	        		return;
	        	}
	        	if (leerCodigoCurso() == -1) {
	        		mensaje("Selecciona un codigo de curso");
	        		return;
	        	}
	            Alumno alu = aa.buscar(leerCodigoAlumno());
	            if (alu.getEstado() == 0) {
	                am.adicionar(new Matricula(
	                        leerNumeroMatricula(),
	                        alu.getCodAlumno(),
	                        leerCodigoCurso(),
	                        Calendario.fechaActual(),
	                        Calendario.horaActual()
	                ));
	                alu.setEstado(1);
	                aa.ActualizarArchivo();
	                listar();
	                mensaje("Nueva matrícula añadida exitosamente");
	            } else {
	                error("El alumno ya se encuentra matriculado", cboCodAlumno);
	            }
	            break;

	        case "Modificar":
	        	if (leerCodigoAlumno() == -1) {
	        		mensaje("Selecciona un codigo de alumno");
	        		return;
	        	}
	            am.buscar(leerNumeroMatricula()).setCodCurso(leerCodigoCurso());
	            am.ActualizarArchivo();
	            listar();
	            mensaje("Matrícula modificada exitosamente");
	            break;

	        case "Eliminar":
	        	//Validar si el campo esta vacio
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
	                Matricula m = am.buscar(leerNumeroMatricula());
	                Alumno a = aa.buscar(m.getCodAlumno());
	                am.eliminar(m);
	                a.setEstado(0);
	                aa.ActualizarArchivo();
	                listar();
	                mensaje("Matrícula eliminada exitosamente");
	            }
	            break;

	        case "Consultar":
	        	//Verificar si se ingreso un codigo
	        	if (txtCodigoAlumno.getText().trim().equals("") || txtCodigoAlumno.getText().trim().equals(" ")) {
	        		mensaje("Ingresa un codigo de alumno");
	        		return;
	        	}
	        	if ((txtCodigoAlumno.getText() instanceof String)){
	        		mensaje("Ingresa un codigo de alumno");
	        		return;
	        	}
	        	
	            Alumno al = aa.buscar(Integer.parseInt(txtCodigoAlumno.getText().trim()));
	            txtAlumno.setText(al.getNombres() + " " + al.getApellidos());
	            txtEstadoAlumno.setText(nombreEstado(al.getEstado()));

	            for (int i = 0; i < am.tamaño(); i++) {
	                Matricula mat = am.obtener(i);
	                if (mat.getCodAlumno() == al.getCodAlumno()) {
	                    cboNumMatricula.setSelectedItem(mat.getNumMatricula()); //Establecer numero de matricula en cbo
	                    cboCodCurso.setSelectedItem(mat.getCodCurso()); //Establecer codigo de curso en cbo
	                    Curso c = ac.buscar(mat.getCodCurso());
	                    if (c != null)
	                        txtNombreCurso.setText(c.getAsignatura());
	                    break;
	                }
	            }
	            return;
	        default:
	            mensaje("Acción no reconocida.");
	    }
	    deshabilitarTodo();
	    cboOpciones.setSelectedIndex(0);
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
		cboOpciones.setSelectedIndex(0);
	}
	protected void itemStateChangedCboCodAlumno(ItemEvent e) {
			int codAlumno = leerCodigoAlumno();
			Alumno alumno = aa.buscar(codAlumno);
			if (alumno != null) {
				txtAlumno.setText(alumno.getNombres() + " " + alumno.getApellidos());
				txtEstadoAlumno.setText(nombreEstado(alumno.getEstado()));
			}
			for (int i = 0; i < am.tamaño(); i++) {
			    Matricula m = am.obtener(i);
			    if (m.getCodAlumno() == codAlumno) {
			        cboNumMatricula.setSelectedItem(m.getNumMatricula());
			        cboCodCurso.setSelectedItem(m.getCodCurso());
			        break;
			    }
			}
		}
	protected void itemStateChangedCboCodCurso(ItemEvent e) {
			int codCurso = leerCodigoCurso();
			Curso curso = ac.buscar(codCurso);
			if (curso != null) {
				txtNombreCurso.setText(curso.getAsignatura());
			}
	}
	protected void itemStateChangedCboNumMatricula(ItemEvent e) {
			int numMatricula = leerNumeroMatricula();
			Matricula matricula = am.buscar(numMatricula);
			if (matricula != null) {
				cboCodAlumno.setSelectedItem(matricula.getCodAlumno());
				cboCodCurso.setSelectedItem(matricula.getCodCurso());
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
		habilitar(false, false, false, false, false, false, true, true,false);
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
            boolean curso, boolean aceptar, boolean cancelar, boolean codAlumno) {
		cboNumMatricula.setEnabled(numMatricula);
		cboCodAlumno.setEnabled(codigoAlumno);
		txtAlumno.setEditable(alumno);
		txtEstadoAlumno.setEnabled(estadoAlumno);
		cboCodCurso.setEnabled(codigoCurso);
		txtNombreCurso.setEnabled(curso);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		txtCodigoAlumno.setEditable(codAlumno);
	}
	void prepararAdicionar() {
	    limpiar();
	    habilitar(true, true, false, true, true, true, true, true,false);
	    cboNumMatricula.addItem(am.codigoCorrelativo());
	    cboNumMatricula.setSelectedIndex(am.tamaño());
	    cboCodAlumno.requestFocus();
	}
	void prepararConsultar() {
	    limpiar();
	    habilitar(false, false, false, false, false, false, true, true, true);

	    txtCodigoAlumno.requestFocus();
	}
	void error(String mensaje, JComboBox<?> combo) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
		combo.requestFocus();
	}

	void prepararModificar() {
	    habilitar(true, true, false, true, true, true, true, true,false);
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
				am.obtener(i).getFecha(),
				am.obtener(i).getHora(),
				activo(aa.buscar(am.obtener(i).getCodAlumno()).getEstado())
			};
			modelo.addRow(fila);
		}
	}
	int leerNumeroMatricula() {
		return Integer.parseInt(cboNumMatricula.getSelectedItem().toString());
	}
	int leerCodigoAlumno() {
		if (cboCodAlumno.getSelectedItem() == null) { //Test
			return -1;
		}
		return Integer.parseInt(cboCodAlumno.getSelectedItem().toString());
	}
	String leerAlumno() {
		return txtAlumno.getText().trim().toUpperCase();
	}
	int leerCodigoCurso() {
		if (cboCodCurso.getSelectedItem() == null) { //Test
			return -1;
		}
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
		 if (cboCodAlumno.getItemCount() == 0) {
		        mensaje("No hay matrículas para eliminar");
		        return;}
		    habilitar(true, true, false, true, false, false, true, true,false);
		    cboCodAlumno.requestFocus();
	}
}