package Interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Interfaz extends JFrame {

	// creación objetos
	JComboBox<String> cbDivisa1 = new JComboBox<>();
	JComboBox<String> cbDivisa2 = new JComboBox<>();
	JDesktopPane desktopPane = new JDesktopPane();
	JTextField txtResultado = new JTextField();
	JTextField txtMoneda = new JTextField();
	JButton btnIntercambiarMonedas = new JButton("Alternar");
	JButton btnOperaciones = new JButton("Calcular");
	JLabel lblDuno = new JLabel("Dolar USA");
	JLabel lblDdos = new JLabel("Dolar USA");

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

	// Contructor de la Interfaz agrega toda la GUI
	public Interfaz() {

		objetos();

	}

	private void objetos() {

		setResizable(false); // Evitar que pueda modificar el tamaño de la ventana
		setFont(new Font("Roboto", Font.BOLD, 12));
		setTitle("Conversor Monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 220);
		getContentPane().setLayout(null);

		// Ubicación de JDesktopPanel
		desktopPane.setBounds(0, 0, 573, 181);
		getContentPane().add(desktopPane);

		// Ubicación del ComboBox
		cbDivisa1.setToolTipText("Seleciona la divisa principal \r\n");
		cbDivisa2.setToolTipText("Seleciona la divisa a convertir \r\n");
		txtResultado.setEditable(false); // Evitamos que pueda editar la casilla del Resultado
		txtResultado.setColumns(10);
		txtResultado.setColumns(10);
		datosComboBox(); // rellena el comboBox con el metodo

		// Iconos
		ImageIcon iconCambioDivisa = new ImageIcon("src/imagenes/cambios_divisa.png");
		ImageIcon iconCalcular = new ImageIcon("src/imagenes/calcular.png");
		ImageIcon iconEuro = new ImageIcon("src/imagenes/euro.png");
		ImageIcon iconDolar = new ImageIcon("src/imagenes/dollar.png");
		ImageIcon iconPesoCol = new ImageIcon("src/imagenes/peso.png");

		// Botone Intercambio de Divisas y Operaciones

		btnIntercambiarMonedas.setToolTipText("Intercambiar Divisas");
		btnIntercambiarMonedas.setIcon(iconCambioDivisa);
		btnIntercambiarMonedas.setFont(new Font("Roboto", Font.BOLD, 14));
		btnOperaciones.setToolTipText("Calcular Divisas");
		btnOperaciones.setIcon(iconCalcular);
		btnOperaciones.setFont(new Font("Roboto", Font.BOLD, 14));

		// Asignar icono a los Label
		lblDuno.setIcon(iconDolar);
		lblDuno.setFont(new Font("Roboto", Font.BOLD, 13));
		lblDdos.setIcon(iconDolar);
		lblDdos.setFont(new Font("Roboto", Font.BOLD, 13));

		// Layout y ubicación de Objetos
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
				gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane.createSequentialGroup()
								.addGap(19)
								.addComponent(lblDuno, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(cbDivisa1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(txtMoneda, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_desktopPane.createSequentialGroup()
								.addGap(19)
								.addComponent(lblDdos, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(cbDivisa2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(txtResultado, GroupLayout.PREFERRED_SIZE, 252,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_desktopPane.createSequentialGroup()
								.addGap(125)
								.addComponent(btnIntercambiarMonedas, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
								.addGap(91)
								.addComponent(btnOperaciones, GroupLayout.PREFERRED_SIZE, 136,
										GroupLayout.PREFERRED_SIZE)
								.addGap(85)));
		gl_desktopPane.setVerticalGroup(
				gl_desktopPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_desktopPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtMoneda, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDuno, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cbDivisa1, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))
								.addGap(11)
								.addGroup(gl_desktopPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtResultado, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDdos, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(cbDivisa2, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))
								.addGap(38)
								.addGroup(gl_desktopPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnIntercambiarMonedas, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnOperaciones, GroupLayout.PREFERRED_SIZE, 40,
												GroupLayout.PREFERRED_SIZE))));
		gl_desktopPane.setHonorsVisibility(false);
		desktopPane.setLayout(gl_desktopPane);

		// Cambio de iconos en los Label de acuerdo a la selección
		cbDivisa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cbDivisa1.getSelectedItem().equals("USD")) {
					lblDuno.setIcon(iconDolar);
					lblDuno.setText("Dolar USA");
				} else if (cbDivisa1.getSelectedItem().equals("EUR")) {
					lblDuno.setIcon(iconEuro);
					lblDuno.setText("Euro");
				} else if (cbDivisa1.getSelectedItem().equals("COP")) {
					lblDuno.setIcon(iconPesoCol);
					lblDuno.setText("Peso COL");
				}

			}
		});

		// Cambio de iconos en los Label de acuerdo a la selección
		cbDivisa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cbDivisa2.getSelectedItem().equals("USD")) {
					lblDdos.setIcon(iconDolar);
					lblDdos.setText("Dolar USA");
				} else if (cbDivisa2.getSelectedItem().equals("EUR")) {
					lblDdos.setIcon(iconEuro);
					lblDdos.setText("Euro");
				} else if (cbDivisa2.getSelectedItem().equals("COP")) {
					lblDdos.setIcon(iconPesoCol);
					lblDdos.setText("Peso COL");
				}

			}
		});

		// llama al metodo Operacion Divisas
		btnOperaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacionDivisas();
			}
		});

		// Llama a los metodos
		btnIntercambiarMonedas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invertirSeleccionComboBox();
				invertirResultado();
				operacionDivisas();
			}
		});

	}

	// Metodo para agregar información a los ComboBox
	private void datosComboBox() {

		// Obtener los datos de la Clase DivisasList
		DivisasList datos = new DivisasList();

		// Llenar el ComboBox Divisa1 con los datos de la Clase Divisas List
		for (Divisa dato : datos.getListaDatos()) {
			cbDivisa1.addItem(dato.getMoneda());
		}

		// Llenar el ComboBox Divisa2 con los datos de la Clase Divisas List
		for (Divisa dato : datos.getListaDatos()) {
			cbDivisa2.addItem(dato.getMoneda());
		}
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
	public void invertirSeleccionComboBox() {
		int index1 = cbDivisa1.getSelectedIndex();
		int index2 = cbDivisa2.getSelectedIndex();
		int temp = index1;
		index1 = index2;
		index2 = temp;
		cbDivisa1.setSelectedIndex(index1);
		cbDivisa2.setSelectedIndex(index2);
	}

	// Invertir resultados en los JtextField
	public void invertirResultado() {
		String index1 = txtMoneda.getText();
		String index2 = txtResultado.getText();
		String temp = index1;
		index1 = index2;
		index2 = temp;
		txtMoneda.setText(index1);
		txtResultado.setText(index2);
	}

	// para evitar el uso de if anidados se crea un metodo HashMap para mejor
	// lectura en el codigo
	protected void operacionDivisas() {
		try {
			
			String valorTexto = txtMoneda.getText(); // toma el valor ingresado
			double valorDoble = Double.parseDouble(valorTexto); // se pasa a double para poder hacer las operaciones
			String divisa1 = (String) getCbDivisa1().getSelectedItem(); // * obtenemos el valor del combobox
			String divisa2 = (String) getCbDivisa2().getSelectedItem(); // * obtenemos el valor del combobox
			String separador = divisa1 + " - " + divisa2; // ! el separador usado entre las elecciones

			// HashMap con las posibles combinaciones
			Map<String, String> opciones = new HashMap<>();
			opciones.put("USD - EUR", "USD a EUR");
			opciones.put("USD - COP", "USD a COP");
			opciones.put("EUR - USD", "EUR a USD");
			opciones.put("EUR - COP", "EUR a COP");
			opciones.put("COP - USD", "COP a USD");
			opciones.put("COP - EUR", "COP a EUR");

			String resultado = opciones.get(separador);

			// Comprobacion del resultado y posibles combinaciones con sus operaciones
			if (resultado == null) {
				JOptionPane.showMessageDialog(null, "Las Divisas no pueden ser iguales", "Alerta",
						JOptionPane.ERROR_MESSAGE);
			} else if (resultado == "USD a EUR") {
				double operacion = valorDoble * 0.95;
				String solucion = Double.valueOf(operacion).toString();
				txtResultado.setText(solucion);
			} else if (resultado == "USD a COP") {
				double operacion = valorDoble * 4841.58;
				String solucion = Double.valueOf(operacion).toString();
				txtResultado.setText(solucion);
			} else if (resultado == "EUR a USD") {
				double operacion = valorDoble * 1.05;
				String solucion = Double.valueOf(operacion).toString();
				txtResultado.setText(solucion);
			} else if (resultado == "EUR a COP") {
				double operacion = valorDoble * 5105.49;
				String solucion = Double.valueOf(operacion).toString();
				txtResultado.setText(solucion);
			} else if (resultado == "COP a USD") {
				double operacion = valorDoble * 0.00021;
				String solucion = Double.valueOf(operacion).toString();
				txtResultado.setText(solucion);
			} else if (resultado == "COP a EUR") {
				double operacion = valorDoble * 0.00019;
				String solucion = Double.valueOf(operacion).toString();
				txtResultado.setText(solucion);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico unicamente", "Error!", JOptionPane.ERROR_MESSAGE);

		}

	}
}
