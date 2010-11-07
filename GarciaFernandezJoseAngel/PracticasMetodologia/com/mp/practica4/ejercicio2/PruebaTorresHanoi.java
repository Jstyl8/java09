//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 4, Ejercicio 2
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica4.ejercicio2;

/**
 * Clase principal para probar la Clase TorresHanoi
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 02.04.2009
 */
public class PruebaTorresHanoi {

	/**
	 * Metodo principal para la prueba de funcionamiento
	 * 
	 * @param args
	 *            parametros del main
	 */
	public static void main(String[] args) {
		TorresHanoi juego = new TorresHanoi(4);
		juego.solucionRec(4, 1, 3, 2);

	}

}
