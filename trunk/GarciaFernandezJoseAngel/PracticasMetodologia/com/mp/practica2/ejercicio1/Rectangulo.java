//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 2, Documentacion de ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica2.ejercicio1;

/**
 * Clase que representa un rectangulo y deriva de la clase Figura
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 07.03.2009
 */
public class Rectangulo extends Figura {
	/**
	 * Genera un rectangulo con una base y una altura y un nombre haciendo uso
	 * del constructor de su superclase
	 * 
	 * @param largo
	 *            representa la base del rectangulo
	 * @param ancho double representa la altura del rectangulo
	 */
	public Rectangulo(double largo, double ancho) {
		super("Rectangulo");
		base = largo;
		alt = ancho;
	}

	/**
	 * Implementa el metodo area de su superclase
	 * 
	 * @return Devuelve el area del rectangulo
	 */
	public double area() {
		return base * alt;
	}

	/**
	 * variable privada que almacena el valor de la base
	 */
	private double base;
	/**
	 * variable privada que almacena el valor de la altura
	 */
	private double alt;
}