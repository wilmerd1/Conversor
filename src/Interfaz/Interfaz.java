package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import Clases.Divisa;
import Clases.DivisasList;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class Interfaz extends JFrame {
	JComboBox<String> comboBox1 = new JComboBox<>();
	JComboBox<String> comboBox2 = new JComboBox<>();
	/**
	 * Launch the application.
	 */
	static double pesoCol = 4896.18;

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

	/**
	 * Create the frame.
	 */

	public void invertirSeleccion() {
		int index1 = comboBox1.getSelectedIndex();
		int index2 = comboBox2.getSelectedIndex();
		int temp = index1;
		index1 = index2;
		index2 = temp;
		comboBox1.setSelectedIndex(index1);
		comboBox2.setSelectedIndex(index2);
	}

	public Interfaz() {
		setFont(new Font("Roboto", Font.BOLD, 12));
		setResizable(false);
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 434, 261);
		getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		// comboBox1.setModel(new DefaultComboBoxModel<String>(new String[] { "USD",
		// "EUR", "Peso COL" }));
		// comboBox2.setModel(new DefaultComboBoxModel<String>(new String[] { "USD",
		// "EUR", "Peso COL" }));

		// Crear el ComboBox

		comboBox1.setBounds(103, 62, 201, 22);
		desktopPane.add(comboBox1);

		comboBox2.setBounds(103, 138, 201, 22);
		desktopPane.add(comboBox2);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				invertirSeleccion();
			}
		});
		btnNewButton.setBounds(41, 198, 89, 23);
		desktopPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * String moneda1 = (String) comboBox1.getSelectedItem().toString();
				 * String moneda2 = (String) comboBox2.getSelectedItem().toString();
				 * System.out.println("Combo1 " + moneda1);
				 * System.out.println("Combo2 " + moneda2);
				 * System.out.println("  ");
				 */
				OperacionDivisas();
				// Operaciones.Operacion();
			}

		});
		btnNewButton_1.setBounds(215, 198, 89, 23);
		desktopPane.add(btnNewButton_1);

		// Obtener los datos de
		DivisasList datos = new DivisasList();

		// Llenar el ComboBox con los datos
		for (Divisa dato : datos.getListaDatos()) {
			comboBox1.addItem(dato.getMoneda());
		}

		// Llenar el ComboBox con los datos
		for (Divisa dato : datos.getListaDatos()) {
			comboBox2.addItem(dato.getMoneda());
		}

	}

	protected void OperacionDivisas() {

		String moneda1 = (String) getComboBox1().getSelectedItem();
		String moneda2 = (String) getComboBox2().getSelectedItem();

		String clave = moneda1 + " - " + moneda2;
		System.out.println("Combo1 " + moneda1);
		System.out.println("Combo2 " + moneda2);
		System.out.println(" ");

		Map<String, String> opciones = new HashMap<>();
		opciones.put("USD - EUR", "USD a EUR");
		opciones.put("USD - COP", "USD a COP");

		opciones.put("EUR - USD", "EUR a USD");
		opciones.put("EUR - COP", "EUR a COP");

		opciones.put("COP - USD", "COP a USD");
		opciones.put("COP - EUR", "COP a EUR");

		String resultado = opciones.get(clave);

		if (resultado == null) {

			System.out.println("Cambie de Divisa no pueden ser las mismas");

		} else {

			System.out.println("Solución: " + resultado);
		}

	};

	// para evitar el uso de if anidados se usa el HashMap para mejor lectura 

	/*
	 * while (validador) {
	 * 
	 * if (moneda1.equals("USD") && moneda2.equals("EUR")) {
	 * System.out.println("Realizar USD a  EUR");
	 * break;
	 * } else if (moneda1.equals("EUR") && moneda2.equals("USD")) {
	 * System.out.println("Realizar EUR a USD");
	 * break;
	 * } System.out.println("Mirar Otras");
	 * break;
	 * 
	 * }
	 */

	public JComboBox<String> getComboBox1() {
		return comboBox1;
	}

	public JComboBox<String> getComboBox2() {
		return comboBox2;
	}

}
