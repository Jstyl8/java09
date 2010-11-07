
package com.mio.meto.TorresHanoi;

import java.io.*;
import java.text.*;


/**
 * Programa recursivo para resolver <I>Las Torres de Hanoi</I>
 * @author CTE, Javier Ruiz
 **/
public class TowersOfHanoi  
{

	private final static BufferedReader  stdIn = new  BufferedReader(new  InputStreamReader(System.in));
	private final static PrintWriter  stdOut = new  PrintWriter(System.out, true);
	private final static PrintWriter  stdErr = new  PrintWriter(System.err, true);


	public static void  main(String[]  args) throws IOException, NumberFormatException  
	{
		stdErr.print("Cuantos discos son?  ");
		stdErr.flush();
		int numDisks = Integer.parseInt(stdIn.readLine());
		

		move(numDisks, 1, 3, 2);
	}



	/**
	 * El procedimiento para mover <I>n</I> discos de la torre <SAMP>from</SAMP> a la torre <SAMP>to</SAMP> es el siguiente:
	 * <OL>
	 * <LI> Mover <I>n</I>-1 discos de <SAMP>from</SAMP> a <SAMP>temp</SAMP>, usando <SAMP>to</SAMP> como auxiliar.
	 * <LI> Mover 1 disco de <SAMP>from</SAMP> a <SAMP>to</SAMP>.<BR>
	 *      (Para mover 1 disco no se necesita auxiliar, pero para llenar la sintaxis del m&eacute;todo
	 *	diremos que el auxiliar es <SAMP>temp</SAMP>)
	 * <LI> Mover los <I>n</I>-1 discos de <SAMP>temp</SAMP> a <SAMP>to</SAMP>, usando <SAMP>from</SAMP> como auxiliar.
	 * </OL>
	 * El proceso se repite dentro de s&iacute; mismo.
	 * Los movimientos que se indican al usuario son los que consisten en mover un disco. Cuando se mueve s&oacute;lo un disco, no se llama al m&eacute;todo <SAMP>move</SAMP> otra vez.
	 *
	 * @param n El n&uacute;mero de discos de la torre (o pedazo de torre) actual.
	 * @param from El n&uacute;mero de la torre donde se encuentran los discos
	 * @param to La torre hacia donde queremos mover los discos
	 * @param temp La otra torre, usada como auxiliar
	 **/
	protected static void  move(int  n, int  from, int  to, int  temp)  
	{
		if (n==1)
		{
			System.out.println("Mover el disco superior de la torre " + from + " a la torre " + to);
		}
		else
		{
			move(n-1, from, temp, to);
			move(1,   from, to, temp);
			move(n-1, temp, to, from);
		}
			
		
	}
}