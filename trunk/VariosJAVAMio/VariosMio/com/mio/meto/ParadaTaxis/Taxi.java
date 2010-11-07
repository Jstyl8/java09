//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 7, Ejercicio 4
// ASIGNATURA : Metodologia de la Programación
//
package com.mio.meto.ParadaTaxis;

/**
 * Clase que representa un taxi
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09/05/2009
 */
public class Taxi {

	/**
	 * Variable privada que representa el numero de licencia del taxi
	 */
	private int numeroLicencia;
	/**
	 * Variable privada que representa si el taxi es adaptado para minusvalidos
	 */
	private boolean minusvalidos;

	/**
	 * Genera un objeto de tipo Taxi
	 * 
	 * @param numeroLicencia
	 *            el numero de licencia a poner
	 * @param minusvalidos
	 *            si es o no apto para minusvalidos
	 */
	public Taxi(int numeroLicencia, boolean minusvalidos) {
		this.setNumeroLicencia(numeroLicencia);
		this.setMinusvalidos(minusvalidos);
	}

	/**
	 * Metodo modificador para la propiedad numeroLicencia
	 * 
	 * @param numeroLicencia
	 *            el numeroLicencia a poner
	 */
	public void setNumeroLicencia(int numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}

	/**
	 * Metodo de acceso para la propiedad numeroLicencia
	 * 
	 * @return el numeroLicencia
	 */
	public int getNumeroLicencia() {
		return numeroLicencia;
	}

	/**
	 * Metodo modificador para la propiedad minusValidos
	 * 
	 * @param minusvalidos
	 *            a poner, si es apto para minusvalidos o no
	 */
	public void setMinusvalidos(boolean minusvalidos) {
		this.minusvalidos = minusvalidos;
	}

	/**
	 * Metodo de acceso para la propiedad minusValidos
	 * 
	 * @return si es apto para minusvalidos o no
	 */
	public boolean getMinusvalidos() {
		return minusvalidos;
	}

	/**
	 * Sobreescribe el metodo toString de object
	 * 
	 * @return un string con la licencia del taxi
	 */
	public String toString() {
		return minusvalidos ? "si minusvalidos " + numeroLicencia : "no minusvalidos "
				+ numeroLicencia;

	}
}
