package com.mio.meto.DYV;

/**
 * @author Angel Nieto Lopez
 * @category Clase que declara SolucionSubsecuencia implementando Solucion
 */
public class SolucionSubsecuencia implements Solucion {

	/**
	 * Vector privado que almacena la subsecuencia que son elementos de tipo
	 * entero
	 */
	private int[] vector;

	/**
	 * Variable privada de tipo entero que almacena la posicion derecha de
	 * comienzo de la subsecuencia
	 */
	private int derecha;

	/**
	 * Variable privada de tipo entero que almacena la posicion izquierda de
	 * comienzo de la subsecuencia
	 */
	private int izquierda;

	/**
	 * Variable privada de tipo entero que almacena de la suma maxima
	 */
	private int sumaMax;

	/**
	 * Metodo constructor que crea objetos de tipo SolucionSubsecuencia en
	 * funcion de un subsecuencia de numeros enteros,su posicion inicial y su
	 * posicion final.
	 *
	 * @param vector
	 *            Vector de la subsecuencia que almacena valores de tipo entero
	 * @param izquierda
	 *            Parametro de tipo entero que almacena la posicion inicial de
	 *            la subsecuencia
	 * @param derecha
	 *            Parametro de tipo entero que almacena la posicion final de la
	 *            subsecuencia
	 */
	public SolucionSubsecuencia(int[] vector, int izquierda, int derecha) {
		this.vector = vector;
		this.izquierda = izquierda;
		this.derecha = derecha;
	}

	/**
	 * Metodo que devuelve la posicion final de la subsecuencia
	 *
	 * @return Valor de tipo entero que es la posicion final de la subsecuencia
	 */
	public int getDer() {
		return derecha;
	}

	/**
	 * Metodo que actualiza el valor de la posicion final de la subsecuencia
	 *
	 * @param derecha
	 *            Parametro de tipo entero que almacena el nuevo valor de la
	 *            posicion final de la subsecuancia
	 */
	public void setDer(int derecha) {
		this.derecha = derecha;
	}

	/**
	 * Metodo que devuelve la posicion inicial de la subsecuencia
	 *
	 * @return Valor de tipo entero que es la posicion inicial de la
	 *         subsecuencia
	 */
	public int getIzq() {
		return izquierda;
	}

	/**
	 * Metodo que actualiza el valor de la posicion inicial de la subsecuencia
	 *
	 * @param izquierda
	 *            Parametro de tipo entero que almacena el nuevo valor de la
	 *            posicion inicial de la subsecuancia
	 */
	public void setIzq(int izquierda) {
		this.izquierda = izquierda;
	}

	/**
	 * Metodo que devuelve la suma maxima de la subsecuencia
	 *
	 * @return Valor de tipo entero que es la suma maxima de la subsecuencia
	 */
	public int getSumaMax() {
		return sumaMax;
	}

	/**
	 * Metodo que actualiza el valor de la suma maxima de la subsecuencia
	 *
	 * @param sumaMax
	 *            Parametro de tipo entero que almacena el nuevo valor de la
	 *            suma maxima de la subsecuancia
	 */
	public void setSumaMax(int sumaMax) {
		this.sumaMax = sumaMax;
	}

	/**
	 * Metodo que devuelve el vector de la subsecuencia
	 *
	 * @return Vector que almacena elementos de tipo entero de la subsecuencia
	 */
	public int[] getVector() {
		return vector;
	}

	/**
	 * Metodo que actualiza el valor del vector de la subsecuencia
	 *
	 * @param vector
	 *            Vector que almacena elementos de tipo entero el nuevo valor
	 *            del vector de la subsecuancia
	 */
	public void setVector(int[] vector) {
		this.vector = vector;
	}

	/**
	 * Metodo que devuelve un elemento del vector de la subsecuencia
	 *
	 * @param posicion
	 *            Parametro de tipo entero que almacena la posicion del vector
	 *            de la queremos obtener su valor
	 * @return Valor del elemento del vector que es de tipo entero
	 */
	public int getElementoVector(int posicion) {
		return vector[posicion];
	}
}
