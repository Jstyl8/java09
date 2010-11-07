package com.mp.practica8.ejercicio4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ResidenciaXML {

    private String nombreArchivo;
    private XStream xstream;

 
	public ResidenciaXML(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
		xstream = new XStream(new DomDriver());
	}

    public void escribir(Residencia residencia) throws IOException {
    	
    	xstream.toXML(residencia, new PrintWriter(nombreArchivo));
    }

    public Residencia leer() throws IOException {
  
    	Residencia residencia = (Residencia)xstream.fromXML(new FileReader(nombreArchivo));
        return residencia;
    }
	
	
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
}
