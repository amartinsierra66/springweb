package model;

public class Candidato {
	
	private int idcandidato;
	private String nombre;
	
	private int edad;
	private String puesto;
	private String email;
	public Candidato(int idcandidato, String nombre, int edad, String puesto, String email) {
		super();
		this.idcandidato = idcandidato;
		this.nombre = nombre;
		this.edad = edad;
		this.puesto = puesto;
		this.email = email;
	}
	public Candidato() {
		super();
	}
	public int getIdcandidato() {
		return idcandidato;
	}
	public void setIdcandidato(int idcandidato) {
		this.idcandidato = idcandidato;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
