package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import cod2.DirectorioNoBorradoException;
import cod2.UtilidadConfig;

/**
 * JFrame que hace lo del Japplet XD
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 06/11/2010
 */
public class DetectorBindsFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JFileChooser fc = null;
	private FileNameExtensionFilter filter;
	private File config;
	UtilidadConfig uc;
	ArrayList aux;
	private JPanel jPBase = null;
	private JButton jBScanear = null;
	private JLabel jLinfo = null;
	private JLabel jLineaIlegal = null;
	private JButton jBCrearConfig = null;
	private JLabel jLConfigLimpia = null;
	private JTextField jTRutaConfigEdit = null;
	private JLabel jLRutaNoValida = null;
	private JLabel jLConfigReady = null;
	private JLabel jLIns = null;
	private JButton jBExaminar = null;
	private JTextArea jTACampoIlegal = null;
	private JScrollPane sbrText;
	private JLabel jLDone1 = null;
	private JButton jBScanDir = null;
	private JLabel jLDirLimpio = null;
	private JLabel jLDone2 = null;
	private JButton jBLimpiarDir = null;
	private JButton jBScanMain = null;
	private JLabel jLMainLimpio = null;
	private JLabel jLDone3 = null;
	private JButton jBLimpiarMain = null;
	private JMenuBarJ jMBJ;

	/**
	 * This is the default constructor
	 */
	public DetectorBindsFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 490);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/visual/imgs/eldeorrr.jpg")));
		this.setContentPane(getJPbase());
		this.setJMenuBar(getJMBJ());
		this.setResizable(false);
		this.setTitle("Limpiador Call of Duty 2");
	}

	/**
	 * This method initializes jTFrutaArchivo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JMenuBarJ getJMBJ() {
		if (jMBJ == null) {
			jMBJ = new JMenuBarJ(
					this,
					new JDialogAcercade(this, "Limpiador Call of Duty 2",
							"1.1 06/11/2010", "Jstyl_8",
							"http://jstyl8.net46.net",
							"/visual/imgs/eldeorrr.jpg"),
					new JDialogComoUsar(this, "Usalo libremente es gratis.",
							"Elige la ruta de la config y usa los botones para realizar las operaciones."));

		}
		return jMBJ;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPbase() {
		if (jPBase == null) {
			jPBase = new JPanel();
			jLDone3 = new JLabel();
			jLDone3.setBounds(new Rectangle(436, 409, 54, 25));
			jLDone3.setText("Hecho!");
			jLDone3.setVisible(false);
			jLMainLimpio = new JLabel();
			jLMainLimpio.setBounds(new Rectangle(14, 409, 258, 23));
			jLMainLimpio.setText("Para limpiar main pulsa en limpiarMain:");
			jLMainLimpio.setVisible(false);
			jLDone2 = new JLabel();
			jLDone2.setBounds(new Rectangle(436, 379, 54, 25));
			jLDone2.setText("Hecho!");
			jLDone2.setVisible(false);
			jLDirLimpio = new JLabel();
			jLDirLimpio
					.setText("Para limpiar el directorio pulsa en limpiarDir:");
			jLDirLimpio.setSize(new Dimension(258, 25));
			jLDirLimpio.setLocation(new Point(14, 379));
			jLDirLimpio.setVisible(false);
			jLDone1 = new JLabel();
			jLDone1.setBounds(new Rectangle(436, 349, 54, 25));
			jLDone1.setText("Hecho!");
			jLDone1.setVisible(false);
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
			jLineaIlegal = new JLabel();
			jLineaIlegal.setText("Bind/Dir/cfg no permitido/a");
			jLineaIlegal.setLocation(new Point(210, 147));
			jLineaIlegal.setSize(new Dimension(156, 23));
			jLinfo = new JLabel();
			jLinfo.setBounds(new Rectangle(11, 147, 187, 23));
			jLinfo.setText("Numero linea/Tamaño Dir/cfg KB");
			jPBase.setLayout(null);
			jPBase.add(getJBScanFile(), null);
			jPBase.add(jLinfo, null);
			jPBase.add(jLineaIlegal, null);
			jPBase.add(getJBCrearConfig(), null);
			jPBase.add(jLConfigLimpia, null);
			jPBase.add(getJTRutaConfigEdit(), null);
			jPBase.add(jLRutaNoValida, null);
			jPBase.add(jLConfigReady, null);
			jPBase.add(jLIns, null);
			jPBase.add(getJBExaminar(), null);
			sbrText = new JScrollPane(jTACampoIlegal);
			sbrText.setBounds(new Rectangle(11, 182, 480, 160));
			sbrText.setViewportView(getJTACampoIlegal());
			sbrText
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			jPBase.add(sbrText, null);
			jPBase.add(jLDone1, null);
			jPBase.add(getJBScanDir(), null);
			jPBase.add(jLDirLimpio, null);
			jPBase.add(jLDone2, null);
			jPBase.add(getJBLimpiarDir(), null);
			jPBase.add(getJBScanMain(), null);
			jPBase.add(jLMainLimpio, null);
			jPBase.add(jLDone3, null);
			jPBase.add(getJBLimpiarMain(), null);
		}
		return jPBase;
	}

	/**
	 * This method initializes jBScanear11
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBScanFile() {
		if (jBScanear == null) {
			jBScanear = new JButton();
			jBScanear.setLocation(new Point(8, 116));
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
					aux = uc.analizarConfig(config);
					if (!aux.isEmpty()) {
						Iterator i = aux.iterator();
						Iterator j = uc.getLineas().iterator();
						StringBuffer buffer = new StringBuffer();
						while (i.hasNext()) {
							buffer.append(((Integer) j.next()).toString())
									.append(" - " + i.next() + "\n");

						}
						getJTACampoIlegal().setText(buffer.toString());
						jLConfigLimpia.setVisible(true);
						getJBCrearConfig().setVisible(true);
						getJBCrearConfig().setEnabled(true);
						aux.clear();
					} else {
						getJTACampoIlegal().setText("CONFIG LIMPIA CHALAO");
					}
					jBLimpiarDir.setEnabled(false);
					jBLimpiarDir.setVisible(false);
					jLDone2.setVisible(false);
					jLDirLimpio.setVisible(false);

					jLDone3.setVisible(false);
					jLMainLimpio.setVisible(false);
					jBLimpiarMain.setVisible(false);
					jBLimpiarMain.setEnabled(false);
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
			jBCrearConfig.setEnabled(false);
			jBCrearConfig.setText("Generar");
			jBCrearConfig.setSize(new Dimension(131, 25));
			jBCrearConfig.setLocation(new Point(280, 349));
			jBCrearConfig.setVisible(false);
			jBCrearConfig.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					uc.generarConfig(config.getParent());
					jLDone1.setVisible(true);

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
			jBExaminar.setActionCommand(null);
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
						uc = new UtilidadConfig(config);
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
	private JTextArea getJTACampoIlegal() {
		if (jTACampoIlegal == null) {
			jTACampoIlegal = new JTextArea();
			jTACampoIlegal.setLineWrap(true);

		}
		return jTACampoIlegal;
	}

	/**
	 * This method initializes jBScanDir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBScanDir() {
		if (jBScanDir == null) {
			jBScanDir = new JButton();
			jBScanDir.setBounds(new Rectangle(165, 116, 145, 25));
			jBScanDir.setText("Scanear Directorio");
			jBScanDir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (!config.exists()) {

						}
					} catch (Exception e2) {
						jLRutaNoValida.setVisible(true);
					}

					String ruta = config.getParent();
					ruta = ruta.substring(0, ruta.indexOf(File.separator
							+ "main"));
					aux = uc.analizarDirectorios(ruta);
					if (!aux.isEmpty()) {
						Iterator i = aux.iterator();
						Iterator j = uc.getSize().iterator();
						StringBuffer buffer = new StringBuffer();
						while (i.hasNext()) {
							String n = String.format("%.2f", ((Long) j.next())
									.doubleValue() / 1024);
							buffer.append(n).append(" - " + i.next() + "\n");

						}
						getJTACampoIlegal().setText(buffer.toString());
						jLDirLimpio.setVisible(true);
						jBLimpiarDir.setVisible(true);
						jBLimpiarDir.setEnabled(true);
						aux.clear();
					} else {
						getJTACampoIlegal().setText("DIRECTORIO LIMPIO CHALAO");
					}
					jLConfigLimpia.setVisible(false);
					jLDone1.setVisible(false);
					jBCrearConfig.setVisible(false);
					jBCrearConfig.setEnabled(false);

					jLDone3.setVisible(false);
					jLMainLimpio.setVisible(false);
					jBLimpiarMain.setVisible(false);
					jBLimpiarMain.setEnabled(false);
				}
			});
		}
		return jBScanDir;
	}

	/**
	 * This method initializes jBLimpiarDir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBLimpiarDir() {
		if (jBLimpiarDir == null) {
			jBLimpiarDir = new JButton();
			jBLimpiarDir.setEnabled(false);
			jBLimpiarDir.setText("LimpiarDir");
			jBLimpiarDir.setSize(new Dimension(131, 25));
			jBLimpiarDir.setLocation(new Point(280, 379));
			jBLimpiarDir.setVisible(false);
			jBLimpiarDir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ruta = config.getParent();
					ruta = ruta.substring(0, ruta.indexOf(File.separator
							+ "main"));
					try {
						uc.limpiarDirectorios(ruta);
						jLDone2.setVisible(true);
						java.awt.Desktop dk = null;
						dk = java.awt.Desktop.getDesktop();
						try {
							dk.open(new File(ruta));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (DirectorioNoBorradoException e1) {
						getJTACampoIlegal().setText("PROBLEMA DE BORRADO");
						e1.printStackTrace();
					}
				}
			});
		}
		return jBLimpiarDir;
	}

	/**
	 * This method initializes jBScanMain
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBScanMain() {
		if (jBScanMain == null) {
			jBScanMain = new JButton();
			jBScanMain.setText("Scanear main");
			jBScanMain.setSize(new Dimension(131, 25));
			jBScanMain.setLocation(new Point(333, 116));
			jBScanMain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (!config.exists()) {

						}
					} catch (Exception e2) {
						jLRutaNoValida.setVisible(true);
					}

					String ruta = config.getParent();
					ruta = ruta.substring(0, ruta.indexOf(File.separator
							+ "players"));
					aux = uc.analizarMain(ruta);
					if (!aux.isEmpty()) {
						Iterator i = aux.iterator();
						Iterator j = uc.getSize().iterator();
						StringBuffer buffer = new StringBuffer();
						while (i.hasNext()) {
							String n = String.format("%.2f", ((Long) j.next())
									.doubleValue() / 1024);
							buffer.append(n).append(" - " + i.next() + "\n");

						}
						getJTACampoIlegal().setText(buffer.toString());
						jLMainLimpio.setVisible(true);
						jBLimpiarMain.setVisible(true);
						jBLimpiarMain.setEnabled(true);
					} else {
						getJTACampoIlegal().setText("MAIN LIMPIO CHALAO");
					}

					jBLimpiarDir.setEnabled(false);
					jBLimpiarDir.setVisible(false);
					jLDone2.setVisible(false);
					jLDirLimpio.setVisible(false);

					jLConfigLimpia.setVisible(false);
					jLDone1.setVisible(false);
					jBCrearConfig.setVisible(false);
					jBCrearConfig.setEnabled(false);
				}
			});
		}
		return jBScanMain;
	}

	/**
	 * This method initializes jBLimpiarMain
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBLimpiarMain() {
		if (jBLimpiarMain == null) {
			jBLimpiarMain = new JButton();
			jBLimpiarMain.setText("LimpiarMain");
			jBLimpiarMain.setSize(new Dimension(131, 25));
			jBLimpiarMain.setLocation(new Point(280, 409));
			jBLimpiarMain.setEnabled(false);
			jBLimpiarMain.setVisible(false);
			jBLimpiarMain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ruta = config.getParent();
					ruta = ruta.substring(0, ruta.indexOf(File.separator
							+ "players"));
					try {
						uc.limpiarMain(ruta);
						jLDone3.setVisible(true);
						java.awt.Desktop dk = null;
						dk = java.awt.Desktop.getDesktop();
						try {
							dk.open(new File(ruta));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (DirectorioNoBorradoException e1) {
						getJTACampoIlegal().setText("PROBLEMA DE BORRADO");
						e1.printStackTrace();
					}
				}
			});
		}
		return jBLimpiarMain;
	}
}
