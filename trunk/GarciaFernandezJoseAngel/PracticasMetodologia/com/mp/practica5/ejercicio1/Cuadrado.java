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
 * Clase que representa un cuadrado y extiende de la clase Rectangulo
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 20.04.2009
 */
public class Cuadrado extends Rectangulo {

	/**
	 * Genera un cuadrado haciendo uso del constructor de su superclase
	 * 
	 * @param lado
	 *            representa el lado del cuadrado
	 */
	public Cuadrado(double lado) {
		super(lado, lado);
		setNombre("Cuadrado");
	}
}