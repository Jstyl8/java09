//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 2, Ejercicio 6
// ASIGNATURA : Metodologia de la Programación
//

package com.mio.meto.Residencia2;

/**
 * Clase que representa una habitacion
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09.03.2009
 */
public class Habitacion {
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
