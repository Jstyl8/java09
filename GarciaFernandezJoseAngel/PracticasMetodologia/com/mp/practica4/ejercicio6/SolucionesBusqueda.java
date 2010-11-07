//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 4, Ejercicio 6
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica4.ejercicio6;

import com.mp.excepciones.ElementoNoEncontradoException;

/**
 * Clase que contiene los distintos metodos para realizar busquedas
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 21.03.2009
 */
public class SolucionesBusqueda {

	public SolucionesBusqueda(Busqueda busqueda) {
	}

	/**
	 * Metodo de busqueda lineal O(N)
	 * 
	 * @param busqueda
	 *            representa la busqueda a utilizar
	 * @return devuelve el numero buscado o lanza una excepcion
	 * @exception ElementoNoEncontradoException
	 *                si no se encuentra el numero buscado
	 */
	public long busquedaLineal(Busqueda busqueda)
			throws ElementoNoEncontradoException {

		for (int i = 0; i < busqueda.getNDatos(); i++) {

			if (busqueda.getDatos()[i] == busqueda.getNumBuscado())
				return busqueda.getDatos()[i];
		}
		throw new ElementoNoEncontradoException("No encontrado");
	}

	/**
	 * Metodo de busqueda binaria iterada
	 * 
	 * @param busqueda
	 *            representa la busqueda a utilizar
	 * @return devuelve el numero buscado o lanza una excepcion
	 * @exception ElementoNoEncontradoException
	 *                si no se encuentra el numero buscado
	 */
	public long busquedaBinariaIter(Busqueda busqueda)
			throws ElementoNoEncontradoException {

		int inicio = 0;
		int fin = busqueda.getNDatos() - 1;
		int medio;

		while (inicio <= fin) {
			medio = (inicio + fin) / 2;

			if (busqueda.getDatos()[medio] < busqueda.getNumBuscado())
				inicio = medio + 1;
			else if (busqueda.getDatos()[medio] > busqueda.getNumBuscado())
				fin = medio - 1;
			else
				return medio;
		}
		throw new ElementoNoEncontradoException("No encontrado");
	}

	/**
	 * Metodo de busqueda binaria recursiva
	 * 
	 * @param busqueda
	 *            representa la busqueda a utilizar
	 * @return devuelve el numero buscado o lanza una excepcion
	 * @exception ElementoNoEncontradoException
	 *                si no se encuentra el numero buscado
	 */
	public int busquedaBinariaRec(Busqueda busqueda)
			throws ElementoNoEncontradoException {

		int numBuscado = busqBinaria(busqueda.getDatos(), 0, busqueda
				.getDatos().length - 1, busqueda.getNumBuscado());
	
			return numBuscado;
	}

	/**
	 * Metodo privado de busqueda binaria recursiva para su uso en
	 * busquedaBinariRec
	 * 
	 * @param array
	 *            de datos enteros
	 * @param limInf
	 *            limite inferior
	 * @param limSup
	 *            limite superior
	 * @param valor
	 *            buscado
	 * @return -1, si no se encuentra, o el numero buscado si se encuentra
	 * @throws ElementoNoEncontradoException 
	 */
	private int busqBinaria(int array[], int limInf, int limSup, int valor) throws ElementoNoEncontradoException {

		if (limInf > limSup)
			throw new ElementoNoEncontradoException("No encontrado");
		else {
			int mitad = (limInf + limSup) / 2;
			if (valor == array[mitad])
				return mitad;
			else if (valor < array[mitad])
				return busqBinaria(array, limInf, mitad - 1, valor);
			else
				return busqBinaria(array, mitad + 1, limSup, valor);
		}
	}
}
