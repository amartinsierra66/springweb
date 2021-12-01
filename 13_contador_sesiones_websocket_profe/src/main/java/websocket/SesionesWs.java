package websocket;

import java.io.IOException;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/sesiones")
public class SesionesWs {
	@OnOpen
	public void init(Session sesion) {
		GestorSesiones gestor=GestorSesiones.getGestorSesiones();
		//añadimos la nueva sesión a la lista de sesiones
		gestor.addSession(sesion);
		//retransmitimos el tamaño de dicha lista a todos los clientes
		List<Session> sesiones=gestor.getSessions();
		for(Session s:sesiones) {
			try {
				s.getBasicRemote().sendText(sesiones.size()+"");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	@OnClose
	public void fin(Session sesion) {
		GestorSesiones gestor=GestorSesiones.getGestorSesiones();
		//quitamos la sesión cerrada de la lista de sesiones
		gestor.removeSession(sesion);
		//retransmitimos el tamaño de dicha lista a todos los clientes
		List<Session> sesiones=gestor.getSessions();
		for(Session s:sesiones) {
			try {
				s.getBasicRemote().sendText(sesiones.size()+"");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
}
