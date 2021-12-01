package servidor;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

public class SingletonSesiones {
	private static SingletonSesiones obj;
	private static List<Session> sesiones;
	private SingletonSesiones() {
		sesiones=new ArrayList<>();
	}
	public static SingletonSesiones getInstance() {
		if(obj==null) {
			obj=new SingletonSesiones();
		}
		return obj;
	}
	
	public void agregarSesion(Session s) {
		sesiones.add(s);
	}
	public List<Session> recuperarSesiones(){
		return sesiones;
	}
	public void eliminarSesion(Session s) {
		sesiones.remove(s);
	}
}
