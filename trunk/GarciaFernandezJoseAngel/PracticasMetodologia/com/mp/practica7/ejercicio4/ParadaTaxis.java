//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 7, Ejercicio 4
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica7.ejercicio4;

import com.mp.estructurasdatos.ColaVec;
import com.mp.excepciones.DesbordamientoInferiorException;

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
	private ColaVec taxis;

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
		taxis = new ColaVec();
	}

	/**
	 * Devuelve el numero de taxis
	 * 
	 * @return el numero de taxis
	 */
	public int numeroTaxis() {
		return taxis.tamaño();
	}

	/**
	 * Inserta un taxi en la parada
	 * 
	 * @param x
	 *            el elemento a insertar.
	 */
	public void entradaTaxi(Taxi x) {
		taxis.insertar(x);

	}

	/**
	 * Devuelve el primer taxi que entro a la parada. No altera la cola.
	 * 
	 * @return Devuelve el primer taxi que entro a la parada.
	 * @exception DesbordamientoInferiorException
	 *                si la parada esta vacia.
	 */
	public Taxi primerTaxi() throws DesbordamientoInferiorException {
		return (Taxi) taxis.primero();
	}

	/**
	 * Devuelve y elimina el taxi insertado primero en la parada.
	 * 
	 * @return Devuelve el primer taxi que entro a la parada.
	 * @exception DesbordamientoInferiorException
	 *                si la parada esta vacia.
	 */
	public Taxi salidaTaxi() throws DesbordamientoInferiorException {
		return (Taxi) taxis.quitarPrimero();
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
		if (taxis.esVacia())
			throw new DesbordamientoInferiorException(
					"parada de Taxis vacia en minusvalidoTaxi");

		Taxi[] aux = new Taxi[taxis.tamaño()];
		for (int i = 0; !taxis.esVacia(); i++) {
			aux[i] = (Taxi) taxis.quitarPrimero();
		}

		String listado = "";
		for (int i = 0; i < aux.length; i++) {
			listado += " "+aux[i].getNumeroLicencia();
			taxis.insertar(aux[i]);
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
		if (taxis.esVacia())
			throw new DesbordamientoInferiorException(
					"parada de Taxis vacia en minusvalidoTaxi");

		Taxi[] aux = new Taxi[taxis.tamaño()];

		for (int i = 0; !taxis.esVacia(); i++) {
			aux[i] = (Taxi) taxis.quitarPrimero();
		}
		taxis.vaciar();

		Taxi minus = null;
		boolean encontrado = false;
		for (int i = 0; i < aux.length; i++) {
			if (aux[i].getMinusvalidos() && encontrado == false) {
				minus = aux[i];
				encontrado = true;
			} else {
				taxis.insertar(aux[i]);
			}
		}
		return minus;
	}
}
