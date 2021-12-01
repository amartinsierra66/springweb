package model;

public class Mensaje {
	private String usuario;
	private String mensaje;
	private int conectados;
	public Mensaje(String usuario, String mensaje, int conectados) {
		super();
		this.usuario = usuario;
		this.mensaje = mensaje;
		this.conectados = conectados;
	}
	public Mensaje() {
		super();
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getConectados() {
		return conectados;
	}
	public void setConectados(int conectados) {
		this.conectados = conectados;
	}
	
}
