package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Clases.Divisa;
import Clases.DivisasList;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Interfaz extends JFrame {

	JComboBox<String> cbDivisa1 = new JComboBox<>();
	JComboBox<String> cbDivisa2 = new JComboBox<>();
	JTextField txtResultado = new JTextField();
	JDesktopPane desktopPane = new JDesktopPane();
	JTextField txtMoneda = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Getter y Setters de los ComboBox y TextField
	public JComboBox<String> getCbDivisa1() {
		return cbDivisa1;
	}

	public JComboBox<String> getCbDivisa2() {
		return cbDivisa2;
	}

	public JTextField getTxtResultado() {
		return txtResultado;
	}

	public void setTxtResultado(JTextField textField) {
		this.txtResultado = textField;
	}

	public JTextField getTxtMoneda() {
		return txtMoneda;
	}

	public void setTxtMoneda(JTextField txtMoneda) {
		this.txtMoneda = txtMoneda;
	}

	// Metodo para invertir selección de los JComboBox
	public void invertirSeleccion() {
		int index1 = cbDivisa1.getSelectedIndex();
		int index2 = cbDivisa2.getSelectedIndex();
		int temp = index1;
		index1 = index2;
		index2 = temp;
		cbDivisa1.setSelectedIndex(index1);
		cbDivisa2.setSelectedIndex(index2);
	}

	// Contructor de la Interfaz agrega toda la GUI
	public Interfaz() {
		setFont(new Font("Roboto", Font.BOLD, 12));
		setResizable(false);
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(null);

		// Ubicación de JDesktopPanel
		desktopPane.setBounds(0, 0, 450, 450);
		getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		// Ubicación del ComboBox
		cbDivisa1.setBounds(212, 11, 201, 22);
		desktopPane.add(cbDivisa1);
		cbDivisa2.setBounds(212, 67, 201, 22);
		desktopPane.add(cbDivisa2);

		datosComboBox();

		// Ubicación del texfield
		txtResultado.setBounds(35, 350, 370, 50);
		txtResultado.setEditable(false);
		desktopPane.add(txtResultado);
		txtResultado.setColumns(10);

		txtMoneda.setBounds(35, 100, 176, 46);
		desktopPane.add(txtMoneda);
		txtResultado.setColumns(10);

		// Jlabel

		JLabel lblResultado = new JLabel("Alertas - Pruebas");
		lblResultado.setBounds(35, 335, 340, 10);
		desktopPane.add(lblResultado);

		// Creación Boton Intercambio de Divisas y Operaciones
		JButton btnIntercambiarMonedas = new JButton("Intercambiar Monedas");
		// (ubicacion desde la izquierda, arriba hacia abajo, largo objeto, altura
		// objeto )
		btnIntercambiarMonedas.setBounds(37, 50, 136, 23);
		desktopPane.add(btnIntercambiarMonedas);

		JButton btnOperaciones = new JButton("Operaciones");
		btnOperaciones.setBounds(224, 111, 136, 23);
		desktopPane.add(btnOperaciones);

		// Acciones por click en el Botón Intercambiar Monedas
		btnIntercambiarMonedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acciona por botón los dos metodos
				invertirSeleccion();
				OperacionDivisas();
			}
		});

		// Acciones por click en el Botón Operaciones
		btnOperaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperacionDivisas();
			}
		});
	}

	// Metodo para agregar información a los ComboBox
	private void datosComboBox() {
		// Obtener los datos de
		DivisasList datos = new DivisasList();

		// Llenar el ComboBox Divisa 1con los datos de la Clase Divisas List
		for (Divisa dato : datos.getListaDatos()) {
			cbDivisa1.addItem(dato.getMoneda());
		}

		// Llenar el ComboBox Divisa 1con los datos de la Clase Divisas List
		for (Divisa dato : datos.getListaDatos()) {
			cbDivisa2.addItem(dato.getMoneda());
		}
	}

	// para evitar el uso de if anidados se crea un metodo HashMap para mejor
	// lectura en el codigo
	protected void OperacionDivisas() {

		String valorTexto = txtMoneda.getText();

		double valorDoble = Double.parseDouble(valorTexto);


		String divisa1 = (String) getCbDivisa1().getSelectedItem();
		String divisa2 = (String) getCbDivisa2().getSelectedItem();

		String separador = divisa1 + " - " + divisa2;
		System.out.println("Combo1 " + divisa1);
		System.out.println("Combo2 " + divisa2);
		System.out.println(" ");

		Map<String, String> opciones = new HashMap<>();
		opciones.put("USD - EUR", "USD a EUR");
		opciones.put("USD - COP", "USD a COP");
		opciones.put("EUR - USD", "EUR a USD");
		opciones.put("EUR - COP", "EUR a COP");
		opciones.put("COP - USD", "COP a USD");
		opciones.put("COP - EUR", "COP a EUR");

		String resultado = opciones.get(separador);

		if (resultado == null) {
			txtResultado.setText("Cambie de Divisa no pueden ser las mismas");
			System.out.println("Cambie de Divisa no pueden ser las mismas");

		} else if (resultado == "USD a EUR") {
			double operacon = valorDoble * 0.95;
			String solucion = Double.valueOf(operacon).toString();
			txtResultado.setText(valorTexto + " Dólar Estadounidense son " + solucion+ " Euro");
		}else if (resultado == "USD a COP") {
			double operacon = valorDoble *4841.58;
			String solucion = Double.valueOf(operacon).toString();
			txtResultado.setText(valorTexto + " Dólar Estadounidense son " + solucion+ " Peso Colombiano");
		}else if (resultado == "EUR a USD") {
			double operacon = valorDoble * 1.05;
			String solucion = Double.valueOf(operacon).toString();
			txtResultado.setText(valorTexto + " Euro son " + solucion+ " Dólar Estadounidense");
		}else if (resultado == "EUR a COP") {
			double operacon = valorDoble * 5105.49;
			String solucion = Double.valueOf(operacon).toString();
			txtResultado.setText(valorTexto + " Euro son " + solucion+ " Peso Colombiano");
		}else if (resultado == "COP a USD") {
			double operacon = valorDoble * 0.00021;
			String solucion = Double.valueOf(operacon).toString();
			txtResultado.setText(valorTexto + " Peso Colombiano son " +solucion+ " Dólar Estadounidense");
		}else if (resultado == "COP a EUR") {
			double operacon = valorDoble * 0.00019;
			String solucion = Double.valueOf(operacon).toString();
			txtResultado.setText(valorTexto + " Peso Colombiano son " + solucion+ " Euro");
		}

		/*
		 * if (resultado == null) {
		 * 
		 * txtResultado.setText("Cambie de Divisa no pueden ser las mismas"); // Imprime
		 * resultado en un TextField
		 * 
		 * System.out.println("Cambie de Divisa no pueden ser las mismas");
		 * 
		 * } else {
		 * 
		 * txtResultado.setText("Solución: " + resultado); // Imprime resultado en un
		 * TextField
		 * 
		 * System.out.println("Solución: " + resultado);
		 * }
		 */
	};

}
