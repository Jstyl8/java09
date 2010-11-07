package com.mp.practica2.ejercicio4.test;

import com.mp.practica2.ejercicio4.Mayor;

import junit.framework.TestCase;

public class MayorTest extends TestCase {

	public MayorTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testNormal() {
		int[] arr = new int[3];
		arr[0] = 9;
		arr[1] = 8;
		arr[2] = 7;
		assertEquals(9, Mayor.elEnteroMayor(arr));
	}

	public void testOrden() {
		assertEquals(9, Mayor.elEnteroMayor(new int[] { 9, 8, 7 }));
		assertEquals(9, Mayor.elEnteroMayor(new int[] { 7, 9, 8 }));
		assertEquals(9, Mayor.elEnteroMayor(new int[] { 7, 8, 9 }));
	}

	public void testNegativo() {
		assertEquals(-7, Mayor.elEnteroMayor(new int[] { -9, -8, -7 }));
	}

	public void testDuplicados() {
		assertEquals(9, Mayor.elEnteroMayor(new int[] { 9, 8, 9, 7 }));
	}

	public void testSoloUno() {
		assertEquals(1, Mayor.elEnteroMayor(new int[] { 1 }));
	}

}
