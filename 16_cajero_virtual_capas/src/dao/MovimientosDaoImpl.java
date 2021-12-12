package dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Cuenta;
import model.Movimiento;
@Repository
public class MovimientosDaoImpl implements MovimientosDao {
	@Autowired
	JdbcTemplate template;
	@Override
	public void saveMovimiento(Movimiento movimiento) {
		String sql="insert into movimientos(cantidad,fecha,operacion,idCuenta) values(?,?,?,?)";
		template.update(sql,movimiento.getCantidad(),
				Date.valueOf(movimiento.getFecha()),
				movimiento.getOperacion(),
				movimiento.getCuenta());
	}

	@Override
	public List<Movimiento> findByCuenta(int numeroCuenta) {
		String sql="select * from movimientos where idCuenta=?";
		return template.query(sql, (rs,f)->new Movimiento(0,
				rs.getDouble("cantidad"),
				rs.getDate("fecha").toLocalDate(),
				rs.getString("operacion"),
				rs.getInt("idCuenta")),
				numeroCuenta);
	}

	@Override
	public List<Movimiento> findByCuenta(int numeroCuenta, LocalDate f1, LocalDate f2) {
		String sql="select * from movimientos where idCuenta=? and fecha>=? and fecha<=?";
		return template.query(sql, (rs,f)->new Movimiento(0,
				rs.getDouble("cantidad"),
				rs.getDate("fecha").toLocalDate(),
				rs.getString("operacion"),
				rs.getInt("idCuenta")),
				numeroCuenta,
				Date.valueOf(f1),
				Date.valueOf(f2));
	}

}
