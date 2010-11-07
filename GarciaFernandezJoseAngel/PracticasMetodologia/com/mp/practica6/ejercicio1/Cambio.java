//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 6, Ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica6.ejercicio1;

/**
 * Clase que representa un cambio
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 02.05.2009
 */
public class Cambio {

	/**
	 * Array privado que representa las monedas
	 */
	private int[] monedas;
	/**
	 * Variable privada que representa la cantidad a cambiar
	 */
	private int aCambiar;

	/**
	 * Genera un objeto cambio con parametros
	 * 
	 * @param monedas
	 * @param aCambiar
	 */
	public Cambio(int[] monedas, int aCambiar) {
		super();
		this.monedas = monedas;
		this.aCambiar = aCambiar;
	}

	/**
	 * Metodo modificador para el array monedas
	 * 
	 * @param monedas
	 *            el array de monedas a poner
	 */
	public void setMonedas(int[] monedas) {
		this.monedas = monedas;
	}

	/**
	 * Metodo de acceso para el array monedas
	 * 
	 * @return el array de monedas
	 */
	public int[] getMonedas() {
		return monedas;
	}

	/**
	 * Metodo modificador para el la propiedad aCambiar
	 * 
	 * @param aCambiar
	 *            la cantidad a cambiar
	 */
	public void setACambiar(int aCambiar) {
		this.aCambiar = aCambiar;
	}

	/**
	 * Metodo de acceso para la propiedad aCambiar
	 * 
	 * @return la cantidad a cambiar
	 */
	public int getACambiar() {
		return aCambiar;
	}

}
