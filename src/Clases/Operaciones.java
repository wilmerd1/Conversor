package Clases;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import Interfaz.Interfaz;

public class Operaciones {
	

			
	public static void Operacion() {
		
				
		Interfaz inter = new Interfaz();
		
		
		//int indice1 = inter.comboBox1.getSelectedIndex();
		//int indice2 = inter.comboBox2.getSelectedIndex();
		//inter.comboBox1.setSelectedIndex(indice1);
		
		String indice1 = (String)inter.comboBox1.getSelectedItem();
		String indice2 = (String)inter.comboBox2.getSelectedItem();
		
		
		System.out.println(indice1);
		System.out.println(indice2);
		
		if (indice1 == "USD" && indice2 =="USD") {
			System.out.println("Euro y peso ");
			
		}else {
			
			System.out.println("otro ");
		}
		
		
		
	    
}
	}

	
	
		
	
	

	
		
	

	

