//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 7, Ejercicio 4
// ASIGNATURA : Metodologia de la Programación
//
package com.mio.meto.ParadaTaxis;

import com.mio.excepciones.DesbordamientoInferiorException;

/**
 * Clase que representa una parada de taxi
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09/05/2009
 */
public class ParadaTaxis {

	/**
	 * Variable privada que representa el nombre de la parada de taxis
	 */
	private String nombreParada;
	/**
	 * Variable privada que representa la direccion de la parada de taxis
	 */
	private String direccion;

	/**
	 * Variable privada que representa los taxis de la parada
	 */
	private Taxi[] taxis;

	/**
	 * Variable privada que representa el taxi mas antiguo insertado
	 */
	private int cabeza;

	/**
	 * Variable privada que representa el taxi mas reciente insertado
	 */
	private int fin;

	/**
	 * Variable privada que representa el numero de taxis en la parada
	 */
	private int nTaxis;

	/**
	 * Variable privada que representa el numero de taxis base en la parada
	 */
	private static final int TAMAÑO_POR_DEFECTO = 10;

	/**
	 * Genera un objeto de tipo ParadaTaxis
	 * 
	 * @param nombreParada
	 *            el nombre a poner
	 * @param direccion
	 *            la direccion a poner
	 */
	public ParadaTaxis(String nombreParada, String direccion) {
		this.nombreParada = nombreParada;
		this.direccion = direccion;
		taxis = new Taxi[TAMAÑO_POR_DEFECTO];
		nTaxis = 0;
		cabeza = 0;
		fin = -1;
	}

	/**
	 * Devuelve el numero de taxis
	 * 
	 * @return el numero de taxis
	 */
	public int numeroTaxis() {
		return nTaxis;
	}

	/**
	 * Comprueba si la parada esta lógicamente vacia.
	 * 
	 * @return true si esta vacia, sino false.
	 */
	public boolean esVacia() {
		return nTaxis == 0;
	}

	/**
	 * Inserta un taxi en la parada
	 * 
	 * @param x
	 *            el elemento a insertar.
	 */
	public void entradaTaxi(Taxi x) {
		if (nTaxis == taxis.length)
			asegurarCapacidad();
		fin = incrementar(fin);
		taxis[fin] = x;
		nTaxis++;

	}

	/**
	 * Metodo que duplica la capacidad de la parada de taxis
	 */
	protected void asegurarCapacidad() {

		Taxi[] aux = new Taxi[taxis.length * 2];
		for (int i = 0; i < nTaxis; i++, cabeza = incrementar(cabeza)) {
			aux[i] = taxis[cabeza];
		}
		taxis = aux;
		cabeza = 0;
		fin = nTaxis - 1;

	}

	/**
	 * Devuelve el primer taxi que entro a la parada. No altera la cola.
	 * 
	 * @return Devuelve el primer taxi que entro a la parada.
	 * @exception DesbordamientoInferiorException
	 *                si la parada esta vacia.
	 */
	public Taxi primerTaxi() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException(
					"parada de Taxis vacia en primerTaxi");
		else
			return taxis[cabeza];
	}

	/**
	 * Devuelve y elimina el taxi insertado primero en la parada.
	 * 
	 * @return Devuelve el primer taxi que entro a la parada.
	 * @exception DesbordamientoInferiorException
	 *                si la parada esta vacia.
	 */
	public Taxi salidaTaxi() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException(
					"parada de Taxis vacia en salidaTaxi");

		nTaxis--;
		Taxi valor = taxis[cabeza];
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
		if (++x == taxis.length)
			x = 0;
		return x;
	}

	/**
	 * Metodo que realiza un listado mostrando el numero de licencia de los
	 * taxis en la parada
	 * 
	 * @return el listado de taxis
	 * @exception DesbordamientoInferiorException
	 *                si la parada esta vacia.
	 */
	public String listado() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException(
					"parada de Taxis vacia en listado");

		String listado = "";
		for (int i = 0; i < nTaxis; i++) {
			listado += " " + taxis[i].getNumeroLicencia();
		}
		return listado;
	}

	/**
	 * Devuelve y elimina el taxi insertado primero en la parada que sirva para
	 * minusvalidos
	 * 
	 * @return Devuelve el primer taxi que entro a la parada para minusvalidos
	 * @exception DesbordamientoInferiorException
	 *                si la parada esta vacia.
	 */
	public Taxi minusvalidoTaxi() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException(
					"parada de Taxis vacia en minusvalidoTaxi");
		Taxi minus = null;
		boolean encontrado = false;
		int tmp = cabeza;
		for (int i = 0; i < nTaxis && encontrado == false; i++, cabeza = incrementar(cabeza)) {
			if (taxis[cabeza].getMinusvalidos() == true) {
				nTaxis--;
				minus = taxis[cabeza];
				encontrado = true;
				// actualiza la posicion de los taxis
				while (cabeza < fin) {
					taxis[cabeza] = taxis[cabeza = incrementar(cabeza)];
				}
				taxis[cabeza] = null;
			}
		}
		cabeza = tmp;
		return minus;
	}
}
