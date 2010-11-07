package com.mio.meto.Calculadora;

import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculadora {

    private StringTokenizer expr;
    private Stack pilaOp;
    private Stack pilaVal;
    private Long valorActual;

    private static final int TOK_EOL= -1; 
    private static final int TOK_VALOR= 0; 
    private static final int TOK_MAS= 1; 
    private static final int TOK_POR= 2; 

    public Calculadora(String expr) {

	this.expr= new StringTokenizer(expr,"+*",true);
	pilaOp= new Stack();
	pilaVal= new Stack();
	pilaOp.push(new Integer(TOK_EOL));
    }

    /**
     * Devuelve el resultado de evaluar la expresión.
     * Sucesivamente, lee un token y lo procesa, hasta que ya no queden
     * tokens. En ese momento, devuelve el valor de la pila de valores.
     */
    public long getValor() {
	int token;
	
	do {
	    token= obtenerToken();
	    procesarToken(token);
	} while (token != TOK_EOL); 
	
	Long resultado= (Long)pilaVal.pop();
	if (resultado==null || pilaVal.pop() != null) {
	    System.out.println("Expresión errónea");
	    return 0;
	}
	else return resultado.longValue();
    }

    /**
     * Lee el siguiente token de la expresión. Si es un valor (número),
     * devuelve TOK_VALOR y actualiza el atributo valorActual.
     */
    private int obtenerToken() {
	String s;

	try {
	    s= expr.nextToken();
	} catch (NoSuchElementException e) {
	    return TOK_EOL;
	}
	
	if (s.equals("+")) return TOK_MAS;
	else if (s.equals("*")) return TOK_POR;

	// es un valor
	try {
	    valorActual= new Long(s);
	} catch (NumberFormatException ex) {
	    System.out.println("Valor con formato incorrecto");
	    return TOK_EOL;
	}

	return TOK_VALOR;
    }

    /**
     * Desapila dos valores de la pila de valores y apila el
     * resultado de aplicarles el operador recibido com parámetro.
     */
    private void operadorBinario(int token) {

	long op1,op2;

	Long lop2= (Long)pilaVal.pop();
	Long lop1= (Long)pilaVal.pop();

	if (lop1==null || lop2==null) {
	    System.out.println("Pila de valores incorrecta");
	    return;
	}

	op1= lop1.longValue();
	op2= lop2.longValue();

	switch (token) {

	case TOK_MAS:
	    pilaVal.push(new Long(op1+op2));
	    break;

	case TOK_POR:
	    pilaVal.push(new Long(op1*op2));
	    break;
	}
    }

    /**
     * Procesa un token:
     *   - si es TOK_VALOR, apila valorActual
     *   - si es TOK_EOL, vacía la pila de operadores
     *   - si es TOK_MAS, vacía la pila menos el TOK_EOL final
     *   - si es TOK_POR, vacía la pila hasta llegar a un TOK_MAS o TOK_EOL
     * Para cada token de operador desapilado, realiza el cálculo
     * invocando a operadorBinario.
     */
    private void procesarToken(int token) {
	int cima;

	switch (token) {

	case TOK_VALOR:
	    pilaVal.push(valorActual);
	    break;

	case TOK_EOL:
	    // se desapila todo
	    while ((cima=((Integer)pilaOp.pop()).intValue()) != TOK_EOL)
		operadorBinario(cima);	    
	    break;

	case TOK_MAS:
	    // precedencia menor: se desapila todo
	    while ((cima=((Integer)pilaOp.pop()).intValue()) != TOK_EOL)
		operadorBinario(cima);

	    // devuelve el EOL desapilado
	    pilaOp.push(new Integer(cima));
	    // apila el operador
	    pilaOp.push(new Integer(token));
	    break;

	case TOK_POR:
	    // precedencia mayor: se desapila todo hasta un +
	    while ((cima=((Integer)pilaOp.pop()).intValue()) != TOK_EOL &&
		   cima != TOK_MAS )
		operadorBinario(cima);

	    // devuelve el último operador desapilado
	    pilaOp.push(new Integer(cima));
	    // apila el operador
	    pilaOp.push(new Integer(token));
	    break;

	}
    }

    public static void main(String args[]) {

	Calculadora c= new Calculadora(args[0]);
	System.out.println(c.getValor());
    }

}
