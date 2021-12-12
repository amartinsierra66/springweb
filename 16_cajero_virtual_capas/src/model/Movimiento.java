package model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * The persistent class for the movimientos database table.
 * 
 */

public class Movimiento {
	
	private int idMovimiento;

	private double cantidad;

	@JsonSerialize(using = SerializacionFecha.class)
	private LocalDate fecha;

	private String operacion;

	
	private int cuenta;

	public Movimiento(int idMovimiento, double cantidad, LocalDate fecha, String operacion, int cuenta) {
		super();
		this.idMovimiento = idMovimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.operacion = operacion;
		this.cuenta = cuenta;
	}

	public Movimiento() {
	}

	public int getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDate getFecha() {
		return fecha;

		//return this.fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public int getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}

}