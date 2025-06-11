package clases;

public class Retiro {
	//Atributos
	private String fecha;
	private String hora;
	
	//Constructor
	public Retiro(String fecha, String hora) {

		this.fecha = fecha;
		this.hora = hora;
	}
	
	//Getters y setters
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
