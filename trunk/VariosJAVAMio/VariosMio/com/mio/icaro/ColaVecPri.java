package com.mio.icaro;

import com.mio.excepciones.DesbordamientoInferiorException;

public class ColaVecPri extends ColaVec{
	
	public ColaVecPri(){
		super();
	}
	
	public void insertarPrioridad(Comparable x){
		insertar(x);
	}
	
	public Comparable salirPrioridad() throws DesbordamientoInferiorException{
		Comparable []aux=new Comparable[tamaño()];
		int i=0;
		int pos=0;
		while(esVacia()==false){
			aux[i]=(Comparable)this.quitarPrimero();
			i++;
		}
		Comparable mayor=aux[0];
		for(i=1; i<aux.length;i++){
			if(mayor.compareTo(aux[i])==1){
				mayor=aux[i];
				pos=i;
			}
		}
		for(i=0; i<aux.length;i++){
			if(i!=pos){
				insertar(aux[i]);
			}
		}
		return mayor;
	}

}
