//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 3, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica3.ejercicio3;

/**
 * Clase que representa una busqueda
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.03.2009
 */

public class Busqueda {

	/**
	 * Variable privada que representa el numero de datos
	 */
	private int nDatos;

	/**
	 * Variable privada que representa el numero a buscar
	 */
	private int numBuscado;

	/**
	 * Array privado que representa los datos de la busqueda
	 */
	private int[] datos;

	/**
	 * Genera una busqueda con un numero de datos predefinido
	 * 
	 * @param nDatos
	 *            el numero de datos
	 */
	public Busqueda(int nDatos) {
		super();
		this.setNDatos(nDatos);
	}

	/**
	 * Metodo modificador para la propiedad nDatos
	 * 
	 * @param nDatos
	 *            el nDatos de la busqueda
	 */
	public void setNDatos(int nDatos) {
		this.nDatos = nDatos;
	}

	/**
	 * Metodo de acceso para la propiedad nDatos
	 * 
	 * @return el nDatos de la busqueda
	 */
	public int getNDatos() {
		return nDatos;
	}

	/**
	 * Metodo modificador para la propiedad numBuscado
	 * 
	 * @param numBuscado
	 *            el numero a buscar
	 */
	public void setNumBuscado(int numBuscado) {
		this.numBuscado = numBuscado;
	}

	/**
	 * Metodo de acceso para la propiedad numBuscado
	 * 
	 * @return el numero a buscar
	 */
	public int getNumBuscado() {
		return numBuscado;
	}

	/**
	 * Metodo modificador para el array datos
	 * 
	 * @param datos
	 *            el array a poner
	 */
	public void setDatos(int[] datos) {
		this.datos = datos;
	}

	/**
	 * Metodo de acceso para el array datos
	 * 
	 * @return el array de datos
	 */
	public int[] getDatos() {
		return datos;
	}
}
