package service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CuentasDao;
import dao.MovimientosDao;
import model.Cuenta;
import model.Movimiento;
@Service
public class CajeroServiceImpl implements CajeroService {
	@Autowired
	CuentasDao cuentasRepository;
	@Autowired
	MovimientosDao movimientosRepository;
	@Override
	public Cuenta validarCuenta(int numeroCuenta) {
		return cuentasRepository.findById(numeroCuenta);
	}

	@Override
	public void ingresar(double cantidad, int numeroCuenta) {
		Cuenta cuenta=cuentasRepository.findById(numeroCuenta);
		if(cuenta !=null) {
			cuenta.setSaldo(cuenta.getSaldo()+cantidad);
			cuentasRepository.updateCuenta(cuenta);
			Movimiento m=new Movimiento(0,cantidad,LocalDate.now(),"ingreso",numeroCuenta);
			
			movimientosRepository.saveMovimiento(m);
		}
	}
	@Transactional
	@Override
	public void extraer(double cantidad, int numeroCuenta) {
		Cuenta cuenta=cuentasRepository.findById(numeroCuenta);
		if(cuenta !=null&&cuenta.getSaldo()>=cantidad) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			cuentasRepository.updateCuenta(cuenta);
			Movimiento m=new Movimiento(0,cantidad,LocalDate.now(),"extracción",numeroCuenta);
			movimientosRepository.saveMovimiento(m);
		}

	}

	@Override
	public void transferencia(double cantidad, int numeroCuentaOrigen, int numeroCuentaDestino) {
		ingresar(cantidad,numeroCuentaDestino);
		extraer(cantidad,numeroCuentaOrigen);

	}

	@Override
	public List<Movimiento> recuperarMovimientos(int numeroCuenta, LocalDate f1, LocalDate f2) {
		if(f1.isAfter(f2)) {
			return movimientosRepository.findByCuenta(numeroCuenta,f2,f1);
		}
		else {
			return movimientosRepository.findByCuenta(numeroCuenta,f1,f2);
		}
	}

	@Override
	public double saldo(int numeroCuenta) {	
		Cuenta cuenta= validarCuenta(numeroCuenta);
		if(cuenta!=null) {
			return cuenta.getSaldo();
		}
		return 0;
	}

}
