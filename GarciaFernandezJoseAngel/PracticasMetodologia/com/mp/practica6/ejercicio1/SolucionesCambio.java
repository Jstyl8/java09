//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 6, Ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica6.ejercicio1;

/**
 * Clase que contiene metodos para calcular el numero de monedas a dar en un
 * cambio
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 31.03.2009
 */
public class SolucionesCambio {

	/**
	 * Array de int que se usara en el metodo cambioMonedaDinamico y que
	 * almacenara el numero de monedas usadas para el cambio
	 */
	private static int[] monedasUsadas;

	/**
	 * Array de int que se usara en el metodo cambioMonedaDinamico que contiene
	 * la ultima moneda usada para devolver el cambio optimo en cada caso
	 */
	private static int[] ultimaMoneda;

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
	 * Metodo privado recursivo para devolver el numero minimo de monedas
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

	/**
	 * Metodo voraz para calcular el minimo numero de monedas a devolver
	 * 
	 * @param cambio
	 *            el cambio a tratar
	 * @return el numero minimo de monedas
	 */
	public static int cambioMonedaVoraz(Cambio cambio) {

		int nMonedas = 0;
		int cambioUso = cambio.getACambiar();
		for (int i = cambio.getMonedas().length - 1; i >= 0; i--) {

			while (cambioUso >= cambio.getMonedas()[i]) {
				nMonedas++;
				cambioUso -= cambio.getMonedas()[i];
			}
		}
		return nMonedas;
	}

	/**
	 * Metodo de programacion dinamica para calcular el minimo numero de monedas
	 * a devolver
	 * 
	 * @param cambio
	 *            el cambio a tratar
	 * @return el numero minimo de monedas
	 */
	public static int cambioMonedaDinamico(Cambio cambio) {

		monedasUsadas = new int[cambio.getACambiar() + 1];
		ultimaMoneda = new int[cambio.getACambiar() + 1];

		monedasUsadas[0] = 0;
		ultimaMoneda[0] = 1;

		for (int unidades = 1; unidades <= cambio.getACambiar(); unidades++) {
			int minMonedas = unidades;
			int nuevaMoneda = 1;

			for (int j = 0; j < cambio.getMonedas().length; j++) {
				if (cambio.getMonedas()[j] > unidades) {
					continue;
				}
				if (monedasUsadas[unidades - cambio.getMonedas()[j]] + 1 < minMonedas) {
					minMonedas = monedasUsadas[unidades
							- cambio.getMonedas()[j]] + 1;
					nuevaMoneda = cambio.getMonedas()[j];
				}
			}
			monedasUsadas[unidades] = minMonedas;
			ultimaMoneda[unidades] = nuevaMoneda;
		}
		return monedasUsadas[cambio.getACambiar()];
	}
}
