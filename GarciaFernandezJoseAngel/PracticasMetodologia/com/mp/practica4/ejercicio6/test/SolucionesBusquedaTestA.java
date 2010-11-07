package com.mp.practica4.ejercicio6.test;

import java.util.Arrays;

import com.mp.practica4.ejercicio6.Busqueda;
import com.mp.practica4.ejercicio6.SolucionesBusqueda;
import com.mp.excepciones.ElementoNoEncontradoException;

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
        SolucionesBusqueda solucionesBusqueda = new SolucionesBusqueda(busqueda);
        
        try {
            assertEquals(99, solucionesBusqueda.busquedaLineal(busqueda));
        } catch (ElementoNoEncontradoException e) {
             e.printStackTrace();
        }
        
        try {
            assertEquals(99, solucionesBusqueda.busquedaBinariaIter(busqueda));
        } catch (ElementoNoEncontradoException e) {
             e.printStackTrace();
        }
        
        try {
            assertEquals(99, solucionesBusqueda.busquedaBinariaRec(busqueda));
        } catch (ElementoNoEncontradoException e) {
             e.printStackTrace();
        }
        
        int indice = Arrays.binarySearch(datos, 99);
        assertEquals(99, datos[indice]);
         
    }
    
    public void testBusquedaSinExito() {
        
        Busqueda busqueda = new Busqueda(100);
        int[] datos = new int[100];
        for (int i = 0; i < datos.length; i++) {
            datos[i]=i*2;
        }
        busqueda.setDatos(datos);
        busqueda.setNumBuscado(3);
        SolucionesBusqueda solucionesBusqueda = new SolucionesBusqueda(busqueda);
        ElementoNoEncontradoException excepcion = new ElementoNoEncontradoException("No encontrado");
        
        try {
            assertEquals(3, solucionesBusqueda.busquedaLineal(busqueda));
        } catch (ElementoNoEncontradoException e) {
             //e.printStackTrace();
            assertEquals(excepcion.getMessage(), e.getMessage());
        }
        
        try {
            assertEquals(3, solucionesBusqueda.busquedaBinariaIter(busqueda));
        } catch (ElementoNoEncontradoException e) {
             //e.printStackTrace();
            assertEquals(excepcion.getMessage(), e.getMessage());
        }
        
        try {
            assertEquals(3, solucionesBusqueda.busquedaBinariaRec(busqueda));
        } catch (ElementoNoEncontradoException e) {
             //e.printStackTrace();
            assertEquals(excepcion.getMessage(), e.getMessage());
 
        }
        
        int indice = Arrays.binarySearch(datos, 99);
        assertTrue(indice<0);
    }
    
   
    
}
