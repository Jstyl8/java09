package com.mio.general.examen.ejer3.test;

import com.mio.general.examen.ejer3.Ordenacion;
import com.mio.utilidades.NumerosAleatorios;


import junit.framework.TestCase;

public class OrdenacionTestA extends TestCase {

	private String mensaje;

    public static void main(String[] args) {
    }

    public OrdenacionTestA(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }


    public void testVectorNormal() {

            Integer[] array = {
            		new Integer(3),new Integer(1),new Integer(2),new Integer(8),
                    new Integer(3),new Integer(5),new Integer(2),new Integer(8),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(4),new Integer(1),new Integer(7),new Integer(10),
                    new Integer(3),new Integer(6),new Integer(2),new Integer(8)};


            Integer[] temp = (Integer[])array.clone();

            Ordenacion.ordenacionPorInsercion(temp);

            mensaje ="Falla: No está ordenado";
            for (int i = 0, j = 1; j < temp.length; i++,j++) {
                assertTrue(mensaje,temp[i].intValue() <= temp[j].intValue());
            }

            temp = (Integer[])array.clone();

            Ordenacion.mergeSort(temp);

            for (int i = 0, j = 1; j < temp.length; i++,j++) {
                assertTrue(mensaje,temp[i].intValue() <= temp[j].intValue());
            }

            temp = (Integer[])array.clone();

            Ordenacion.sort(temp);

            for (int i = 0, j = 1; j < temp.length; i++,j++) {
                assertTrue(mensaje,temp[i].intValue() <= temp[j].intValue());
            }

            temp = (Integer[])array.clone();

            Ordenacion.quickSort(temp);

            for (int i = 0, j = 1; j < temp.length; i++,j++) {
                assertTrue(mensaje,temp[i].intValue() <= temp[j].intValue());
            }

    }

    public void testVectorAleatorio() {

        Integer[] array = new Integer[1000];

        NumerosAleatorios aleatorio = new NumerosAleatorios();

        for (int i = 0; i < array.length; i++) {
            array[i]=  new Integer(aleatorio.randomInt(-1000, 1000));
        }
        Integer[] temp = (Integer[])array.clone();

        Ordenacion.ordenacionPorInsercion(temp);

        mensaje ="Falla: No está ordenado";
        for (int i = 0, j = 1; j < temp.length; i++,j++) {
            assertTrue(mensaje,temp[i].intValue() <= temp[j].intValue());
        }

        temp = (Integer[])array.clone();

        Ordenacion.mergeSort(temp);

        for (int i = 0, j = 1; j < temp.length; i++,j++) {
            assertTrue(mensaje,temp[i].intValue() <= temp[j].intValue());
        }

        temp = (Integer[])array.clone();

        Ordenacion.sort(temp);

        for (int i = 0, j = 1; j < temp.length; i++,j++) {
            assertTrue(mensaje,temp[i].intValue() <= temp[j].intValue());
        }

        temp = (Integer[])array.clone();

        Ordenacion.quickSort(temp);

        for (int i = 0, j = 1; j < temp.length; i++,j++) {
            assertTrue(mensaje,temp[i].intValue() <= temp[j].intValue());
        }
    }
}
