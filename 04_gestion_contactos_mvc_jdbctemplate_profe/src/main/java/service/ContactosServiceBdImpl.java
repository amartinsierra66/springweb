package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Contacto;
@Service
public class ContactosServiceBdImpl implements ContactosService {
	@Autowired
	JdbcTemplate template;
	
	
	@Override
	public void altaContacto(Contacto contacto) {
		
		String sql="Insert into contactos(nombre, email, edad) values(?,?,?)";
		template.update(sql,contacto.getNombre(),contacto.getEmail(),contacto.getEdad());
	}
	//elimina el contacto cuyo identificador se recibe como parámetro
	@Override
	public void eliminarContacto(int idContacto) {
		
		String sql="delete from contactos where idContacto=?";
		template.update(sql,idContacto);
	}
	//establece un nuevo email y edad, para el contacto cuyo identificador se recibe
	@Override
	public void actualizarDatosContacto(int idContacto, String email, int edad) {
		
		String sql="update contactos set email=?,edad=? where idContacto=?";
		template.update(sql,email,edad,idContacto);
		
	}
	
	
	@Override
	public List<Contacto> recuperarContactos(){
		
		String sql="select * from contactos ";	
		return template.query(sql, (rs,f)->
					new Contacto(rs.getInt("idContacto"), 
							rs.getString("nombre"), 
							rs.getString("email"), 
							rs.getInt("edad")));
				
	}
	
	@Override
	public List<Contacto> recuperarContactos(String fin){
		return recuperarContactos().stream()
			.filter(c->c.getEmail().endsWith(fin))
			.collect(Collectors.toList());
	}
	@Override
	public void altaContactos(Contacto[] contactos) {
		
		String sql="Insert into contactos(nombre, email, edad) values(?,?,?)";
		for(Contacto c:contactos) {
			template.update(sql,c.getNombre(),c.getEmail(),c.getEdad());
		}
	}
	@Override
	public Contacto contactoPorEmail(String email) {
		String sql="select * from contactos where email=?";
		
		return template.queryForObject(sql, (rs,f)->
				new Contacto(rs.getInt("idContacto"), 
				rs.getString("nombre"), 
				rs.getString("email"), 
				rs.getInt("edad")),
				email);
	}
}
