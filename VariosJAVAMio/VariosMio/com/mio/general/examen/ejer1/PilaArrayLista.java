/**
 * 
 */
package com.mio.general.examen.ejer1;

import com.mio.estructurasdatos.ArrayLista;
import com.mio.estructurasdatos.Pila;
import com.mio.excepciones.DesbordamientoInferiorException;

/**
 * @author Jstyl_8
 * 
 */
public class PilaArrayLista implements Pila {

	ArrayLista pila;
	

	public PilaArrayLista() {
		pila = new ArrayLista();
	}

	public void apilar(Object x) {
		pila.insertar(0, x);
	}

	public Object cima() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("pila vacia");

		return pila.get(0);
	}

	public Object cimaYDesapilar() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("pila vacia");
		Object antiguo = pila.get(0);
		pila.eliminar(0);
		return antiguo;
	}

	public void desapilar() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("pila vacia");
		pila.eliminar(0);
	}

	public boolean esVacia() {
		return pila.esVacia();
	}

	public int tamaño() {
		return pila.tamaño();
	}

	public void vaciar() {
		pila.vaciar();
	}

}
