package com.mp.practica7.ejercicio3.test;

import com.mp.practica7.ejercicio3.Evaluador;

import junit.framework.TestCase;

public class EvaluadorTest extends TestCase {

	private String mensaje;
	private Evaluador evaluador;

	protected void setUp() throws Exception {
		super.setUp();
		evaluador = new Evaluador();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}


	public void testParser() {

		String expresion= "  22 + 2 ";

		String[] array = evaluador.parser(expresion);

		String salida="";

		for (int i = 0; i < array.length; i++) {
			 salida += array[i];
		}
		mensaje = "Debe quitar los blancos";
		assertEquals(mensaje, "22+2", salida);

		expresion = salida;

		array = evaluador.parser(expresion);

		salida="";

		for (int i = 0; i < array.length; i++) {
			 salida += array[i];
		}
		mensaje = "Debe obtener la misma cadena";
		assertEquals(mensaje, expresion, salida);

	}

	public void testPostfija() {

		String[] expresion1 = {"3","2","+"};

		mensaje = "Resultado debe ser 5";
		assertEquals(mensaje,5, evaluador.postfija(expresion1));

		String[] expresion2 = {"3","3","+","2","/"};

		mensaje = "Resultado debe ser 3";
		assertEquals(mensaje,3, evaluador.postfija(expresion2));

	}

	public void testInfijaAPosfija()  {

		String[] expresion= {"3","+","2"};

		String[] array = null;

            try {
                array = evaluador.infijaAPosfija(expresion);
                String[] salida={"3","2","+"};


                for (int i = 0; i < salida.length; i++) {
                	mensaje = "Deben coincidir";
                    assertEquals(mensaje,salida[i], array[i]);
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        String[] expresion1= {"(","3","+","2"};

        String[] array1 = null;
        try {
            array1 = evaluador.infijaAPosfija(expresion1);
            String[] salida1={"3","2","+"};
            mensaje = "No deben coincidir";
            for (int i = 0; i < salida1.length; i++) {
                assertEquals(mensaje, salida1[i], array1[i]);
            }
            fail(mensaje);
        } catch (Exception e) {
            System.out.println(e);
        }

        String[] expresion2= {"(","3","+","2",")",")"};

        String[] array2 = null;
        try {
            array2 = evaluador.infijaAPosfija(expresion2);
            String[] salida2={"3","2","+"};
            mensaje = "Deben coincidir";
            for (int i = 0; i < salida2.length; i++) {
                assertEquals(mensaje, salida2[i], array2[i]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        String[] expresion3= {"(","(","3","+","2",")"};

        String[] array3 = null;
        try {
            array3 = evaluador.infijaAPosfija(expresion3);
            String[] salida3={"3","2","+"};
        	mensaje = "No deben coincidir";
            for (int i = 0; i < salida3.length; i++) {
                assertEquals(mensaje, salida3[i], array3[i]);
            }
            fail(mensaje);
        } catch (Exception e) {
            System.out.println(e);
        }

        String[] expresion4= {"3","p","2"};

        String[] array4 = null;

            try {
                array4 = evaluador.infijaAPosfija(expresion4);
                String[] salida4={"3","2","+"};
                mensaje = "No deben coincidir";
                for (int i = 0; i < salida4.length; i++) {
                    assertEquals(mensaje, salida4[i], array4[i]);
                }
                fail(mensaje);

            } catch (Exception e) {
                System.out.println(e);
            }

	}


	public void testEvaluar()   {

		String expresion= "2+3";

		try {
			mensaje = "Resultado debe ser 5";
            assertEquals(mensaje,5, evaluador.evaluar(expresion));
        } catch (Exception e) {
            e.printStackTrace();
        }

		expresion= "(2+3)";

		try {
			mensaje = "Resultado debe ser 5";
            assertEquals(mensaje,5, evaluador.evaluar(expresion));
        } catch (Exception e) {
            System.out.println(e);
        }

		expresion= "((2+3))";

		try {
			mensaje = "Resultado debe ser 5";
            assertEquals(mensaje,5, evaluador.evaluar(expresion));
        } catch (Exception e) {

            System.out.println(e);
        }

        expresion= "(2-3)* 2";
        try {
        	mensaje = "Resultado debe ser -2";
            assertEquals(mensaje,-2, evaluador.evaluar(expresion));
        } catch (Exception e) {
            System.out.println(e);
        }

        expresion= "(2-3)* 2 / 2";
        try {
        	mensaje = "Resultado debe ser -1";
            assertEquals(mensaje,-1, evaluador.evaluar(expresion));
        } catch (Exception e) {
            System.out.println(e);
        }

        expresion= "(2-3)* 2 / 1 + 2";
        try {
        	mensaje = "Resultado debe ser 0";
            assertEquals(mensaje,0, evaluador.evaluar(expresion));
        } catch (Exception e) {

            System.out.println(e);
        }

        expresion= " 2-3* 2 / 1 + 2";
        try {
        	mensaje = "Resultado debe ser -2";
            assertEquals(mensaje,-2, evaluador.evaluar(expresion));
        } catch (Exception e) {
            System.out.println(e);
        }

        expresion= "((2+3)";

        try {
        	mensaje = "Resultado debe ser 5";
            assertEquals(mensaje,5, evaluador.evaluar(expresion));
        } catch (Exception e) {

            System.out.println(e);
            for (int i = 0; i < 2; i++) {
                System.out.println(e.getStackTrace()[i]);
            }
        }
	}




}
