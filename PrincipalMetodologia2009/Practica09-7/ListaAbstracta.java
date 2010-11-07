package com.mp.practica7.ejercicio5;



/**
 * Clase abstracta de conveniencia para las implementaciones.
 *
 */
public abstract class ListaAbstracta implements Lista {

    public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append('[');

        if (!esVacia()) {
            Iterador i = iterador();
            for (i.primero(); !i.estaDentro(); i.siguiente()) {
                buffer.append(i.actual()).append(", ");
            }

            buffer.setLength(buffer.length() - 2);
        }

        buffer.append(']');

        return buffer.toString();
    }



    public boolean equals(Object objecto) {
        return objecto instanceof Lista ? equals((Lista) objecto) : false;
    }

    public boolean equals(Lista otra) {
        if (otra == null || tamaño() != otra.tamaño()) {
            return false;
        }

        Iterador i = iterador();
        Iterador j = otra.iterador();
        for (i.primero(), j.primero(); !i.estaDentro() && !j.estaDentro(); i.siguiente(), j.siguiente()) {
            if (!i.actual().equals(j.actual())) {
                break;
            }
        }

        return i.estaDentro() && j.estaDentro();
    }
}
