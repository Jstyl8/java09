//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 7, Ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//
package com.mio.estructurasdatos;

import com.mio.excepciones.DesbordamientoInferiorException;

/**
 * Clase que representa una Pila implementada mediante un array
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09/05/2009
 */
public class PilaVec implements Pila {

	/**
	 * Variable privada que representa los datos de la pila
	 */
	private Object array[];

	/**
	 * Variable privada que representa la cima de la pila
	 */
	private int cimaDePila;

	/**
	 * Variable privada uq representa el tamaño base de la pila
	 */
	private static final int TAMAÑO = 10;

	/**
	 * Genera un objeto de tipo PilaVec
	 */
	public PilaVec() {
		array = new Object[TAMAÑO];
		cimaDePila = -1;
	}

	/**
	 * Inserta un elemento nuevo en la pila
	 * 
	 * @param x
	 *            el elemento a insertar
	 */
	public void apilar(Object x) {
		if (cimaDePila + 1 == array.length)
			asegurarCapacidad();

		array[++cimaDePila] = x;

	}

	/**
	 * Duplica el tamaño de la pila
	 */
	private void asegurarCapacidad() {
		Object[] aux = new Object[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			aux[i] = array[i];
		}
		array = aux;
	}

	/**
	 * Obtiene el elemento mas recientemente insertado en pila No altera pila
	 * 
	 * @return el elemento mas recientemente insertado
	 * @exception DesbordamientoInferiorException
	 *                si la pila esta vacia
	 */
	public Object cima() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("pila vacia");
		else
			return array[cimaDePila];
	}

	/**
	 * Devuelve y elimina el elemento mas recientemente inserta en pila
	 * 
	 * @return elemento insertado
	 * @exception DesbordamientoInferiorException
	 *                si la pila esta vacia
	 */
	public Object cimaYDesapilar() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException(
					"pila vacia en cimaYDesapilar");
		else
			return array[cimaDePila--];

	}

	/**
	 * Elimina el elemento mas recientemente insertado
	 * 
	 * @exception DesbordamientoInferiorException
	 *                si la pila esta vacia
	 */

	public void desapilar() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException(
					"pila vacia en metodo desapilar");
		else
			cimaDePila--;
	}

	/**
	 * Comprueba si la pila esta vacia
	 * 
	 * @return true si pila vacia, sino false
	 */
	public boolean esVacia() {
		return cimaDePila == -1;
	}

	/**
	 * Devuelve el tamaño de la pila
	 * 
	 * @return la cima de la pila
	 */
	public int tamaño() {

		return cimaDePila;
	}

	/**
	 * Pone la pila logicamente a vacio
	 */
	public void vaciar() {
		cimaDePila = -1;

	}
}
