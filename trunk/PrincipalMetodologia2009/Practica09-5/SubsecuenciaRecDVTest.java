package com.mp.practica5.ejercicio3.test;

import com.mp.practica5.ejercicio3.SubsecuenciaRecDV;
import com.mp.practica5.ejercicio3.Subsecuencia;

import junit.framework.TestCase;

public class SubsecuenciaRecDVTest extends TestCase {

    private Subsecuencia subsecuenciaProblema;

    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testSubsecuenciaNormal() {

        int[] datos = { 1, 2, 3, 0, 0, 0, -1, 0 };

        subsecuenciaProblema = new Subsecuencia(datos);

        SubsecuenciaRecDV subsecuenciaRecDV = new SubsecuenciaRecDV(
                subsecuenciaProblema);

        subsecuenciaRecDV.resolver();
        assertTrue(subsecuenciaRecDV.getSumaMax() == 6);
        assertTrue(subsecuenciaRecDV.getSecIni() == 0);
        assertTrue(subsecuenciaRecDV.getSecFin() == 2);

    }

    public void testSubsecuenciaCero() {

        int[] datos = { 0, 0, 0, 0, 0, 0, 0, 0 };

        subsecuenciaProblema = new Subsecuencia(datos);

        SubsecuenciaRecDV subsecuenciaRecDV = new SubsecuenciaRecDV(
                subsecuenciaProblema);

        subsecuenciaRecDV.resolver();
        assertTrue(subsecuenciaRecDV.getSumaMax() == 0);
        assertTrue(subsecuenciaRecDV.getSecIni() == 0);
        assertTrue(subsecuenciaRecDV.getSecFin() == 0);

    }

    public void testSubsecuenciaNegativos() {

        int[] datos = { -1, -2, -3, -4, -5, -6, -7, -8 };

        subsecuenciaProblema = new Subsecuencia(datos);

        SubsecuenciaRecDV subsecuenciaRecDV = new SubsecuenciaRecDV(
                subsecuenciaProblema);

        subsecuenciaRecDV.resolver();
        assertTrue(subsecuenciaRecDV.getSumaMax() == 0);
        assertTrue(subsecuenciaRecDV.getSecIni() == 0);
        assertTrue(subsecuenciaRecDV.getSecFin() == 0);

    }

    public void testSubsecuenciaIguales() {

        int[] datos = { 1, 1, 1, 1, 1, 1, 1, 1 };

        subsecuenciaProblema = new Subsecuencia(datos);

        SubsecuenciaRecDV subsecuenciaRecDV = new SubsecuenciaRecDV(
                subsecuenciaProblema);

        subsecuenciaRecDV.resolver();
        assertTrue(subsecuenciaRecDV.getSumaMax() == 8);
        assertTrue(subsecuenciaRecDV.getSecIni() == 0);
        assertTrue(subsecuenciaRecDV.getSecFin() == 7);

    }

}
