package Clases;

import java.util.ArrayList;
import java.util.List;

public class DivisasList {
	private List<Divisa> listaDatos;

    public DivisasList() {
        listaDatos = new ArrayList<>();

        // Agregar algunos datos a la lista
        Divisa moneda1 = new Divisa();
        moneda1.setMoneda("USD");
        listaDatos.add(moneda1);

        Divisa moneda2 = new Divisa();
        moneda2.setMoneda("EUR");
        listaDatos.add(moneda2);

        Divisa moneda3 = new Divisa();
        moneda3.setMoneda("COP");
        listaDatos.add(moneda3);
    }

    public List<Divisa> getListaDatos() {
        return listaDatos;
    }
    
}