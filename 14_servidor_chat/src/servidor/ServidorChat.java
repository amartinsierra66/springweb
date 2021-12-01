package servidor;

import java.io.IOException;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import model.Mensaje;
import util.Utilidades;

@ServerEndpoint("/chat")
public class ServidorChat {
	@OnOpen
	public void open(Session sesion) {
		
		SingletonSesiones singleton=SingletonSesiones.getInstance();
		singleton.agregarSesion(sesion);
		
	}
	@OnClose
	public void close(Session sesion) {
		SingletonSesiones singleton=SingletonSesiones.getInstance();
		singleton.eliminarSesion(sesion);
		
	}
	
	@OnMessage
	public void recepcion(String message) {
		Mensaje mensaje=Utilidades.convertirJsonAMensaje(message);
		
		//retransmitimos el mensaje a todas las sesiones
		List<Session> sesiones=SingletonSesiones.getInstance().recuperarSesiones();
		mensaje.setConectados(sesiones.size());
		//convertimos el mensaje a JSON para enviarlo
		String textoJson=Utilidades.convertirMensajeAJson(mensaje);
		sesiones.forEach(s->{
			try {
				
				s.getBasicRemote().sendText(textoJson);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	
}
