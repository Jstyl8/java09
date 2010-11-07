package visual;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import borrado.ArchivoNoBorradoException;
import borrado.UtilidadBorrado;
import java.awt.Toolkit;

public class BorradorArchivosFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPBase = null;
	private JButton jBExaminar = null;
	private JFileChooser fc = null;
	private File archivo;
	private String patron = ""; // @jve:decl-index=0:
	private JLabel jLIn = null;
	private JTextField jTFrutaArchivo = null;
	private UtilidadBorrado ub = null;
	private JButton jBdeleteArchivo = null;
	private JTextField jTFInfo = null;
	private JTextField jTFpatron = null;
	private JLabel jLpatron = null;
	private JButton jBdeleteDir = null;
	private JCheckBox jCBborrarTo = null;
	private JMenuBarJ jMBJ = null;

	/**
	 * This is the default constructor
	 */
	public BorradorArchivosFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(580, 240);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/visual/imgs/eldeorrr.jpg")));
		this.setContentPane(getJPBase());
		this.setJMenuBar(getJMBJ());
		this.setResizable(false);
		this.setTitle("Borrador de Archivos");
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
					new JDialogAcercade(this, "Borrador de Archivos", "1.1 06/11/2010",
							"Jstyl_8", "http://jstyl8.net46.net",
							"/visual/imgs/eldeorrr.jpg"),
					new JDialogComoUsar(
							this,
							"Usalo libremente es gratis.",
							"Elige el directorio, introduce la palabra, elige si quieres borrar en subdirectorios y a borrar!."));

		}
		return jMBJ;
	}

	/**
	 * This method initializes jPBase
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPBase() {
		if (jPBase == null) {
			jLpatron = new JLabel();
			jLpatron.setBounds(new Rectangle(14, 100, 503, 16));
			jLpatron
					.setText("Introduzca palabra clave para el borrado de archivos o en blanco para borrado completo:");
			jLIn = new JLabel();
			jLIn.setBounds(new Rectangle(14, 15, 481, 21));
			jLIn
					.setText("Introduzca la ruta del archivo a borrar o el directorio a procesar pulsando examinar:");
			jPBase = new JPanel();
			jPBase.setLayout(null);
			jPBase.add(getJBExaminar(), null);
			jPBase.add(jLIn, null);
			jPBase.add(getJTFrutaArchivo(), null);
			jPBase.add(getJBdeleteArchivo(), null);
			jPBase.add(getJTFInfo(), null);
			jPBase.add(getJTFpatron(), null);
			jPBase.add(jLpatron, null);
			jPBase.add(getJBdeleteDir(), null);
			jPBase.add(getJCBborrarTo(), null);
		}
		return jPBase;
	}

	/**
	 * This method initializes jBExaminar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBExaminar() {
		if (jBExaminar == null) {
			jBExaminar = new JButton();
			jBExaminar.setBounds(new Rectangle(425, 70, 131, 25));
			jBExaminar.setText("Examinar");
			jBExaminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fc = new JFileChooser();
					fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					int returnVal = fc.showDialog(jPBase, "Aceptar");
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						archivo = fc.getSelectedFile();
						getJTFrutaArchivo().setText(archivo.getPath());
						ub = new UtilidadBorrado(archivo);
					}
				}
			});
		}
		return jBExaminar;
	}

	/**
	 * This method initializes jTFrutaArchivo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFrutaArchivo() {
		if (jTFrutaArchivo == null) {
			jTFrutaArchivo = new JTextField();
			jTFrutaArchivo.setBounds(new Rectangle(14, 41, 542, 25));
			jTFrutaArchivo.setEditable(false);
		}
		return jTFrutaArchivo;
	}

	/**
	 * This method initializes jBdeleteArchivo
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBdeleteArchivo() {
		if (jBdeleteArchivo == null) {
			jBdeleteArchivo = new JButton();
			jBdeleteArchivo.setBounds(new Rectangle(14, 150, 131, 25));
			jBdeleteArchivo.setText("Borrar Archivo");
			jBdeleteArchivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if (ubEsNulo()) {
							getJTFInfo().setText("Elige el Archivo/Directorio");
						} else if (ub.deleteFile()) {
							getJTFInfo().setText("Archivo Borrado");
							java.awt.Desktop dk = null;
							dk = java.awt.Desktop.getDesktop();
							try {
								dk.open(new File(ub.getArchivo().getParent()));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else {
							getJTFInfo().setText("Problema de Borrado");
						}
					} catch (ArchivoNoBorradoException e1) {
						getJTFInfo().setText(e1.getMessage());
					}
				}
			});
		}
		return jBdeleteArchivo;
	}

	/**
	 * This method initializes jTFInfo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFInfo() {
		if (jTFInfo == null) {
			jTFInfo = new JTextField();
			jTFInfo.setBounds(new Rectangle(357, 150, 197, 25));
			jTFInfo.setEditable(false);
		}
		return jTFInfo;
	}

	/**
	 * This method initializes jTFpatron
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFpatron() {
		if (jTFpatron == null) {
			jTFpatron = new JTextField();
			jTFpatron.setBounds(new Rectangle(14, 120, 175, 25));
		}
		return jTFpatron;
	}

	/**
	 * This method initializes jBdeleteDir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBdeleteDir() {
		if (jBdeleteDir == null) {
			jBdeleteDir = new JButton();
			jBdeleteDir.setBounds(new Rectangle(166, 150, 163, 25));
			jBdeleteDir.setText("Borrar Archivos");
			jBdeleteDir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (ubEsNulo()) {
						getJTFInfo().setText("Elige el Archivo/Directorio");
					} else {
						patron = getJTFpatron().getText();
						try {
							if (patron.equals("") && ub.isSubdirs()) {
								if (archivo.isDirectory()
										&& archivo.list().length != 0) {
									ub.deleteFilesSubDir(archivo);
								} else {
									throw new ArchivoNoBorradoException(
											"No es directorio/No existe/Es vacio");
								}
							} else if (patron.equals("") && !ub.isSubdirs()) {
								ub.deleteFilesDir(archivo);
							} else if (!ub.isSubdirs()) {
								ub.deleteFilesPatronDir(archivo, patron);
							} else {
								if (archivo.isDirectory()
										&& archivo.list().length != 0) {
									ub.deleteFilesPatronAll(archivo, patron);
								} else {
									throw new ArchivoNoBorradoException(
											"No es directorio/No existe/Es vacio");
								}
							}
							getJTFInfo().setText("Borrado Exitoso");
							java.awt.Desktop dk = null;
							dk = java.awt.Desktop.getDesktop();
							try {
								dk.open(ub.getArchivo());
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (ArchivoNoBorradoException e1) {
							getJTFInfo().setText(e1.getMessage());
						}
					}
				}
			});
		}
		return jBdeleteDir;
	}

	private boolean ubEsNulo() {
		return ub == null ? true : false;
	}

	/**
	 * This method initializes jCBborrarTo
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCBborrarTo() {
		if (jCBborrarTo == null) {
			jCBborrarTo = new JCheckBox("Borrado en Subdirectorios", false);
			jCBborrarTo.setBounds(new Rectangle(197, 121, 178, 21));
			jCBborrarTo.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if (ubEsNulo()) {
						getJTFInfo().setText("Elige el Archivo/Directorio");
						jCBborrarTo.setSelected(false);
					} else {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							ub.setSubdirs(true);
						} else {
							ub.setSubdirs(false);
						}
					}
				}
			});

		}
		return jCBborrarTo;
	}

}
