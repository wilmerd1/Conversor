package Clases;

import java.util.ArrayList;
import java.util.List;

public class DivisasList {
	private List<Divisa> listaDatos;

    public DivisasList() {
        listaDatos = new ArrayList<>();

        // Agregar algunos datos a la lista
        Divisa dato1 = new Divisa();
        dato1.setMoneda("USD");
        listaDatos.add(dato1);

        Divisa dato2 = new Divisa();
        dato2.setMoneda("EUR");
        listaDatos.add(dato2);

        Divisa dato3 = new Divisa();
        dato3.setMoneda("COP");
        listaDatos.add(dato3);
    }

    public List<Divisa> getListaDatos() {
        return listaDatos;
    }
    
}