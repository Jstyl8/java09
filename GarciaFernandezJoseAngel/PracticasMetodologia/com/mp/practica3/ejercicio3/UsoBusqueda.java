//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 3, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//

package com.mp.practica3.ejercicio3;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Clase para comprobar la eficiencia de los algoritmos para busqueda
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.03.2009
 */
public class UsoBusqueda {

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
	private static NumberFormat formatter = new DecimalFormat("0.####E0");

	/**
	 * Metodo privado que se usara para mostrar los tiempos
	 * 
	 * @param tiempo
	 *            representa el tiempo en realizar la busqueda
	 * */
	private static void listado(long tiempo) {
		System.out.printf("%-10s%-15s%-15s%-15s%s", k,
				formatter.format(tiempo), formatter.format(tiempo / k),
				formatter.format(tiempo / Math.pow(k, 2)), formatter
						.format(tiempo / Math.log10(k)));
		System.out.println();

	}

	/**
	 * Metodo principal para la prueba de tiempos
	 * 
	 * @param args
	 *            parametros del main
	 */
	public static void main(String[] args) {

		System.out.printf("%-10s%-15s%-15s%-15s%s", "N", "Tiempo(ns)", "T/N",
				"T/N\u00B2", "T/(logN)");
		System.out.println();

		// Bucle para la salida por pantalla con 10000, 20000 y 40000 elementos
		k = 10000;
		for (int j = 1; j <= 3; j++) {

			Busqueda busqueda = new Busqueda(k);
			int[] datos = new int[k];
			for (int i = 0; i < datos.length; i++) {
				datos[i] = i;
			}
			busqueda.setDatos(datos);
			busqueda.setNumBuscado(2000);

			startTime = System.nanoTime();
			SolucionesBusqueda.busquedaBinariaIter(busqueda);
			long estimatedTime = System.nanoTime() - startTime;

			listado(estimatedTime);
			k *= 2;
		}
	}
}