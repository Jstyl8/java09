//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 3, Ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//

package com.mp.practica3.ejercicio1;

import java.text.DecimalFormat;

/**
 * Clase para comprobar la eficiencia de los algoritmos para resolver
 * polinomios
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.03.2009
 */
public class UsoPolinomio {
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
	 * @param cuadraticoTime
	 *            el tiempo de procesamiento del metodo polinomioCuadratico
	 * @param linealTime
	 *            el tiempo de procesamiento del metodo polinomioLineal
	 */
	private static void listado(long cuadraticoTime, long linealTime) {

		System.out.printf("%-10s%-15s%-15s", k, formatter
				.format(cuadraticoTime), formatter.format(linealTime));
		System.out.println();

	}

	/**
	 * Metodo principal para la prueba de tiempos
	 * 
	 * @param args
	 *            parametros del main
	 */
	public static void main(String[] args) {

		System.out.println("Tiempos en nanosegundos");
		System.out.printf("%-10s%-15s%-15s", "N", "O(N\u00B2)", "O(N)");
		System.out.println();
		
		// Bucle para la salida por pantalla con 10, 100 y 1000 elementos
		k = 10;
		for (int j = 1; j <= 2; j++) {

			Polinomio polinomioProblema = new Polinomio(k, 3.0);
			double[] coeficientes = new double[polinomioProblema.getGrado() + 1];
			for (int i = 0; i < polinomioProblema.getGrado(); i++) {
				coeficientes[i] = 2.0;
			}
			polinomioProblema.setCoeficientes(coeficientes);

			startTime = System.nanoTime();
			SolucionesPolinomio.polinomioLineal(polinomioProblema);
			long estimatedTime1 = System.nanoTime() - startTime;

			startTime = System.nanoTime();
			SolucionesPolinomio.polinomioCuadratico(polinomioProblema);
			long estimatedTime2 = System.nanoTime() - startTime;

			listado(estimatedTime1, estimatedTime2);
			k *= 10;
		}
	}

}
