package com.mio.meto.TorresHanoi;

/**
 * @author Angel Nieto
 * @category Clase ejecutable para comprobar el funcionamiento de la clase
 *           TorresHanoi
 */
public class principal {

	/**
	 * Metodo main para probar las torres de hanoi
	 * 
	 * @param args
	 *            parametros propios del main
	 */
	public static void main(String[] args) {
		TorresHanoi torres = new TorresHanoi(3);
		//torres.solucionRec(3, 1, 3, 2);
		torres.solucionRecSimple(3, 1, 3, 2);
	}
}
