package dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Libro;

@Repository
public class VentasDaoImpl implements VentasDao {
	@Autowired
	@Qualifier("template2")
	JdbcTemplate template;
	@Override
	public void saveSell(int idCliente, List<Libro> libros) {
		 String sql="insert into ventas (idCliente, idLibro, fecha) values(?,?,?)";
		 for(Libro libro:libros) {
			 template.update(sql,idCliente,libro.getIsbn(),Timestamp.valueOf(LocalDateTime.now()));
		 }

	}

}
