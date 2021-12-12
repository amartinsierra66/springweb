package dao;
import java.util.List;

import model.Cuenta;

public interface CuentasDao {
	void updateCuenta(Cuenta cuenta);
	Cuenta findById(int numeroCuenta);
	
}
