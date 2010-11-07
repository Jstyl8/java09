package com.mp.practica4.ejercicio3.test;


import com.mp.practica4.ejercicio3.Cambio;
import com.mp.practica4.ejercicio3.SolucionesCambio;

import junit.framework.TestCase;

public class SolucionesCambioTestA extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}


	public void testCambioMonedaRecursivoNormal() {
 
        int[] monedas = { 1, 5, 8, 10, 25 };
       
        int acambiar = 30;

        Cambio cambio = new Cambio(monedas, acambiar);
        
		assertEquals(2,SolucionesCambio.cambioMonedaRecursivo(cambio));
		
        cambio.setACambiar(1);
 
		assertEquals(1,SolucionesCambio.cambioMonedaRecursivo(cambio));
		
        cambio.setACambiar(8);
		assertEquals(1,SolucionesCambio.cambioMonedaRecursivo(cambio));
		
	
        cambio.setACambiar(0);
		assertEquals(0,SolucionesCambio.cambioMonedaRecursivo(cambio));
        
        cambio.setACambiar(24);
        assertEquals(3,SolucionesCambio.cambioMonedaRecursivo(cambio));
	}

}
