package Clases;
import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		
		Divisas divisas = new Divisas();
		String num1= JOptionPane.showInputDialog(args);
		
		double dolar = Double.parseDouble(num1) ;
		
		Double pesoCol=4896.18;
		divisas.setNumero(dolar);
		
		
		System.out.println(dolar+" Dólar Estadounidense, Equivale a $"+dolar*pesoCol+" Peso Colombiano");
		
		
		

	}

}
