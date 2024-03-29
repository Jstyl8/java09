package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import reflejos.UtilidadReflejos;

public class ReflejosFrame extends JFrame {

	private JPanel jPBase = null;
	private JButton jBEmpezar = null;
	private JButton jBReiniciar = null;
	private JButton jBParar = null;
	private JTextField jTFTime = null;
	private JTextPane jTPya = null;
	private static long startTime;
	private static long elapsedTime;
	private JLabel jLseg = null;
	private JTextArea jTAInfo = null;
	private UtilidadReflejos ur;
	private String listado;
	private JTextArea jTAListado = null;
	private JScrollPane sbrText = null;
	private JMenuBarJ jMBJ = null;

	/**
	 * This is the default constructor
	 */
	public ReflejosFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(360, 230);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/visual/imgs/eldeorrr.jpg")));
		this.setJMenuBar(getJMBJ());
		this.setContentPane(getJBase());
		this.setResizable(false);
		this.setTitle("Reflejos");
		ur = new UtilidadReflejos(3);
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
					new JDialogAcercade(this, "Reflejos", "1.1 07/11/2010",
							"Jstyl_8", "http://jstyl8.net46.net",
							"/visual/imgs/eldeorrr.jpg"),
					new JDialogComoUsar(this, "Usalo libremente, es gratis.",
							"Tan simple como pinchar en empezar, contar hasta 3 y ver si has atinao!."));

		}
		return jMBJ;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJBase() {
		if (jPBase == null) {
			jPBase = new JPanel();
			jLseg = new JLabel();
			jLseg.setBounds(new Rectangle(284, 97, 60, 19));
			jLseg.setText("Segundos");

			jPBase.setLayout(null);
			jPBase.add(getJBEmpezar(), null);
			jPBase.add(getJBReiniciar(), null);
			jPBase.add(getJBParar(), null);
			jPBase.add(getJTFTime(), null);
			jPBase.add(getJTPya(), null);
			jPBase.add(jLseg, null);
			jPBase.add(getJTAInfo(), null);
			jPBase.add(getJTAListado(), null);

			sbrText = new JScrollPane(jTAListado);
			sbrText.setBounds(new Rectangle(4, 135, 340, 61));
			sbrText.setViewportView(getJTAListado());
			sbrText
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			jPBase.add(sbrText, null);
		}
		return jPBase;
	}

	/**
	 * This method initializes jBEmpezar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBEmpezar() {
		if (jBEmpezar == null) {
			jBEmpezar = new JButton();
			jBEmpezar.setBounds(new Rectangle(4, 9, 84, 29));
			jBEmpezar.setText("Empezar");
			jBEmpezar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					jBParar.setEnabled(true);
					jTPya.setBackground(Color.blue);
					jTPya.setText("     íPARALO!");
					startTime = System.nanoTime();
				}
			});
		}
		return jBEmpezar;
	}

	/**
	 * This method initializes jBReiniciar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBReiniciar() {
		if (jBReiniciar == null) {
			jBReiniciar = new JButton();
			jBReiniciar.setBounds(new Rectangle(96, 9, 84, 29));
			jBReiniciar.setText("Reiniciar");
			jBReiniciar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTPya.setBackground(Color.red);
					jTPya.setText("┐PREPARADO?");
					jTFTime.setText(null);
					jBParar.setEnabled(false);
					jBEmpezar.setEnabled(true);
					jTAListado.setText(null);
					ur.borrarDatos();
				}
			});
		}
		return jBReiniciar;
	}

	/**
	 * This method initializes jBParar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBParar() {
		if (jBParar == null) {
			jBParar = new JButton();
			jBParar.setBounds(new Rectangle(4, 87, 180, 44));
			jBParar.setText("Parar");
			jBParar.setEnabled(false);
			jBParar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					elapsedTime = System.nanoTime() - startTime;
					double dif = elapsedTime - ur.getTiempoBasens();
					jTFTime.setText(ur.getFormatter().format(
							dif * UtilidadReflejos.tos));
					jBParar.setEnabled(false);
					ur.insertarOrdenado(dif);
					listado = ur.RealizarListado();
					jTAListado.setText(listado);
					jTPya.setBackground(Color.red);
					jTPya.setText("┐PREPARADO?");

				}
			});
		}
		return jBParar;
	}

	/**
	 * This method initializes jTFTime
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTFTime() {
		if (jTFTime == null) {
			jTFTime = new JTextField();
			jTFTime.setBounds(new Rectangle(193, 87, 86, 44));
			jTFTime.setEditable(false);
		}
		return jTFTime;
	}

	/**
	 * This method initializes jTPya
	 * 
	 * @return javax.swing.JTextPane
	 */
	private JTextPane getJTPya() {
		if (jTPya == null) {
			jTPya = new JTextPane();
			jTPya.setBounds(new Rectangle(4, 50, 145, 33));
			jTPya.setEditable(false);
			jTPya.setBackground(Color.red);
			jTPya.setText("┐PREPARADO?");
			jTPya.setFont(new Font("Dialog", Font.BOLD, 18));
		}
		return jTPya;
	}

	/**
	 * This method initializes jTAInfo
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTAInfo() {
		if (jTAInfo == null) {
			jTAInfo = new JTextArea();
			jTAInfo.setBounds(new Rectangle(186, 9, 158, 55));
			jTAInfo
					.setText("Pulsa Empezar, en 3 segundos pulsa Parar y veras tu tiempo de reaccion!");
			jTAInfo.setEditable(false);
			jTAInfo.setLineWrap(true);
			LineBorder b = new LineBorder(Color.black, 2);
			jTAInfo.setBorder(b);
		}
		return jTAInfo;
	}

	/**
	 * This method initializes jTAListado
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTAListado() {
		if (jTAListado == null) {
			jTAListado = new JTextArea();
			jTAListado.setBounds(new Rectangle(4, 136, 339, 60));
			jTAListado.setEditable(false);
		}
		return jTAListado;
	}

}
