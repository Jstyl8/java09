//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 4, Ejercicio 5
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica5.ejercicio3;

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
	private int numElem;

	/**
	 * Variable privada que representa el rango de valores de la subsecuencia
	 */
	private int rango;

	/**
	 * Array privado que representa los enteros de la subsecuencia
	 */
	protected int[] datosModelo;

	/**
	 * Genera una subsecuencia con un array de enteros predefinido
	 * 
	 * @param datosModelo
	 *            el array de enteros
	 */
	public Subsecuencia(int[] datosModelo) {
		this.setDatosModelo(datosModelo);
		numElem = datosModelo.length;
	}

	/**
	 * Genera una subsecuencia aleatoria
	 * 
	 * @param numElem
	 *            de subsecuencia
	 * @param rango
	 *            para la generacion de los enteros
	 */
	public Subsecuencia(int numElem, int rango) {
		NumerosAleatorios ale = new NumerosAleatorios();
		this.rango = rango;
		this.numElem = numElem;
		this.datosModelo = new int[numElem];
		for (int i = 0; i < datosModelo.length; i++) {
			datosModelo[i] = ale.randomInt(-rango, rango);
		}

	}

	/**
	 * Metodo modificador para la propiedad numElem
	 * 
	 * @param numElem
	 *            a poner
	 */
	public void setNumElem(int numElem) {
		this.numElem = numElem;
	}

	/**
	 * Metodo de acceso para la propiedad numElem
	 * 
	 * @return el numero de elementos de la subsecuencia
	 */
	public int getNumElem() {
		return numElem;
	}

	/**
	 * Metodo modificador para el array datosModelo
	 * 
	 * @param datosModelo
	 *            el array de entero a poner
	 */
	public void setDatosModelo(int[] datosModelo) {
		this.datosModelo = datosModelo;
	}

	/**
	 * Metodo de acceso para el array datosModelo
	 * 
	 * @return el array datosModelo de la subsecuencia
	 */
	public int[] getDatoModelo() {
		return datosModelo;
	}

}