package com.mio.icaro;

import com.mio.excepciones.DesbordamientoInferiorException;



public class ColaVec implements Cola{

	private Object[]vector;
	private int cabeza;
	private int fin;
	private static final int TAMAÑO_POR_DEFECTO=10;
	private int tamañoCola;
	
	public ColaVec(){
		vector = new Object[TAMAÑO_POR_DEFECTO];
		cabeza=0;
		fin=-1;
		tamañoCola=0;
	}
	
	public boolean esVacia(){
		if(tamañoCola==0)
			return true;
		else
			return false;
	}
	
	public Object primero()throws DesbordamientoInferiorException{
		if(esVacia()==true)
			throw new DesbordamientoInferiorException("Ernes y Samu");
		return vector[cabeza];
	}
	
	public void insertar(Object x){
		if(tamañoCola==vector.length)
			asegurarCapacidad();
		fin=incrementar(fin);
		vector[fin]=x;
		tamañoCola++;
	}
	
	private void asegurarCapacidad(){
		Object[]aux=new Object[vector.length*2];
		for(int i=0; i<tamañoCola;i++,cabeza=incrementar(cabeza)){
			aux[i]=vector[cabeza];
		}
		vector=aux;
		cabeza=0;
		fin=tamañoCola-1;
	}
	
	private int incrementar(int n){
		n++;
		if(n==vector.length){
			n=0;
		}
		return n;
	}
	
	public Object quitarPrimero()throws DesbordamientoInferiorException{
		if(esVacia()==true)
			throw new DesbordamientoInferiorException("Ernes y Samu");
		Object fuera=vector[cabeza];
		cabeza=incrementar(cabeza);
		tamañoCola--;
		return fuera;
	}
	
	public int tamaño(){
		return tamañoCola;
	}
	
	public void vaciar(){
		tamañoCola=0;
		cabeza=0;
		fin=-1;
	}
	
}
