//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 8, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica8.ejercicio3;

import java.util.ArrayList;

/**
 * Clase que representa una banda de datos
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 23/05/2009
 */
public class BandaInt {

	/**
	 * Variable privada de tipo String que representa el nombre de la banda
	 */
	private String nombreBanda;

	/**
	 * Array doble privado de enteros que representa los datos por lineas y
	 * columnas
	 */
	private int[][] datos;

	/**
	 * Genera un objeto de tipo BandaInt con parametros
	 * 
	 * @param nombreBanda
	 *            el nombre de la banda
	 * @param datos
	 *            el array doble privado de la banda
	 */
	public BandaInt(String nombreBanda, int[][] datos) {
		this.nombreBanda = nombreBanda;
		this.datos = datos;
	}

	/**
	 * Genera un objeto de tipo BandaInt
	 * 
	 * @param nombreBanda
	 *            el nombre de la banda
	 * @param x
	 *            el numero de lineas
	 * @param y
	 *            el numero de pixeles(columnas)
	 */
	public BandaInt(String nombreBanda, int x, int y) {
		this.nombreBanda = nombreBanda;
		this.datos = new int[x][y];
	}

	/**
	 * Metodo de acceso para la propiedad nombreBanda
	 * 
	 * @return el nombre de la Banda
	 */
	public String getNombreBanda() {
		return nombreBanda;
	}

	/**
	 * Metodo modificador para la propiedad nombreBanda
	 * 
	 * @param nombreBanda
	 *            el nombreBanda a poner
	 */
	public void setNombreBanda(String nombreBanda) {
		this.nombreBanda = nombreBanda;
	}

	/**
	 * Metodo de acceso para el array datos
	 * 
	 * @return el array de datos
	 */
	public int[][] getDatos() {
		return datos;
	}

	/**
	 * Metodo modificador para la propiedad datos
	 * 
	 * @param datos
	 *            el array de datos a poner
	 */
	public void setDatos(int[][] datos) {
		this.datos = datos;
	}

	/**
	 * Metodo de acceso para una posicion especifica del array de datos
	 * 
	 * @param x
	 *            la fila x
	 * @param y
	 *            la columna y
	 * @return el dato de la posicion x,y del array de datos
	 */
	public int getDatoXY(int x, int y) {
		return datos[x][y];
	}

	/**
	 * Metodo modificador de una posicion del array de datos
	 * 
	 * @param dato
	 *            el dato a poner
	 * @param x
	 *            la fila x
	 * @param y
	 *            la columna y
	 */
	public void setDatoXY(int dato, int x, int y) {
		datos[x][y] = dato;
	}

	/**
	 * Sobreescribe el toString de object
	 * 
	 * @return el nombre, numero de filas y de columnas de la BandaInt
	 */
	public String toString() {
		return nombreBanda + " nFilas " + datos.length + "  nColumnas "
				+ datos[0].length;
	}
}
