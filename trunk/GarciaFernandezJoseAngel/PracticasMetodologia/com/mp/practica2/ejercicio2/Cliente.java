//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica2.ejercicio2;

/**
 * Clase que representa un cliente
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 07.03.2009
 */
public class Cliente {

	/**
	 * Variable privada que representa el nombre del cliente
	 */
	private String nombre;
	/**
	 * Variable privada que representa el numero de telefono del cliente
	 */
	private String telefono;
	/**
	 * Array privado que representa los deudores del cliente
	 */
	private Deudor[] deudores;
	/**
	 * Variable privada que representa el numero de deudores del Cliente
	 */
	private int nDeudores;

	/**
	 * Genera un cliente con parametros
	 * 
	 * @param nombre
	 *            representa nombre del cliente
	 * @param telefono
	 *            representa el numero de telefono del ciente
	 * @param nDeudores
	 *            representa numero de deudores del ciente
	 * @param deudores
	 *            representa los deudores que tiene el cliente
	 */
	public Cliente(String nombre, String telefono, int nDeudores,
			Deudor[] deudores) {
		super();
		this.setNombre(nombre);
		this.setTelefono(telefono);
		this.setNDeudores(nDeudores);
		this.deudores = new Deudor[nDeudores];
	}

	/**
	 * Genera un cliente por defecto
	 */
	public Cliente() {
	}

	/**
	 * Metodo modificador de la propiedad nombre
	 * 
	 * @param nombre
	 *            representa nombre del cliente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo de acceso de la propiedad nombre
	 * 
	 * @return devuelve el nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo modificador de la propiedad telefono
	 * 
	 * @param telefono
	 *            representa telefono del cliente
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Metodo de acceso de la propiedad telefono
	 * 
	 * @return devuelve el telefono del cliente
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Metodo modificador de la propiedad nDeudores
	 * 
	 * @param nDeudores
	 *            representa el numero de deudores del ciente
	 */
	public void setNDeudores(int nDeudores) {
		this.nDeudores = nDeudores;
	}

	/**
	 * Metodo de acceso de la propiedad Ndeudores
	 * 
	 * @return devuelve el numero deudores del cliente
	 */
	public int getNDeudores() {
		return nDeudores;
	}

	/**
	 * Metodo modificador del vector deudores
	 * 
	 * @param deudores
	 *            representa los deudores que tiene el cliente
	 */
	public void setDeudores(Deudor[] deudores) {
		this.deudores = deudores;
	}

	/**
	 * Metodo de acceso al vector deudores
	 * 
	 * @return devuelve el vector deudores del cliente
	 */
	public Deudor[] getDeudores() {
		return deudores;
	}

	/**
	 * Calcula el total prestado del cliente
	 * 
	 * @return devuelve el total prestado del cliente
	 */
	public double CantidadTotalPrestada() {
		double totalPrestado = 0;

		for (int j = 0; j < getNDeudores(); j++) {
			totalPrestado += deudores[j].getCantidadPrestada();
		}
		return totalPrestado;

	}

}
