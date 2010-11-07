//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 3, Ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//

package com.mio.meto.polinomio;

/**
 * Clase que representa un polinomio
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.03.2008
 */
public class Polinomio {
	/**
	 * Variable privada que representa el grado del polinomio
	 */
	private int grado;

	/**
	 * Variable privada que representa la variable
	 */
	private double x;

	/**
	 * Array privado que representa los coeficientes del polinomio
	 */
	private double[] coeficientes;

	/**
	 * Genera un Polinomio con parametros
	 * 
	 * @param grado el grado del polinomio
	 * @param x la variable
	 */
	public Polinomio(int grado, double x) {
		this.grado = grado;
		this.x = x;
	}

	/**
	 * Metodo modificador para la propiedad grado
	 * 
	 * @param grado
	 *            el grado a poner
	 */
	public void setGrado(int grado) {
		this.grado = grado;
	}

	/**
	 * Metodo de acceso para la propiedad grado
	 * 
	 * @return el grado del polinomio
	 */
	public int getGrado() {
		return grado;
	}

	/**
	 * Metodo modificador para la propiedad x
	 * 
	 * @param x
	 *            la variable a poner
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Metodo de acceso para la propiedad x
	 * 
	 * @return la variable del polinomio
	 */
	public double getX() {
		return x;
	}

	/**
	 * Metodo modificador para el array coeficientes
	 * 
	 * @param coeficientes
	 *            the coeficientes to set
	 */
	public void setCoeficientes(double[] coeficientes) {
		this.coeficientes = coeficientes;
	}

	/**
	 * Metodo de acceso para el array coeficientes
	 * 
	 * @return the coeficientes
	 */
	public double[] getCoeficientes() {
		return coeficientes;
	}

}
