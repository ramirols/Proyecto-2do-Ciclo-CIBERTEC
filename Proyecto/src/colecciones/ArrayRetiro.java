package colecciones;

import java.io.*;
import java.util.ArrayList;
import clases.Retiro;

public class ArrayRetiro {
	private ArrayList<Retiro> retiros;

	public ArrayRetiro() {
		retiros = new ArrayList<Retiro>();
		cargar();
	}

	public void adicionar(Retiro r) {
		retiros.add(r);
		grabar();
	}

	public int tamanio() {
		return retiros.size();
	}

	public Retiro obtener(int i) {
		return retiros.get(i);
	}

	public Retiro buscar(int numRetiro) {
		for (Retiro r : retiros) {
			if (r.getNumRetiro() == numRetiro) {
				return r;
			}
		}
		return null;
	}
	public int codigoCorrelativo() {
		if (retiros.size() == 0)
			return 200001;
		return retiros.get(retiros.size() - 1).getNumRetiro() + 1;
	}

	public void grabar() {
		try (PrintWriter pw = new PrintWriter(new FileWriter("Datos/retiros.txt"))) {
			for (Retiro r : retiros) {
				String linea = r.getNumRetiro() + ";" + r.getNumMatricula() + ";" + r.getFecha() + ";" + r.getHora();
				pw.println(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void eliminar(Retiro x) {
		retiros.remove(x);
		grabar();
	}
	private void cargar() {
		try (BufferedReader br = new BufferedReader(new FileReader("Datos/retiros.txt"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] s = linea.split(";");
				int numRetiro = Integer.parseInt(s[0].trim());
				int numMatricula = Integer.parseInt(s[1].trim());
				String fecha = s[2].trim();
				String hora = s[3].trim();
				retiros.add(new Retiro(numRetiro, numMatricula, fecha, hora));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
