package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Interfaz extends JFrame {
	private JTextField txtNumero;
	private JTextField txtResultado;

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

	/**
	 * Create the frame.
	 */
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
		
		txtNumero = new JTextField();
		txtNumero.setBounds(124, 37, 143, 33);
		desktopPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConvertir.setBounds(272, 137, 152, 23);
		desktopPane.add(btnConvertir);
		
		txtResultado = new JTextField();
		txtResultado.setColumns(10);
		txtResultado.setBounds(124, 203, 143, 33);
		desktopPane.add(txtResultado);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 46, 104, 14);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado");
		lblNewLabel_1.setBounds(10, 212, 104, 14);
		desktopPane.add(lblNewLabel_1);
	}
}
