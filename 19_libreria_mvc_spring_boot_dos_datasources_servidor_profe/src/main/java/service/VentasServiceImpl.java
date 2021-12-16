package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VentasDao;
import model.Cliente;
import model.Libro;
@Service
public class VentasServiceImpl implements VentasService {

	@Autowired
	VentasDao ventasDao;
	@Override
	public void nuevaVenta(Cliente cliente, List<Libro> libros) {
		if(cliente!=null&&libros!=null&&libros.size()>0) {
			ventasDao.saveSell(cliente.getIdCliente(), libros);
		}
	}

}
