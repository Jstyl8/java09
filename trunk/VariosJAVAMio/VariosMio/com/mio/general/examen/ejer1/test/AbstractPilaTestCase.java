package com.mio.general.examen.ejer1.test;

import junit.framework.TestCase;

import com.mio.excepciones.DesbordamientoInferiorException;
import com.mio.estructurasdatos.Pila;

public abstract class AbstractPilaTestCase extends TestCase {

	String mensaje;
	private Pila pila;

	protected void setUp() throws Exception {
		super.setUp();
		pila = crearPila();
	}

	protected abstract Pila crearPila();

	public final void testEsVacia() {

		mensaje = "Debe estar vacia";
		assertTrue(mensaje, pila.esVacia());
		pila.apilar(new Integer(1));
		mensaje = "NO debe estar vacia";
		assertFalse(mensaje, pila.esVacia());
		pila.vaciar();
		mensaje = "Debe estar vacia";
		assertTrue(mensaje, pila.esVacia());

	}

	public final void testVaciar() {

		pila.vaciar();
		mensaje = "Debe estar vacia";
		assertTrue(mensaje, pila.esVacia());
		pila.apilar(new Integer(11));
		mensaje = "NO debe estar vacia";
		assertFalse(mensaje, pila.esVacia());
		pila.vaciar();
		mensaje = "Debe estar vacia";
		assertTrue(mensaje, pila.esVacia());
	}

	public final void testCima() {

		for (int i = 0; i < 100; i++) {
			Integer entero = new Integer(i);
			pila.apilar(entero);
		}
		try {
			mensaje = "El último en entrar fue el 99";
			assertEquals(mensaje, (Integer) pila.cima(), new Integer(99));
		} catch (DesbordamientoInferiorException e1) {

			e1.printStackTrace();
		}

		pila.vaciar();

		try {
			pila.cima();

		} catch (DesbordamientoInferiorException e1) {

			DesbordamientoInferiorException e = new DesbordamientoInferiorException(
					"pila vacia");
			mensaje = "No es la excepción esperada";
			assertEquals(mensaje, e.getMessage(), e1.getMessage());
			// e1.printStackTrace();
		}

	}

	public final void testDesapilar() throws DesbordamientoInferiorException {

		for (int i = 0; i < 100; i++) {
			Integer entero = new Integer(i);
			pila.apilar(entero);
		}
		pila.desapilar();
		mensaje = "Deberia ser 98";
		assertEquals(mensaje, (Integer) pila.cima(), new Integer(98));
		mensaje = "NO debe estar vacia";
		assertFalse(mensaje, pila.esVacia());

	}

	public final void testCimaYDesapilar()
			throws DesbordamientoInferiorException {

		pila.vaciar();
		for (int i = 0; i < 100; i++) {
			Integer entero = new Integer(i);
			pila.apilar(entero);
		}
		mensaje = "Deberia ser 99";
		assertEquals(mensaje, pila.cima(), new Integer(99));
		for (int i = 0; i < 100; i++) {
			assertEquals((Integer) pila.cimaYDesapilar(), new Integer(99 - i));
		}
		mensaje = "Debe estar vacia";
		assertTrue(mensaje, pila.esVacia());

	}

	public final void testApilar() throws DesbordamientoInferiorException {

		for (int i = 0; i < 100; i++) {
			Integer entero = new Integer(i);
			pila.apilar(entero);
			assertEquals(pila.cima(), entero);
		}
		mensaje = "NO debe estar vacia";
		assertFalse(mensaje, pila.esVacia());

	}
}
