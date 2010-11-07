package com.mp.practica7.ejercicio4.test;

import com.mp.excepciones.DesbordamientoInferiorException;
import com.mp.practica7.ejercicio4.ParadaTaxis;
import com.mp.practica7.ejercicio4.Taxi;

import junit.framework.TestCase;

public class ParadaTaxisTest extends TestCase {

	private String mensaje;
    private Taxi taxi1;
    private Taxi taxi2;
    private Taxi taxi3;
    private Taxi taxi4;

    private ParadaTaxis parada;

    public ParadaTaxisTest(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();

        taxi1 = new Taxi(111, false);
        taxi2 = new Taxi(222, false);
        taxi3 = new Taxi(333, true);
        taxi4 = new Taxi(444, false);

        parada = new ParadaTaxis("El alquian", "Calle principal 12");
    }

    public void testEntradaSalidaTaxi() {

        mensaje = "Deben ser 0 taxis en la parada";
    	assertEquals(mensaje, parada.numeroTaxis(), 0);

        parada.entradaTaxi(taxi1);

        parada.entradaTaxi(taxi2);

        parada.entradaTaxi(taxi3);

        mensaje = "Deben ser 3 taxis en la parada";
        assertTrue(parada.numeroTaxis() == 3);

        try {
            Taxi taxi = parada.salidaTaxi();
            mensaje = "Debe ser el mismo taxi";
            assertEquals(mensaje, taxi, taxi1);
        } catch (DesbordamientoInferiorException e) {
            e.printStackTrace();
        }

        mensaje = "Deben ser 2 taxis en la parada";
        assertEquals(mensaje, parada.numeroTaxis(), 2);

        try {
            Taxi taxi = parada.primerTaxi();
            mensaje = "Debe ser el mismo taxi";
            assertEquals(mensaje, taxi, taxi2);
        } catch (DesbordamientoInferiorException e) {
            e.printStackTrace();
        }

        mensaje = "Deben ser 2 taxis en la parada";
        assertEquals(mensaje, parada.numeroTaxis(), 2);

    }

    public void testMinusvalidosTaxi() {

        parada.entradaTaxi(taxi1);
        parada.entradaTaxi(taxi2);
        parada.entradaTaxi(taxi3);
        parada.entradaTaxi(taxi4);
        Taxi taxi5 = new Taxi(555, true);
        parada.entradaTaxi(taxi5);

        Taxi taxi = null;
        try {
            taxi = parada.minusvalidoTaxi();
        } catch (DesbordamientoInferiorException e) {
            e.printStackTrace();
        }

        mensaje = "Deben ser el taxi 3";
        assertEquals(mensaje, taxi, taxi3);
        assertTrue(parada.numeroTaxis() == 4);

        try {
            taxi = parada.minusvalidoTaxi();
        } catch (DesbordamientoInferiorException e) {
            e.printStackTrace();
        }

        mensaje = "Deben ser el taxi 5";
        assertEquals(mensaje, taxi, taxi5);
        assertTrue(parada.numeroTaxis() == 3);

        try {
            taxi = parada.minusvalidoTaxi();
        } catch (DesbordamientoInferiorException e) {
            e.printStackTrace();
        }

        mensaje = "Deben ser null";
        assertNull(mensaje, taxi);
        mensaje = "Siguen siendo 3 taxis en la parada";
        assertTrue(mensaje,parada.numeroTaxis() == 3);


        try {
        	mensaje = "Debe ser el taxi1";
            assertEquals(mensaje, parada.salidaTaxi(), taxi1);
        } catch (DesbordamientoInferiorException e) {
           e.printStackTrace();
        }
    }

    public void testListadoTaxis() {

         parada.entradaTaxi(taxi1);
         parada.entradaTaxi(taxi2);
         parada.entradaTaxi(taxi3);
         parada.entradaTaxi(taxi4);

         try {
			//System.out.print(parada.listado());
        	mensaje = "Deben aparecer en el listado las licencias";
			assertTrue(mensaje, parada.listado().contains("111"));
			assertTrue(mensaje, parada.listado().contains("222"));
			assertTrue(mensaje, parada.listado().contains("333"));
			assertTrue(mensaje, parada.listado().contains("444"));

		} catch (DesbordamientoInferiorException e) {
			e.printStackTrace();
		}
    }
}
