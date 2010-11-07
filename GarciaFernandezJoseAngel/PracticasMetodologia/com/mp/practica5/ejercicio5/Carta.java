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
 * Clase que representa una carta e implementa la interfaz Comparable
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.04.2009
 */
public class Carta implements Comparable {

	/**
	 * Variable privada que representa el palo de la carta
	 */
	private String palo;
	/**
	 * Variable privada que representa el numero de la carta
	 */
	private int numero;
	/**
	 * Variable privada que representa el valor de la carta
	 */
	private int valor;

	/**
	 * Genera una carta con parametros de palo numero y valor
	 * 
	 * @param palo
	 *            representa el palo de la carta
	 * @param numero
	 *            representa el numero de la carta
	 * @param valor
	 *            representa el valor de la carta
	 */
	public Carta(String palo, int numero, int valor) {
		super();
		this.palo = palo;
		this.numero = numero;
		this.valor = valor;
	}

	/**
	 * Genera una carta con parametros de palo y numero
	 * 
	 * @param palo
	 *            representa el palo de la carta
	 * @param numero
	 *            representa el numero de la carta
	 */
	public Carta(String palo, int numero) {
		super();
		this.palo = palo;
		this.numero = numero;
	}

	/**
	 * Metodo de acceso de la propiedad palo
	 * 
	 * @return devuelve el palo de la carta
	 */
	public String getPalo() {
		return palo;
	}

	/**
	 * Metodo modificador de la propiedad palo
	 * 
	 * @param palo
	 *            representa el palo de la carta
	 */
	public void setPalo(String palo) {
		this.palo = palo;
	}

	/**
	 * Metodo de acceso de la propiedad numero
	 * 
	 * @return devuelve el numero de la carta
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Metodo modificador de la propiedad numero
	 * 
	 * @param numero
	 *            representa el numero de la carta
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Metodo de acceso de la propiedad valor
	 * 
	 * @return devuelve el valor de la carta
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Metodo modificador de la propiedad valor
	 * 
	 * @param valor
	 *            representa el valor de la carta
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * Metodo que comprueba si 2 cartas son iguales
	 * 
	 * @param o
	 *            a comparar
	 * @return devuelve false si no son iguales y true si son iguales
	 */
	public boolean equals(Object o) {

		if (!(o instanceof Carta)) {
			return false;
		}

		Carta carta = (Carta) o;
		if ((this.numero == carta.numero) && (this.palo == carta.palo)) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo que comprueba el orden de 2 cartas
	 * 
	 * @param o
	 *            a comparar
	 * @return devuelve -1 si this es mayor, 0 si son iguales y 1 si o es mayor
	 */
	public int compareTo(Object o) {

		Carta carta = (Carta) o;
		String[] palos = { "O", "C", "E", "B" };

		if (this.equals(carta)) {
			return 0;
		}
		int posThis = 0;
		for (int i = 0; i < palos.length; i++) {
			if (this.palo.equals(palos[i]))
				posThis = i;
		}
		int posCarta = 0;
		for (int i = 0; i < palos.length; i++) {
			if (carta.palo.equals(palos[i]))
				posCarta = i;
		}
		if (posThis < posCarta) {
			return -1;
		} else if (posThis > posCarta) {
			return 1;
		} else {
			if (this.numero < carta.numero) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	/**
	 * Metodo toString para mostrar por pantalla
	 * 
	 * @return devuelve la carta por pantalla mostrando el palo y el numero
	 */
	public String toString() {
		return palo + numero;
	}

}
