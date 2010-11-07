package com.mp.practica4.ejercicio5.test;

import com.mp.practica4.ejercicio5.SolucionesSubsecuencia;
import com.mp.practica4.ejercicio5.Subsecuencia;

import junit.framework.TestCase;

public class SolucionesSubsecuenciaTestA extends TestCase {

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

        SolucionesSubsecuencia.SubsecuenciaNLogaritmica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 6);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertEquals(2, SolucionesSubsecuencia.secFin);

    }

    public void testSubsecuenciaCero() {

        int[] datos = { 0, 0, 0, 0, 0, 0, 0, 0 };

        subsecuenciaProblema = new Subsecuencia(datos);

        SolucionesSubsecuencia.SubsecuenciaCubica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == -1);
        assertTrue(SolucionesSubsecuencia.secFin == -1);

        SolucionesSubsecuencia.SubsecuenciaCuadratica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == -1);
        assertTrue(SolucionesSubsecuencia.secFin == -1);

        SolucionesSubsecuencia.SubsecuenciaLineal(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == -1);
        assertTrue(SolucionesSubsecuencia.secFin == -1);

        SolucionesSubsecuencia.SubsecuenciaNLogaritmica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == -1);
        assertTrue(SolucionesSubsecuencia.secFin == -1);

    }

    public void testSubsecuenciaNegativos() {

        int[] datos = { -1, -2, -3, -4, -5, -6, -7, -8 };

        subsecuenciaProblema = new Subsecuencia(datos);

        SolucionesSubsecuencia.SubsecuenciaCubica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == -1);
        assertTrue(SolucionesSubsecuencia.secFin == -1);

        SolucionesSubsecuencia.SubsecuenciaCuadratica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == -1);
        assertTrue(SolucionesSubsecuencia.secFin == -1);

        SolucionesSubsecuencia.SubsecuenciaLineal(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == -1);
        assertTrue(SolucionesSubsecuencia.secFin == -1);

        SolucionesSubsecuencia.SubsecuenciaNLogaritmica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 0);
        assertTrue(SolucionesSubsecuencia.secIni == -1);
        assertTrue(SolucionesSubsecuencia.secFin == -1);

    }

    public void testSubsecuenciaIguales() {

        int[] datos = { 1, 1, 1, 1 };

        subsecuenciaProblema = new Subsecuencia(datos);

        SolucionesSubsecuencia.SubsecuenciaCubica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 4);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 3);

        SolucionesSubsecuencia.SubsecuenciaCuadratica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 4);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 3);

        SolucionesSubsecuencia.SubsecuenciaLineal(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 4);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 3);

        SolucionesSubsecuencia.SubsecuenciaNLogaritmica(subsecuenciaProblema);
        assertTrue(SolucionesSubsecuencia.sumaMax == 4);
        assertTrue(SolucionesSubsecuencia.secIni == 0);
        assertTrue(SolucionesSubsecuencia.secFin == 3);

    }

    public void testSubsecuenciaAleatorio() {

        for (int i = 0; i < 100; i++) {

            int[] sumaMax = new int[4];
            int[] secIni = new int[4];
            int[] secFin = new int[4];

            subsecuenciaProblema = new Subsecuencia(10, 10);

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

            SolucionesSubsecuencia
                    .SubsecuenciaNLogaritmica(subsecuenciaProblema);
            sumaMax[3] = SolucionesSubsecuencia.sumaMax;
            secIni[3] = SolucionesSubsecuencia.secIni;
            secFin[3] = SolucionesSubsecuencia.secFin;

            assertTrue(sumaMax[0] == sumaMax[1]);
            assertTrue(sumaMax[1] == sumaMax[2]);
            assertTrue(sumaMax[2] == sumaMax[3]);

            assertTrue(secIni[0] == secIni[1]);
            assertTrue(secIni[1] == secIni[2]);
            assertTrue(secIni[2] == secIni[3]);

            assertTrue(secFin[0] == secFin[1]);
            assertTrue(secFin[1] == secFin[2]);
            assertTrue(secFin[2] == secFin[3]);
        }

    }
}
