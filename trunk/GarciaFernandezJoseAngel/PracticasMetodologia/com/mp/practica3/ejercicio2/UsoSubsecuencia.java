//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 3, Ejercicio 2
// ASIGNATURA : Metodologia de la Programación
//

package com.mp.practica3.ejercicio2;

import java.text.DecimalFormat;

/**
 * Clase para comprobar la eficiencia de los algoritmos para resolver
 * subsecuencias
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.03.2009
 */
public class UsoSubsecuencia {

	/**
	 * Variable privada que se usara como tiempo de inicio para el tiempo de
	 * ejecucion
	 */
	private static long startTime;

	/**
	 * Variable privada que se usara para manejar el bucle y la cantidad de
	 * elementos de la busqueda
	 */
	private static int k;

	/**
	 * Objeto de tipo NumberFormat que se usara para mostrar los resultados en
	 * notacion cientifica
	 */
	private static DecimalFormat formatter = new DecimalFormat("0.####E0");

	/**
	 * Metodo privado que se usara para mostrar los tiempos
	 * 
	 * @param cubicaTime
	 *            el tiempo en realizar la busqueda del metodo
	 *            SubsecuenciaCubica
	 * @param cuadraticaTime
	 *            el tiempo en realizar la busqueda del algoritmo
	 *            SubsecuenciaCuadratica
	 * @param linealTime
	 *            el tiempo en realizar la busqueda del metodo
	 *            SubsecuenciaLineal
	 */
	private static void listado(long cubicaTime, long cuadraticaTime,
			long linealTime) {
		System.out.printf("%-10s%-15s%-15s%-15s", k, 
				formatter.format(cubicaTime*0.000001),
				formatter.format(cuadraticaTime*0.000001), 
				formatter.format(linealTime*0.000001));
		System.out.println();

	}

	/**
	 * Metodo principal para la prueba de tiempos
	 * 
	 * @param args
	 *            parametros del main
	 */
	public static void main(String[] args) {

		System.out.println("Tiempos en milisegundos");
		System.out.printf("%-10s%-15s%-15s%-15s", "N", "O(N\u00B3)",
				"O(N\u00B2)", "O(N)");
		System.out.println();
		
		// Bucle para la salida por pantalla con 10, 100 y 1000 elementos
		k = 10;
		for (int j = 1; j <= 3; j++) {

			Subsecuencia subsecuenciaProblema = new Subsecuencia(k,10);

			startTime = System.nanoTime();
			SolucionesSubsecuencia.SubsecuenciaCubica(subsecuenciaProblema);
			long estimatedTime1 = System.nanoTime() - startTime;

			startTime = System.nanoTime();
			SolucionesSubsecuencia.SubsecuenciaCuadratica(subsecuenciaProblema);
			long estimatedTime2 = System.nanoTime() - startTime;

			startTime = System.nanoTime();
			SolucionesSubsecuencia.SubsecuenciaLineal(subsecuenciaProblema);
			long estimatedTime3 = System.nanoTime() - startTime;

			listado(estimatedTime1, estimatedTime2, estimatedTime3);
			k *= 10;
		}
	}

}
