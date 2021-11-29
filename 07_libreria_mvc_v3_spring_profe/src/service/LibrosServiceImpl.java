/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LibrosDao;
import dao.TemasDao;
import model.Libro;
import model.Tema;

@Service
 public class LibrosServiceImpl implements LibrosService {
	
	@Autowired
	LibrosDao librosDao;
	@Autowired
	TemasDao temasDao;

	@Override
	public List<Libro> recuperarLibros(int idTema) {
		if(idTema==0) {
			return librosDao.findAll();
		}else {
			return librosDao.findByIdTheme(idTema);
		}
	}

	@Override
	public Libro recuperarLibroPorIsbn(int isbn) {
		return librosDao.findByIsbn(isbn);
	}

	@Override
	public List<Tema> obtenerTemas() {
		return temasDao.findAll();
	}

	@Override
	public Tema recuperarTemaPorId(int idTema) {
		return temasDao.findById(idTema);
	}
	   
}
