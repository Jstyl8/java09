package com.mp.practica7.ejercicio3;

import java.util.StringTokenizer;

import com.mp.estructurasdatos.ColaVec;
import com.mp.estructurasdatos.Pila;
import com.mp.estructurasdatos.PilaLista;
import com.mp.estructurasdatos.PilaVec;
import com.mp.excepciones.DesbordamientoInferiorException;;

public class Evaluador {

    private final char SUMAR = '+', RESTAR = '-';

    private final char MULTIPLICAR = '*', DIVIDIR = '/';

    private Pila pila;

    public Evaluador() {
       // Terminar
    }

    public int evaluar(String expresion) throws Exception {

        int resultado;
        String[] cparser = parser(expresion);
        String[] cpostfija = infijaAPosfija(cparser);
        resultado = postfija(cpostfija);

        return resultado;
    }

    public int postfija(String[] entrada) {

    	// Terminar
    }

    public String[] infijaAPosfija(String[] entrada) throws Exception {

    	// Terminar

    }

    public String[] parser(String entrada) {

    	// Terminar

    }

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

    private boolean esOperador(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token
                .equals("/"));
    }
}
