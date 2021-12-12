package service;

import java.time.LocalDate;
import java.util.List;

import model.Cuenta;
import model.Movimiento;

public interface CajeroService {
	Cuenta validarCuenta(int numeroCuenta);
	void ingresar(double cantidad, int numeroCuenta);
	void extraer(double cantidad, int numeroCuenta);
	void transferencia(double cantidad, int numeroCuentaOrigen, int numeroCuentaDestino);
	List<Movimiento> recuperarMovimientos(int numeroCuenta,LocalDate f1, LocalDate f2);
	double saldo(int numeroCuenta);	
}
