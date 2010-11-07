//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 3, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica3.ejercicio3;

/**
 * Clase que contiene los distintos metodos para realizar busquedas
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.03.2009
 */
public class SolucionesBusqueda {

	/**
	 * Metodo de busqueda lineal O(N)
	 * 
	 * @param busqueda
	 *            representa la busqueda a utilizar
	 * @return devuelve el numero buscado o el minimo valor si no se encuentra
	 */
	public static long busquedaLineal(Busqueda busqueda) {

		for (int i = 0; i < busqueda.getNDatos(); i++) {

			if (busqueda.getDatos()[i] == busqueda.getNumBuscado())
				return busqueda.getDatos()[i];
		}
		return Long.MIN_VALUE;
	}

	/**
	 * Metodo de busqueda binaria iterada
	 * 
	 * @param busqueda
	 *            representa la busqueda a utilizar
	 * @return devuelve el numero buscado o el minimo valor si no se encuentra
	 */
	public static long busquedaBinariaIter(Busqueda busqueda) {

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
		return Long.MIN_VALUE;
	}

}
