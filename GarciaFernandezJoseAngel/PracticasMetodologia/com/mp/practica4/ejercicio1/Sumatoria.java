//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 4, Ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica4.ejercicio1;

/**
 * Clase que contiene metodos para solucionar la suma de los n primeros enteros
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 30.03.2009
 */
public class Sumatoria {

	/**
	 * Metodo de suma Gaussiana
	 * 
	 * @param n
	 *            representa el entero limite n
	 * @return devuelve la sumatoria hasta n mediante la formula de gaus
	 */
	public static int sumaGaus(int n) {

		if (n < 0) {
			return 0;
		} else {
			return (n * (n + 1)) / 2;
		}
	}

	/**
	 * Metodo de suma Recursiva
	 * 
	 * @param n
	 *            representa el entero limite n
	 * @return devuelve la sumatoria hasta n mediante recursividad
	 */
	public static int sumaRec(int n) {
		if (n < 0) {
			return 0;
		} else {
			return sumaRec(n - 1) + n;
		}
	}

	/**
	 * Metodo de suma Iterativa
	 * 
	 * @param n
	 *            representa el entero limite n
	 * @return devuelve la sumatoria hasta n mediante iteracion
	 */
	public static int sumaIter(int n) {
		int suma = 0;
		while (n > 0) {
			suma += n--;
		}
		return suma;
	}
}
