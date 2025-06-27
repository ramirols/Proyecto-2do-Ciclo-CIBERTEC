package colecciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Matricula;

public class ArrayMatricula {
	//CREACION DEL ARRAY LIST
	private ArrayList<Matricula> matricula;
	
	//METODOS 
	public ArrayMatricula() {
		matricula = new ArrayList<Matricula>();
		cargarMatriculas();
	}
	public void adicionar(Matricula x) {
		matricula.add(x);
		grabarMatriculas();
	}
	public void eliminar (Matricula x) {
		matricula.remove(x);
		grabarMatriculas();
	}
	public int tamaño() {
		return matricula.size();
	}
	public Matricula obtener(int i) {
		return matricula.get(i);
	}
	public Matricula buscar(int codigo) {
		for (int i=0; i<matricula.size(); i++) {
			if(matricula.get(i).getNumMatricula() == codigo)
				return matricula.get(i);
		}
		return null;
	}
	public Matricula buscarCod(int codigo) {
		for(int i = 0; i<matricula.size(); i++) {
			if (matricula.get(i).getCodAlumno() == codigo)
				return matricula.get(i);
		}
		return null;
	}
	public int codigoCorrelativo() {
		if(matricula.size() == 0) return 00001;
		return matricula.get(matricula.size()-1).getNumMatricula() + 1;
	}
	public void ActualizarArchivo() {
		grabarMatriculas();
	}
	//METODO PARA GUARDAR LOS DATOS EN EL TXT
	private void grabarMatriculas() {
		try {
			PrintWriter pw;
			String linea;
			Matricula x;
			pw = new PrintWriter(new FileWriter("Datos/matriculas.txt"));
			for (int i = 0; i<matricula.size(); i++) {
				x = matricula.get(i);
				linea = x.getNumMatricula()+";"+
						x.getCodAlumno()+";"+
						x.getCodCurso()+";"+
						x.getHora()+";"+
						x.getFecha();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al guardar las matrículas: " + e.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void cargarMatriculas() {
		try {
			int numMatricula, codAlumno, codCurso;
			String fecha, hora, linea;
			String[] s;
			BufferedReader br = new BufferedReader(new FileReader("Datos/matriculas.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				numMatricula = Integer.parseInt(s[0].trim());
				codAlumno = Integer.parseInt(s[1].trim());
				codCurso = Integer.parseInt(s[2].trim());
				fecha = s[3].trim();
				hora = s[4].trim();
				matricula.add(new Matricula(numMatricula, codAlumno, codCurso, fecha, hora));
			}
			br.close();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar las matrículas: " + e.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
