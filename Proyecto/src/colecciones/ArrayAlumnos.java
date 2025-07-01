package colecciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Alumno;

public class ArrayAlumnos {
	//Variable de clase
	private static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	
	public ArrayAlumnos() {
		listaAlumnos = new ArrayList<Alumno>();
		cargarAlumnos();
	}
	//getter
	public static ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}
	public int codigoCorrelativo() {
		if (listaAlumnos.size() == 0) return 202010001;
		return listaAlumnos.get(listaAlumnos.size()-1).getCodAlumno() + 1;
	}
	//Metodos
	public void adicionarAlumno(Alumno alu) {
		listaAlumnos.add(alu);
		grabarAlumnos();
	}
	public int tamanio() {
		return listaAlumnos.size();
	}
	public Alumno obtener(int i) {
		return listaAlumnos.get(i);
	}
	public void eliminarAlumno(int i){
		listaAlumnos.remove(i);
	}
	public Alumno buscar(int codigo) {
		for (int i = 0; i < listaAlumnos.size(); i++) {
			if (listaAlumnos.get(i).getCodAlumno() == codigo)
				return listaAlumnos.get(i);
		}
		return null;
	}
	public void ActualizarArchivo() {
		grabarAlumnos();
	}
	private void grabarAlumnos() {
		try {
			PrintWriter pw;
			String linea;
			Alumno x;
			pw = new PrintWriter(new FileWriter("Datos/Alumnos.txt"));
			for (int i = 0; i< listaAlumnos.size(); i++) {
				x = listaAlumnos.get(i);
				linea = x.getCodAlumno() + ";" +
					    x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getDni() + ";" +
						x.getEdad() + ";" +
						x.getCelular() + ";" +
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarAlumnos() {
		try {
			BufferedReader br;
			String linea, nombres, apellidos, dni;
			String[] s;
			int codAlumno, estado, edad, celular;
			br = new BufferedReader(new FileReader("Datos/Alumnos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codAlumno = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				dni = s[3].trim();
				edad = Integer.parseInt(s[4].trim());
				celular = Integer.parseInt(s[5].trim());
				estado = Integer.parseInt(s[6].trim());
				adicionarAlumno(new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado));
			}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace(); // muestra el error real
		}
	}
}
