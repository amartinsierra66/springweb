package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Cliente;

@Repository
public class ClientesDaoImpl implements ClientesDao {
	
	@Autowired
	@Qualifier("template2")
	JdbcTemplate template;

	@Override
	public Cliente findByCredentials(String user, String pwd) {
		String sql="Select * from clientes where ";
        sql+="usuario=? and password=?";
        List<Cliente> clientes=template.query(sql, (rs,fila)->new Cliente(rs.getInt("idCliente"), 
  			  rs.getString("usuario"), 
  			  rs.getString("password"),
  			  rs.getString("email"),
  			  rs.getInt("telefono")),
        		user,pwd);
        return clientes.size()>0?clientes.get(0):null;
	}

	@Override
	public boolean saveCliente(Cliente cliente) {
		String sql="insert into clientes(usuario, password,email,telefono) values(?,?,?,?)";
		return template.update(sql,
				cliente.getUsuario(),
				cliente.getPassword(),
				cliente.getEmail(),
				cliente.getTelefono())>0;
	}

}
