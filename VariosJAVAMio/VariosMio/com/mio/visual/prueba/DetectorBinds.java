package com.mio.visual.prueba;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DetectorBinds extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6235723009184383308L;

	private JFileChooser fc = null;
	private FileNameExtensionFilter filter;
	private File config;
	UtilidadConfig uc;
	ArrayList aux;
	private JPanel jPBase = null;
	private JButton jBScanear = null;
	private JLabel jLinfo = null;
	private JLabel jLineaBind = null;
	private JButton jBCrearConfig = null;
	private JLabel jLConfigLimpia = null;
	private JTextField jTRutaConfigEdit = null;
	private JLabel jLRutaNoValida = null;
	private JLabel jLConfigReady = null;
	private JLabel jLIns = null;
	private JButton jBExaminar = null;
	private JTextArea jTACampoBinds = null;
	private JScrollPane sbrText;
	private JLabel jLDone = null;

	/**
	 * This method initializes
	 * 
	 */
	public DetectorBinds() {
		super();
	}

	/**
	 * This method initializes this
	 * 
	 */
	public void init() {
		this.setName("Detector de Binds");
		this.setSize(new Dimension(502, 391));
		this.setContentPane(getJPBase11());
	}

	/**
	 * This method initializes jPBase11
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPBase11() {
		if (jPBase == null) {
			jLDone = new JLabel();
			jLDone.setBounds(new Rectangle(435, 349, 54, 25));
			jLDone.setText("Hecho!");
			jLDone.setVisible(false);
			jLIns = new JLabel();
			jLIns.setBounds(new Rectangle(9, 20, 307, 15));
			jLIns
					.setText("Introduzca la ruta de la config pulsando en examinar:");
			jLConfigReady = new JLabel();
			jLConfigReady.setBounds(new Rectangle(6, 77, 142, 24));
			jLConfigReady.setText("Config preparada");
			jLConfigReady.setVisible(false);
			jLRutaNoValida = new JLabel();
			jLRutaNoValida.setBounds(new Rectangle(165, 77, 142, 24));
			jLRutaNoValida.setText("RUTA NO VALIDA");
			jLRutaNoValida.setVisible(false);
			jLConfigLimpia = new JLabel();
			jLConfigLimpia.setBounds(new Rectangle(14, 349, 258, 25));
			jLConfigLimpia
					.setText("Para crear la config limpia pulsa en generar:");
			jLConfigLimpia.setVisible(false);
			jLineaBind = new JLabel();
			jLineaBind.setBounds(new Rectangle(113, 147, 111, 23));
			jLineaBind.setText("Bind no permitido");
			jLinfo = new JLabel();
			jLinfo.setBounds(new Rectangle(11, 147, 90, 23));
			jLinfo.setText("Numero linea");
			jPBase = new JPanel();
			jPBase.setLayout(null);
			jPBase.add(getJBScanear(), null);
			jPBase.add(jLinfo, null);
			jPBase.add(jLineaBind, null);
			jPBase.add(getJBCrearConfig(), null);
			jPBase.add(jLConfigLimpia, null);
			jPBase.add(getJTRutaConfigEdit(), null);
			jPBase.add(jLRutaNoValida, null);
			jPBase.add(jLConfigReady, null);
			jPBase.add(jLIns, null);
			jPBase.add(getJBExaminar(), null);
			sbrText = new JScrollPane(jTACampoBinds);
			sbrText.setBounds(new Rectangle(11, 182, 480, 160));
			sbrText.setViewportView(getJTACampoBinds());
			sbrText
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			jPBase.add(sbrText, null);
			jPBase.add(jLDone, null);
		}
		return jPBase;
	}

	/**
	 * This method initializes jBScanear11
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBScanear() {
		if (jBScanear == null) {
			jBScanear = new JButton();
			jBScanear.setLocation(new Point(8, 115));
			jBScanear.setText("Scanear Config");
			jBScanear.setSize(new Dimension(131, 25));
			jBScanear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						if (!config.exists()) {

						}
					} catch (Exception e2) {
						jLRutaNoValida.setVisible(true);

					}
					uc = new UtilidadConfig();
					uc.analizarConfig(config);
					aux = uc.getIlegales();
					if (!aux.isEmpty()) {
						Iterator i = aux.iterator();
						Iterator j = uc.getLineas().iterator();
						StringBuffer buffer = new StringBuffer();
						while (i.hasNext()) {
							buffer.append(((Integer) j.next()).toString())
									.append(" - " + i.next() + "\n");

						}
						getJTACampoBinds().setText(buffer.toString());
						jLConfigLimpia.setVisible(true);
						getJBCrearConfig().setVisible(true);
						getJBCrearConfig().setEnabled(true);
					} else {
						getJTACampoBinds().setText("CONFIG LIMPIA CHALAO");
					}

				}
			});
		}
		return jBScanear;
	}

	/**
	 * This method initializes jBCrearConfig11
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBCrearConfig() {
		if (jBCrearConfig == null) {
			jBCrearConfig = new JButton();
			jBCrearConfig.setBounds(new Rectangle(277, 349, 131, 25));
			jBCrearConfig.setEnabled(false);
			jBCrearConfig.setText("Generar");
			jBCrearConfig.setVisible(false);
			jBCrearConfig.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					uc.generarConfig(config.getParent());
					jLDone.setVisible(true);

					java.awt.Desktop dk = null;
					dk = java.awt.Desktop.getDesktop();
					try {
						dk.open(new File(config.getParent()));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});
		}
		return jBCrearConfig;
	}

	/**
	 * This method initializes jTRutaConfigEdit11
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTRutaConfigEdit() {
		if (jTRutaConfigEdit == null) {
			jTRutaConfigEdit = new JTextField();
			jTRutaConfigEdit.setBounds(new Rectangle(8, 41, 479, 27));
			jTRutaConfigEdit.setEditable(false);
			LineBorder border = new LineBorder(Color.DARK_GRAY, 1);
			jTRutaConfigEdit.setBorder(border);
		}
		return jTRutaConfigEdit;
	}

	/**
	 * This method initializes jBExaminar11
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBExaminar() {
		if (jBExaminar == null) {
			jBExaminar = new JButton();
			jBExaminar.setBounds(new Rectangle(356, 76, 131, 25));
			jBExaminar.setText("Examinar");
			jBExaminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fc = new JFileChooser(
							"C:\\Archivos de programa\\Activision\\Call of Duty 2\\main\\players\\");
					filter = new FileNameExtensionFilter("Configs (.cfg)",
							"cfg");
					fc.setFileFilter(filter);
					int returnVal = fc.showDialog(jPBase, "Aceptar");
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						config = fc.getSelectedFile();
						getJTRutaConfigEdit().setText(config.getPath());
						jLConfigReady.setVisible(true);
					}
				}
			});
		}
		return jBExaminar;
	}

	/**
	 * This method initializes jTACampoBinds
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTACampoBinds() {
		if (jTACampoBinds == null) {
			jTACampoBinds = new JTextArea();
			jTACampoBinds.setLineWrap(true);

		}
		return jTACampoBinds;
	}

} // @jve:decl-index=0:visual-constraint="10,38"
