package com.mio.visual.prueba;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class UtilidadConfig {

	private static final String[] noValidos = { "toggle ", "wait", "vstr",
			"exec" };

	private ArrayList ilegales;

	private ArrayList lineas;

	private int nLinea;

	private ArrayList configLimpia;

	public UtilidadConfig() {
		ilegales = new ArrayList();
		configLimpia = new ArrayList();
		lineas = new ArrayList();
		nLinea = 0;
	}

	/**
	 * @return the ilegales
	 */
	public ArrayList getIlegales() {
		return ilegales;
	}

	/**
	 * @return the lineas
	 */
	public ArrayList getLineas() {
		return lineas;
	}

	/**
	 * @return the nLinea
	 */
	public int getNLinea() {
		return nLinea;
	}

	/**
	 * @return the configLimpia
	 */
	public ArrayList getConfigLimpia() {
		return configLimpia;
	}

	public int getNIlegales() {
		return ilegales.size();
	}

	public void analizarConfig(File config) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(config));

			String str;
			boolean añadida = false;
			while ((str = in.readLine()) != null) {

				for (int i = 0; i < noValidos.length && !añadida; i++) {
					if (str.lastIndexOf(noValidos[i]) != -1) {
						if ((str.lastIndexOf("cl_paused") == -1)) {
							ilegales.add(str);
							añadida = true;
							lineas.add(nLinea);
						}
					}
				}
				if (!añadida) {
					configLimpia.add(str);
				}
				añadida = false;
				nLinea++;
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void generarConfig(String ruta) {
		try {
			ruta += File.separator + "config_mp-Limpia.cfg";
			PrintWriter bf = new PrintWriter(new FileWriter(ruta));
			Iterator i = configLimpia.iterator();
			while (i.hasNext()) {
				bf.println((String) i.next());
			}
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
