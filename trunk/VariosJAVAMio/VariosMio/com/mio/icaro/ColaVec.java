package com.mio.icaro;

import com.mio.excepciones.DesbordamientoInferiorException;



public class ColaVec implements Cola{

	private Object[]vector;
	private int cabeza;
	private int fin;
	private static final int TAMA�O_POR_DEFECTO=10;
	private int tama�oCola;
	
	public ColaVec(){
		vector = new Object[TAMA�O_POR_DEFECTO];
		cabeza=0;
		fin=-1;
		tama�oCola=0;
	}
	
	public boolean esVacia(){
		if(tama�oCola==0)
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
		if(tama�oCola==vector.length)
			asegurarCapacidad();
		fin=incrementar(fin);
		vector[fin]=x;
		tama�oCola++;
	}
	
	private void asegurarCapacidad(){
		Object[]aux=new Object[vector.length*2];
		for(int i=0; i<tama�oCola;i++,cabeza=incrementar(cabeza)){
			aux[i]=vector[cabeza];
		}
		vector=aux;
		cabeza=0;
		fin=tama�oCola-1;
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
		tama�oCola--;
		return fuera;
	}
	
	public int tama�o(){
		return tama�oCola;
	}
	
	public void vaciar(){
		tama�oCola=0;
		cabeza=0;
		fin=-1;
	}
	
}
