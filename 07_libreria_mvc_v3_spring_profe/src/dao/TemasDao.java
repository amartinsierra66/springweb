package dao;

import java.util.List;

import model.Tema;

public interface TemasDao {
	List<Tema> findAll();
	Tema findById(int idTema);
}
