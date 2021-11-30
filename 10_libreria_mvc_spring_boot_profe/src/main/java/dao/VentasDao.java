package dao;

import java.util.List;

import model.Libro;

public interface VentasDao {
	void saveSell(int idCliente, List<Libro> libros);
}
