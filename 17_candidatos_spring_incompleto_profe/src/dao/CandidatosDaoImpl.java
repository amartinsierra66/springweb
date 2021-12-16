package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Candidato;
@Repository
public class CandidatosDaoImpl implements CandidatosDao {
	@Autowired
	JdbcTemplate template;
	@Override
	public Candidato findByEmail(String email) {
		//////
		return null;
	}

	@Override
	public Candidato findById(int idCandidato) {
		String sql="select * from candidatos where idCandidato=?";
		List<Candidato> candidatos= template.query(sql, 
				(rs,fila)->new Candidato(rs.getInt("idCandidato"), 
						rs.getString("nombre"), 
						rs.getInt("edad"), 
						rs.getString("puesto"), 
						rs.getString("email"))
				);
		return candidatos.size()>0?candidatos.get(0):null;
	}

	@Override
	public void save(Candidato candidato) {
		/////

	}

	@Override
	public List<Candidato> findAll() {
		String sql="select * from candidatos";
		return template.query(sql, 
				(rs,fila)->new Candidato(rs.getInt("idCandidato"), 
						rs.getString("nombre"), 
						rs.getInt("edad"), 
						rs.getString("puesto"), 
						rs.getString("email"))
				);
	}

	@Override
	public void deleteById(int idCandidato) {
		String sql="delete from candidatos where idCandidato=?";
		template.update(sql,idCandidato);

	}

}
