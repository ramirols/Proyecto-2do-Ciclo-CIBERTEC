package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import colecciones.ArrayAlumnos;
import gui_consulta.ConsultaAlumnoCurso;
import gui_consulta.ConsultaMatriculasRetiros;
import gui_registro.RegistroMatricula;
import gui_registro.RegistroRetiro;
import gui_reporte.Reporte_MP;
import gui_reporte.Reporte_MPC;
import gui_reporte.Reporte_MV;

public class Menu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mntmAlumno;
	private JMenuItem mntmCurso;
	private JMenuItem mntmConsultaAlumno;
	private JMenuItem mntmConsultaMatriculaRetiro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Menu");
		
		setIconImage(new ImageIcon(getClass().getResource("/imgs/favicon.png")).getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmAlumno = new JMenuItem("Alumnos");
		mntmAlumno.addActionListener(this);
		mnMantenimiento.add(mntmAlumno);
		
		mntmCurso = new JMenuItem("Cursos");
		mntmCurso.addActionListener(this);
		mnMantenimiento.add(mntmCurso);
		
		mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mntmRegistroMatricula = new JMenuItem("Matricula");
		mntmRegistroMatricula.addActionListener(this);
		mnRegistro.add(mntmRegistroMatricula);
		
		mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.addActionListener(this);
		mnRegistro.add(mntmRetiro);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mntmConsultaAlumno = new JMenuItem("Alumnos y Cursos");
		mntmConsultaAlumno.addActionListener(this);
		mnConsulta.add(mntmConsultaAlumno);
		
		mntmConsultaMatriculaRetiro = new JMenuItem("Matrículas y Retiros");
		mntmConsultaMatriculaRetiro.addActionListener(this);
		mnConsulta.add(mntmConsultaMatriculaRetiro);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmMatriculaPendiente = new JMenuItem("Matrícula pendiente");
		mntmMatriculaPendiente.addActionListener(this);
		mnReporte.add(mntmMatriculaPendiente);
		
		mntmMatriculaVigente = new JMenuItem("Matricula Vigente");
		mntmMatriculaVigente.addActionListener(this);
		mnReporte.add(mntmMatriculaVigente);
		
		mntmMatriculaPorCurso = new JMenuItem("Matricula por Curso");
		mntmMatriculaPorCurso.addActionListener(this);
		mnReporte.add(mntmMatriculaPorCurso);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Cargar imagen central
	    ImageIcon imagen = new ImageIcon(getClass().getResource("/imgs/fondo.png"));
	    JLabel lblImagenCentral1 = new JLabel(imagen);
	    contentPane.add(lblImagenCentral1); // aún sin coordenadas

	    // Centrar la imagen cuando el frame se redimensiona o inicia
	    addComponentListener(new ComponentAdapter() {
	        @Override
	        public void componentResized(ComponentEvent e) {
	            int anchoImagen = imagen.getIconWidth();
	            int altoImagen = imagen.getIconHeight();

	            int anchoPanel = contentPane.getWidth();
	            int altoPanel = contentPane.getHeight();

	            int x = (anchoPanel - anchoImagen) / 2;
	            int y = (altoPanel - altoImagen) / 2;

	            lblImagenCentral1.setBounds(x, y, anchoImagen, altoImagen);
	        }
	    });
		
	}
	
	ArrayAlumnos aa = new ArrayAlumnos();
	private JMenuItem mntmMatriculaPendiente;
	private JMenuItem mntmMatriculaVigente;
	private JMenuItem mntmRegistroMatricula;
	private JMenuItem mntmMatriculaPorCurso;
	private JMenuItem mntmRetiro;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmRetiro) {
			actionPerformedMntmRetiro(e);
		}
		if (e.getSource() == mntmMatriculaPorCurso) {
			actionPerformedMntmMatriculaPorCurso(e);
		}
		if (e.getSource() == mntmRegistroMatricula) {
			actionPerformedMntmRegistroMatricula(e);
		}
		if (e.getSource() == mntmMatriculaVigente) {
			actionPerformedMntmMatriculaVigente(e);
		}
		if (e.getSource() == mntmCurso) {
			actionPerformedMntmCurso(e);
		}
		if (e.getSource() == mntmAlumno) {
			actionPerformedMntmAlumno(e);
		}
		
		if (e.getSource() == mntmMatriculaPendiente) {
            actionPerformedMntmMatriculaPendiente(e);
        }
		
		if (e.getSource() == mntmConsultaAlumno) {
			ConsultaAlumnoCurso ventana = new ConsultaAlumnoCurso();
			ventana.setVisible(true);
		}
		
		if (e.getSource() == mntmConsultaMatriculaRetiro) {
			new ConsultaMatriculasRetiros().setVisible(true);
		}
		
	}
	protected void actionPerformedMntmAlumno(ActionEvent e) {
		MantenimientoAlumno MA = new MantenimientoAlumno();
		MA.setLocationRelativeTo(MA);
		MA.setVisible(true);
	}
	protected void actionPerformedMntmCurso(ActionEvent e) {
		MantenimientoCurso MC = new MantenimientoCurso();
		MC.setLocationRelativeTo(MC);
		MC.setVisible(true);
	}

	protected void actionPerformedMntmMatriculaPendiente(ActionEvent e) {
        Reporte_MP MP = new Reporte_MP();
        MP.setLocationRelativeTo(this);
        MP.setVisible(true);
	}
	protected void actionPerformedMntmMatriculaVigente(ActionEvent e) {
		Reporte_MV MV = new Reporte_MV();
		MV.setLocationRelativeTo(this);
        MV.setVisible(true);
	}
	protected void actionPerformedMntmRegistroMatricula(ActionEvent e) {
		RegistroMatricula RM = new RegistroMatricula();
		RM.setLocationRelativeTo(this);
        RM.setVisible(true);
	}
	protected void actionPerformedMntmMatriculaPorCurso(ActionEvent e) {
		Reporte_MPC MPC = new Reporte_MPC();
		MPC.setLocationRelativeTo(this);
        MPC.setVisible(true);
	}
	protected void actionPerformedMntmRetiro(ActionEvent e) {
		RegistroRetiro RR = new RegistroRetiro();
		RR.setLocationRelativeTo(this);
		RR.setVisible(true);
	}
}
