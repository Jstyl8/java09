package com.mp.practica4.ejercicio1.test;


import com.mp.practica4.ejercicio1.Factorial;

import junit.framework.TestCase;

public class FactorialTestA extends TestCase {

    public FactorialTestA(String arg0) {
        super(arg0);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }
    
public void testFactorial() {
    
        assertEquals(1,Factorial.factorialRec(0));
        assertEquals(1,Factorial.factorialRec(1));
        assertEquals(2,Factorial.factorialRec(2));
        assertEquals(6,Factorial.factorialRec(3));
        
        assertEquals(1,Factorial.factorialIter(0));
        assertEquals(1,Factorial.factorialIter(1));
        assertEquals(2,Factorial.factorialIter(2));
        assertEquals(6,Factorial.factorialIter(3));
       
        assertEquals(Factorial.factorialIter(1),Factorial.factorialRec(1));
        assertEquals(Factorial.factorialIter(2),Factorial.factorialRec(2));
        assertEquals(Factorial.factorialIter(3),Factorial.factorialRec(3));
        assertEquals(Factorial.factorialIter(4),Factorial.factorialRec(4));
        assertEquals(Factorial.factorialIter(5),Factorial.factorialRec(5));
        assertEquals(Factorial.factorialIter(12),Factorial.factorialRec(12));
    }

}
