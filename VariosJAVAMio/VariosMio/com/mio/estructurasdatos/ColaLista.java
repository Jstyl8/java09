//
// Universidad de Almer�a
// Ingenier�a T�cnica de Inform�tica de Sistemas
// Fuente Java seg�n Plantilla
//
// PRACTICA : Practica 7, Ejercicio 2
// ASIGNATURA : Metodologia de la Programaci�n
//
package com.mio.estructurasdatos;

import com.mio.excepciones.DesbordamientoInferiorException;

/**
 * Clase que representa una Cola implementada mediante NodoLista
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09/05/2009
 */
public class ColaLista implements Cola {

	/**
	 * Variable privada que representa el elemento mas antiguo insertado
	 */
	private NodoLista cabeza;

	/**
	 * Variable privada que representa el elemento mas reciente insertado
	 */
	private NodoLista fin;

	/**
	 * Variable privada que representa la cantidad de elementos en la cola
	 */
	private int tama�o;

	/**
	 * Genera un objeto de tipo ColaLista
	 */
	public ColaLista() {
		vaciar();
	}

	/**
	 * Comprueba si la cola esta l�gicamente vacia.
	 * 
	 * @return true si esta vacia, sino false.
	 */
	public boolean esVacia() {
		return cabeza == null;
	}

	/**
	 * Inserta un elemento nuevo en la cola.
	 * 
	 * @param x
	 *            el elemento a insertar.
	 */
	public void insertar(Object x) {
		tama�o++;
		if (esVacia())
			fin = cabeza = new NodoLista(x);
		else
			fin = fin.siguiente = new NodoLista(x);

	}

	/**
	 * Devuelve el elemento insertado primero en la cola. No altera la cola.
	 * 
	 * @return Devuelve el elemento insertado primero en la cola.
	 * @exception DesbordamientoInferiorException
	 *                si la cola es vacia.
	 */
	public Object primero() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("cola vacia en primero");
		else
			return cabeza.dato;
	}

	/**
	 * Devuelve y elimina el elemento insertado primero en la cola. No altera la
	 * cola.
	 * 
	 * @return Devuelve el elemento insertado primero en la cola.
	 * @exception DesbordamientoInferiorException
	 *                si la cola es vacia.
	 */
	public Object quitarPrimero() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException(
					"Cola vacia en quitarPrimero");
		Object dato = cabeza.dato;
		cabeza = cabeza.siguiente;
		tama�o--;
		return dato;
	}

	/**
	 * Devuelve el tama�o de la cola
	 * 
	 * @return tama�oCola
	 */
	public int tama�o() {
		return tama�o;
	}

	/**
	 * Pone la cola vacia logicamente.
	 */
	public void vaciar() {
		cabeza = fin = null;
		tama�o = 0;

	}

}
