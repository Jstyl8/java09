package com.mio.general.examen.ejer1.test;

import com.mio.estructurasdatos.Pila;
import com.mio.general.examen.ejer1.PilaLinkedList;


public class PilaLinkedListTest extends AbstractPilaTestCase {

	protected Pila crearPila() {

		return new PilaLinkedList();
	}
}
