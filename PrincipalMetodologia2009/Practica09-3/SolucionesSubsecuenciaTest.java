package com.mp.practica3.ejercicio2.test;

import com.mp.practica3.ejercicio2.SolucionesSubsecuencia;
import com.mp.practica3.ejercicio2.Subsecuencia;

import junit.framework.TestCase;

public class SolucionesSubsecuenciaTest extends TestCase {

    private Subsecuencia subsecuenciaProblema;

    protected void setUp() throws Exception {
        super.setUp();
    }

       public void testSubsecuenciaNormal() {

        int[] datos = { 1, 2, 3, 0, 0, 0, -1, 0 };

        subsecuenciaProblema = new Subsecuencia(datos);

        SolucionesSubsecuencia.SubsecuenciaCubica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 6);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 2);

        SolucionesSubsecuencia.SubsecuenciaCuadratica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 6);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 2);

        SolucionesSubsecuencia.SubsecuenciaLineal(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 6);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 2);

    }

    public void testSubsecuenciaCero() {

        int[] datos = { 0, 0, 0, 0, 0, 0, 0, 0 };

        subsecuenciaProblema = new Subsecuencia(datos);

        SolucionesSubsecuencia.SubsecuenciaCubica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 0);

        SolucionesSubsecuencia.SubsecuenciaCuadratica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 0);

        SolucionesSubsecuencia.SubsecuenciaLineal(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 0);

    }

    public void testSubsecuenciaNegativos() {

        int[] datos = { -1, -2, -3, -4, -5, -6, -7, -8 };

        subsecuenciaProblema = new Subsecuencia(datos);

        SolucionesSubsecuencia.SubsecuenciaCubica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 0);
        SolucionesSubsecuencia.SubsecuenciaCuadratica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 0);
        SolucionesSubsecuencia.SubsecuenciaLineal(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 0);

    }

    public void testSubsecuenciaIguales() {

        int[] datos = { 1, 1, 1, 1, 1, 1, 1, 1 };

        subsecuenciaProblema = new Subsecuencia(datos);

        SolucionesSubsecuencia.SubsecuenciaCubica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 8);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 7);

        SolucionesSubsecuencia.SubsecuenciaCuadratica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 8);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 7);

        SolucionesSubsecuencia.SubsecuenciaLineal(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 8);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 7);

    }

    public void testSubsecuenciaAleatorio() {

        int[] sumaMax = new int[3];
        int[] secIni = new int[3];
        int[] secFin = new int[3];

        subsecuenciaProblema = new Subsecuencia(1000, 10);

        SolucionesSubsecuencia.SubsecuenciaCubica(subsecuenciaProblema);
        sumaMax[0] = SolucionesSubsecuencia.sumaMax;
        secIni[0] = SolucionesSubsecuencia.secIni;
        secFin[0] = SolucionesSubsecuencia.secFin;

        SolucionesSubsecuencia.SubsecuenciaCuadratica(subsecuenciaProblema);
        sumaMax[1] = SolucionesSubsecuencia.sumaMax;
        secIni[1] = SolucionesSubsecuencia.secIni;
        secFin[1] = SolucionesSubsecuencia.secFin;

        SolucionesSubsecuencia.SubsecuenciaLineal(subsecuenciaProblema);
        sumaMax[2] = SolucionesSubsecuencia.sumaMax;
        secIni[2] = SolucionesSubsecuencia.secIni;
        secFin[2] = SolucionesSubsecuencia.secFin;

        assertTrue(sumaMax[0] == sumaMax[1]);
        assertTrue(sumaMax[1] == sumaMax[2]);

        assertTrue(secIni[0] == secIni[1]);
        assertTrue(secIni[1] == secIni[2]);

        assertTrue(secFin[0] == secFin[1]);
        assertTrue(secFin[1] == secFin[2]);

    }

}
