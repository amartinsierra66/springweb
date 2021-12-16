package dao;

import java.util.List;

import model.Libro;

public interface LibrosDao {
	List<Libro> findAll();
	List<Libro> findByIdTheme(int idTema);
	Libro findByIsbn(int isbn);
}
