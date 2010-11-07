//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 7, Ejercicio 5
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica7.ejercicio5;

import com.mp.practica7.ejercicio5.IteradorFueraLimitesException;

/**
 * Clase que representa un iterador para la lista
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09/05/2009
 */
public class ArrayIterador implements Iterador {

	/**
	 * Array privado de objects
	 */
	private Object[] array;

	/**
	 * Variable privada que representa la primera posicion
	 */
	private int primero;

	/**
	 * Variable privada que representa la ultima posicion
	 */
	private int ultimo;

	/**
	 * Variable privada que representa la posicion actual
	 */
	private int actual;

	/**
	 * Genera un objeto de tipo ArrayIterador a partir de un array predefinido
	 * 
	 * @param array
	 *            el array a poner
	 */
	public ArrayIterador(Object[] array) {
		this.array = array;
		primero = 0;
		ultimo = array.length-1;
	}

	/**
	 * Genera un objeto de tipo ArrayIterador con parametros
	 * 
	 * @param array
	 *            el array a poner
	 * @param primero
	 *            la primera posicion del iterador
	 * @param longitud
	 *            el numero de elementos del iterador
	 */
	public ArrayIterador(Object[] array, int primero, int longitud) {
		this.array = array;
		this.primero = primero;
		this.ultimo = longitud-primero-1;
	}

	/**
	 * Posiciona en el primer elemento.
	 * 
	 */
	public void primero() {
		actual = primero;
	}

	/**
	 * Posiciona en el último elemento.
	 * 
	 */
	public void ultimo() {
		actual = ultimo;
	}

	/**
	 * Comprueba que el iterador referencia un elemento.
	 * 
	 * @return true si referencia a un elemento; en otro caso false.
	 */
	public boolean estaDentro() {
		if (actual >= primero && actual <= ultimo)
			return true;
		else
			return false;
	}

	/**
	 * Posiciona en el siguiente elemento.
	 * 
	 */
	public void siguiente() {
		actual++;
	}

	/**
	 * Posiciona en el anterior elemento.
	 * 
	 */
	public void anterior() {
		actual--;
	}

	/**
	 * Obtiene el valor de elemento actual.
	 * 
	 * @return El valor del elemento actual.
	 * @throws IteradorFueraLimitesException
	 *             si no hay elemento actual.
	 */
	public Object actual() throws IteradorFueraLimitesException {
		if (actual >= primero && actual <= ultimo)
			return array[actual];
		else
			throw new IteradorFueraLimitesException();

	}

}
