package service;

import java.util.List;

import model.Libro;
import model.Tema;

public interface LibrosService {
	List<Libro> recuperarLibros(int idTema);
	Libro recuperarLibroPorIsbn(int isbn);
	List<Tema> obtenerTemas();
	Tema recuperarTemaPorId(int idTema);
}