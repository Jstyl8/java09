//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Ejercicio 4
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica5.ejercicio4;

/**
 * Clase que representa un array de elementos comparables
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 24/04/2009
 */
public class VectorComparables {

	/**
	 * Array de elementos comparables que representa el conjunto de elementos a
	 * ordenar
	 */
	private Comparable[] vector;

	/**
	 * Variable privada que representa el numero de elementos del array vector
	 */
	private int numElementos;

	/**
	 * Metodo de acceso para la propiedad vector
	 * 
	 * @return vector el array de de elementos comparables
	 */
	public Comparable[] getVector() {
		return vector;
	}

	/**
	 * Genera un objeto de tipo VectorComparables por defecto
	 */
	public VectorComparables() {

	}

	/**
	 * Genera un objeto de tipo VectorComparables con un numero de elementos
	 * prefijado
	 * 
	 * @param numElementos
	 *            el numero de elementos del array vector a crear
	 */
	public VectorComparables(int numElementos) {
		this.numElementos = numElementos;
		vector = new Comparable[numElementos];
	}

	/**
	 * Metodo modificador para la propiedad vector
	 * 
	 * @param vector
	 *            el vector a poner
	 */
	public void setVector(Comparable[] vector) {
		this.vector = vector;
	}

	/**
	 * Metodo de acceso para la propiedad numElementos
	 * 
	 * @return el numero de elementos del array vector
	 */
	public int getNumElementos() {
		return numElementos;
	}

	/**
	 * Metodo modificador para la propiedad numElementos
	 * 
	 * @param numElementos
	 *            el numero de elementos a poner
	 */
	public void setNumElementos(int numElementos) {
		this.numElementos = numElementos;
	}
	
	/**
	 * Sobrecarga del metodo toString
	 * 
	 * @return un String con las propiedades de VectorComparables
	 */
	public String toString() {
		String salida = "El numero de elementos es "+numElementos+" y los datos son: ";
		for (Comparable a : vector)
			salida += a + " ";
		return salida;
	}
}
