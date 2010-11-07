package com.mp.practica4.ejercicio1.test;

import com.mp.practica4.ejercicio1.Fibonacci;

import junit.framework.TestCase;

public class FibonacciTestA extends TestCase {

    public static void main(String[] args) {
    }

    public FibonacciTestA(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testFibonacci() {

    	assertEquals(0,Fibonacci.fibonacciRec(0));
        assertEquals(1,Fibonacci.fibonacciRec(1));
        assertEquals(1,Fibonacci.fibonacciRec(2));
        assertEquals(2,Fibonacci.fibonacciRec(3));
        assertEquals(8,Fibonacci.fibonacciRec(6));

        assertEquals(Fibonacci.fibonacciIter(0),Fibonacci.fibonacciRec(0));
        assertEquals(Fibonacci.fibonacciIter(1),Fibonacci.fibonacciRec(1));
        assertEquals(Fibonacci.fibonacciIter(2),Fibonacci.fibonacciRec(2));
        assertEquals(Fibonacci.fibonacciIter(3),Fibonacci.fibonacciRec(3));
        assertEquals(Fibonacci.fibonacciIter(4),Fibonacci.fibonacciRec(4));
        assertEquals(Fibonacci.fibonacciIter(5),Fibonacci.fibonacciRec(5));
        assertEquals(Fibonacci.fibonacciIter(12),Fibonacci.fibonacciRec(12));
    }

}
