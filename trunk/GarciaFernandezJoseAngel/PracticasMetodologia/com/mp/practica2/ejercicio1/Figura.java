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
 * Clase que representa una figura cualquiera
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 07.03.2009
 */
public abstract class Figura {
	/**
	 * Metodo para calcular el area de una figura
	 * 
	 * @return Devuelve el area de la figura
	 */
	abstract public double area();

	/**
	 * Metodo constructor usado para clases derivadas de Figura
	 * 
	 * @param nombreFigura
	 *            representa nombre de la figura
	 */
	public Figura(String nombreFigura) {
		nombre = nombreFigura;
	}
	
	/**
	 * Metodo usado para acceder a la propiedad nombre de Figura
	 * 
	 * @return Devuelve el nombre de la figura
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo usado para modificar nombre
	 * 
	 * @param nombreFigura Representa el nombre de la figura
	 */
	public void setNombre(String nombreFigura) {
		nombre=nombreFigura;
	}
	/**
	 * Calcula la figura con area menor
	 * 
	 * @param lder
	 *            referencia a una figura
	 * @return Devuelve un valor booleano en funcion de que figura tenga mayor
	 *         area
	 */
	final public boolean menorQue(Figura lder) {
		return area() < lder.area();
	}

	/**
	 * Sobrecarga el metodo toString
	 * 
	 * @return Devuelve una cadena con el nombre y el area de la figura
	 */
	final public String toString() {
		return nombre + " con area " + area();
	}

	/**
	 * variable privada que guarda el nombre de la figura
	 */
	private String nombre;
}