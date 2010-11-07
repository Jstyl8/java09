//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 7, Ejercicio 2
// ASIGNATURA : Metodologia de la Programación
//
package com.mio.general.examen.ejer6;

import com.mio.excepciones.DesbordamientoInferiorException;

/**
 * Clase que representa una Cola implementada mediante un array
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09/05/2009
 */
public class ColaVec extends ColaAbstracta {

	/**
	 * Variable privada que representa los datos de la cola
	 */
	private Object array[];

	/**
	 * Variable privada que representa el elemento mas antiguo insertado
	 */
	private int cabeza;

	/**
	 * Variable privada que representa el elemento mas reciente insertado
	 */
	private int fin;

	/**
	 * Variable privada que representa el numero de elementos en la cola
	 */
	private int tamañoCola;

	/**
	 * Variable privada que representa el numero de elementos base en la cola
	 */
	private static final int TAMAÑO_POR_DEFECTO = 10;

	/**
	 * Genera un objeto de tipo ColaVec
	 */
	public ColaVec() {
		array = new Object[TAMAÑO_POR_DEFECTO];
		vaciar();
	}

	/**
	 * Comprueba si la cola esta lógicamente vacia.
	 * 
	 * @return true si esta vacia, sino false.
	 */
	public boolean esVacia() {
		return tamañoCola == 0;
	}

	/**
	 * Inserta un elemento nuevo en la cola.
	 * 
	 * @param x
	 *            el elemento a insertar.
	 */
	public void insertar(Object x) {
		if (tamañoCola == array.length)
			asegurarCapacidad();
		fin = incrementar(fin);
		array[fin] = x;
		tamañoCola++;

	}

	/**
	 * Metodo que duplica la capacidad de la cola
	 */
	protected void asegurarCapacidad() {

		Object[] aux = new Object[array.length * 2];
		for (int i = 0; i < tamañoCola; i++, cabeza = incrementar(cabeza)) {
			aux[i] = array[cabeza];
		}
		array = aux;
		cabeza = 0;
		fin = tamañoCola - 1;

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
			return array[cabeza];
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

		tamañoCola--;
		Object valor = array[cabeza];
		cabeza = incrementar(cabeza);
		return valor;
	}

	/**
	 * Metodo privado para incremento con circularidad
	 * 
	 * @param x
	 *            el valor a incrementar
	 * @return devuelve el valor incrementado
	 */
	private int incrementar(int x) {
		if (++x == array.length)
			x = 0;
		return x;
	}

	/**
	 * Devuelve el tamaño de la cola
	 * 
	 * @return tamañoCola
	 */
	public int tamaño() {
		return tamañoCola;
	}

	/**
	 * Pone la cola vacia logicamente.
	 */
	public void vaciar() {
		tamañoCola = 0;
		cabeza = 0;
		fin = -1;
	}

}
