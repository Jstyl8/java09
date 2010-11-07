package com.mio.utilidades;

import java.io.*;

public class LeerDatos {
	private BufferedReader lecturaTeclado;
	
	public LeerDatos() {
		lecturaTeclado = new BufferedReader
		(new InputStreamReader(System.in));
	}
	
	public LeerDatos(BufferedReader lecturaTeclado) {
		super();
		this.lecturaTeclado = lecturaTeclado;
	}

	public String leerCadena() throws IOException {	
		String cadenaleida;
		
		cadenaleida = lecturaTeclado.readLine();
		
		return cadenaleida;
	}
	
	public char leerCaracter() throws IOException {	
		char caracter;
		String cadenaLeida;
		
		cadenaLeida = lecturaTeclado.readLine();
		caracter = cadenaLeida.charAt( 0 );
		
		return caracter;
	}
	
	public double leerDouble() throws IOException {	
		double numero;
		String cadenaLeida;
		
		cadenaLeida = lecturaTeclado.readLine();
		numero = Double.parseDouble(cadenaLeida);
		
		return numero;
	}	
	
	public int leerEntero() throws IOException {	
		int numero;
		String cadenaLeida;
		
		cadenaLeida = lecturaTeclado.readLine();
		numero = Integer.parseInt(cadenaLeida);
		
		return numero;
	}	
	
	public float leerFloat() throws IOException {	
		float numero;
		String cadenaLeida;
		
		cadenaLeida = lecturaTeclado.readLine();
		numero = Float.parseFloat(cadenaLeida);
		
		return numero;
	}	
}
