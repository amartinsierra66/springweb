package dao;

import java.util.List;

import model.Candidato;

public interface CandidatosDao {
	
	Candidato findByEmail(String email);
	Candidato findById(int idCandidato);
	void save(Candidato candidato);
	List<Candidato> findAll();
	void deleteById(int idCandidato);
	
	
	
}
