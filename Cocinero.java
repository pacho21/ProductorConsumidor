package main;

public class Cocinero implements Runnable {

    private Bufet bufet;

    private int tiempoCocinar;
    private int tiempoFumar;
    private int hamburguesas;

    private String nom;

    private boolean estado;

    public Cocinero(Bufet b, int id) {
        this.bufet = b;
        this.nom = "Cocinero " + id;
        this.tiempoCocinar = 5;
        this.tiempoFumar = 10;
        this.estado = true;
    }

    public void cocinar() {
        while (this.hamburguesas < 10) {
            try {
                Thread.sleep(this.tiempoCocinar * 10);                
                this.hamburguesas++;
            } catch (InterruptedException e) {

            }
        }

    }

    public void ponerHamburguesa() {
        while (this.hamburguesas != 0) {

            this.bufet.addHamburguesa();
            this.hamburguesas--;
        }
    }

    public void fumar() {
        try {            
            Thread.sleep(this.tiempoFumar * 1000);

        } catch (InterruptedException e) {

        }
    }

    @Override
    public void run() {
        while (estado) {
            cocinar();
            ponerHamburguesa();
            fumar();
        }
    }

}
