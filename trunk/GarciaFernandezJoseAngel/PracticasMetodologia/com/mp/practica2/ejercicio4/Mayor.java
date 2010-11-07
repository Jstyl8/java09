//
// Universidad de Almer�a
// Ingenier�a T�cnica de Inform�tica de Sistemas
// Fuente Java seg�n Plantilla
//
// PRACTICA : Practica 2, Ejercicio 4
// ASIGNATURA : Metodologia de la Programaci�n
//
package com.mp.practica2.ejercicio4;

/**
 * Clase que contiene un metodo para hallar el entero mayor de un array de
 * entero
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 07.03.2009
 */
public class Mayor {

	/**
	 * elEnteroMayor
	 * 
	 * @param vector
	 *            Un array de enteros no vacio
	 * @return El entero mayor en el array
	 */
	public static int elEnteroMayor(int[] vector) {

		int indice;
		int max = Integer.MIN_VALUE;

		for (indice = 0; indice < vector.length; indice++) {
			if (vector[indice] > max) {
				max = vector[indice];
			}
		}
		return max;
	}

}
