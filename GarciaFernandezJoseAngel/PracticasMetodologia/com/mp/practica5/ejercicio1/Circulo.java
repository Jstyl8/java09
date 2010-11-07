//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Documentacion de ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica5.ejercicio1;

/**
 * Clase que representa un circulo y extiende de la clase Figura
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 20.04.2009
 */
public class Circulo extends Figura {
	/**
	 * Genera un circulo con un radio y nombre haciendo uso del constructor de
	 * su superclase
	 * 
	 * @param r
	 *            representa el radio del circulo
	 */
	public Circulo(double r) {
		super("Circulo");
		radio = r;
	}

	/**
	 * Implementa el metodo area de su superclase
	 * 
	 * @return Devuelve el area del circulo
	 */
	public double area() {
		return PI * radio * radio;
	}

	/**
	 * variable privada statica y final que representa el numero PI
	 */
	private static final double PI = 3.14159265358979323;
	/**
	 * variable privada que almacena el valor del radio
	 */
	private double radio;

}