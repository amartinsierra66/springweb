package websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/saludar")
public class SaludoWs {
	@OnOpen
	public void init(Session sesion) {
		System.out.println("El servidor se ha conectado");
	}
	
	@OnClose
	public void fin() {
		System.out.println("El servidor se ha cerrado");
	}
	
	
	@OnMessage
	public String message(String texto) {
		return "Bienvenido a mi websocket "+texto;
	}
}
