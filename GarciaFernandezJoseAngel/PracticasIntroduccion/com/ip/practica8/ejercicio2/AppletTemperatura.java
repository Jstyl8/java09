package com.ip.practica8.ejercicio2;
/**
*nombre: AppletTemperatura
*autor: José Ángel García Fernández
*fecha: 23/12/08
*Descripcion: es un applet que  entre sus operaciones se encuenta el 
*calcular la conversion de grados Celsius a grados Farenheit
*/

import java.applet.*;		//importa la clase applet
import java.awt.*;			//importa la clase que contiene los elementos graficos
import java.awt.event.*;	//importa la clase que conteine las operaciones sobre eventos

public class AppletTemperatura extends Applet implements ActionListener
{
	private TextField TFentrada = new TextField(16);
	private TextField TFresultado = new TextField(16);
	private Label Ltitulo = new Label("Introduce el valor de la temperatura>>");
	private Button Bcf = new Button("C a F");
	private Button Bfc = new Button("F a C");
	private Temperatura t= new Temperatura();
/**************************************************************************
METODO INIT(): Se declara e inicializa el boton que vamos a utilizar y lo añadimos 
a la lista que espera eventos
********************************************************************/
	public void init()
	{
		Bfc.addActionListener(this);
		Bcf.addActionListener(this);
		setSize(175,200);
		TFresultado.setEditable(false);
		add(Ltitulo);
		add(TFentrada);	
		add(Bcf);	
		add(Bfc);	
		add(TFresultado);	
	}//fin init
/**************************************************************************
METODO ACTIONPERFORMED(): En este método se gestionan los eventos que 
suceden sobre los elementos definidos anteriormente
********************************************************************/
	public void actionPerformed(ActionEvent e)
	{
			float numero = Float.parseFloat(TFentrada.getText());
			if(e.getSource()==Bcf)
				TFresultado.setText(numero+" ºC = "+t.ConvertirCF(numero)+"F");
			if(e.getSource()==Bfc)
				TFresultado.setText(numero+" ºF = "+t.ConvertirFC(numero)+"C");
	}//fin actionPerformed
}//fin de Applettemperatura