package com.mp.practica3.ejercicio3.test;

import com.mp.practica3.ejercicio3.Busqueda;
import com.mp.practica3.ejercicio3.SolucionesBusqueda;


import junit.framework.TestCase;

public class SolucionesBusquedaTestA extends TestCase {

    public static void main(String[] args) {
    }

    public SolucionesBusquedaTestA(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testBusquedaExitosa() {

        Busqueda busqueda = new Busqueda(100);
        int[] datos = new int[100];
        for (int i = 0; i < datos.length; i++) {
            datos[i]=i;
        }
        busqueda.setDatos(datos);

        busqueda.setNumBuscado(99);
        assertEquals(99, SolucionesBusqueda.busquedaLineal(busqueda));
        assertEquals(99, SolucionesBusqueda.busquedaBinariaIter(busqueda));

        busqueda.setNumBuscado(0);
        assertEquals(0, SolucionesBusqueda.busquedaLineal(busqueda));
        assertEquals(0, SolucionesBusqueda.busquedaBinariaIter(busqueda));

        busqueda.setNumBuscado(55);
        assertEquals(55, SolucionesBusqueda.busquedaLineal(busqueda));
        assertEquals(55, SolucionesBusqueda.busquedaBinariaIter(busqueda));

    }

    public void testBusquedaSinExito() {

        Busqueda busqueda = new Busqueda(100);
        int[] datos = new int[100];
        for (int i = 0; i < datos.length; i++) {
            datos[i]=i*2;
        }
        busqueda.setDatos(datos);

        busqueda.setNumBuscado(3);
        assertFalse(SolucionesBusqueda.busquedaLineal(busqueda)==3);
        assertEquals(Long.MIN_VALUE, SolucionesBusqueda.busquedaLineal(busqueda));

        busqueda.setNumBuscado(33);
        assertFalse(SolucionesBusqueda.busquedaBinariaIter(busqueda)==33);
        assertEquals(Long.MIN_VALUE, SolucionesBusqueda.busquedaBinariaIter(busqueda));

        busqueda.setNumBuscado(-33);
        assertFalse(SolucionesBusqueda.busquedaBinariaIter(busqueda)==-33);
        assertEquals(Long.MIN_VALUE, SolucionesBusqueda.busquedaBinariaIter(busqueda));

    }

}
