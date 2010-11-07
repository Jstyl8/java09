package com.mp.practica7.ejercicio2;

// Nodo basico 

class NodoLista {
    // Atributos
    Object dato;

    NodoLista siguiente;

    public NodoLista(Object elElemento) {
        this(elElemento, null);
    }

    public NodoLista(Object elElemento, NodoLista n) {
        dato = elElemento;
        siguiente = n;
    }
}
