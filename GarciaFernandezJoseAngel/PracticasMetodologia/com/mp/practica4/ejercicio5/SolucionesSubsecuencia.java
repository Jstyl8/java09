//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 4, Ejercicio 5
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica4.ejercicio5;

/**
 * Clase que contiene los distintos metodos para resolver el problema de la
 * subsecuencia maxima
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.1 21.03.2009
 */
public class SolucionesSubsecuencia {

	/**
	 * Variable publica que representa el inicio de la subsecuencia maxima
	 */
	public static int secIni;

	/**
	 * Variable publica que representa el fin de la subsecuencia maxima
	 */
	public static int secFin;

	/**
	 * Variable publica que representa la suma maxima de la subsecuencia
	 */
	public static int sumaMax;

	/**
	 * Metodo de orden O(N^3)para hallar la subsecuencia maxima
	 * 
	 * @param subsecuenciaProblema
	 *            representa la subsecuencia a tratar
	 */
	public static void SubsecuenciaCubica(Subsecuencia subsecuenciaProblema) {

		sumaMax = 0;
		secIni = -1;
		secFin = -1;

		for (int i = 0; i < subsecuenciaProblema.getNElementos(); i++) {
			for (int j = i; j < subsecuenciaProblema.getNElementos(); j++) {

				int sumaActual = 0;
				for (int k = i; k <= j; k++)
					sumaActual += subsecuenciaProblema.getEnteros()[k];

				if (sumaActual > sumaMax) {
					sumaMax = sumaActual;
					secIni = i;
					secFin = j;
				}

			}
		}
	}

	/**
	 * Metodo de orden O(N^2)para hallar la subsecuencia maxima
	 * 
	 * @param subsecuenciaProblema
	 *            representa la subsecuencia a tratar
	 */
	public static void SubsecuenciaCuadratica(Subsecuencia subsecuenciaProblema) {

		sumaMax = 0;
		secIni = -1;
		secFin = -1;

		for (int i = 0; i < subsecuenciaProblema.getNElementos(); i++) {

			int sumaActual = 0;
			for (int j = i; j < subsecuenciaProblema.getNElementos(); j++) {
				sumaActual += subsecuenciaProblema.getEnteros()[j];

				if (sumaActual > sumaMax) {
					sumaMax = sumaActual;
					secIni = i;
					secFin = j;
				}
			}
		}
	}

	/**
	 * Metodo de orden O(N)para hallar la subsecuencia maxima
	 * 
	 * @param subsecuenciaProblema
	 *            representa la subsecuencia a tratar
	 */
	public static void SubsecuenciaLineal(Subsecuencia subsecuenciaProblema) {

		sumaMax = 0;
		secIni = -1;
		secFin = -1;

		int sumaActual = 0;
		for (int i = 0, j = 0; j < subsecuenciaProblema.getNElementos(); j++) {

			sumaActual += subsecuenciaProblema.getEnteros()[j];
			if (sumaActual > sumaMax) {
				sumaMax = sumaActual;
				secIni = i;
				secFin = j;
			} else if (sumaActual < 0) {
				i = j + 1;
				sumaActual = 0;
			}
		}
	}

	/**
	 * Metodo de orden O(NLogN)para hallar la subsecuencia maxima
	 * 
	 * @param subsecuenciaProblema
	 *            representa la subsecuencia a tratar
	 */
	public static void SubsecuenciaNLogaritmica(
			Subsecuencia subsecuenciaProblema) {
		sumaMax = 0;
		secIni = -1;
		secFin = -1;

		int[] datos = new int[3];
		datos = SubsecuenciaNLogaritmica(subsecuenciaProblema.getEnteros(), 0,
				subsecuenciaProblema.getNElementos() - 1);
		sumaMax = datos[0];
		secIni = datos[1];
		secFin = datos[2];
	}

	/**
	 * Metodo privado recursivo para su uso en el metodo
	 * SubsecuenciaNLogaritmica()
	 * 
	 * @param a
	 *            el array de enteros
	 * @param izdo
	 *            margen izquierdo del subarray
	 * @param dcho
	 *            margen derecho del subarray
	 * @return la subsecuencia maxima
	 */
	private static int[] SubsecuenciaNLogaritmica(int[] a, int izdo, int dcho) {
		int[] datos = new int[3];
		int[] sumaMaximaizdo = new int[3];
		int[] sumaMaximadcho = new int[3];
		int[] sumaDesdeCentro = new int[3];
		int sumaLadoIzquierdo, sumaLadoDerecho, centro, sumaMaximaLadoIzquierdo, sumaMaximaLadoDerecho;

		// caso base
		if (izdo == dcho) {
			if (a[izdo] > 0) {
				datos[0] = a[izdo];
				datos[1] = izdo;
				datos[2] = dcho;
				return datos;
			} else {
				datos[0] = 0;
				datos[1] = -1;
				datos[2] = -1;
				return datos;
			}
		} else {

			centro = (izdo + dcho) / 2;

			sumaMaximaizdo = SubsecuenciaNLogaritmica(a, izdo, centro);
			sumaMaximadcho = SubsecuenciaNLogaritmica(a, centro + 1, dcho);

			sumaMaximaLadoIzquierdo = 0;
			sumaLadoIzquierdo = 0;
			for (int i = centro; i >= izdo; i--) {
				sumaLadoIzquierdo = sumaLadoIzquierdo + a[i];
				if (sumaLadoIzquierdo > sumaMaximaLadoIzquierdo) {
					sumaMaximaLadoIzquierdo = sumaLadoIzquierdo;
					sumaDesdeCentro[1] = i;
				}
			}

			sumaMaximaLadoDerecho = 0;
			sumaLadoDerecho = 0;
			for (int i = centro + 1; i <= dcho; i++) {
				sumaLadoDerecho = sumaLadoDerecho + a[i];
				if (sumaLadoDerecho > sumaMaximaLadoDerecho) {
					sumaMaximaLadoDerecho = sumaLadoDerecho;
					sumaDesdeCentro[2] = i;
				}
			}

			sumaDesdeCentro[0] = sumaMaximaLadoIzquierdo
					+ sumaMaximaLadoDerecho;

			int maximo = max3(sumaMaximaizdo[0], sumaMaximadcho[0],
					sumaDesdeCentro[0]);

			if (maximo == sumaMaximaizdo[0])
				return sumaMaximaizdo;
			else if (maximo == sumaMaximadcho[0])
				return sumaMaximadcho;
			else
				return sumaDesdeCentro;

		}
	}

	/**
	 * Metodo privado que calcula el maximo de 3 entero
	 * 
	 * @param a
	 *            el entero 1
	 * @param b
	 *            el entero 2
	 * @param c
	 *            el entero 3
	 * @return el maximo de los tres valores
	 */
	private static int max3(int a, int b, int c) {
		return a > b ? a > c ? a : c : b > c ? b : c;
	}
}