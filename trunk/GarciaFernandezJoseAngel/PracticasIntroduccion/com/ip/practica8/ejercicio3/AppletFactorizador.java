package com.ip.practica8.ejercicio3;


import java.applet.*;		//importa la clase applet
import java.awt.*;			//importa la clase que contiene los elementos graficos
import java.awt.event.*;	//importa la clase que conteine las operaciones sobre eventos

@SuppressWarnings("serial")
public class AppletFactorizador extends Applet implements ActionListener
{
	private TextField TFentrada = new TextField(16);
	private TextField TFresultado = new TextField(16);
	private Label Ltitulo = new Label("FACTORIZADOR");
	private Label Lentrada = new Label("Introduce el numero a descomponer>>");
	private Button Bf = new Button("Factorizar");
	private Factorizador F= new Factorizador();
/**************************************************************************
METODO INIT(): Se declara e inicializa el boton que vamos a utilizar y lo añadimos 
a la lista que espera eventos
********************************************************************/
	public void init()
	{
		Bf.addActionListener(this);
		TFresultado.setEditable(false);
		add(Ltitulo);
		add(Lentrada);
		add(TFentrada);	
		add(Bf);	
		add(TFresultado);	
	}//fin init
/**************************************************************************
METODO ACTIONPERFORMED(): En este método se gestionan los eventos que 
suceden sobre los elementos definidos anteriormente
********************************************************************/
	public void actionPerformed(ActionEvent e)
	{
		int numero = Integer.parseInt(TFentrada.getText());
		if(e.getSource()==Bf)
				TFresultado.setText(F.Calcular_descomposicion_factorial(numero));
				
	}//fin actionPerformed
}//fin de AppletFactorizador