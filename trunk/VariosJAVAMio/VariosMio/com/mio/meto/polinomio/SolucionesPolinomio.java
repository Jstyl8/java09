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
 * Clase que contiene los distintos metodos para resolver un polinomio
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 21.03.2008
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

	/*
	 *
	 * Metodo de orden O(NlogN)para calcular la potencia
	 * 
	 * @param polinomioProblema
	 *            representa el polinomio a tratar
	 * @return devuelve el resultado de evaluar el polinomio
	 *
	public static int polinomioNLogaritmico(Polinomio polinomioProblema) {
		int resultado = 0;
		for (int i = 0; i <= polinomioProblema.getGrado(); i++) {
			resultado = (int) (resultado + polinomioProblema.getCoeficientes()[i]
					* potencia(polinomioProblema.getX(), i));

		}
		return resultado;
	}
	

	/**
	 * Metodo privado de orden O(logN) para usarlo en polinomioNLogaritmico
	 * 
	 * @param x
	 *            representa la variable
	 * @param e
	 *            representa el termino exponente
	 * @return el resultado de la potencia
	 *
	private static double potencia(double x, int e) {
		if (e > 0) {
			return x * potencia(x, e - 1);
		} else {
			return 1;
		}

	}*/
	
	/**
	 * Metodo de orden O(NlogN)para calcular la potencia
	 * 
	 * @param polinomioProblema
	 *            representa el polinomio a tratar
	 * @return devuelve el resultado de evaluar el polinomio
	 */
	public static double polinomioNLogaritmico(Polinomio polinomio){
        return calcular(polinomio, polinomio.getGrado());
 }
	/**
	 * Metodo privado de orden O(logN) para usarlo en polinomioNLogaritmico
	 * 
	 * @param polinomio
	 *            representa el polinomio
	 * @param longitud
	 *            representa el termino exponente
	 * @return el resultado de la potencia
	 */
	 private static double calcular(Polinomio polinomio, int longitud){
	     if(longitud == 0){
	         return polinomio.getCoeficientes()[polinomio.getCoeficientes().length-1];
	     } else {
	         return polinomio.getCoeficientes()[longitud] * Math.pow(polinomio.getX(),longitud) + calcular(polinomio, longitud - 1); 
	     }
	 }
}
