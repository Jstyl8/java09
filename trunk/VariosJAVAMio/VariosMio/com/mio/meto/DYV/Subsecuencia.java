package com.mio.meto.DYV;

import com.mio.utilidades.*;

/**
 * @author Angel Nieto
 * @category Clase que se encarga de crear objetos de tipo Subsecuencia
 */
public class Subsecuencia {
	/**
	 * Variable privada global de tipo entero que almacena el numero de datos
	 * que hay en el vector valores de la subsecuencia
	 */
	private int nElementos;
	/**
	 * Variable privada global de tipo entero que almacena el rango de la
	 * subsecuencia
	 */
	private int rango;
	/**
	 * Vector privado global que almacena los valores de tipo entero de la
	 * secuencia cuya subsecuencia maxima queremos calcular
	 */
	private int[] subsecuencia;

	/**
	 * Metodo constructor que se encarga de crear objetos de tipo subsecuencia
	 * en funcion de un vector de valores que le pasamos
	 *
	 * @param valores
	 *            Vector que almacena la subsecuencia de valores de tipo entero
	 */
	public Subsecuencia(int[] valores) {
		this.subsecuencia = valores;
		nElementos = valores.length;
	}

	/**
	 * Metodo constructor que se encarga de crear objetos de tipo subsecuencia
	 * en funcion del numero de valores y del rango de la subsecuencia
	 *
	 * @param nElementos
	 *            Parametro de tipo entero que almacena el numero de elementos
	 *            de la secuencia
	 * @param rango
	 *            Parametro de tipo entero que almacena el rango de valores en
	 *            el que se encuentra la subsecuencia
	 */
	public Subsecuencia(int nElementos, int rango) {
		this.nElementos = nElementos;
		this.rango = rango;
		subsecuencia = new int[nElementos];
		generarValores();
	}

	/**
	 * Metodo que se encarga de generar de forma aleatoria los elementos del
	 * vector valores de la secuencia los cuales se encuentran dentro de un
	 * rango
	 */
	private void generarValores() {
		NumerosAleatorios aleatorios = new NumerosAleatorios();
		for (int i = 0; i < nElementos; i++) {
			subsecuencia[i] = aleatorios.randomInt(-rango, rango);
		}
	}

	/**
	 * Metodo que se encarga de devolver el numero de elementos del vector de
	 * valores de la subsecuencia
	 *
	 * @return Valor de tipo entero que almacena el numero de datos del vector
	 *         valores
	 */
	public int getNumeroElementos() {
		return nElementos;
	}

	/**
	 * Metodo que se encarga de devolver el rango del vector valores de la
	 * subsecuencia
	 *
	 * @return Valor de tipo entero que almacena el rango en el que se
	 *         encuentran los datos del vector valores
	 */
	public int getRango() {
		return rango;
	}
	/**
	 * Metodo que se encarga de modificar el valor del rango de la subsecuencia
	 *
	 * @param rango
	 *            Parametro de tipo entero que almacena el nuevo valor del rango
	 *            de la subsecuencia
	 */
	public void setRango(int rango) {
		this.rango = rango;
	}
	/**
	 * Metodo que se encarga de devolver el vector de valores de la subsecuencia
	 *
	 * @return Vector de valores de la subsecuencia que almacena valores de tipo
	 *         entero
	 */
	public int[] getSubsecuencia() {
		return subsecuencia;
	}
	/**
	 * Metodo que se encarga de modificar el valor del vector de valores
	 * de la subsecuencia
	 *
	 * @param valores
	 *            Vector que almacena los nuevos valores de la subsecuencia de
	 *            tipo entero
	 */
	public void setSubsecuencia(int[] valores) {
		this.subsecuencia = valores;
	}
	/**
	 * Metodo que se encarga de devover un dato del vector de valores
	 *
	 * @param posicion
	 *            Parametro de tipo entero que almacena la posicion del vector
	 *            cuyo valor queremos conseguir
	 * @return Valor de tipo entero del vector valores en la posicion que
	 *         le pasamos
	 */
	public int getElementoSubsecuencia(int posicion) {
		return subsecuencia[posicion];
	}
}
