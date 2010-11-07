package com.mio.general.examen.ejer6;

import com.mio.estructurasdatos.Cola;
import com.mio.excepciones.DesbordamientoInferiorException;

public abstract class ColaAbstracta implements Cola {

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		Object[] aux = new Object[tamaño()];
		buffer.append("[");
		if (!esVacia()) {
			for (int i = 0; i < aux.length; i++) {
				try {
					aux[i] = quitarPrimero();
					buffer.append(aux[i]).append(", ");
				} catch (DesbordamientoInferiorException e) {
					e.printStackTrace();
				}
			}
			buffer.setLength(buffer.length() - 2);
		}
		buffer.append("]");
		for (int i = 0; i < aux.length; i++) {
			insertar(aux[i]);
		}
		return buffer.toString();
	}

	public boolean equals(Object o) {
		return o instanceof Cola ? equals((Cola) o) : false;
	}

	public boolean equals(Cola otra) {
		if (otra == null || tamaño() != otra.tamaño()) {
			return false;
		}
		boolean iguales = true;
		Object[] auxThis = new Object[tamaño()];
		Object[] auxOtra = new Object[otra.tamaño()];
		for (int i = 0; i < auxThis.length; i++) {
			try {
				auxThis[i] = quitarPrimero();
				auxOtra[i] = otra.quitarPrimero();
			} catch (DesbordamientoInferiorException e) {
				e.printStackTrace();
			}
			if (!auxThis[i].equals(auxOtra[i])) {
				iguales = false;
			}
		}
		for (int i = 0; i < auxThis.length; i++) {
			insertar(auxThis[i]);
			otra.insertar(auxOtra[i]);
		}
		return iguales;
	}
}
