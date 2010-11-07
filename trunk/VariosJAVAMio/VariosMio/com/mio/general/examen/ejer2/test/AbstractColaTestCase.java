package com.mio.general.examen.ejer2.test;

import junit.framework.TestCase;

import com.mio.excepciones.DesbordamientoInferiorException;
import com.mio.estructurasdatos.Cola;

public abstract class AbstractColaTestCase extends TestCase {

	private String mensaje;
	private Cola cola;

	protected void setUp() throws Exception {
		super.setUp();
		cola = crearCola();
	}

	protected abstract Cola crearCola();

	public final void testEsVacia() {

		mensaje = "El tama�o de la cola debe ser 0";
		assertEquals(mensaje, 0, cola.tama�o());
		mensaje = "Debe estar vacia";
		assertTrue(mensaje, cola.esVacia());

		try {
			cola.quitarPrimero();
			mensaje = "Debe saltar la excepci�n";
			fail(mensaje);
		} catch (DesbordamientoInferiorException e) {

		}
	}

	public void testVaciar() {

		mensaje = "Debe estar vacia";
		assertTrue(mensaje, cola.esVacia());

		cola.insertar(new Integer(11));
		cola.insertar(new Double(11));
		cola.insertar(new Float(11));

		mensaje = "No debe estar vacia";
		assertFalse(mensaje, cola.esVacia());

		cola.vaciar();

		mensaje = "El tama�o de la cola debe ser 0";
		assertEquals(mensaje, 0, cola.tama�o());
		mensaje = "Debe estar vacia";
		assertTrue(mensaje, cola.esVacia());

		try {
			cola.quitarPrimero();
			mensaje = "Debe saltar la excepci�n";
			fail(mensaje);
		} catch (DesbordamientoInferiorException e) {

		}
	}

	public void testEncolarDesencolar() {

		Integer entero = new Integer(11);
		Double realdoble = new Double(11);
		Float real = new Float(11);

		cola.insertar(entero);
		cola.insertar(realdoble);
		cola.insertar(real);

		mensaje = "El tama�o de la cola debe ser 3";
		assertEquals(mensaje, 3, cola.tama�o());
		mensaje = "No debe estar vacia";
		assertFalse(mensaje, cola.esVacia());

		try {
			mensaje = "Deben ser iguales";
			assertEquals(mensaje, entero, (Integer) cola.quitarPrimero());
		} catch (DesbordamientoInferiorException e3) {

			e3.printStackTrace();
		}

		mensaje = "El tama�o de la cola debe ser 2";
		assertEquals(mensaje, 2, cola.tama�o());
		mensaje = "No debe estar vacia";
		assertFalse(mensaje, cola.esVacia());

		try {
			mensaje = "Deben ser iguales";
			assertEquals(mensaje, realdoble, (Double) cola.quitarPrimero());
		} catch (DesbordamientoInferiorException e2) {

			e2.printStackTrace();
		}

		mensaje = "El tama�o de la cola debe ser 1";
		assertEquals(mensaje, 1, cola.tama�o());
		mensaje = "No debe estar vacia";
		assertFalse(mensaje, cola.esVacia());

		try {
			mensaje = "Deben ser iguales";
			assertEquals(mensaje, real, (Float) cola.quitarPrimero());
		} catch (DesbordamientoInferiorException e1) {

			e1.printStackTrace();
		}

		mensaje = "El tama�o de la cola debe ser 0";
		assertEquals(mensaje, 0, cola.tama�o());
		mensaje = "Debe estar vacia";
		assertTrue(mensaje, cola.esVacia());

		try {
			cola.quitarPrimero();
			mensaje = "Debe saltar la excepci�n";
			fail(mensaje);

		} catch (DesbordamientoInferiorException e) {

		}
	}

	public final void testInsertar() {

		for (int i = 0; i < 1000; i++) {
			Integer entero = new Integer(i);
			cola.insertar(entero);
		}

		mensaje = "No debe estar vacia";
		assertFalse(mensaje, cola.esVacia());

		for (int i = 0; i < 1000; i++) {
			Integer entero = new Integer(i);
			try {
				mensaje = "Deben ser iguales";
				assertEquals(mensaje, cola.quitarPrimero(), entero);
			} catch (DesbordamientoInferiorException e) {

				e.printStackTrace();
			}
		}

		mensaje = "Debe estar vacia";
		assertTrue(mensaje, cola.esVacia());

	}

}
