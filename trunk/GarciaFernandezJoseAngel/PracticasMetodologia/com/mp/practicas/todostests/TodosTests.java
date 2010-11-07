package com.mp.practicas.todostests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TodosTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.mp.practicas.todostests");
		//$JUnit-BEGIN$

		// Practica 2
        suite.addTestSuite(com.mp.practica2.ejercicio1.test.FigurasTest.class);
		suite.addTestSuite(com.mp.practica2.ejercicio4.test.MayorTest.class);
		suite.addTestSuite(com.mp.practica2.ejercicio5.test.EmpresaCobrosTestA.class);
        suite.addTestSuite(com.mp.practica2.ejercicio6.test.ResidenciaTestA.class);
        suite.addTestSuite(com.mp.practica2.ejercicio6.test.ResidenciaTestB.class);

        // Practica 3
        suite.addTestSuite(com.mp.practica3.ejercicio1.test.SolucionesPolinomioTest.class);
        suite.addTestSuite(com.mp.practica3.ejercicio2.test.SolucionesSubsecuenciaTest.class);
        suite.addTestSuite(com.mp.practica3.ejercicio3.test.SolucionesBusquedaTestA.class);

        // Practica 4
        suite.addTestSuite(com.mp.practica4.ejercicio1.test.FactorialTestA.class);
        suite.addTestSuite(com.mp.practica4.ejercicio1.test.FibonacciTestA.class);
        suite.addTestSuite(com.mp.practica4.ejercicio1.test.SumatoriaTestA.class);
        suite.addTestSuite(com.mp.practica4.ejercicio3.test.SolucionesCambioTestA.class);
        suite.addTestSuite(com.mp.practica4.ejercicio4.test.SolucionesPolinomioTestA.class);
        suite.addTestSuite(com.mp.practica4.ejercicio5.test.SolucionesSubsecuenciaTestA.class);
        suite.addTestSuite(com.mp.practica4.ejercicio6.test.SolucionesBusquedaTestA.class);

        // Practica 5

        suite.addTestSuite(com.mp.practica5.ejercicio1.test.FigurasTest.class);
        suite.addTestSuite(com.mp.practica5.ejercicio2.test.OrdenacionTestA.class);
        suite.addTestSuite(com.mp.practica5.ejercicio2.test.OrdenacionTestB.class);

        // Poner bajo comentario el ejercicio no elegido

        Class cls = null;
        try {
            cls = Class.forName("com.mp.practica5.ejercicio3.test.SubsecuenciaRecDVTest");
            suite.addTestSuite(com.mp.practica5.ejercicio3.test.SubsecuenciaRecDVTest.class);

        } catch (ClassNotFoundException e) {
        	System.out.println(e);
        }


        try {
            cls = Class.forName("com.mp.practica5.ejercicio4.test.MergeSortTest");
            suite.addTestSuite(com.mp.practica5.ejercicio4.test.MergeSortTest.class);
        } catch (ClassNotFoundException e) {
        	System.out.println(e);
        }
        
        suite.addTestSuite(com.mp.practica5.ejercicio5.test.BarajaTest.class);
        
        // Practica 6
        suite.addTestSuite(com.mp.practica6.ejercicio1.test.CambioTestA.class);
        suite.addTestSuite(com.mp.practica6.ejercicio2.test.CambioVorazVZTestA.class);
        suite.addTestSuite(com.mp.practica6.ejercicio3.test.LaberintoTestA.class);


        // Practica 7
        suite.addTestSuite(com.mp.practica7.ejercicio1.test.PilaVecTest.class);
        suite.addTestSuite(com.mp.practica7.ejercicio1.test.PilaListaTest.class);
        suite.addTestSuite(com.mp.practica7.ejercicio2.test.ColaVecTest.class);
        suite.addTestSuite(com.mp.practica7.ejercicio2.test.ColaListaTest.class);
        suite.addTestSuite(com.mp.practica7.ejercicio3.test.EvaluadorTest.class);
        suite.addTestSuite(com.mp.practica7.ejercicio4.test.ParadaTaxisTest.class);
        suite.addTestSuite(com.mp.practica7.ejercicio5.test.ArrayListaTest.class);
        suite.addTestSuite(com.mp.practica7.ejercicio6.test.ResidenciaTestA.class);
        suite.addTestSuite(com.mp.practica7.ejercicio6.test.ResidenciaTestB.class);

        // Practica 8
        suite.addTestSuite(com.mp.practica8.ejercicio1.test.UtilidadDirectoriosTest.class);
        suite.addTestSuite(com.mp.practica8.ejercicio2.test.ListadoNotasTest.class);
        suite.addTestSuite(com.mp.practica8.ejercicio3.test.ImagenTest.class);
        suite.addTestSuite(com.mp.practica8.ejercicio4.test.ResidenciaTestA.class);
        suite.addTestSuite(com.mp.practica8.ejercicio4.test.ResidenciaTestB.class);
        suite.addTestSuite(com.mp.practica8.ejercicio4.test.ResidenciaTestC.class); 

        
		return suite;
	}

}
