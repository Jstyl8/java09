package com.ip.practica9.ejercicio1;
/**
*nombre: AppletComparaCadenas
*autor: José Ángel García Fernández
*fecha: 24/12/08
*Descripcion: es un applet que utiliza clase OperacionesCadenas para comprar dos cadenas
*/

import java.applet.*;		//importa la clase applet
import java.awt.*;			//importa la clase que contiene los elementos graficos
import java.awt.event.*;	//importa la clase que conteine las operaciones sobre eventos


public class AppletComparaCadenas extends Applet implements ActionListener
{
	private TextField TFcadena1 = new TextField(20);
	private TextField TFcadena2 = new TextField(20);
	private TextField TFresultado = new TextField(30);
	private Label Lcadena1 = new Label("Introduce cadena1 >>");
	private Label Lcadena2 = new Label("Introduce cadena2 >>");
	private Label Lresultado = new Label("Resultado>>");
	private Button Bcomparar = new Button("Comparar");
	private Button Bborrar = new Button("Borrar");
	private OperacionesCadenas cadena= new OperacionesCadenas();
/**************************************************************************
METODO INIT(): Se declara e inicializa el boton que vamos a utilizar y lo añadimos 
a la lista que espera eventos
********************************************************************/
	public void init()
	{
		Bcomparar.addActionListener(this);
		Bborrar.addActionListener(this);
		setSize(350,150);
		TFresultado.setEditable(false);
		add(Lcadena1);
		add(TFcadena1);
		add(Lcadena2);	
		add(TFcadena2);	
		add(Lresultado);
		add(TFresultado);
		add(Bborrar);
		add(Bcomparar);
	}//fin init
/**************************************************************************
METODO ACTIONPERFORMED(): En este método se gestionan los eventos que 
suceden sobre los elementos definidos anteriormente
********************************************************************/
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==Bcomparar)
				TFresultado.setText(cadena.Comparar(TFcadena1.getText(), TFcadena2.getText()));
		if(e.getSource()==Bborrar)
		{
			TFcadena1.setText(null);
			TFcadena2.setText(null);
			TFresultado.setText(null);
		}
	}//fin actionPerformed
}//fin de AppletComparaCadenas