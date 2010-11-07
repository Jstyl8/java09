/**
 * 
 */
package com.mio.general.examen.ejer2;

import com.mio.estructurasdatos.ArrayLista;
import com.mio.estructurasdatos.Cola;
import com.mio.excepciones.DesbordamientoInferiorException;

/**
 * @author Jstyl_8
 * 
 */
public class ColaArrayLista implements Cola {

	ArrayLista cola;

	public ColaArrayLista() {
		cola = new ArrayLista();
	}

	public boolean esVacia() {
		return cola.esVacia();
	}

	public void insertar(Object x) {
		cola.a�adir(x);

	}

	public Object primero() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("Cola Vacia");

		return cola.get(0);
	}

	public Object quitarPrimero() throws DesbordamientoInferiorException {
		if (esVacia())
			throw new DesbordamientoInferiorException("Cola Vacia");
		Object antiguo = cola.get(0);
		cola.eliminar(0);
		return antiguo;
	}

	public int tama�o() {
		return cola.tama�o();
	}

	public void vaciar() {
		cola.vaciar();

	}

}
