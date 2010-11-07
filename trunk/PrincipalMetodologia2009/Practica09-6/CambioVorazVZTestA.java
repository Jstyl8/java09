package com.mp.practica6.ejercicio2.test;


import com.mp.practica6.ejercicio2.Cambio;
import com.mp.practica6.ejercicio2.CambioVoraz;


import junit.framework.TestCase;

public class CambioVorazVZTestA extends TestCase {

	private String mensaje;

    protected void setUp() throws Exception {
        super.setUp();
		mensaje = "";
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
    public void testCambioMonedaVZ() {

        int[] monedas = { 100, 50, 20, 10, 5, 2, 1 };
        int aCambiar = 127;

        Cambio cambio = new Cambio(monedas, aCambiar);
        CambioVoraz cambioVoraz = new CambioVoraz(cambio);
        cambioVoraz.resolver();
        mensaje ="Deberian ser 4 monedas";
        assertEquals(mensaje,4,cambioVoraz.getNumMinimoMonedas());

        cambio.setACambiar(1);
        cambioVoraz.setCambio(cambio);
        cambioVoraz.resolver();
        mensaje ="Deberian ser una moneda";
        assertEquals(mensaje,1,cambioVoraz.getNumMinimoMonedas());

        cambio.setACambiar(8);
        cambioVoraz.setCambio(cambio);
        cambioVoraz.resolver();
        mensaje ="Deberian ser 3 monedas";
        assertEquals(mensaje,3,cambioVoraz.getNumMinimoMonedas());


        cambio.setACambiar(0);
        cambioVoraz.setCambio(cambio);
        cambioVoraz.resolver();
        mensaje ="Deberian ser 0 monedas";
        assertEquals(mensaje,0,cambioVoraz.getNumMinimoMonedas());

        cambio.setACambiar(24);
        cambioVoraz.setCambio(cambio);
        cambioVoraz.resolver();
        mensaje ="Deberian ser 3 monedas";
        assertEquals(mensaje,3,cambioVoraz.getNumMinimoMonedas());

    }
}
