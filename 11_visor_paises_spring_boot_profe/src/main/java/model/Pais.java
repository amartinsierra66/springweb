/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Antonio
 */
public class Pais {
	@JsonProperty("name")
    private String nombre;
	@JsonProperty("region")
    private String continente;
	@JsonProperty("population")
    private long habitantes;
    private String capital;
    @JsonProperty("flag")
    private String bandera;
	public Pais(String nombre, String continente, long habitantes, String capital) {
		super();
		this.nombre = nombre;
		this.continente = continente;
		this.habitantes = habitantes;
		this.capital = capital;
	}
	public Pais() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContinente() {
		return continente;
	}
	public void setContinente(String continente) {
		this.continente = continente;
	}
	public long getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(long habitantes) {
		this.habitantes = habitantes;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getBandera() {
		return bandera;
	}
	public void setBandera(String bandera) {
		this.bandera = bandera;
	}
   
}
