//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Documentacion de ejercicio 5
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica5.ejercicio5;

/**
 * Clase que representa una baraja
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.04.2009
 */
public class Baraja {

	/**
	 * Variable privada que representa el nombre de la baraja
	 */
	private String nombreBaraja;

	/**
	 * Array privado de elementos tipo carta que representa las cartas de la
	 * baraja
	 */
	private Carta[] cartas;

	/**
	 * Genera una baraja con parametros
	 * 
	 * @param nombreBaraja
	 *            el nombre de la baraja
	 * @param cartas
	 *            array de elementos tipo carta
	 */
	public Baraja(String nombreBaraja, Carta[] cartas) {
		super();
		this.nombreBaraja = nombreBaraja;
		this.cartas = cartas;
	}

	/**
	 * Metodo de acceso de la propiedad nombreBaraja
	 * 
	 * @return devuelve el nombre de la baraja
	 */
	public String getNombreBaraja() {
		return nombreBaraja;
	}

	/**
	 * Metodo modificador de la propiedad nombreBaraja
	 * 
	 * @param nombreBaraja
	 *            representa el nombre de la baraja
	 */
	public void setNombreBaraja(String nombreBaraja) {
		this.nombreBaraja = nombreBaraja;
	}

	/**
	 * Metodo de acceso de la propiedad cartas
	 * 
	 * @return devuelve el array de cartas de la baraja
	 */
	public Carta[] getCartas() {
		return cartas;
	}

	/**
	 * Metodo modificador de la propiedad cartas
	 * 
	 * @param cartas
	 *            representa el array de cartas de la baraja
	 */
	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}

	/**
	 * Metodo toString para mostrar por pantalla
	 * 
	 * @return devuelve la baraja por pantalla
	 */
	public String toString() {
		String baraja = "";
		for (int i = 0; i < cartas.length; i++) {
			baraja += cartas[i] + " ";
		}
		return baraja;

	}

}
