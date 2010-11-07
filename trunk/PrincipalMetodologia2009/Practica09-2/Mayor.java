package com.mp.practica2.ejercicio4;

public class Mayor {

	/**
	 * El EnteroMayor
	 * 
	 * @param vector
	 *            Un array de enteros no vacio
	 * @return El entero mayor en el array
	 */
	public static int elEnteroMayor(int[] vector) {

		int indice;
		int max = Integer.MIN_VALUE;

		for (indice = 0; indice < vector.length -1; indice++) {
			if (vector[indice] > max) {
				max = vector[indice];
			}
		}
		return max;
	}

}
