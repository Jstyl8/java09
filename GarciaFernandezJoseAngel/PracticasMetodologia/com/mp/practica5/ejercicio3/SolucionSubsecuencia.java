//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica5.ejercicio3;

/**
 * Clase que implementa la interfaz solucion y representa la subsecuencia maxima
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 22.03.2009
 */
public class SolucionSubsecuencia implements Solucion {

	/**
	 * Variable privada que representa los enteros de la subsecuencia maxima
	 */
	private int[] array;
	/**
	 * Variable privada que representa el fin de la subsecuencia maxima
	 */
	private int der;

	/**
	 * Variable privada que representa el inicio de la subsecuencia maxima
	 */
	private int izq;

	/**
	 * Variable privada que representa la suma maxima de la subsecuencia maxima
	 */
	private int sumaMax;

	/**
	 * Genera un objeto de tipo SolucionSubsecuencia con parametros
	 * 
	 * @param array
	 *            representa los enteros de la subsecuencia solucion
	 * @param izq
	 *            representa el fin de la subsecuencia solucion
	 * @param der
	 *            representa el fin de la subsecuencia solucion
	 */
	public SolucionSubsecuencia(int[] array, int izq, int der) {
		this.array = array;
		this.izq = izq;
		this.der = der;
	}

	/**
	 * Metodo de acceso para la propiedad array
	 * 
	 * @return array que representa los enteros de la subsecuencia maxima
	 */
	public int[] getArray() {
		return array;
	}

	/**
	 * Metodo modificador para la propiedad array
	 * 
	 * @param array
	 *            el array de enteros a poner
	 */
	public void setArray(int[] array) {
		this.array = array;
	}

	/**
	 * Metodo de acceso para la propiedad der
	 * 
	 * @return der que representa el fin de la subsecuencia maxima
	 */
	public int getDer() {
		return der;
	}

	/**
	 * 
	 * Metodo modificador para la propiedad der
	 * 
	 * @param der
	 *            el fin de subsecuencia maxima a poner
	 */
	public void setDer(int der) {
		this.der = der;
	}

	/**
	 * Metodo de acceso para la propiedad izq
	 * 
	 * @return izq que representa el inicio de la subsecuencia maxima
	 */
	public int getIzq() {
		return izq;
	}

	/**
	 * Metodo modificador para la propiedad izq
	 * 
	 * @param izq
	 *            el inicio de subsecuencia maxima a poner
	 */
	public void setIzq(int izq) {
		this.izq = izq;
	}

	/**
	 * Metodo de acceso para la propiedad sumaMax
	 * 
	 * @return sumaMax que representa la suma maxima de la subsecuencia
	 */
	public int getSumaMax() {
		return sumaMax;
	}

	/**
	 * Metodo modificador para la propiedad sumaMax
	 * 
	 * @param sumaMax
	 *            la sumaMax de la subsecuencia maxima a poner
	 */
	public void setSumaMax(int sumaMax) {
		this.sumaMax = sumaMax;
	}

	/**
	 * Sobrecarga del metodo toString
	 * 
	 * @return un String con las propiedades de SolucionSubsecuencia
	 */
	public String toString() {
		String salida = "El inicio de la subsecuencia maxima es " + izq
				+ ", el final " + der + ", la suma maxima es " + sumaMax
				+ " y los datos son ";
		for (int a : array)
			salida += a + " ";
		return salida;
	}

}
