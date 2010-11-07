//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica2.ejercicio5;

/**
 * Clase que representa un deudor
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 07.03.2009
 */
public class Deudor {

	/**
	 * Variable privada que representa el DNI del deudor
	 */
	private String DNI;
	/**
	 * Variable privada que representa la cantidad Prestada al deudor
	 */
	private double cantidadPrestada;
	/**
	 * Variable privada que representa la cantidad Cobrada al deudor
	 */
	private double cantidadCobrada;

	/**
	 * Genera un deudor con parametros
	 * 
	 * @param DNI
	 *            representa el DNI del deudor
	 * @param cantidadPrestada
	 *            representa la cantidad Prestada al deudor
	 * @param cantidadCobrada
	 *            representa la cantidad Cobrada al deudor
	 */
	public Deudor(String DNI, double cantidadPrestada, double cantidadCobrada) {
		super();
		this.setDNI(DNI);
		this.setCantidadPrestada(cantidadPrestada);
		this.setCantidadCobrada(cantidadCobrada);
	}

	/**
	 * Metodo modificador de la propiedad cantidadPrestada
	 * 
	 * @param cantidadPrestada
	 *            representa la cantidad Prestada al deudor
	 */
	public void setCantidadPrestada(double cantidadPrestada) {
		this.cantidadPrestada = cantidadPrestada;
	}

	/**
	 * Metodo de acceso de la propiedad cantidadPrestada
	 * 
	 * @return devuelve la cantidad Prestada al deudor
	 */
	public double getCantidadPrestada() {
		return cantidadPrestada;
	}

	/**
	 * Metodo modificador de la propiedad cantidadCobrada
	 * 
	 * @param cantidadCobrada
	 *            representa la cantidad Cobrada al deudor
	 */
	public void setCantidadCobrada(double cantidadCobrada) {
		this.cantidadCobrada = cantidadCobrada;
	}

	/**
	 * Metodo de acceso de la propiedad cantidadCobrada
	 * 
	 * @return devuelve la cantidad Cobrada al deudor
	 */
	public double getCantidadCobrada() {
		return cantidadCobrada;
	}

	/**
	 * Metodo modificador de la propiedad DNI
	 * 
	 * @param dNI
	 *            representa el DNI del deudor
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	/**
	 * Metodo de acceso de la propiedad DNI
	 * 
	 * @return devuelve el DNI del deudor
	 */
	public String getDNI() {
		return DNI;
	}
}
