//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 5, Documentacion de ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//

package com.mp.practica5.ejercicio1;

import java.io.*;

/**
 * Clase que lee un numero de figuras determinado por el usuario y las muestra
 * ordenandolas de menor a mayor area.
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 20.04.2009
 */
public class PruebaFigura {
	/**
	 * Referencia a un objeto de tipo BufferedReader para usarlo en la lectura
	 * de datos
	 */
	private static BufferedReader in;

	/**
	 * Ordena un vector de figuras de menor a mayor area
	 * 
	 * @param a
	 *            Vector de objetos de clases derivadas de tipo figura
	 */

	public static void ordenacionPorInsercion(Figura[] a) {
		for (int p = 1; p < a.length; p++) {
			int j = p;
			Figura tmp = a[p];

			for (; j > 0 && (tmp.compareTo(a[j - 1]) < 0); j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	/**
	 * Metodo que lee las figuras que el usuario introduzca
	 * 
	 * @return Devolvera objetos de tipo circulo, cuadrado o rectangulo en
	 *         funcion de la eleccion del usuario
	 * @exception IOException
	 *                cuando se produzca una lectura de teclado erronea
	 *                devolvera un circulo de radio 0
	 */
	private static Figura leerFigura() {
		double rad;
		double largo;
		double ancho;
		String unaLinea;

		try {
			System.out.println("Introduzca el tipo de figura:");
			do {
				unaLinea = in.readLine();
			} while (unaLinea.length() == 0);

			switch (unaLinea.charAt(0)) {
			case 'c':
				System.out.println("Introduzca el radio: ");
				rad = Double.valueOf(in.readLine()).doubleValue();
				return new Circulo(rad);
			case 's':
				System.out.println("Introduzca el lado: ");
				largo = Double.valueOf(in.readLine()).doubleValue();
				return new Cuadrado(largo);
			case 'r':
				System.out.println("Introduzca el largo y el ancho "
						+ "en líneas separadas: ");
				largo = Double.valueOf(in.readLine()).doubleValue();
				ancho = Double.valueOf(in.readLine()).doubleValue();
				return new Rectangulo(largo, ancho);
			default:
				System.err.println("Escriba c, r, or s");
				return new Circulo(0);
			}
		} catch (IOException e) {
			System.err.println(e);
			return new Circulo(0);
		}
	}

	/**
	 * Metodo principal para la prueba de tiempos
	 * 
	 * @param args
	 *            parametros del main
	 */
	public static void main(String[] args) {
		try {
			// Lectura del número de figuras
			System.out.println("Introduzca # de figuras: ");
			in = new BufferedReader(new InputStreamReader(System.in));
			int numFiguras = Integer.parseInt(in.readLine());

			// Lectura de las figuras
			Figura[] array = new Figura[numFiguras];
			for (int i = 0; i < numFiguras; i++)
				array[i] = leerFigura();

			// Ordenación y salida
			ordenacionPorInsercion(array);
			System.out.println("Ordenados por area:");
			for (int i = 0; i < numFiguras; i++)
				System.out.println(array[i]);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
