/**
 * 
 */
package visual;

import gen.UtilidadRenombre;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase visual para la utilidadrenombre
 * 
 * @author Jose Angel Garcia Fernandez
 * @version 1.0 28/12/2009
 */
public class Renombrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTFnuevo = null;
	private JTextField jTFpatron = null;
	private JLabel jLpatron = null; // @jve:decl-index=0:visual-constraint="603,10"
	private JLabel jLnuevo = null;
	private JLabel jLinfo = null;
	private JButton jBrenombre = null;
	private JButton jBdir = null;
	private JFileChooser fc;

	private UtilidadRenombre util = null;
	private File dir = null;

	/**
	 * This is the default constructor
	 */
	public Renombrador() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(245, 120);
		this.setContentPane(getJContentPane());
		this.setTitle("Renombrador");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);

			jLinfo = new JLabel();
			jLinfo.setBounds(new Rectangle(120, 55, 100, 20));
			jLinfo.setText("");

			jLnuevo = new JLabel();
			jLnuevo.setBounds(new Rectangle(120, 5, 45, 20));
			jLnuevo.setText("Nuevo:");

			jLpatron = new JLabel();
			jLpatron.setText("Patrón:");
			jLpatron.setBounds(new Rectangle(5, 5, 45, 20));

			jContentPane.add(jLpatron);
			jContentPane.add(jLnuevo);
			jContentPane.add(jLinfo);
			jContentPane.add(getJTFpatron());
			jContentPane.add(getJTFin());
			jContentPane.add(getJBrenombre());
			jContentPane.add(getJBdir());
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTFnuevo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFin() {
		if (jTFnuevo == null) {
			jTFnuevo = new JTextField();
			jTFnuevo.setBounds(new Rectangle(120, 27, 100, 20));
			jTFnuevo.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					jLinfo.setText("");
				}
			});
		}
		return jTFnuevo;
	}

	/**
	 * This method initializes patron
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFpatron() {
		if (jTFpatron == null) {
			jTFpatron = new JTextField();
			jTFpatron.setBounds(new Rectangle(5, 27, 100, 20));
			jTFpatron.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					jLinfo.setText("");
				}
			});
		}
		return jTFpatron;
	}

	/**
	 * This method initializes jBrenombre
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBrenombre() {
		if (jBrenombre == null) {
			jBrenombre = new JButton();
			jBrenombre.setBounds(new Rectangle(5, 65, 100, 15));
			jBrenombre.setText("Rename");
			jBrenombre.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String rutaBase;
					if (dir == null)
						rutaBase = System.getProperty("user.dir");
					else
						rutaBase = dir.getAbsolutePath();
					String pat = jTFpatron.getText();
					String nuevo = jTFnuevo.getText();
					if (pat.equals(nuevo)) {
						jLinfo.setText("IGUALES!");
					} else if (pat.equals("")) {
						jLinfo.setText("NO HAY PATRÓN!");
					} else {
						util = new UtilidadRenombre(rutaBase, pat, nuevo);
						util.renombrarFicheros();
						jLinfo.setText("HECHO!");
						util.generarLog();
						java.awt.Desktop dk = null;
						dk = java.awt.Desktop.getDesktop();
						try {
							dk.open(new File(rutaBase));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return jBrenombre;
	}

	/**
	 * This method initializes jBdir
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBdir() {
		if (jBdir == null) {
			jBdir = new JButton("Selec Dir");
			jBdir.setBounds(new Rectangle(5, 48, 100, 15));
			jBdir.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					fc = new JFileChooser();
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int returnVal = fc.showDialog(jContentPane, "Aceptar");
					if (returnVal == JFileChooser.APPROVE_OPTION)
						dir = fc.getSelectedFile();
				}
			});
		}
		return jBdir;
	}
} // @jve:decl-index=0:visual-constraint="10,10"
