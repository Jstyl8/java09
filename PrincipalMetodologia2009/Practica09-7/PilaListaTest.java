package com.mp.practica7.ejercicio1.test;

import com.mp.practica7.ejercicio1.Pila;
import com.mp.practica7.ejercicio1.PilaLista;

public class PilaListaTest extends AbstractPilaTestCase {

    protected Pila crearPila() {

        return new PilaLista();
    }
}
