//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 3, Ejercicio 1
// ASIGNATURA : Metodologia de la Programación
//

package com.mp.practica3.ejercicio1;

/**
 * Clase que contiene los distintos metodos para resolver un polinomio
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.03.2009
 */
public class SolucionesPolinomio {

	/**
	 * Metodo de Orden O(N) para calcular la potencia
	 * 
	 * @param polinomioProblema
	 *            representa el polinomio a tratar
	 * @return devuelve el resultado de evaluar el polinomio
	 */
	public static int polinomioLineal(Polinomio polinomioProblema) {
		int resultado = 0;
		for (int i = polinomioProblema.getGrado(); i >= 1; i--) {
			// suma el coeficiente
			resultado += polinomioProblema.getCoeficientes()[i];
			// multiplica por la variable
			resultado *= polinomioProblema.getX();
		}
		// suma el termino independiente
		return (int) (resultado + polinomioProblema.getCoeficientes()[0]);
	}

	/**
	 * Metodo de orden O(N^2)para calcular la potencia
	 * 
	 * @param polinomioProblema
	 *            representa el polinomio a tratar
	 * @return devuelve el resultado de evaluar el polinomio
	 */
	public static int polinomioCuadratico(Polinomio polinomioProblema) {
		int resultado = 0;
		for (int i = 0; i <= polinomioProblema.getGrado(); i++) {
			resultado = (int) (resultado + polinomioProblema.getCoeficientes()[i]
					* Math.pow(polinomioProblema.getX(), i));
		}
		return resultado;
	}
}
