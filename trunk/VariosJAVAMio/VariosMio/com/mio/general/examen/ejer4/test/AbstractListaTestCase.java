package com.mio.general.examen.ejer4.test;

import com.mio.estructurasdatos.ArrayIterador;

import com.mio.estructurasdatos.Iterador;
import com.mio.estructurasdatos.Lista;
import com.mio.excepciones.IteradorFueraLimitesException;
import com.mio.general.examen.ejer4.ArrayIteradorSimple;
import com.mio.general.examen.ejer4.ArrayListaSimple;
import com.mio.general.examen.ejer4.IteradorSimple;

import junit.framework.TestCase;

public abstract class AbstractListaTestCase extends TestCase {

	protected static final Object VALOR_A = "A";

	protected static final Object VALOR_B = "B";

	protected static final Object VALOR_C = "C";

	private ArrayListaSimple lista;

	public abstract Lista crearLista();

	protected void setUp() throws Exception {
		super.setUp();
		crearLista();
		lista = (ArrayListaSimple) crearLista();

	}

	public void testInsertarEnListaVacia() {

		assertEquals(0, lista.tamaño());
		assertTrue(lista.esVacia());

		lista.añadir(VALOR_A);

		assertEquals(1, lista.tamaño());
		assertFalse(lista.esVacia());
		assertFalse(lista.contiene(VALOR_B));
		assertTrue(lista.contiene(VALOR_A));
		assertSame(VALOR_A, lista.get(0));

	}

	public void testRecorridoEnLista() {

		for (int i = 0; i < 10; i++) {
			lista.añadir(new Integer(i));
		}
		int i = 0;
		ArrayIterador iter = (ArrayIterador) lista.iterador();
		for (iter.primero(); iter.estaDentro(); iter.siguiente()) {
			assertEquals(i, ((Integer) iter.actual()).intValue());
			i++;
		}
	}

	public void testRecorridoEnListaSimple() {

		for (int i = 0; i < 10; i++) {
			lista.añadir(new Integer(i));
		}
		int i = 0;
		ArrayIteradorSimple iter = (ArrayIteradorSimple) lista.iteradorSimple();
		while (iter.estaDentro()) {
			assertEquals(i, ((Integer) iter.siguiente()).intValue());
			i++;
		}
	}

	public void testInsertarEntreElementos() {

		lista.insertar(0, VALOR_A);
		lista.insertar(1, VALOR_B);
		lista.insertar(1, VALOR_C);
		assertEquals(3, lista.tamaño());

		assertSame(VALOR_A, lista.get(0));
		assertSame(VALOR_C, lista.get(1));
		assertSame(VALOR_B, lista.get(2));
	}

	public void testInsertarAntesPrimerElemento() {

		lista.insertar(0, VALOR_A);
		lista.insertar(0, VALOR_B);

		assertEquals(2, lista.tamaño());
		assertSame(VALOR_B, lista.get(0));
		assertSame(VALOR_A, lista.get(1));

	}

	public void testInsertarDespuesUltimoElemento() {

		lista.insertar(0, VALOR_A);
		lista.insertar(1, VALOR_B);

		assertEquals(2, lista.tamaño());
		assertSame(VALOR_A, lista.get(0));
		assertSame(VALOR_B, lista.get(1));

	}

	public void testEliminarUnSoloElemento() {

		lista.añadir(VALOR_A);
		assertEquals(1, lista.tamaño());
		assertSame(VALOR_A, lista.get(0));
		assertSame(VALOR_A, lista.eliminar(0));
		assertEquals(0, lista.tamaño());
	}

	public void testAñadir() {

		lista.añadir(VALOR_A);
		lista.añadir(VALOR_C);
		lista.añadir(VALOR_B);

		assertEquals(3, lista.tamaño());
		assertSame(VALOR_A, lista.get(0));
		assertSame(VALOR_C, lista.get(1));
		assertSame(VALOR_B, lista.get(2));

	}

	public void testInsertarFueraLimites() {

		try {
			lista.insertar(-1, VALOR_A);
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}
		try {
			lista.insertar(1, VALOR_B);
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}
	}

	public void testGetFueraLimites() {
		try {
			lista.get(-1);
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}

		try {
			lista.get(0);
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}

		lista.añadir(VALOR_A);

		try {
			lista.get(1);
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}
	}

	public void testEliminarElementoInterno() {

		lista.añadir(VALOR_A);
		lista.añadir(VALOR_C);
		lista.añadir(VALOR_B);

		assertEquals(3, lista.tamaño());
		assertSame(VALOR_A, lista.get(0));
		assertSame(VALOR_C, lista.get(1));
		assertSame(VALOR_B, lista.get(2));

		assertSame(VALOR_C, lista.eliminar(1));

		assertEquals(2, lista.tamaño());
		assertSame(VALOR_A, lista.get(0));
		assertSame(VALOR_B, lista.get(1));
	}

	public void testEliminarPrimerElemento() {

		lista.añadir(VALOR_A);
		lista.añadir(VALOR_B);
		lista.añadir(VALOR_C);

		assertEquals(3, lista.tamaño());
		assertSame(VALOR_A, lista.get(0));
		assertSame(VALOR_B, lista.get(1));
		assertSame(VALOR_C, lista.get(2));

		assertSame(VALOR_A, lista.eliminar(0));

		assertEquals(2, lista.tamaño());
		assertSame(VALOR_B, lista.get(0));
		assertSame(VALOR_C, lista.get(1));
	}

	public void testEliminarUltimoElemento() {

		lista.añadir(VALOR_A);
		lista.añadir(VALOR_B);
		lista.añadir(VALOR_C);

		assertEquals(3, lista.tamaño());
		assertSame(VALOR_A, lista.get(0));
		assertSame(VALOR_B, lista.get(1));
		assertSame(VALOR_C, lista.get(2));

		assertSame(VALOR_C, lista.eliminar(2));

		assertEquals(2, lista.tamaño());
		assertSame(VALOR_A, lista.get(0));
		assertSame(VALOR_B, lista.get(1));
	}

	public void testEliminarPorValor() {

		lista.añadir(VALOR_A);
		lista.añadir(VALOR_B);
		lista.añadir(VALOR_A);

		assertEquals(3, lista.tamaño());
		assertSame(VALOR_A, lista.get(0));
		assertSame(VALOR_B, lista.get(1));
		assertSame(VALOR_A, lista.get(2));

		assertTrue(lista.eliminar(VALOR_A));

		assertEquals(2, lista.tamaño());
		assertSame(VALOR_B, lista.get(0));
		assertSame(VALOR_A, lista.get(1));

		assertTrue(lista.eliminar(VALOR_A));

		assertEquals(1, lista.tamaño());
		assertSame(VALOR_B, lista.get(0));

		assertFalse(lista.eliminar(VALOR_C));

		assertEquals(1, lista.tamaño());
		assertSame(VALOR_B, lista.get(0));

		assertTrue(lista.eliminar(VALOR_B));

		assertEquals(0, lista.tamaño());
	}

	public void testEliminarFueraLimites() {

		try {
			lista.eliminar(-1);
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}

		try {
			lista.eliminar(0);
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}

	}

	public void testSet() {

		lista.insertar(0, VALOR_A);
		assertSame(VALOR_A, lista.get(0));
		assertSame(VALOR_A, lista.set(0, VALOR_B));
		assertSame(VALOR_B, lista.get(0));
	}

	public void testFueraLimites() {

		try {
			lista.set(-1, VALOR_A);

			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}
		try {
			lista.set(0, VALOR_B);
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}

		lista.insertar(0, VALOR_C);

		try {
			lista.set(1, VALOR_C);
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}
	}

	public void testIteracionVacia() {

		Iterador iterador = lista.iterador();

		assertFalse(iterador.estaDentro());

		try {
			iterador.actual();
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}
	}

	public void testIteracionVaciaSimple() {

		IteradorSimple iteradorSimple = lista.iteradorSimple();

		assertFalse(iteradorSimple.estaDentro());

		try {
			iteradorSimple.siguiente();
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}
	}

	public void testIteracionDirecta() {

		lista.añadir(VALOR_A);
		lista.añadir(VALOR_B);
		lista.añadir(VALOR_C);

		Iterador iterador = lista.iterador();

		iterador.primero();
		assertTrue(iterador.estaDentro());
		assertSame(VALOR_A, iterador.actual());

		iterador.siguiente();
		assertTrue(iterador.estaDentro());
		assertSame(VALOR_B, iterador.actual());

		iterador.siguiente();
		assertTrue(iterador.estaDentro());
		assertSame(VALOR_C, iterador.actual());

		iterador.siguiente();
		assertFalse(iterador.estaDentro());

		try {
			iterador.actual();
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}
	}

	public void testIteracionDirectaSimple() {

		lista.añadir(VALOR_A);
		lista.añadir(VALOR_B);
		lista.añadir(VALOR_C);

		IteradorSimple IteradorSimple = lista.iteradorSimple();

		assertTrue(IteradorSimple.estaDentro());
		assertSame(VALOR_A, IteradorSimple.siguiente());

		assertTrue(IteradorSimple.estaDentro());
		assertSame(VALOR_B, IteradorSimple.siguiente());

		assertTrue(IteradorSimple.estaDentro());
		assertSame(VALOR_C, IteradorSimple.siguiente());

		assertFalse(IteradorSimple.estaDentro());

		try {
			IteradorSimple.siguiente();
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}
	}

	public void testIteracionInversa() {

		lista.añadir(VALOR_A);
		lista.añadir(VALOR_B);
		lista.añadir(VALOR_C);

		Iterador iterador = lista.iterador();

		iterador.ultimo();

		assertTrue(iterador.estaDentro());
		assertSame(VALOR_C, iterador.actual());

		iterador.anterior();
		assertTrue(iterador.estaDentro());
		assertSame(VALOR_B, iterador.actual());

		iterador.anterior();
		assertTrue(iterador.estaDentro());
		assertSame(VALOR_A, iterador.actual());

		iterador.anterior();
		assertFalse(iterador.estaDentro());

		try {
			iterador.actual();
			fail();
		} catch (IteradorFueraLimitesException e) {
			/* esperado */
			assertTrue(true);
		}
	}

	public void testIndiceDe() {

		lista.añadir(VALOR_A);
		lista.añadir(VALOR_B);
		lista.añadir(VALOR_A);

		assertEquals(0, lista.indiceDe(VALOR_A));
		assertEquals(1, lista.indiceDe(VALOR_B));
		assertEquals(-1, lista.indiceDe(VALOR_C));
	}

	public void testContiene() {

		lista.añadir(VALOR_A);
		lista.añadir(VALOR_B);
		lista.añadir(VALOR_A);

		assertTrue(lista.contiene(VALOR_A));
		assertTrue(lista.contiene(VALOR_B));
		assertFalse(lista.contiene(VALOR_C));
	}

	public void testVaciar() {

		lista.añadir(VALOR_A);
		lista.añadir(VALOR_B);
		lista.añadir(VALOR_C);

		assertFalse(lista.esVacia());
		lista.vaciar();
		assertTrue(lista.esVacia());
	}

}
