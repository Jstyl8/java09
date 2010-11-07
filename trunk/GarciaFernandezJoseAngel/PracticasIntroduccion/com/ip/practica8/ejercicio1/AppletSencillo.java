package com.ip.practica8.ejercicio1;
/**
*nombre: AppletSencillo
*autor: José Ángel García Fernández
*fecha: 23/12/08
*Descripcion: es un applet que al pulsar en un boton cambia el estado de encendido
*a apagado y viceversa..
*/

import java.applet.*;		//importa la clase applet
import java.awt.*;			//importa la clase que contiene los elementos graficos
import java.awt.event.*;	//importa la clase que conteine las operaciones sobre eventos

@SuppressWarnings("serial")
public class AppletSencillo extends Applet implements ActionListener
{
	private Button pulsador; //de la clase Java.awt.*
/**************************************************************************
METODO INIT(): Se declara e inicializa el boton que vamos a utilizar y lo añadimos 
a la lista que espera eventos
********************************************************************/
	public void init()
	{
			pulsador=new Button ("La maquina esta apagada");
			pulsador.addActionListener(this);
			add(pulsador);						//se añade a la escucha el boton
	}//fin init
/**************************************************************************
METODO ACTIONPERFORMED(): En este metodo se gestionan los eventos que suceden 
sobre le boton definido anteriormente
********************************************************************/
	public void actionPerformed(ActionEvent e)
	{
			String etiqueta = pulsador.getLabel(); //contiene el texto del boton
			if(etiqueta.equals("La maquina esta encendida"))
				pulsador.setLabel("La maquina esta apagada");
			else
				pulsador.setLabel("La maquina esta encendida");
	}//fin actionPerformed
}//fin de AppletSencillo