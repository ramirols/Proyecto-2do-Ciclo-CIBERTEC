package clases;

public class Alumno {
	//Atributos
	private String nombres;
	private String apellidos;
	private String dni;
	private int edad;
	private int celular;
	private int estado;
	private int codAlumno;
	
	//Metodo constructor
	public Alumno(int codAlumno, String nombres, String apellidos, String dni, int edad, int celular, int estado) {
		this.codAlumno=codAlumno;
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.dni=dni;
		this.edad=edad;
		this.celular=celular;
		this.estado = estado;
		
	}
	
	//Getters y setters
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	
}
