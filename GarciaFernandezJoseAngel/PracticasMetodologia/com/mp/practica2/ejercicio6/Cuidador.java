//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 2, Ejercicio 6
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica2.ejercicio6;

/**
 * Clase que representa un cuidador
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09.03.2009
 */
public class Cuidador {

	/**
	 * Variable privada que representa el nombre del cuidador
	 */
	private String nombre;

	/**
	 * Variable privada que representa el DNI del cuidador
	 */
	private String DNI;

	/**
	 * Genera un Cuidador con parametros
	 * 
	 * @param nombre
	 * @param dni
	 */
	public Cuidador(String nombre, String dni) {
		this.setNombre(nombre);
		setDni(dni);
	}

	/**
	 * Metodo modificador para la propiedad nombre
	 * 
	 * @param nombre
	 *            representa el nombre del cuidador
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo de acceso para la propiedad nombre
	 * 
	 * @return devuelve el nombre del cuidador
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo modificador para la propiedad DNI
	 * 
	 * @param dNI
	 *            representa el DNI del cuidador
	 */
	public void setDni(String dNI) {
		DNI = dNI;
	}

	/**
	 * Metodo de acceso para la propiedad DNI
	 * 
	 * @return devuelve el DNI del cuidador
	 */
	public String getDni() {
		return DNI;
	}

	/**
	 * Metodo que comprueba si 2 cuidadores son iguales
	 * 
	 * @param cuidador
	 *            a comparar
	 * @return devuelve false si no son iguales y true si son iguales
	 */
	public boolean equals(Cuidador cuidador) {
		if (this == cuidador)
			return true;
		if (cuidador == null)
			return false;
		if ((this.getDni().equals(cuidador.getDni()))) {
			return true;
		}
		return false;
	}
}
