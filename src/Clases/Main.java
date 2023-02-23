package Clases;

public class Main {

	public static void main(String[] args) {
		
		double dolar= 1;
		double pesoCol=4896.18;
		Divisas divisas = new Divisas();
		
		divisas.setNumero(dolar);
		
		System.out.println(dolar+" Dólar Estadounidense, Equivale a $"+pesoCol+" Peso Colombiano");
		
		
		

	}

}
