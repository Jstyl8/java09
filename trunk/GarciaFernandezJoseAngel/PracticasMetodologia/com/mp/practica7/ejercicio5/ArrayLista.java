//
// Universidad de Almer�a
// Ingenier�a T�cnica de Inform�tica de Sistemas
// Fuente Java seg�n Plantilla
//
// PRACTICA : Practica 7, Ejercicio 5
// ASIGNATURA : Metodologia de la Programaci�n
//
package com.mp.practica7.ejercicio5;

import com.mp.practica7.ejercicio5.IteradorFueraLimitesException;

/**
 * Clase que representa una lista implementada mediante un array
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 09/05/2009
 */
public class ArrayLista extends ListaAbstracta {

	/**
	 * Variable privada que representa la capacidad inicial por defecto de la
	 * lista
	 */
	private static final int CAPACIDAD_INICIAL_POR_DEFECTO = 10;

	/**
	 * Variable privada que representa la capacidad inicial de la lista
	 */
	private int capacidadInicial;

	/**
	 * Array privado de objects
	 */
	protected Object[] array;

	/**
	 * Variable privada que representa el tama�o de la lista
	 */
	private int tama�o;

	/**
	 * Genera un objeto de tipo ArrayLista con la capacidad por defecto
	 */
	public ArrayLista() {
		this(CAPACIDAD_INICIAL_POR_DEFECTO);
	}

	/**
	 * Genera un objeto de tipo ArrayLista con una capacidad dada
	 * 
	 * @param capacidadInicial
	 *            a poner
	 */
	public ArrayLista(int capacidadInicial) {
		this(new Object[capacidadInicial]);
	}

	/**
	 * Genera un objeto de tipo ArrayLista usando un array externo
	 * 
	 * @param array
	 *            a poner
	 */
	public ArrayLista(Object[] array) {
		this.array = array;
		tama�o = 0;
		capacidadInicial = array.length;
	}

	/**
	 * Inserta un valor en la lista en la posicion dada. El tama�o de la lista
	 * se incrementa en uno.
	 * 
	 * @param indice
	 *            La posici�n (0, 1, 2...) en la que debe insertarse.
	 * @param valor
	 *            El valor a a�adir.
	 * @throws IndexOutOfBoundsException
	 *             si la posicion especificada cae fuera del rango.
	 * 
	 */
	public void insertar(int indice, Object valor)
			throws IndexOutOfBoundsException {

		
		if (indice < 0 || indice > tama�o)
			throw new IteradorFueraLimitesException();

		asegurarCapacidad(tama�o + 1);
		Object[] aux = array.clone();
		for (int i = indice; i < tama�o; i++) {
			aux[i + 1] = array[i];
		}
		aux[indice] = valor;
		array = aux;
		tama�o++;
	}

	/**
	 * A�ade un valor al final de la lista. El tama�o de la lista se incrementa
	 * en uno.
	 * 
	 * @param valor
	 *            del El valor que se a�ade.
	 */
	public void a�adir(Object valor) {

		asegurarCapacidad(tama�o + 1);
		array[tama�o++] = valor;

	}

	/**
	 * Elimina el valor de una posici�n dada en la lista. El tama�o se
	 * decrementa en uno.
	 * 
	 * @param indice
	 *            La posici�n (0, 1, 2...) en la cual se va a eliminar.
	 * @return El valor contenido en la posici�n especificada.
	 * @throws IteradorFueraLimitesException
	 *             si la posici�n esta fuera del rango.
	 * 
	 */
	public Object eliminar(int indice) throws IteradorFueraLimitesException {

		if (estaFueraLimites(indice))
			throw new IteradorFueraLimitesException();
		Object antiguo = array[indice];
		tama�o--;
		for (int i = indice; i < tama�o; i++) {
			array[i] = array[i + 1];
		}
		array[tama�o] = null;
		return antiguo;
	}

	/**
	 * Elimina la primera ocurrencia de un valor especificado. El tama�o de la
	 * lista decrece en uno si es encontrado
	 * 
	 * 
	 * @param valor
	 *            El valor a eliminar.
	 * @return <code>true</code> si es eliminado; en otro caso
	 *         <code>false</code> si no es encontrado.
	 */
	public boolean eliminar(Object valor) {
		boolean encontrado = false;
		for (int i = 0; i < tama�o && !encontrado; i++) {
			if (array[i].equals(valor)) {
				encontrado = true;
				tama�o--;
				for (int j = i; j < tama�o; j++) {
					array[j] = array[j + 1];
				}
				array[tama�o] = null;
			}
		}
		return encontrado;
	}

	/**
	 * Elimina todos los elementos de la lista. El tama�o de la lista se
	 * reposiciona en 0.
	 */
	public void vaciar() {
		for (int i = 0; i < tama�o; i++) {
			array[i] = null;
		}
		tama�o = 0;

	}

	/**
	 * Coloca el valor en una posicion determinada en la lista.
	 * 
	 * @param indice
	 *            La posici�n (0, 1, 2...) de la que se debe obtener el valor.
	 * @param valor
	 *            El valor a colocar en la posici�n especificada.
	 * @return El valor original de la posici�n especificada.
	 * @throws IndexOutOfBoundsException
	 *             si la posicion especificada cae fuera del rango.
	 * 
	 */
	public Object set(int indice, Object valor)
			throws IndexOutOfBoundsException {
		if (estaFueraLimites(indice))
			throw new IteradorFueraLimitesException();

		Object antiguo = array[indice];
		array[indice] = valor;
		return antiguo;

	}

	/**
	 * Obtiene el valor de una posici�n especificada de la lista.
	 * 
	 * @param indice
	 *            La posici�n (0, 1, 2...) de la que se debe obtener el valor.
	 * @return El valor de la posici�n especificada.
	 * @throws IndexOutOfBoundsException
	 *             si la posicion especificada cae fuera del rango.
	 * 
	 */
	public Object get(int indice) throws IndexOutOfBoundsException {

		if (estaFueraLimites(indice))
			throw new IteradorFueraLimitesException();

		return array[indice];

	}

	/**
	 * Obtiene la posici�n de la primera ocurrencia de un valor especificado
	 * dentro de la lista.
	 * 
	 * @param valor
	 *            El valor situado en el indice requerido.
	 * @return La posici�n (0, 1, 2...) de la primera ocurrencia del valor; en
	 *         otro caso -1.
	 */
	public int indiceDe(Object valor) {
		for (int i = 0; i < tama�o; i++) {
			if (array[i].equals(valor))
				return i;

		}
		return -1;

	}

	/**
	 * Determina si la lista contiene un valor especifico.
	 * 
	 * @param valor
	 *            El valor que se busca.
	 * @return true si es encontrado; otro caso false.
	 */
	public boolean contiene(Object valor) {
		for (int i = 0; i < tama�o; i++) {
			if (array[i].equals(valor))
				return true;
		}
		return false;

	}

	/**
	 * Obtiene el n�mero de elementos de la lista.
	 * 
	 * @return El n�mero de elementos de la lista.
	 */
	public int tama�o() {
		return tama�o;
	}

	/**
	 * Determina si la lista esta o no vacia.
	 * 
	 * @return true si la lista esta vacia (tama�o() == 0); en otro caso false.
	 */
	public boolean esVacia() {
		return tama�o() == 0;

	}

	/**
	 * Obtiene un iterador sobre todos los valores.
	 * 
	 * @return un iterador.
	 */
	public Iterador iterador() {
		ArrayIterador ArrayIter = new ArrayIterador(array, 0, tama�o);
		return ArrayIter;
	}

	/**
	 * Duplica el tama�o del array en funcion de capacidad
	 * 
	 * @param capacidad
	 *            la capacidad a comprobar
	 */
	private void asegurarCapacidad(int capacidad) {
		if (capacidad > array.length) {
			Object[] aux = new Object[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				aux[i] = array[i];
			}
			array = aux;
		}
	}

	/**
	 * Metodo que comprueba si un indice esta dentro de los limites
	 * 
	 * @param indice
	 *            a comprobar
	 * @return true si es valido o false si no lo es
	 */
	private boolean estaFueraLimites(int indice) {
		if (indice < 0 || indice >= tama�o)
			return true;
		else
			return false;
	}

	/**
	 * Metodo que comprueba si un indice esta dentro de los limites
	 * 
	 * @param indice
	 *            a comprobar
	 * @return -1 si se encuentra por la izquierda, 0 si es valido y 1 si se
	 *         encuentra por la derecha
	 */
	private int compruebaFueraLimites(int indice) {
		if (indice < 0)
			return -1;
		else if (indice >= tama�o)
			return 1;
		else
			return 0;
	}
}
