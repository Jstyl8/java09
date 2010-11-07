package com.mio.general.examen.ejer1.test;

import com.mio.estructurasdatos.Pila;
import com.mio.general.examen.ejer1.PilaArrayLista;

public class PilaArrayListaTest extends AbstractPilaTestCase {

	protected Pila crearPila() {

		return new PilaArrayLista();
	}
}
