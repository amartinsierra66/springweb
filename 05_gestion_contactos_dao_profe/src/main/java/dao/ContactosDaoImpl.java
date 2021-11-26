package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Contacto;


@Repository
public class ContactosDaoImpl implements ContactosDao {
	@Autowired
	JdbcTemplate template;

	@Override
	public void saveContact(Contacto contacto) {
		String sql="Insert into contactos(nombre, email, edad) values(?,?,?)";
		template.update(sql,contacto.getNombre(),contacto.getEmail(),contacto.getEdad());
	}

	@Override
	public Contacto findByEmail(String email) {
		String sql="select * from contactos where email=?";		
		List<Contacto> resultado= template.query(sql, (rs,f)->
				new Contacto(rs.getInt("idContacto"), 
				rs.getString("nombre"), 
				rs.getString("email"), 
				rs.getInt("edad")),
				email);
		return resultado.size()>0?resultado.get(0):null;
	}

	@Override
	public Contacto findById(int idContacto) {
		String sql="select * from contactos where idContacto=?";
		try {
			return template.queryForObject(sql, (rs,f)->
					new Contacto(rs.getInt("idContacto"), 
					rs.getString("nombre"), 
					rs.getString("email"), 
					rs.getInt("edad")),
					idContacto);
		}
		catch(EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	public List<Contacto> findAll() {
		String sql="select * from contactos ";	
		return template.query(sql, (rs,f)->
					new Contacto(rs.getInt("idContacto"), 
							rs.getString("nombre"), 
							rs.getString("email"), 
							rs.getInt("edad")));
	}

	@Override
	public void removeById(int idContacto) {
		String sql="delete from contactos where idContacto=?";
		template.update(sql,idContacto);

	}

}
