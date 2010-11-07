package com.mio.general.examen.ejer2;

import java.util.LinkedList;

import com.mio.estructurasdatos.Cola;
import com.mio.excepciones.DesbordamientoInferiorException;

public class ColaLinkedList implements Cola {

	LinkedList cola;

	public ColaLinkedList() {
		cola = new LinkedList();
	}

	public boolean esVacia() {
		return cola.isEmpty();
	}

	public void insertar(Object x) {
		cola.addLast(x);
	}

	public Object primero() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("Cola Vacia");
		return cola.getFirst();
	}

	public Object quitarPrimero() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("Cola Vacia");
		Object antiguo = cola.getFirst();
		cola.removeFirst();
		return antiguo;
	}

	public int tamaño() {
		return cola.size();
	}

	public void vaciar() {
		cola.clear();
	}

}
