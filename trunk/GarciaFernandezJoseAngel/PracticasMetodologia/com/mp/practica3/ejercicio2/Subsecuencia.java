//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 3, Ejercicio 2
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica3.ejercicio2;

import com.mp.utilidades.NumerosAleatorios;

/**
 * Clase que representa una subsecuencia de numeros enteros
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.03.2009
 */
public class Subsecuencia {

	/**
	 * Variable privada que representa el numero de elementos de la subsecuencia
	 */
	private int nElementos;

	/**
	 * Array privado que representa los enteros
	 */
	private int[] enteros;

	/**
	 * Variable privada que representa el rango de valores de la subsecuencia
	 */
	private int rango;

	/**
	 * Genera una subsecuencia con un array de enteros predefinido
	 * 
	 * @param enteros
	 *            el array de enteros
	 */
	public Subsecuencia(int[] enteros) {
		this.setEnteros(enteros);
		nElementos=enteros.length;
	}

	/**
	 * Genera una subsecuencia aleatoria
	 * 
	 * @param nElementos
	 *            de subsecuencia
	 * @param rango
	 *            para la generacion de los enteros
	 */
	public Subsecuencia(int nElementos, int rango) {
		NumerosAleatorios ale = new NumerosAleatorios();
		this.nElementos = nElementos;
		this.rango = rango;
		this.enteros = new int[nElementos];
		for (int i = 0; i < enteros.length; i++) {
			enteros[i] = ale.randomInt(-rango, rango);
		}

	}

	/**
	 * Metodo modificador para la propiedad nElementos
	 * 
	 * @param nElementos
	 *            a poner
	 */
	public void setNElementos(int nElementos) {
		this.nElementos = nElementos;
	}

	/**
	 * Metodo de acceso para la propiedad nElementos
	 * 
	 * @return el numero de elementos de la subsecuencia
	 */
	public int getNElementos() {
		return nElementos;
	}

	/**
	 * Metodo modificador para el array enteros
	 * 
	 * @param enteros
	 *            el array de entero a poner
	 */
	public void setEnteros(int[] enteros) {
		this.enteros = enteros;
	}

	/**
	 * Metodo de acceso para el array enteros
	 * 
	 * @return el array de enteros de la subsecuencia
	 */
	public int[] getEnteros() {
		return enteros;
	}

}