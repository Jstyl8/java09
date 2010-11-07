package com.mp.practica8.ejercicio2.test;

import java.io.File;

import com.mp.practica8.ejercicio2.ListadoNotas;

import junit.framework.TestCase;

public class ListadoNotasTest extends TestCase {

    String directorioEntrada;
    String coeficientes;
    String notas;
    String notasFinales;

    public ListadoNotasTest(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();
        directorioEntrada= System.getProperty("user.dir");

        directorioEntrada = directorioEntrada + File.separator +
		   "PracticasMetodologia" + File.separator +
		   "com" + File.separator +
		   "mp" + File.separator +
		   "practica8" + File.separator +
		   "ejercicio2" + File.separator +
		   "test" + File.separator;

        coeficientes = directorioEntrada + "coeficientes.txt";;
        notas = directorioEntrada + "notas.txt";
        notasFinales = directorioEntrada + "notasfinales.txt";
    }

    public void testLeerCoeficientes() {

        ListadoNotas listadoNotas = new ListadoNotas();

        listadoNotas.leerCoeficientes(coeficientes);

        assertEquals(0.65, listadoNotas.getCoeficienteTeoria(), 0.001);
        assertEquals(0.35, listadoNotas.getCoeficientePractica(), 0.001);
        assertEquals(5.0, listadoNotas.getAprobado(), 0.001);
        assertEquals(7.0, listadoNotas.getNotable(), 0.001);
        assertEquals(8.0, listadoNotas.getSobresaliente(), 0.001);
    }

    public void testProcesarNotas() {

        ListadoNotas listadoNotas = new ListadoNotas();
        listadoNotas.leerCoeficientes(coeficientes);
        listadoNotas.procesarNotas(notas, notasFinales);

        assertEquals(1, listadoNotas.getSuspensos());
        assertEquals(1, listadoNotas.getAprobados());
        assertEquals(0, listadoNotas.getNotables());
        assertEquals(1, listadoNotas.getSobresalientes());
        assertEquals(3, listadoNotas.getNumeroAlumnos());
        assertEquals(6.05, listadoNotas.getNotaMedia(), 0.01);
    }
}
