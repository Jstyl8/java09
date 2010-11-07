package com.mp.practica6.ejercicio1.test;

import com.mp.practica6.ejercicio1.Cambio;
import com.mp.practica6.ejercicio1.SolucionesCambio;

import junit.framework.TestCase;


public class CambioTestA extends TestCase {

	private String mensaje;

	public CambioTestA(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		mensaje = "";
	}
	 public void testCambioMonedaRecursivoNormal() {

	        int[] monedas = { 1, 5, 8, 10, 25 };
	        int acambiar = 30;

	        Cambio cambio = new Cambio(monedas, acambiar);

	        mensaje ="Deberian ser dos monedas";
			assertEquals(mensaje,2,SolucionesCambio.cambioMonedaRecursivo(cambio));

	        cambio.setACambiar(1);
	        mensaje ="Deberian ser una moneda";
			assertEquals(mensaje,1,SolucionesCambio.cambioMonedaRecursivo(cambio));

	        cambio.setACambiar(8);
	        mensaje ="Deberian ser una moneda";
			assertEquals(mensaje,1,SolucionesCambio.cambioMonedaRecursivo(cambio));

	        cambio.setACambiar(0);
	        mensaje ="Deberian ser cero monedas";
			assertEquals(mensaje,0,SolucionesCambio.cambioMonedaRecursivo(cambio));

	        cambio.setACambiar(24);
	        mensaje ="Deberian ser tres monedas";
	        assertEquals(mensaje,3,SolucionesCambio.cambioMonedaRecursivo(cambio));
		}

	    public void testCambioMonedaVoraz() {

	        int[] monedas = { 1, 5, 8, 10, 25 };
	        int acambiar = 30;

	        Cambio cambio = new Cambio(monedas, acambiar);
	        mensaje ="Deberian ser dos monedas";
	        assertEquals(mensaje,2,SolucionesCambio.cambioMonedaVoraz(cambio));

	        cambio.setACambiar(1);
	        mensaje ="Deberian ser una moneda";
	        assertEquals(mensaje,1,SolucionesCambio.cambioMonedaVoraz(cambio));

	        cambio.setACambiar(8);
	        mensaje ="Deberian ser una moneda";
	        assertEquals(mensaje,1,SolucionesCambio.cambioMonedaVoraz(cambio));


	        cambio.setACambiar(0);
	        mensaje ="Deberian ser cero monedas";
	        assertEquals(mensaje,0,SolucionesCambio.cambioMonedaVoraz(cambio));

	        cambio.setACambiar(24);
	        mensaje ="Deberian ser 6 monedas";
	        assertEquals(mensaje,6,SolucionesCambio.cambioMonedaVoraz(cambio));

	    }

	    public void testCambioMonedaDinamico() {

	        int[] monedas = { 1, 5, 8, 10, 25 };
	        int acambiar = 30;

	        Cambio cambio = new Cambio(monedas, acambiar);
	        mensaje ="Deberian ser dos monedas";
	        assertEquals(mensaje,2,SolucionesCambio.cambioMonedaDinamico(cambio));

	        cambio.setACambiar(1);
	        mensaje ="Deberian ser una moneda";
	        assertEquals(mensaje,1,SolucionesCambio.cambioMonedaDinamico(cambio));

	        cambio.setACambiar(8);
	        mensaje ="Deberian ser una moneda";
	        assertEquals(mensaje,1,SolucionesCambio.cambioMonedaDinamico(cambio));

	        cambio.setACambiar(0);
	        mensaje ="Deberian ser cero monedas";
	        assertEquals(mensaje,0,SolucionesCambio.cambioMonedaDinamico(cambio));

	        cambio.setACambiar(24);
	        mensaje ="Deberian ser 3 monedas";
	        assertEquals(mensaje,3,SolucionesCambio.cambioMonedaDinamico(cambio));
	    }
}
