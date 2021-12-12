package dao;

import java.time.LocalDate;
import java.util.List;

import model.Movimiento;

public interface MovimientosDao {
	void saveMovimiento(Movimiento movimiento);
	List<Movimiento> findByCuenta(int numeroCuenta);
	List<Movimiento> findByCuenta(int numeroCuenta,LocalDate f1, LocalDate f2);
}
