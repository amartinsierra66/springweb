package util;

import com.google.gson.Gson;

import model.Mensaje;

public class Utilidades {
	public static Mensaje convertirJsonAMensaje(String json) {
		Gson gson=new Gson();
		return gson.fromJson(json,Mensaje.class);
	}
	public static String convertirMensajeAJson(Mensaje mensaje) {
		Gson gson=new Gson();
		return gson.toJson(mensaje);
	}
}
