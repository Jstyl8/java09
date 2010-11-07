//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 4, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica4.ejercicio3;

/**
 * Clase que contiene el metodo recursivo apra calcular el numero de monedas a
 * dar en un cambio
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 31.03.2009
 */
public class SolucionesCambio {

	/**
	 * Metodo para calcular el minimo numero de monedas a devolver
	 * 
	 * @param cambio
	 *            el cambio a tratar
	 * @return el numero minimo de monedas
	 */
	public static int cambioMonedaRecursivo(Cambio cambio) {

		return cambRec(cambio.getMonedas(), cambio.getACambiar());

	}

	/**
	 * Metodo privado para devolver el numero minimo de monedas
	 * 
	 * @param a
	 *            el array de enteros que representa las monedas
	 * @param aCambiar
	 *            el valor del cambio
	 * @return el numero minimo de monedas
	 */
	private static int cambRec(int[] a, int aCambiar) {

		for (int i = 0; i < a.length; i++) {
			if (a[i] == aCambiar) {
				return 1;
			}
		}
		int minMonedas = aCambiar;

		for (int j = 1; j <= aCambiar / 2; j++) {

			int monedasActuales = cambRec(a, j) + cambRec(a, aCambiar - j);
			if (monedasActuales < minMonedas) {
				minMonedas = monedasActuales;
			}
		}
		return minMonedas;
	}
}
