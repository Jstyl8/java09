package com.mio.meto.Calculadora;

import java.util.StringTokenizer;

import com.mio.estructurasdatos.Cola;
import com.mio.estructurasdatos.ColaVec;
import com.mio.estructurasdatos.Pila;
import com.mio.estructurasdatos.PilaVec;
import com.mio.excepciones.DesbordamientoInferiorException;

/**
 * @author Angel Nieto
 * @category Clase que implementa un evaluador para una calculadora
 */
public class Evaluador {

	/**
	 * Variables privadas globales de tipo caracter que almacenan los operadores
	 */
	private final char SUMAR = '+', RESTAR = '-';
	/**
	 * Variables privadas globales de tipo caracter que almacenan los operadores
	 */
	private final char MULTIPLICAR = '*', DIVIDIR = '/';
	/**
	 * Variable privada de tipo Pila que almacena una Pila
	 */
	private Pila pila;

	/**
	 * Metodo contructor de la clase Evaluador
	 */
	public Evaluador() {
		pila = new PilaVec();
	}

	/**
	 * Metodo que se usa para evaluar las expresiones
	 *
	 * @param expresion
	 *            Valor de tipo String que almacena la expresion a evaluar
	 * @return Valor de tipo entero que almacena el resultado de evaluar la
	 *         expresion
	 * @throws Exception
	 *             Si ocurre algo que no debe ocurrir salta la excepcion
	 */
	public int evaluar(String expresion) throws Exception {

		int resultado;
		String[] cparser = parser(expresion);
		String[] cpostfija = infijaAPosfija(cparser);
		resultado = postfija(cpostfija);

		return resultado;
	}

	/**
	 * Metodo que obtiene el resultado de evaluar una expresion postfija
	 *
	 * @param entrada
	 *            Vector con la expresion que sera evaluada que almacena valores
	 *            de tipo String
	 * @return Valor de tipo entero que almacena el resultado de evaluar la
	 *         expresion
	 *
	 */
	public int postfija(String[] entrada) {

		int op1 = 0, op2 = 0, solucion;
		pila.vaciar();
		for (int i = 0; i < entrada.length; i++) {
			if (esOperador(entrada[i])) {
				try {
					op2 = Integer.parseInt((String) pila.cimaYDesapilar());
					op1 = Integer.parseInt((String) pila.cimaYDesapilar());
				} catch (DesbordamientoInferiorException e) {
					e.printStackTrace();
				}
				solucion = evaluarOperacion(entrada[i].charAt(0), op1, op2);
				pila.apilar(String.valueOf(solucion));

			} else
				pila.apilar(entrada[i]);
		}
		int resultado = 0;
		try {
			resultado = Integer.parseInt((String) pila.cimaYDesapilar());
		} catch (DesbordamientoInferiorException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	/**
	 * Metodo que pasa una expresion infija a postfija
	 *
	 * @param entrada
	 *            Vector con la expresion que sera transformada a postfija que
	 *            almacena valores de tipo String
	 * @return Vector con la expresion en forma posfija que tiene valores de
	 *         tipo String
	 * @exception Exception
	 *                Se lanza la excepcion si hay algun problema
	 */
	public String[] infijaAPosfija(String[] entrada) throws Exception {

		Cola cola = new ColaVec();
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
				Integer aux = new Integer(entrada[i]);
				cola.insertar(aux);
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
		String[] auxiliar = new String[cola.tamaño()];
		for (int i = 0; !cola.esVacia(); i++)
			auxiliar[i] = (String) cola.quitarPrimero();
		return auxiliar;

	}

	/**
	 * Metodo que pasa una entrada normal a una expresion infija en tokens
	 *
	 * @param entrada
	 *            Parametro de tipo Stirng que almacena la expresion de entrada
	 * @return Vector con la expresion separada en tokens que almacena valores
	 *         de tipo String
	 */
	public String[] parser(String entrada) {

		StringTokenizer token = new StringTokenizer(entrada, "+-*/ ()", true);
		Cola cola = new ColaVec();

		int numeroToken = token.countTokens();
		for (int i = 0; i < numeroToken; i++) {
			String temporal = token.nextToken();
			if (!temporal.equals(" ")) {
				cola.insertar(temporal);
			}
		}
		String[] auxiliar = new String[cola.tamaño()];
		int i = 0;
		while (!cola.esVacia()) {
			try {
				auxiliar[i] = (String) cola.quitarPrimero();
			} catch (DesbordamientoInferiorException e) {
				e.printStackTrace();
			}
			i++;
		}
		return auxiliar;

	}

	/**
	 * Metodo privado que evalua dos operandos segun la operacion que queremos
	 * realizar
	 *
	 * @param operacion
	 *            Parametro de tipo caracter que almacena el operador para la
	 *            operacion
	 * @param op1
	 *            Parametro de tipo entero que almacena el primer operando
	 * @param op2
	 *            Parametro de tipo entero que almacena el segundo operando
	 * @return Valor de tipo entero que almacena el resultado de evaluar los
	 *         operandos
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
	 * Metodo privado que evalua si la entrada es un operador
	 *
	 * @param token
	 *            Parametro de tipo String que puede ser operando o no
	 * @return Valor de tipo booleano que almacena true si el token es un
	 *         operando y false si no lo es
	 */
	private boolean esOperador(String token) {
		return (token.equals("+") || token.equals("-") || token.equals("*") || token
				.equals("/"));
	}
}


