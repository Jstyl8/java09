//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 3, Ejercicio 4
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica3.ejercicio4;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Clase para comprobar la eficiencia de la concatenacion de Strings y
 * StringBuffers
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.03.2009
 */
public class CosteString {
	/**
	 * Variable privada final que representa el String que se usara para la
	 * concatenacion
	 */
	private final static String LINEA = "********************************************************************************";

	/**
	 * Variable privada final que representa el StringBuffer que se usara para
	 * la concatenacion
	 */
	private final static StringBuffer LINEA2 = new StringBuffer(
			"********************************************************************************");
	/**
	 * Variable privada que se usara para manejar los bucles
	 */
	private static int k;

	/**
	 * Variable privada que se usara como tiempo de inicio para el tiempo de
	 * ejecucion
	 */
	private static long startTime;

	/**
	 * Objeto de tipo NumberFormat que se usara para mostrar los resultados en
	 * notacion cientifica
	 */
	private static NumberFormat formatter = new DecimalFormat("0.####E0");

	/**
	 * Metodo privado que se usara para mostrar los tiempos
	 * 
	 * @param stringTime
	 *            representa el tiempo para la concatenacion de cadenas tipo
	 *            string
	 * @param stringBufferTime
	 *            representa el tiempo para la concatenacion de cadenas tipo
	 *            stringBuffer
	 */
	private static void listado(long stringTime, long stringBufferTime) {
		System.out.printf("%1$-10s%2$-15s%3$-15s\n", k, formatter
				.format(stringTime), formatter.format(stringBufferTime));

	}

	/**
	 * Metodo principal para la prueba de tiempos
	 * 
	 * @param args
	 *            parametros del main
	 */
	public static void main(String[] args) {

		String lectura = new String("");
		StringBuffer lectura2 = new StringBuffer("");

		System.out.println("Tiempos en ns");
		System.out.printf("%1$-10s%2$-15s%3$-15s\n", "N", "String",
				"StringBuffer");

		// Bucle para la concatenacion
		k = 10;
		for (int j = 1; j <= 3; j++) {

			startTime = System.nanoTime();
			for (int i = 0; i < k; i++) {
				lectura += LINEA;
			}
			long estimatedTimeString = System.nanoTime() - startTime;

			startTime = System.nanoTime();
			for (int i = 0; i < k; i++) {
				lectura2.append(LINEA2);
			}
			long estimatedTimeStringBuffer = System.nanoTime() - startTime;

			listado(estimatedTimeString, estimatedTimeStringBuffer);
			k *= 10;
		}
	}
}
