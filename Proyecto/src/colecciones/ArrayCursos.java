package colecciones;

import java.io.*;
import java.util.ArrayList;
import clases.Curso;

public class ArrayCursos {
	private ArrayList<Curso> curso;
	
	public ArrayCursos() {
		curso = new ArrayList<Curso>();
		cargarCursos();
	}
	
	public void adicionar(Curso x) {
		curso.add(x);
		grabarCursos();
	}
	public void eliminar(Curso x) {
		curso.remove(x);
		grabarCursos();
	}
	public int tamanio() {
		return curso.size();
	}
	public Curso obtener(int i) {
		return curso.get(i);
	}
	public Curso buscar(int codigo) {
		for (int i = 0; i < curso.size(); i++) {
			if (curso.get(i).getCodigo() == codigo)
				return curso.get(i);
		}
		return null;
	}
	
	public int codigoCorrelativo() {
		if (curso.size() == 0)
			return 101;
		return curso.get(curso.size()-1).getCodigo() + 1;
	}
	public void ActualizarArchivo() {
		grabarCursos();
	}
	
	private void grabarCursos() {
		try {
			PrintWriter pw;
			String linea;
			Curso x;
			pw = new PrintWriter(new FileWriter("Datos/cursos.txt"));
			for (int i = 0; i< curso.size(); i++) {
				x = curso.get(i);
				linea = x.getCodigo() + ";" +
					    x.getAsignatura() + ";" +
						x.getCiclo() + ";" +
						x.getCreditos() + ";" +
						x.getHoras();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarCursos() {
		try {
			BufferedReader br;
			int codCurso, ciclo, creditos, horas;
			String asignatura, linea;
			String[] s = new String[5];
			br = new BufferedReader(new FileReader("Datos/cursos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codCurso = Integer.parseInt(s[0].trim());
				asignatura = s[1].trim();
				ciclo = Integer.parseInt(s[2].trim());
				creditos = Integer.parseInt(s[3].trim());
				horas = Integer.parseInt(s[4].trim());
				curso.add(new Curso(codCurso, asignatura, ciclo, creditos, horas));
			}
			br.close();
		}
		catch (Exception e) {
			
		}
	}
}

