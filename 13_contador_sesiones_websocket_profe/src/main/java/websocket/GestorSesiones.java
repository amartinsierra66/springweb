package websocket;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

public class GestorSesiones {
	private static GestorSesiones gestor;
	private static List<Session> sesiones;
	private GestorSesiones() {
		sesiones=new ArrayList<>();
	}
	public static GestorSesiones getGestorSesiones() {
		if(gestor==null) {
			gestor=new GestorSesiones();
		}
		return gestor;
	}	
	public void addSession(Session sesion) {
		sesiones.add(sesion);
	}
	public void removeSession(Session sesion) {
		sesiones.remove(sesion);
	}
	public List<Session> getSessions(){
		return sesiones;
	}
}
