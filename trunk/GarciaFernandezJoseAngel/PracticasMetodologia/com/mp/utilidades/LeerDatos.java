//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 1, Ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.utilidades;

import java.io.*;

/**
 * Clase que contiene metodos para leer desde teclado
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 07.03.2009
 */
public class LeerDatos {

	/**
	 * Objeto de la clase BufferedReader para la lectura de teclado
	 */
	private BufferedReader lecturaTeclado;

	/**
	 * Constructor de un objeto LeerDatos
	 */
	public LeerDatos() {
		lecturaTeclado = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Constructor de un objeto LeerDatos con un BufferedReader externo
	 * 
	 * @param lecturaTeclado
	 *            el BufferedReader externo
	 */
	public LeerDatos(BufferedReader lecturaTeclado) {
		super();
		this.lecturaTeclado = lecturaTeclado;
	}

	/**
	 * Metodo para leer strings desde teclado
	 * 
	 * @return la cadena leida
	 * @throws IOException
	 */
	public String leerCadena() throws IOException {
		String cadenaleida;

		cadenaleida = lecturaTeclado.readLine();

		return cadenaleida;
	}

	/**
	 * Metodo para leer caracteres desde teclado
	 * 
	 * @return el caracter leido
	 * @throws IOException
	 */
	public char leerCaracter() throws IOException {
		char caracter;
		String cadenaLeida;

		cadenaLeida = lecturaTeclado.readLine();
		caracter = cadenaLeida.charAt(0);

		return caracter;
	}

	/**
	 * Metodo para leer doubles desde teclado
	 * 
	 * @return el numero double leido
	 * @throws IOException
	 */
	public double leerDouble() throws IOException {
		double numero;
		String cadenaLeida;

		cadenaLeida = lecturaTeclado.readLine();
		numero = Double.parseDouble(cadenaLeida);

		return numero;
	}

	/**
	 * Metodo para leer enteros desde teclado
	 * 
	 * @return el numero entero leido
	 * @throws IOException
	 */
	public int leerEntero() throws IOException {
		int numero;
		String cadenaLeida;

		cadenaLeida = lecturaTeclado.readLine();
		numero = Integer.parseInt(cadenaLeida);

		return numero;
	}

	/**
	 * Metodo para leer floats desde teclado
	 * 
	 * @return el numero float leido
	 * @throws IOException
	 */
	public float leerFloat() throws IOException {
		float numero;
		String cadenaLeida;

		cadenaLeida = lecturaTeclado.readLine();
		numero = Float.parseFloat(cadenaLeida);

		return numero;
	}
}
