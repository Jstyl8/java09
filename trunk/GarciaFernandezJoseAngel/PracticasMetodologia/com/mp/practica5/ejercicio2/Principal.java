//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Documentacion de ejercicio 2
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica5.ejercicio2;

import java.text.DecimalFormat;
import com.mp.utilidades.NumerosAleatorios;

/**
 * Clase para comprobar la eficiencia de los algoritmos de ordenacion
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 20.04.2009
 */
public class Principal {

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
	 * @param InserTime
	 *            el tiempo en realizar la ordenacion con OrdenacionPorInsercion
	 * @param mergeSortTime
	 *           el tiempo en realizar la ordenacion con mergeSort
	 * @param sortTime
	 *            el tiempo en realizar la ordenacion con sort
	 * @param quickSortTime el tiempo en realizar la ordenacion con quickSort
	 */
	private static void listado(long insertTime, long mergeSortTime,
			long sortTime, long quickSortTime) {
		System.out.printf("%-10s%-15s%-15s%-15s%-15s", k, 
				formatter.format(insertTime*0.000001),
				formatter.format(mergeSortTime*0.000001), 
				formatter.format(sortTime*0.000001),
				formatter.format(quickSortTime*0.000001));
		System.out.println();
	}

	/**
	 * Metodo principal para la prueba de tiempos
	 * 
	 * @param args
	 *            parametros del main
	 */
	public static void main(String[] args) {

		NumerosAleatorios ale = new NumerosAleatorios();
		System.out.println("Tiempos en milisegundos");
		System.out.printf("%-10s%-15s%-15s%-15s%-15s", "N", "Insercion",
				"MergeSort", "Sort","quickSort");
		System.out.println();
		
		// Bucle para la salida por pantalla con 10, 100 y 1000 elementos
		k = 100;
		for (int j = 1; j <= 3; j++) {

			Integer[] datos = new Integer[k];
			for (int i = 0; i < datos.length; i++) {
				datos[i] = new Integer(ale.randomInt());
			}
		
			startTime = System.nanoTime();
			Ordenacion.ordenacionPorInsercion(datos);
			long estimatedTime1 = System.nanoTime() - startTime;

			startTime = System.nanoTime();
			Ordenacion.mergeSort(datos);
			long estimatedTime2 = System.nanoTime() - startTime;

			startTime = System.nanoTime();
			Ordenacion.sort(datos);
			long estimatedTime3 = System.nanoTime() - startTime;

			startTime = System.nanoTime();
			Ordenacion.quickSort(datos);
			long estimatedTime4 = System.nanoTime() - startTime;
			
			listado(estimatedTime1, estimatedTime2, estimatedTime3,estimatedTime4);
			k *= 2;
		}
	}
}
