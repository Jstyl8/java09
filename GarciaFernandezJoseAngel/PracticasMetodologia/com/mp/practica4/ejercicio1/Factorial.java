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
 * Clase que contiene metodos para calcular el factorial de un numero
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 30.03.2009
 */
public class Factorial {

	/**
	 * Metodo iterativo para calcular el factorial de un numero
	 * 
	 * @param n
	 *            representa el numero a calcular el factorial
	 * @return devuelve el factorial del numero especificado
	 */
	public static int factorialIter(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;

	}

	/**
	 * Metodo recursivo para calcular el factorial de un numero
	 * 
	 * @param n
	 *            representa el numero a calcular el factorial
	 * @return devuelve el factorial del numero especificado
	 */
	public static int factorialRec(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return factorialRec(n - 1) * n;
		}
	}

}
