package com.mp.practica2.ejercicio1.test;

import com.mp.practica2.ejercicio1.Circulo;
import com.mp.practica2.ejercicio1.Cuadrado;
import com.mp.practica2.ejercicio1.Rectangulo;

import junit.framework.TestCase;

public class FigurasTest extends TestCase {

	public FigurasTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();

	}


	public void testAreas() {

		double lado1 = 2.0;
		double lado2 = 3.0;
		Rectangulo rectangulo = new Rectangulo(lado1, lado2);

		assertEquals(lado1 * lado2, rectangulo.area(), 0.00001);

		Cuadrado cuadrado = new Cuadrado(lado1);
		assertEquals(lado1 * lado1, cuadrado.area(), 0.00001);

		double radio = 1.1;
		Circulo circulo = new Circulo(radio);

		assertEquals(radio * radio * 3.1415, circulo.area(), 0.001);

		assertTrue(circulo.menorQue(rectangulo));
		assertTrue(cuadrado.menorQue(rectangulo));
		assertFalse(cuadrado.menorQue(circulo));

	}

	public void testNombresFiguras(){
		
		Rectangulo rectangulo = new Rectangulo(1.9, 2.9);
		
		assertTrue(rectangulo.getNombre().equals("Rectangulo"));
		
		Circulo circulo = new Circulo(4.9);
		
		assertTrue(circulo.getNombre().equals("Circulo"));
		
		Cuadrado cuadrado = new Cuadrado(2.0);
		
		assertTrue(cuadrado.getNombre().equals("Cuadrado"));
		
	}
	
}
