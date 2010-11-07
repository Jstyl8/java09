//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Documentacion de ejercicio 2
// ASIGNATURA : Metodologia de la Programación
//
package com.mio.general.examen.ejer3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Clase que contiene distintos metodos de ordenacion
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 20.04.2009
 */
public class Ordenacion {

	/**
	 * Variable privada que servira para detectar arrays pequenyos en QuickSort
	 */
	private static final int LIMITE = 10;

	/**
	 * Metodo de ordenacion usando la rutina de java
	 * 
	 * @param a
	 *            un array de elementos comparables
	 */
	public static void sort(Comparable[] a) {
		Arrays.sort(a);
	}

	/**
	 * Metodo de ordenacion por insercion para ordenar un array
	 * 
	 * @param a
	 *            un array de elementos comparables
	 */
	public static void ordenacionPorInsercion(Comparable[] a) {
		for (int p = 1; p < a.length; p++) {
			Comparable tmp = a[p];
			int j = p;

			for (; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	/**
	 * Algoritmo Mergesort
	 * 
	 * @param a
	 *            un array de elementos comparables
	 */
	public static void mergeSort(Comparable[] a) {
		Comparable[] tmpArray = new Comparable[a.length];
		mergeSort(a, tmpArray, 0, a.length - 1);
	}

	/**
	 * Metodo interno que hace las llamadas recursivas
	 * 
	 * @param a
	 *            un array de elementos comparables
	 * @param tmpArray
	 *            un array para colocar el resultado de la mezcla
	 * @param izq
	 *            el indice mas a la izquierda del subarray
	 * @param der
	 *            el indice mas a la derecha del subarray
	 */
	private static void mergeSort(Comparable[] a, Comparable[] tmpArray,
			int izq, int der) {
		if (izq < der) {
			int centro = (izq + der) / 2;
			mergeSort(a, tmpArray, izq, centro);
			mergeSort(a, tmpArray, centro + 1, der);
			mezclar(a, tmpArray, izq, centro + 1, der);
		}
	}

	/**
	 * Metodo interno que mezcla 2 mitades ordenadas de un subarray
	 * 
	 * @param a
	 *            un array de elementos comparables
	 * @param tmpArray
	 *            un array para colocar el resultado de la mezcla
	 * @param posIzq
	 *            el indice mas a la izquierda del subarray
	 * @param posDer
	 *            el indice de comienzo de la segunda mitad
	 * @param posFin
	 *            el indice mas a la derecha del subarray
	 */
	private static void mezclar(Comparable[] a, Comparable[] tmpArray,
			int posIzq, int posDer, int posFin) {
		int finIzq = posDer - 1;
		int posAux = posIzq;
		int numElementos = posFin - posIzq + 1;

		// Bucle Principal
		while (posIzq <= finIzq && posDer <= posFin)
			if (a[posIzq].compareTo(a[posDer]) <= 0)
				tmpArray[posAux++] = a[posIzq++];
			else
				tmpArray[posAux++] = a[posDer++];

		// Copia el resto de la primera mitad
		while (posIzq <= finIzq)
			tmpArray[posAux++] = a[posIzq++];

		// Copia el resto de la segunda mitad
		while (posDer <= posFin)
			tmpArray[posAux++] = a[posDer++];

		// Copia el array auxiliar en el original
		for (int i = 0; i < numElementos; i++, posFin--)
			a[posFin] = tmpArray[posFin];
	}

	/**
	 * Algoritmo Quicksort
	 * 
	 * @param a
	 *            un array de elementos comparables
	 */
	public static void quickSort(Comparable[] a) {
		quicksort(a, 0, a.length - 1);
	}

	/**
	 * Metodo para intercambiar 2 elementos en un array
	 * 
	 * @param a
	 *            un array de elementos comparables
	 * @param index1
	 *            el indice del primer objeto
	 * @param index2
	 *            el indice del segundo objeto
	 */
	private static final void intercambiarReferencias(Comparable[] a,
			int index1, int index2) {
		Comparable tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

	/**
	 * Metodo quickSort interno que hace las llamadas recursivas usa particion
	 * con la mediana de 3 y un limite para detectar arrays pequenyos
	 * 
	 * @param a
	 *            un array de elementos comparables
	 * @param ini
	 *            el indice mas a la izquierda del subarray
	 * @param fin
	 * 
	 *            el indice mas a la derecha del subarray
	 */
	private static void quicksort(Comparable[] a, int ini, int fin) {
		if (ini + LIMITE > fin)
			insertionSort(a, ini, fin);
		else {
			// Ordena ini, medio y fin
			int centro = (ini + fin) / 2;
			if (a[centro].compareTo(a[ini]) < 0)
				intercambiarReferencias(a, ini, centro);
			if (a[fin].compareTo(a[ini]) < 0)
				intercambiarReferencias(a, ini, fin);
			if (a[fin].compareTo(a[centro]) < 0)
				intercambiarReferencias(a, centro, fin);

			// Coloca el pivote en la posicion fin-1
			intercambiarReferencias(a, centro, fin - 1);
			Comparable pivote = a[fin - 1];

			// Empieza la particion
			int i, j;
			for (i = ini, j = fin - 1;;) {
				while (a[++i].compareTo(pivote) < 0)
					;
				while (pivote.compareTo(a[--j]) < 0)
					;
				if (i < j) {
					intercambiarReferencias(a, i, j);
				} else {
					break;
				}
			}

			// Restaura el pivote
			intercambiarReferencias(a, i, fin - 1);

			quicksort(a, ini, i - 1); // Ordena los elementos pequenyos
			quicksort(a, i + 1, fin); // Ordena los elementos grandes
		}
	}

	/**
	 * Rutina de ordenacionpor insercion para su uso en quicksort
	 * 
	 * @param a
	 *            un array de elementos comparables
	 * @param izq
	 *            el indice mas a la izquierda del subarray
	 * @param der
	 *            el indice mas a la derecha del subarray
	 */
	private static final void insertionSort(Comparable[] a, int izq, int der) {
		for (int p = izq + 1; p <= der; p++) {
			Comparable tmp = a[p];
			int j;

			for (j = p; j > izq && tmp.compareTo(a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	/**
	 * Algoritmo Mergesort
	 * 
	 * @param a
	 *            un array de elementos comparables
	 */
	public static void mergeSort(Comparable[] a, Comparator c) {
		Comparable[] tmpArray = new Comparable[a.length];
		mergeSort(a, tmpArray, 0, a.length - 1, c);
	}

	/**
	 * Metodo interno que hace las llamadas recursivas
	 * 
	 * @param a
	 *            un array de elementos comparables
	 * @param tmpArray
	 *            un array para colocar el resultado de la mezcla
	 * @param izq
	 *            el indice mas a la izquierda del subarray
	 * @param der
	 *            el indice mas a la derecha del subarray
	 */
	private static void mergeSort(Comparable[] a, Comparable[] tmpArray,
			int izq, int der, Comparator c) {
		if (izq < der) {
			int centro = (izq + der) / 2;
			mergeSort(a, tmpArray, izq, centro, c);
			mergeSort(a, tmpArray, centro + 1, der, c);
			mezclar(a, tmpArray, izq, centro + 1, der, c);
		}
	}

	/**
	 * Metodo interno que mezcla 2 mitades ordenadas de un subarray
	 * 
	 * @param a
	 *            un array de elementos comparables
	 * @param tmpArray
	 *            un array para colocar el resultado de la mezcla
	 * @param posIzq
	 *            el indice mas a la izquierda del subarray
	 * @param posDer
	 *            el indice de comienzo de la segunda mitad
	 * @param posFin
	 *            el indice mas a la derecha del subarray
	 */
	private static void mezclar(Comparable[] a, Comparable[] tmpArray,
			int posIzq, int posDer, int posFin, Comparator c) {
		int finIzq = posDer - 1;
		int posAux = posIzq;
		int numElementos = posFin - posIzq + 1;

		// Bucle Principal
		while (posIzq <= finIzq && posDer <= posFin)
			if (c.compare(a[posIzq], a[posDer]) <= 0)
				tmpArray[posAux++] = a[posIzq++];
			else
				tmpArray[posAux++] = a[posDer++];

		// Copia el resto de la primera mitad
		while (posIzq <= finIzq)
			tmpArray[posAux++] = a[posIzq++];

		// Copia el resto de la segunda mitad
		while (posDer <= posFin)
			tmpArray[posAux++] = a[posDer++];

		// Copia el array auxiliar en el original
		for (int i = 0; i < numElementos; i++, posFin--)
			a[posFin] = tmpArray[posFin];
	}

}
