package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Tema;

@Repository
public class TemasDaoImpl implements TemasDao {
	@Autowired
	@Qualifier("template2")
	JdbcTemplate template;
	@Override
	public List<Tema> findAll() {
		String sql="select * from temas";
		return template.query(sql, (rs,fila)->
			new Tema(rs.getInt("idTema"),rs.getString("tema")));
	}

	@Override
	public Tema findById(int idTema) {
		String sql="select * from temas where idTema=?";
		List<Tema> temas= template.query(sql, (rs,fila)->
			new Tema(rs.getInt("idTema"),rs.getString("tema")),idTema);
		return temas.size()>0?temas.get(0):null;
	}

}
