package com.mp.practica6.ejercicio3.test;

import com.mp.practica6.ejercicio3.Laberinto;

import junit.framework.TestCase;

public class LaberintoTestA extends TestCase {

	private String mensaje;

    public LaberintoTestA(String arg0) {
        super(arg0);
		mensaje = "";
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testLaberitoSi() {
        char[][] laberinto = { { '*', '*', '*', '*', ' ', '*' },
                { '*', ' ', ' ', ' ', ' ', '*' },
                { '*', ' ', ' ', ' ', ' ', '*' },
                { '*', ' ', ' ', '*', ' ', '*' },
                { '*', '*', ' ', '*', ' ', '*' },
                { '*', '*', '*', 's', ' ', '*' } };

        int entradaX = 0;
        int entradaY = 4;

        Laberinto laberintoSencillo = new Laberinto(laberinto,
                entradaX, entradaY);
        mensaje = "Deberia encontrar la solución";
        assertTrue(mensaje,laberintoSencillo.resolver() == true);
    }

    public void testLaberitoNo() {

        char[][] laberinto = { { '*', '*', '*', '*', ' ', '*' },
                { '*', ' ', ' ', ' ', ' ', '*' },
                { '*', ' ', ' ', '*', '*', '*' },
                { '*', '*', ' ', ' ', ' ', '*' },
                { '*', '*', ' ', '*', ' ', '*' },
                { '*', '*', '*', 's', '*', '*' } };

        int entradaX = 0;
        int entradaY = 4;

        Laberinto laberintoSencillo = new Laberinto(laberinto,
                entradaX, entradaY);
        mensaje = "Deberia NO encontrar la solución";
        assertTrue(mensaje,laberintoSencillo.resolver() == false);
    }
}
