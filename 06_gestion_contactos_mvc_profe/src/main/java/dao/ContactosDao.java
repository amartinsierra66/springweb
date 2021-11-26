package dao;

import java.util.List;

import model.Contacto;

public interface ContactosDao {
	void saveContact(Contacto contacto);
	Contacto findByEmail(String email);
	Contacto findById(int idContacto);
	List<Contacto> findAll();
	void removeById(int idContacto);
	
}
