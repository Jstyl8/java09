//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 8, Ejercicio 4
// ASIGNATURA : Metodologia de la Programación
//

package com.mp.practica8.ejercicio4;

import java.io.Serializable;

/**
 * Clase que representa una habitacion e implementa la interfaz Serializable
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.2 09.03.2009
 */
public class Habitacion implements Serializable{
	/**
	 * Variable privada que representa el numero de la habitacion
	 */
	private String numero;

	/**
	 * Genera una habitacion con parametros
	 * 
	 * @param numero
	 *            de la habitacion
	 */
	public Habitacion(String numero) {
		this.setNumero(numero);
	}

	/**
	 * Metodo modificador para la propiedad numero
	 * 
	 * @param numero
	 *            representa el numero de habitacion
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Metodo de acceso para la propiedad numero
	 * 
	 * @return devuelve el numero de la habitacion
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Sobreescribe el equals de object
	 * 
	 * @param obj
	 *            a comparar
	 * @return devuelve false si obj no es una instancia de Habitacion o son
	 *         distintas y true si son iguales
	 */
	public boolean equals(Object obj) {
		return obj instanceof Habitacion ? equals((Habitacion) obj) : false;
	}

	/**
	 * Metodo que comprueba si 2 habitaciones son iguales
	 * 
	 * @param habitacion
	 *            a comparar
	 * @return devuelve false si no son iguales y true si son iguales
	 */
	public boolean equals(Habitacion habitacion) {
		if (this == habitacion)
			return true;
		if (habitacion == null)
			return false;
		if (this.getNumero().equals(habitacion.getNumero())) {
			return true;
		}
		return false;
	}

}
