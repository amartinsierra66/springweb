package dao;

import model.Cliente;

public interface ClientesDao {
	Cliente findByCredentials(String user, String pwd);
	boolean saveCliente(Cliente cliente);
}
