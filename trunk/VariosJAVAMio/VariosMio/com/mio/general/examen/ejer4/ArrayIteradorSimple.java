package com.mio.general.examen.ejer4;

import com.mio.excepciones.IteradorFueraLimitesException;

public class ArrayIteradorSimple implements IteradorSimple {

	private Object[] array;

	private int actual;

	private int ultimo;

	public ArrayIteradorSimple(Object[] a) {
		array = a;
		this.actual = 0;
		ultimo = a.length - 1;
	}

	public ArrayIteradorSimple(Object[] a, int primero, int tamaño) {
		array = a;
		this.actual = primero;
		ultimo = tamaño - primero - 1;
	}

	public boolean estaDentro() {
		return actual <= ultimo;
	}

	public Object siguiente() {
		if (actual <= ultimo)
			return array[actual++];
		else
			throw new IteradorFueraLimitesException();
	}

}
