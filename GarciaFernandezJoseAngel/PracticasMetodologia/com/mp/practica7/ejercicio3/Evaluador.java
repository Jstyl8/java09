//
// Universidad de Almería
// Ingeniería Técnica de Informática de Sistemas
// Fuente Java según Plantilla
//
// PRACTICA : Practica 7, Ejercicio 3
// ASIGNATURA : Metodologia de la Programación
//
package com.mp.practica7.ejercicio3;

import java.util.StringTokenizer;

import com.mp.estructurasdatos.ColaVec;
import com.mp.estructurasdatos.Pila;
import com.mp.estructurasdatos.PilaLista;
import com.mp.estructurasdatos.PilaVec;
import com.mp.excepciones.DesbordamientoInferiorException;

/**
 * Clase que representa una calculadora
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 11/05/2009
 */
public class Evaluador {

	/**
	 * Variable final de tipo caracter que representa la suma
	 */
	private final char SUMAR = '+';
	/**
	 * Variable final de tipo caracter que representa la resta
	 */
	private final char RESTAR = '-';
	/**
	 * Variable final de tipo caracter que representa la multiplicacion
	 */
	private final char MULTIPLICAR = '*';
	/**
	 * Variable final de tipo caracter que representa la division
	 */
	private final char DIVIDIR = '/';

	/**
	 * Variable que representa la pila que se usara para el almacenamiento y
	 * conversion
	 */
	private Pila pila;

	/**
	 * Genera un objeto de tipo Evaluador
	 */
	public Evaluador() {
		pila = new PilaVec();
	}

	/**
	 * Metodo que realiza la evaluacion de una expresion
	 * 
	 * @param expresion
	 *            la expresion a evaluar
	 * @return el resultado de evaluar la expresion
	 * @throws Exception
	 *             si se produce algun tipo de expcepcion
	 */
	public int evaluar(String expresion) throws Exception {

		int resultado;
		String[] cparser = parser(expresion);
		String[] cpostfija = infijaAPosfija(cparser);
		resultado = postfija(cpostfija);

		return resultado;
	}

	/**
	 * Metodo que calcula la expresion postfija a evaluar
	 * 
	 * @param entrada
	 *            la expresion postFija a evaluar
	 * @return el resultado de evaluar la epresion postFija
	 */
	public int postfija(String[] entrada) {
		try {
			pila.vaciar();
			int der = 0, izq = 0;
			for (int i = 0; i < entrada.length; i++) {
				if (esOperador(entrada[i])) {
					der = Integer.parseInt((String) pila.cimaYDesapilar());
					izq = Integer.parseInt((String) pila.cimaYDesapilar());
					pila.apilar(Integer.toString(evaluarOperacion(entrada[i]
							.charAt(0), izq, der)));
				} else
					pila.apilar(entrada[i]);
			}
			return Integer.parseInt((String) pila.cimaYDesapilar());
		} catch (DesbordamientoInferiorException e) {
			e.printStackTrace();
			return 0;
		}

	}

	/**
	 * Metodo que convierte una expresion infija en postfija
	 * 
	 * @param entrada
	 *            la expresion a convertir en posFija
	 * @return la expresion postfija
	 * @throws Exception
	 *             si se produce una excepcion en el proceso
	 */
	public String[] infijaAPosfija(String[] entrada) throws Exception {
		ColaVec cola = new ColaVec();
		pila.vaciar();
		for (int i = 0; i < entrada.length; i++) {
			if (esOperador(entrada[i])) {
				if (entrada[i].equals("+") || entrada[i].equals("-")) {
					while (!pila.esVacia()
							&& !((String) pila.cima()).equals("(")) {
						cola.insertar((String) pila.cimaYDesapilar());
					}
					pila.apilar(entrada[i]);
				} else {
					while (!pila.esVacia()
							&& (((String) pila.cima()).equals("*") || ((String) pila
									.cima()).equals("/"))) {
						cola.insertar((String) pila.cimaYDesapilar());
					}
					pila.apilar(entrada[i]);
				}
			} else if (entrada[i].equals("("))
				pila.apilar(entrada[i]);
			else if (entrada[i].equals(")")) {
				while (!((String) pila.cima()).equals("(") && !pila.esVacia()) {
					cola.insertar((String) pila.cimaYDesapilar());
				}
				if (!pila.esVacia())
					pila.cimaYDesapilar();
			} else {
				try {
					Integer.parseInt(entrada[i]);
				} catch (Exception e) {
					cola.insertar(0);
					continue;
				}
				cola.insertar(entrada[i]);
			}
		}
		while (!pila.esVacia()) {
			if (!((String) pila.cima()).equals("(")) {
				cola.insertar((String) pila.cimaYDesapilar());
			} else {
				pila.cimaYDesapilar();
				throw new Exception();
			}
		}
		String[] aux = new String[cola.tamaño()];
		for (int i = 0; !cola.esVacia(); i++)
			aux[i] = (String) cola.quitarPrimero();
		return aux;

	}

	/**
	 * Metodo que realiza la division de un String en tokens
	 * 
	 * @param entrada
	 *            String a dividir en tokens
	 * @return el String de entrada dividido en tokens
	 */
	public String[] parser(String entrada) {
		StringTokenizer tokens = new StringTokenizer(entrada, "+-*/ ()", true);
		ColaVec cola = new ColaVec();

		while (tokens.hasMoreElements()) {
			String temp = tokens.nextToken();
			if (!(temp.equals(" ")))
				cola.insertar(temp);
		}

		String[] stringTok = new String[cola.tamaño()];
		for (int i = 0; i < stringTok.length; i++) {
			try {
				stringTok[i] = (String) cola.quitarPrimero();
			} catch (DesbordamientoInferiorException e) {
				e.getStackTrace();
			}
		}
		return stringTok;
	}

	/**
	 * Metodo que realiza una operacion aritmetica en funcion de sus parametros
	 * 
	 * @param operacion
	 *            caracter que indica la operacion
	 * @param op1
	 *            operando 1
	 * @param op2
	 *            operando 2
	 * @return el resultado de evaluar op1 y op2 dependiendo de operacion
	 */
	private int evaluarOperacion(char operacion, int op1, int op2) {
		int resultado = 0;

		switch (operacion) {
		case SUMAR:
			resultado = op1 + op2;
			break;
		case RESTAR:
			resultado = op1 - op2;
			break;
		case MULTIPLICAR:
			resultado = op1 * op2;
			break;
		case DIVIDIR:
			resultado = op1 / op2;
		}
		return resultado;
	}

	/**
	 * Metodo que comprueba si el token es un operador
	 * 
	 * @param token
	 *            el string a evaluar
	 * @return true si es operador y false si no lo es
	 */
	private boolean esOperador(String token) {
		return (token.equals("+") || token.equals("-") || token.equals("*") || token
				.equals("/"));
	}
}
