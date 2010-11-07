//
// Universidad de Almer�a
// Ingenier�a T�cnica de Inform�tica de Sistemas
// Fuente Java seg�n Plantilla
//
// PRACTICA : Practica 7, Ejercicio 1
// ASIGNATURA : Metodologia de la Programaci�n
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
	 * Variable que representa el tama�o de la pila
	 */
	private int tama�o;

	/**
	 * Variable que representa la cima de la pila
	 */
	private NodoLista cimaDePila;

	/**
	 * Genera un objeto de tipo PilaLista
	 */
	public PilaLista() {
		cimaDePila = null;
		tama�o = 0;
	}

	/**
	 * Inserta un elemento nuevo en la pila
	 * 
	 * @param x
	 *            el elemento a insertar
	 */
	public void apilar(Object x) {
		cimaDePila = new NodoLista(x, cimaDePila);
		tama�o++;
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
		tama�o--;
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
		tama�o--;
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
	 * Devuelve el tama�o de la pila
	 */
	public int tama�o() {
		return tama�o;
	}

	/**
	 * Pone pila logicamente a vacio
	 */
	public void vaciar() {
		cimaDePila = null;

	}

}
