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
 * Clase que implementa la interfaz Solucion y se usa para la realizacion de
 * EsquemaDYV
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 24/04/2009
 */
public class SolucionMergeSort implements Solucion{

	/**
	 * Array de elementos comparables que representa el conjunto de elementos
	 * ordenados
	 */
	private Comparable[] vector;
	/**
	 * Variable privada que representa el indice mas a la derecha del subarray
	 */
	private int der;

	/**
	 * Variable privada que representa el indice mas a la izquierda del subarray
	 */
	private int izq;

	/**
	 * Genera una objeto SolucionMergeSort con parametros
	 * 
	 * @param vector
	 *            Array de elementos comparables
	 * @param izq
	 *            el indice mas a la izquierda del subarray
	 * @param der
	 *            el indice mas a la derecha del subarray
	 */
	public SolucionMergeSort(Comparable[] vector, int izq, int der) {
		this.vector = vector;
		this.izq = izq;
		this.der = der;
	}

	/**
	 * Metodo de acceso para la propiedad vector
	 * 
	 * @return vector el array de elementos comparables
	 */
	public Comparable[] getVector() {
		return vector;
	}

	/**
	 * Metodo modificador para la propiedad vector
	 * 
	 * @param vector
	 *            Array de elementos comparables a poner
	 */
	public void setVector(Comparable[] vector) {
		this.vector = vector;
	}

	/**
	 * Metodo que obtiene un elemento del array vector
	 * 
	 * @param i
	 *            el indice del elemento que se quiere obtener
	 * @return el elemento que se encuentra en la posicion i del array vector
	 */
	public Comparable getVector(int i) {
		return vector[i];
	}

	/**
	 * Metodo de acceso para la propiedad der
	 * 
	 * @return der que representa el indice mas a la derecha del subarray
	 */
	public int getDer() {
		return der;
	}

	/**
	 * 
	 * Metodo modificador para la propiedad der
	 * 
	 * @param der
	 *            el indice mas a la derecha del subarray a poner
	 */
	public void setDer(int der) {
		this.der = der;
	}

	/**
	 * Metodo de acceso para la propiedad izq
	 * 
	 * @return izq que representa el indice mas a la izquierda del subarray
	 */
	public int getIzq() {
		return izq;
	}

	/**
	 * Metodo modificador para la propiedad izq
	 * 
	 * @param izq
	 *            el indice mas a la izq del subarray a poner
	 */
	public void setIzq(int izq) {
		this.izq = izq;
	}
}
