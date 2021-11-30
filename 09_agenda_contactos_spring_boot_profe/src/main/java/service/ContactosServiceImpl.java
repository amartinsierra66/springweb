package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ContactosDao;
import model.Contacto;

@Service
public class ContactosServiceImpl implements ContactosService {

	@Autowired
	ContactosDao dao;
	@Override
	public boolean altaContacto(Contacto contacto) {
		//el contacto se añade si el email no existe
		if(dao.findByEmail(contacto.getEmail())==null) {
			dao.saveContact(contacto);
			return true;
		}else {
			return false;
		}

	}

	@Override
	public void eliminarContacto(int idContacto) {
		if(dao.findById(idContacto)!=null) {
			dao.removeById(idContacto);
		}

	}

	@Override
	public List<Contacto> recuperarContactos() {
		return dao.findAll();
	}

}
