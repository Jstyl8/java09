//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 3, Ejercicio 2
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica3.ejercicio2;

/**
 * Clase que contiene los distintos metodos para resolver el problema de la
 * subsecuencia maxima
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.03.2009
 */
public class SolucionesSubsecuencia {

	/**
	 * Variable privada que representa el inicio de la subsecuencia maxima
	 */
	public static int secIni;

	/**
	 * Variable privada que representa el fin de la subsecuencia maxima
	 */
	public static int secFin;

	/**
	 * Variable privada que representa la suma maxima de la subsecuencia
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
		secIni = 0;
		secFin = 0;
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
		secIni = 0;
		secFin = 0;
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
		secIni = 0;
		secFin = 0;
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
}
