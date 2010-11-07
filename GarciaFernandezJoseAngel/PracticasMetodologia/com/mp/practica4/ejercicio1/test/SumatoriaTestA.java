package com.mp.practica4.ejercicio1.test;

import com.mp.practica4.ejercicio1.Sumatoria;

import junit.framework.TestCase;

public class SumatoriaTestA extends TestCase {

    public static void main(String[] args) {
    }

    public SumatoriaTestA(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testSuma() {
    	
        assertEquals(Sumatoria.sumaGaus(3), Sumatoria.sumaRec(3));
        assertEquals(Sumatoria.sumaGaus(100), Sumatoria.sumaRec(100));
        assertEquals(Sumatoria.sumaGaus(100), Sumatoria.sumaIter(100));
        assertEquals(Sumatoria.sumaRec(1000), Sumatoria.sumaIter(1000));
        assertEquals(Sumatoria.sumaGaus(1), Sumatoria.sumaRec(1));
    }

}
