package com.mp.practica4.ejercicio4.test;

import com.mp.practica4.ejercicio4.Polinomio;
import com.mp.practica4.ejercicio4.SolucionesPolinomio;

import junit.framework.TestCase;

public class SolucionesPolinomioTestA extends TestCase {

    public SolucionesPolinomioTestA(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();

    }

    public void testPolinomioNormal() {

        Polinomio polinomioProblema = new Polinomio(2, 2.0);
        double[] coeficientes = { 2.0, 2.0, 2.0 };
        polinomioProblema.setCoeficientes(coeficientes);

        assertTrue(SolucionesPolinomio.polinomioLineal(polinomioProblema) == 14);
        assertTrue(SolucionesPolinomio.polinomioCuadratico(polinomioProblema) == 14);
        assertTrue(SolucionesPolinomio.polinomioNLogaritmico(polinomioProblema) == 14);

    }

    public void testPolinomioVariableCero() {
    	
        Polinomio polinomioProblema = new Polinomio(2, 0.0);
        double[] coeficientes = { 2.0, 2.0, 2.0 };
        polinomioProblema.setCoeficientes(coeficientes);

        assertTrue(SolucionesPolinomio.polinomioLineal(polinomioProblema) == 2);
        assertTrue(SolucionesPolinomio.polinomioCuadratico(polinomioProblema) == 2);
        assertTrue(SolucionesPolinomio.polinomioNLogaritmico(polinomioProblema) == 2);

    }

    public void testPolinomioCoeficientesCero() {
    	
        Polinomio polinomioProblema = new Polinomio(2, 2.0);
        double[] coeficientes = { 0.0, 0.0, 0.0 };
        polinomioProblema.setCoeficientes(coeficientes);

        assertTrue(SolucionesPolinomio.polinomioLineal(polinomioProblema) == 0);
        assertTrue(SolucionesPolinomio.polinomioCuadratico(polinomioProblema) == 0);
        assertTrue(SolucionesPolinomio.polinomioNLogaritmico(polinomioProblema) == 0);

    }

    public void testPolinomioCoeficientesNegativos() {

        Polinomio polinomioProblema = new Polinomio(2, 2.0);
        double[] coeficientes = { -2.0, -2.0, -2.0 };
        polinomioProblema.setCoeficientes(coeficientes);

        assertTrue(SolucionesPolinomio.polinomioLineal(polinomioProblema) == -14.0);
        assertTrue(SolucionesPolinomio.polinomioCuadratico(polinomioProblema) == -14.0);
        assertTrue(SolucionesPolinomio.polinomioNLogaritmico(polinomioProblema) == -14.0);

    }

}
