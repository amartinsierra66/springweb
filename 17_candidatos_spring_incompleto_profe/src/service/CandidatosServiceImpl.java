package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CandidatosDao;
import model.Candidato;


public class CandidatosServiceImpl implements CandidatosService {
	@Autowired
	CandidatosDao repository;

	@Override
	public void altaCandidato(Candidato candidato) {
		if(repository.findById(candidato.getIdcandidato())==null&&
			buscarCandidato(candidato.getEmail())==null) {
			repository.save(candidato);
		}

	}

	@Override
	public void eliminarCandidato(int idCandidato) {
		if(repository.findById(idCandidato)!=null) {
			repository.deleteById(idCandidato);
		}

	}

	@Override
	public List<Candidato> recuperarCandidatos() {
		return repository.findAll();
	}

	@Override
	public Candidato buscarCandidato(String email) {
		return repository.findByEmail(email);
	}

}
