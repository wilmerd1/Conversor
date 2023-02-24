package Clases;

import Interfaz.Interfaz;

public class Operaciones {

	public static void Operacion() {
				
		Interfaz interfaz = new Interfaz();


		String moneda1 = (String) interfaz.getComboBox1().getSelectedItem();
		String moneda2 = (String) interfaz.getComboBox2().getSelectedItem();
				System.out.println("Combo1 " + moneda1);
				System.out.println("Combo2 " + moneda2);
		boolean validador = true;

		while (validador) {
			
			if (moneda1.equals("USD") && moneda2.equals("EUR")) {
				System.out.println("Realizar USD a  EUR");
				break;
			} else if (moneda1.equals("EUR") && moneda2.equals("USD")) {
				System.out.println("Realizar EUR a USD");
				break;
			} System.out.println("Mirar Otras");
			break;
			
		}

	}
}