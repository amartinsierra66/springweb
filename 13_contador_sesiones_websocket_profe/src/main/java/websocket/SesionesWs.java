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
		//a�adimos la nueva sesi�n a la lista de sesiones
		gestor.addSession(sesion);
		//retransmitimos el tama�o de dicha lista a todos los clientes
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
		//quitamos la sesi�n cerrada de la lista de sesiones
		gestor.removeSession(sesion);
		//retransmitimos el tama�o de dicha lista a todos los clientes
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
