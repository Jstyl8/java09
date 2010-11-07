package com.mp.practica7.ejercicio2.test;

import com.mp.practica7.ejercicio2.Cola;
import com.mp.practica7.ejercicio2.ColaLista;

public class ColaListaTest extends AbstractColaTestCase {

    protected Cola crearCola() {
        return new ColaLista();
    }

}
