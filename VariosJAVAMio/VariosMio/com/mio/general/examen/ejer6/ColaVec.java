//
// Universidad de Almer�a
// Ingenier�a T�cnica de Inform�tica de Sistemas
// Fuente Java seg�n Plantilla
//
// PRACTICA : Practica 7, Ejercicio 2
// ASIGNATURA : Metodologia de la Programaci�n
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
	private int tama�oCola;

	/**
	 * Variable privada que representa el numero de elementos base en la cola
	 */
	private static final int TAMA�O_POR_DEFECTO = 10;

	/**
	 * Genera un objeto de tipo ColaVec
	 */
	public ColaVec() {
		array = new Object[TAMA�O_POR_DEFECTO];
		vaciar();
	}

	/**
	 * Comprueba si la cola esta l�gicamente vacia.
	 * 
	 * @return true si esta vacia, sino false.
	 */
	public boolean esVacia() {
		return tama�oCola == 0;
	}

	/**
	 * Inserta un elemento nuevo en la cola.
	 * 
	 * @param x
	 *            el elemento a insertar.
	 */
	public void insertar(Object x) {
		if (tama�oCola == array.length)
			asegurarCapacidad();
		fin = incrementar(fin);
		array[fin] = x;
		tama�oCola++;

	}

	/**
	 * Metodo que duplica la capacidad de la cola
	 */
	protected void asegurarCapacidad() {

		Object[] aux = new Object[array.length * 2];
		for (int i = 0; i < tama�oCola; i++, cabeza = incrementar(cabeza)) {
			aux[i] = array[cabeza];
		}
		array = aux;
		cabeza = 0;
		fin = tama�oCola - 1;

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

		tama�oCola--;
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
	 * Devuelve el tama�o de la cola
	 * 
	 * @return tama�oCola
	 */
	public int tama�o() {
		return tama�oCola;
	}

	/**
	 * Pone la cola vacia logicamente.
	 */
	public void vaciar() {
		tama�oCola = 0;
		cabeza = 0;
		fin = -1;
	}

}
