package com.mio.general.examen.ejer6.test;

import com.mio.estructurasdatos.Cola;
import com.mio.excepciones.DesbordamientoInferiorException;

import junit.framework.TestCase;

public abstract class AbstractColaTestCase extends TestCase {

	private String mensaje;
	private Cola cola;
	private Cola cola2;

	protected void setUp() throws Exception {
		super.setUp();
		cola = crearCola();
		cola2 = crearCola();
	}

	protected abstract Cola crearCola();

	public final void testEsVacia() {

		mensaje = "El tamaño de la cola debe ser 0";
		assertEquals(mensaje, 0, cola.tamaño());
		mensaje = "Debe estar vacia";
		assertTrue(mensaje, cola.esVacia());

		try {
			cola.quitarPrimero();
			mensaje = "Debe saltar la excepción";
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

		mensaje = "El tamaño de la cola debe ser 0";
		assertEquals(mensaje, 0, cola.tamaño());
		mensaje = "Debe estar vacia";
		assertTrue(mensaje, cola.esVacia());

		try {
			cola.quitarPrimero();
			mensaje = "Debe saltar la excepción";
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

		mensaje = "El tamaño de la cola debe ser 3";
		assertEquals(mensaje, 3, cola.tamaño());
		mensaje = "No debe estar vacia";
		assertFalse(mensaje, cola.esVacia());

		try {
			mensaje = "Deben ser iguales";
			assertEquals(mensaje, entero, (Integer) cola.quitarPrimero());
		} catch (DesbordamientoInferiorException e3) {

			e3.printStackTrace();
		}

		mensaje = "El tamaño de la cola debe ser 2";
		assertEquals(mensaje, 2, cola.tamaño());
		mensaje = "No debe estar vacia";
		assertFalse(mensaje, cola.esVacia());

		try {
			mensaje = "Deben ser iguales";
			assertEquals(mensaje, realdoble, (Double) cola.quitarPrimero());
		} catch (DesbordamientoInferiorException e2) {

			e2.printStackTrace();
		}

		mensaje = "El tamaño de la cola debe ser 1";
		assertEquals(mensaje, 1, cola.tamaño());
		mensaje = "No debe estar vacia";
		assertFalse(mensaje, cola.esVacia());

		try {
			mensaje = "Deben ser iguales";
			assertEquals(mensaje, real, (Float) cola.quitarPrimero());
		} catch (DesbordamientoInferiorException e1) {

			e1.printStackTrace();
		}

		mensaje = "El tamaño de la cola debe ser 0";
		assertEquals(mensaje, 0, cola.tamaño());
		mensaje = "Debe estar vacia";
		assertTrue(mensaje, cola.esVacia());

		try {
			cola.quitarPrimero();
			mensaje = "Debe saltar la excepción";
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

	public final void testEqualsytoString() {

		for (int i = 0; i < 10; i++) {
			Integer entero = new Integer(i);
			cola.insertar(entero);
		}
		System.out.println(cola);
		String colaString = cola.toString();
		String control = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]";
		assertTrue(colaString.equals(control));

		for (int i = 0; i < 10; i++) {
			Integer entero = new Integer(i);
			cola2.insertar(entero);
		}

		assertTrue(cola.equals(cola2));

		try {
			cola2.quitarPrimero();
		} catch (DesbordamientoInferiorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String colaString2 = cola2.toString();
		String control2 = "[1, 2, 3, 4, 5, 6, 7, 8, 9]";
		assertTrue(colaString2.equals(control2));
		assertFalse(cola.equals(cola2));
		cola2.insertar(new Integer(0));
		assertFalse(cola.equals(cola2));
	}
}
