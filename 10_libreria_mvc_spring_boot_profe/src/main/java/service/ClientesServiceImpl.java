package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import model.Cliente;

@Service
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	ClientesDao clientesDao;
	@Override
	public Cliente validarCliente(String user, String password) {
		return clientesDao.findByCredentials(user, password);
	}
	@Override
	public boolean registrarCliente(Cliente cliente) {
		//Solo se añade si la combinación usuario/contraseña no existe
		if(clientesDao.findByCredentials(cliente.getUsuario(), cliente.getPassword())==null) {
			return clientesDao.saveCliente(cliente);
		}else {
			return false;
		}
		
	}	
}
