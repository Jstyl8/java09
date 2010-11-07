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
 * Clase que contiene metodos para solucionar la secuencia de Fibonacci
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 30.03.2009
 */
public class Fibonacci {

	/**
	 * Metodo iterativo para calcular un elemento de la secuencia de fibonacci
	 * 
	 * @param n
	 *            representa el numero del elemento que queremos obtener
	 * @return devuelve el elemento especificado de la secuencia de fibonacci
	 */
	public static int fibonacciIter(int n) {

		if (n <= 1) {
			return n;
		} else {
			int penultimo = 0;
			int actual = 1;
			int ultimo = 1;
			for (int i = 1; i <= n - 2; i++) {
				penultimo = ultimo;
				ultimo = actual;
				actual = ultimo + penultimo;
			}
			return actual;
		}

	}

	/**
	 * Metodo recursivo para calcular un elemento de la secuencia de fibonacci
	 * 
	 * @param n
	 *            representa el numero del elemento que queremos obtener
	 * @return devuelve el elemento especificado de la secuencia de fibonacci
	 */
	public static int fibonacciRec(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacciRec(n - 1) + fibonacciRec(n - 2);
		}
	}

}
