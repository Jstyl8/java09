//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 6, Documentacion de ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//

package com.mp.practica5.ejercicio1;

/**
 * Clase que representa una figura cualquiera e implementa la interfaz
 * Comparable
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 20.03.2009
 */
public abstract class Figura implements Comparable<Figura> {
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
	 * @param nombreFigura
	 *            Representa el nombre de la figura
	 */
	public void setNombre(String nombreFigura) {
		nombre = nombreFigura;
	}

	/**
	 * Metodo que calculara la figura de menor area
	 * 
	 * @param lder
	 *            referencia a una figura
	 * @return devolvera -1 si lder tiene mayor area, 0 si son iguales y 1 si
	 *         tiene menor area
	 */
	public int compareTo(Figura lder) {
		if (this.area() > lder.area()) {
			return 1;
		} else if (this.area() < lder.area()) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * Sobrecarga del metodo toString
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