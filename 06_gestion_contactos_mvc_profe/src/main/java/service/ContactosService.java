package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {	
	boolean altaContacto(Contacto contacto);
	//elimina el contacto cuyo identificador se recibe como parámetro
	void eliminarContacto(int idContacto);	
	List<Contacto> recuperarContactos();

}