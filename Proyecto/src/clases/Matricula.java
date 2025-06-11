package clases;

public class Matricula {
	//Atributos
	private String String;
	private String hora;
	
	//Constructor
	public Matricula(String string, String hora) {
		String = string;
		this.hora = hora;
	}
	
	//Getters y setters

	public String getString() {
		return String;
	}
	public void setString(String string) {
		String = string;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
