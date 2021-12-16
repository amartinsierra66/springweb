package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Libro;
@Repository
public class LibrosDaoImpl implements LibrosDao {
	@Autowired
	@Qualifier("template2")
	JdbcTemplate template;
	@Override
	public List<Libro> findAll() {
		String sql="select * from libros";
		return template.query(sql, (rs,fila)->
			new Libro(rs.getInt("isbn"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getDouble("precio"),
                rs.getInt("paginas"),
                rs.getInt("idTema")));
	}

	@Override
	public List<Libro> findByIdTheme(int idTema) {
		String sql="select * from libros where idTema=?";
		return template.query(sql, (rs,fila)->
			new Libro(rs.getInt("isbn"),
	            rs.getString("titulo"),
	            rs.getString("autor"),
	            rs.getDouble("precio"),
	            rs.getInt("paginas"),
	            rs.getInt("idTema")),
					idTema);
	}

	@Override
	public Libro findByIsbn(int isbn) {
		String sql="select * from libros where isbn=?";
		List<Libro> libros=template.query(sql, (rs,fila)->
			new Libro(rs.getInt("isbn"),
	            rs.getString("titulo"),
	            rs.getString("autor"),
	            rs.getDouble("precio"),
	            rs.getInt("paginas"),
	            rs.getInt("idTema")),
					isbn);
		return libros.size()>0?libros.get(0):null;
	}

}
