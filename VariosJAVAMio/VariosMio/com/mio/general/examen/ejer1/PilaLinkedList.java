package com.mio.general.examen.ejer1;

import java.util.LinkedList;

import com.mio.estructurasdatos.Pila;
import com.mio.excepciones.DesbordamientoInferiorException;

public class PilaLinkedList implements Pila {

	LinkedList pila;

	public PilaLinkedList() {
		pila = new LinkedList();
	}

	public void apilar(Object x) {
		pila.addFirst(x);
	}

	public Object cima() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("pila vacia");
		return pila.getFirst();
	}

	public Object cimaYDesapilar() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("pila vacia");
		Object antiguo = pila.getFirst();
		pila.removeFirst();
		return antiguo;
	}

	public void desapilar() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("pila vacia");
		pila.removeFirst();
	}

	public boolean esVacia() {
		return pila.isEmpty();
	}

	public int tamaño() {
		return pila.size();
	}

	public void vaciar() {
		pila.clear();

	}

}
