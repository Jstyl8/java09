package com.ip.practica9.ejercicio2;
/**
*nombre: AppletCuentaCaracteres
*autor: José Ángel García Fernández
*fecha: 24/12/08
*Descripcion: es un applet que utiliza metodos de la clase OperacionesCadenas.
*/

import java.applet.*;		//importa la clase applet
import java.awt.*;			//importa la clase que contiene los elementos graficos
import java.awt.event.*;	//importa la clase que conteine las operaciones sobre eventos

import com.ip.practica9.ejercicio1.OperacionesCadenas;

@SuppressWarnings("serial")
public class AppletCuentaCaracteres extends Applet implements ActionListener
{
	private TextField TFcadena = new TextField(20);
	private TextField TFcaracter = new TextField(10);
	private TextField TFcontenido = new TextField(20);
	private TextField TFcuenta= new TextField(10);
	private Label Lcadena = new Label("Introduce la cadena >>");
	private Label Lcaracter = new Label("Introduce el carácter >>");
	private Button Bcontenido = new Button("Comprobar contenido");
	private Button Bcuenta = new Button("Contar caracter");
	private OperacionesCadenas c= new OperacionesCadenas();
/**************************************************************************
METODO INIT(): Se declara e inicializa el boton que vamos a utilizar y lo añadimos 
a la lista que espera eventos
********************************************************************/
	public void init()
	{
		Bcontenido.addActionListener(this);
		Bcuenta.addActionListener(this);
		setSize(320,300);
		TFcontenido.setEditable(false);
		TFcuenta.setEditable(false);
		add(Lcadena);
		add(TFcadena);
		add(Lcaracter);	
		add(TFcaracter);
		add(Bcontenido);
		add(Bcuenta);
		add(TFcontenido);
		add(TFcuenta);
	}//fin init
/**************************************************************************
METODO ACTIONPERFORMED(): En este método se gestionan los eventos que 
suceden sobre los elementos definidos anteriormente
********************************************************************/
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==Bcontenido)
				TFcontenido.setText(c.Comprobar_contenido
							(TFcadena.getText(),TFcaracter.getText().charAt(0)));
		if(e.getSource()==Bcuenta)
		{
			TFcuenta.setText(Integer.toString((c.Contar_caracter
					(TFcadena.getText(),TFcaracter.getText().charAt(0)))));
		}
	}//fin actionPerformed
}//fin de AppletCuentaCadenas