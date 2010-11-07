//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 7, Ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.estructurasdatos;

import com.mp.excepciones.DesbordamientoInferiorException;

/**
 * Clase que representa una Pila implementada mediante NodoLista
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09/05/2009
 */
public class PilaLista implements Pila {

	/**
	 * Variable que representa el tamaño de la pila
	 */
	private int tamaño;

	/**
	 * Variable que representa la cima de la pila
	 */
	private NodoLista cimaDePila;

	/**
	 * Genera un objeto de tipo PilaLista
	 */
	public PilaLista() {
		cimaDePila = null;
		tamaño = 0;
	}

	/**
	 * Inserta un elemento nuevo en la pila
	 * 
	 * @param x
	 *            el elemento a insertar
	 */
	public void apilar(Object x) {
		cimaDePila = new NodoLista(x, cimaDePila);
		tamaño++;
	}

	/**
	 * Obtiene el elemento mas recientemente insertado en pila No altera pila
	 * 
	 * @return el elemento mas recientemente insertado
	 * @exception DesbordamientoInferiorException
	 *                si la pila esta vacia
	 */
	public Object cima() throws DesbordamientoInferiorException {
		if (cimaDePila == null)
			throw new DesbordamientoInferiorException("pila vacia");
		return cimaDePila.dato;
	}

	/**
	 * Devuelve y elimina el elemento mas recientemente insertado en pila
	 * 
	 * @return elemento insertado
	 * @exception DesbordamientoInferiorException
	 *                si la pila esta vacia
	 */
	public Object cimaYDesapilar() throws DesbordamientoInferiorException {
		if (cimaDePila == null)
			throw new DesbordamientoInferiorException("cimaYDesapilar");
		Object datoCima = cimaDePila.dato;
		cimaDePila = cimaDePila.siguiente;
		tamaño--;
		return datoCima;
	}

	/**
	 * Elimina el elemento mas recientemente insertado
	 * 
	 * @exception DesbordamientoInferiorException
	 *                si la pila esta vacia
	 */
	public void desapilar() throws DesbordamientoInferiorException {
		if (cimaDePila == null)
			throw new DesbordamientoInferiorException("desapilar");
		cimaDePila = cimaDePila.siguiente;
		tamaño--;
	}

	/**
	 * Comprueba si la pila esta vacia
	 * 
	 * @return true si pila vacia, sino false
	 */
	public boolean esVacia() {
		return cimaDePila == null;
	}

	/**
	 * Devuelve el tamaño de la pila
	 */
	public int tamaño() {
		return tamaño;
	}

	/**
	 * Pone pila logicamente a vacio
	 */
	public void vaciar() {
		cimaDePila = null;

	}

}
