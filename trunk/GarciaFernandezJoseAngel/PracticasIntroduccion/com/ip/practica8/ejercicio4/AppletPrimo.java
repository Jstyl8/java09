package com.ip.practica8.ejercicio4;
/**
*nombre: AppletPrimo
*autor: José Ángel García Fernández
*fecha: 24/12/08
*Descripcion: es un applet que  entre sus operaciones se encuenta el 
* que calcula si un numero es primo o no.
*/

import java.applet.*;		//importa la clase applet
import java.awt.*;			//importa la clase que contiene los elementos graficos
import java.awt.event.*;	//importa la clase que conteine las operaciones sobre eventos

@SuppressWarnings("serial")
public class AppletPrimo extends Applet implements ActionListener
{
	private TextField TFentrada = new TextField(16);
	private TextField TFresultado = new TextField(20);
	private Label Ltitulo = new Label("Primo o no");
	private Label Lentrada = new Label("Introduce el numero");
	private Button Bc= new Button("Comprobar");
	private Primo P= new Primo();
/**************************************************************************
METODO INIT(): Se declara e inicializa el boton que vamos a utilizar y lo añadimos 
a la lista que espera eventos
********************************************************************/
	public void init()
	{
		Bc.addActionListener(this);
		setSize(175,200);
		TFresultado.setEditable(false);
		add(Ltitulo);
		add(Lentrada);
		add(TFentrada);	
		add(Bc);		
		add(TFresultado);	
	}//fin init
/**************************************************************************
METODO ACTIONPERFORMED(): En este método se gestionan los eventos que 
suceden sobre los elementos definidos anteriormente
********************************************************************/
	public void actionPerformed(ActionEvent e)
	{		
			boolean primo;
			float numero = Float.parseFloat(TFentrada.getText());
			if(e.getSource()==Bc)
			{
				primo = P.EsPrimo(numero);
				TFresultado.setText(P.Asignar_Primo(primo));
			}
	}//fin actionPerformed
}//fin de Applettemperatura