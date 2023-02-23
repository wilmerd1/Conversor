package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Divisa;
import Clases.DivisasList;
import Clases.Operaciones;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class Interfaz extends JFrame {
	 public JComboBox<String> comboBox1 = new JComboBox<>();
	 public JComboBox<String> comboBox2 = new JComboBox<>();
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
        comboBox1.setModel(new DefaultComboBoxModel<String>(new String[] {"USD", "EUR","Peso COL"}));
        comboBox2.setModel(new DefaultComboBoxModel<String>(new String[] {"USD", "EUR","Peso COL"}));
        comboBox1.setSelectedIndex(-1);
        comboBox2.setSelectedIndex(-1);
		
		
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
				Operaciones.Operacion();
				
			}
		});
		btnNewButton_1.setBounds(215, 198, 89, 23);
		desktopPane.add(btnNewButton_1);
		
		
		
        // Obtener los datos de 
        DivisasList datos = new DivisasList();

        // Llenar el ComboBox con los datos
      //  for (Divisa dato : datos.getListaDatos()) {
          //  comboBox1.addItem(dato.getMoneda());
        //}
       
     // Llenar el ComboBox con los datos
     //   for (Divisa dato : datos.getListaDatos()) {
         //   comboBox2.addItem(dato.getMoneda());
       // }
        
        
        }
	public JComboBox<String> getComboBox1() {
        return comboBox1;
    }
    
    public JComboBox<String> getComboBox2() {
        return comboBox2;
}
    
    
    public JComboBox<String> setComboBox1() {
        return comboBox1;
    }
    
    public JComboBox<String> setComboBox2() {
        return comboBox2;
}
}
