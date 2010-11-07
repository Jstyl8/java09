//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 7, Ejercicio 5
// ASIGNATURA : Metodologia de la Programación
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
	 * Variable privada que representa el tamaño de la lista
	 */
	private int tamaño;

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
		tamaño = 0;
		capacidadInicial = array.length;
	}

	/**
	 * Inserta un valor en la lista en la posicion dada. El tamaño de la lista
	 * se incrementa en uno.
	 * 
	 * @param indice
	 *            La posición (0, 1, 2...) en la que debe insertarse.
	 * @param valor
	 *            El valor a añadir.
	 * @throws IndexOutOfBoundsException
	 *             si la posicion especificada cae fuera del rango.
	 * 
	 */
	public void insertar(int indice, Object valor)
			throws IndexOutOfBoundsException {

		
		if (indice < 0 || indice > tamaño)
			throw new IteradorFueraLimitesException();

		asegurarCapacidad(tamaño + 1);
		Object[] aux = array.clone();
		for (int i = indice; i < tamaño; i++) {
			aux[i + 1] = array[i];
		}
		aux[indice] = valor;
		array = aux;
		tamaño++;
	}

	/**
	 * Añade un valor al final de la lista. El tamaño de la lista se incrementa
	 * en uno.
	 * 
	 * @param valor
	 *            del El valor que se añade.
	 */
	public void añadir(Object valor) {

		asegurarCapacidad(tamaño + 1);
		array[tamaño++] = valor;

	}

	/**
	 * Elimina el valor de una posición dada en la lista. El tamaño se
	 * decrementa en uno.
	 * 
	 * @param indice
	 *            La posición (0, 1, 2...) en la cual se va a eliminar.
	 * @return El valor contenido en la posición especificada.
	 * @throws IteradorFueraLimitesException
	 *             si la posición esta fuera del rango.
	 * 
	 */
	public Object eliminar(int indice) throws IteradorFueraLimitesException {

		if (estaFueraLimites(indice))
			throw new IteradorFueraLimitesException();
		Object antiguo = array[indice];
		tamaño--;
		for (int i = indice; i < tamaño; i++) {
			array[i] = array[i + 1];
		}
		array[tamaño] = null;
		return antiguo;
	}

	/**
	 * Elimina la primera ocurrencia de un valor especificado. El tamaño de la
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
		for (int i = 0; i < tamaño && !encontrado; i++) {
			if (array[i].equals(valor)) {
				encontrado = true;
				tamaño--;
				for (int j = i; j < tamaño; j++) {
					array[j] = array[j + 1];
				}
				array[tamaño] = null;
			}
		}
		return encontrado;
	}

	/**
	 * Elimina todos los elementos de la lista. El tamaño de la lista se
	 * reposiciona en 0.
	 */
	public void vaciar() {
		for (int i = 0; i < tamaño; i++) {
			array[i] = null;
		}
		tamaño = 0;

	}

	/**
	 * Coloca el valor en una posicion determinada en la lista.
	 * 
	 * @param indice
	 *            La posición (0, 1, 2...) de la que se debe obtener el valor.
	 * @param valor
	 *            El valor a colocar en la posición especificada.
	 * @return El valor original de la posición especificada.
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
	 * Obtiene el valor de una posición especificada de la lista.
	 * 
	 * @param indice
	 *            La posición (0, 1, 2...) de la que se debe obtener el valor.
	 * @return El valor de la posición especificada.
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
	 * Obtiene la posición de la primera ocurrencia de un valor especificado
	 * dentro de la lista.
	 * 
	 * @param valor
	 *            El valor situado en el indice requerido.
	 * @return La posición (0, 1, 2...) de la primera ocurrencia del valor; en
	 *         otro caso -1.
	 */
	public int indiceDe(Object valor) {
		for (int i = 0; i < tamaño; i++) {
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
		for (int i = 0; i < tamaño; i++) {
			if (array[i].equals(valor))
				return true;
		}
		return false;

	}

	/**
	 * Obtiene el número de elementos de la lista.
	 * 
	 * @return El número de elementos de la lista.
	 */
	public int tamaño() {
		return tamaño;
	}

	/**
	 * Determina si la lista esta o no vacia.
	 * 
	 * @return true si la lista esta vacia (tamaño() == 0); en otro caso false.
	 */
	public boolean esVacia() {
		return tamaño() == 0;

	}

	/**
	 * Obtiene un iterador sobre todos los valores.
	 * 
	 * @return un iterador.
	 */
	public Iterador iterador() {
		ArrayIterador ArrayIter = new ArrayIterador(array, 0, tamaño);
		return ArrayIter;
	}

	/**
	 * Duplica el tamaño del array en funcion de capacidad
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
		if (indice < 0 || indice >= tamaño)
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
		else if (indice >= tamaño)
			return 1;
		else
			return 0;
	}
}
