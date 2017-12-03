package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pacho
 */
public final class Restaurante {

    private ArrayList<Cocinero> cocineros;
    private ArrayList<Cliente> clientes;
    
    private final Bufet bufet_hamburguesas;

    public Restaurante() {
        this.bufet_hamburguesas = new Bufet();

        this.cocineros = new ArrayList<>();
        

        this.clientes = new ArrayList<>();
        

        crearClients();
        crearCocineros();
        crearHilos();
        

    }

    public void crearClients() {
        for (int i = 1; i <= 100; i++) {
            this.clientes.add(new Cliente(this.bufet_hamburguesas, i));
        }

    }

    public void crearCocineros() {
        for (int x = 1; x <= 10; x++) {
            this.cocineros.add(new Cocinero(this.bufet_hamburguesas, x));
        }

    }

    public void crearHilos() {
        for (Cliente c : this.clientes) {
          new Thread(c).start();
        }
        for (Cocinero k : this.cocineros) {
            new Thread(k).start();
        }
    }

    public void ejecutarHilos() {
        

    }

}
