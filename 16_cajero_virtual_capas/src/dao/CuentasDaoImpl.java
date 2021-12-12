package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Cuenta;

@Repository
public class CuentasDaoImpl implements CuentasDao {
	@Autowired
	JdbcTemplate template;
	
	
	@Override
	public void updateCuenta(Cuenta cuenta) {
		String sql="update cuentas set saldo=? where numeroCuenta=?";
		template.update(sql,cuenta.getSaldo(),cuenta.getNumeroCuenta());
	}

	@Override
	public Cuenta findById(int idCuenta) {
		String sql="select * from cuentas where numeroCuenta=?";
		List<Cuenta> res= template.query(sql, (rs,f)->new Cuenta(rs.getInt("numeroCuenta"),
				rs.getDouble("saldo"),
				rs.getString("tipocuenta")),
				idCuenta);
		return res.size()>0?res.get(0):null;
	}

	

	

}
