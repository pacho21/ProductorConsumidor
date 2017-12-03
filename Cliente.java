package main;

public class Cliente implements Runnable {

    private Bufet bufet;

    private String nom;
    private int hamburguesa;

    private int tiempoComer;
    private int tiempoDescansar;
    private boolean estado;

    public Cliente(Bufet b, int id) {
        this.tiempoComer = (5 + (int) (Math.random() * 10));;
        this.hamburguesa = 0;
        this.bufet = b;
        this.tiempoDescansar = (1 + (int) (Math.random() * 60));
        this.nom = "Cliente " + id;
        this.estado = true;
    }

    public void cogerHamburguesa() {
        this.bufet.removeHamburguesa();
        this.hamburguesa++;
        System.out.println(this.nom + " ha cogio una hamburguesha");
    }

    public void comer() {
        while (this.hamburguesa > 0) {
            try {
                System.out.println(this.nom + " ta comiendo :-)");
                Thread.sleep(this.tiempoComer * 1000);
                this.hamburguesa--;
            } catch (InterruptedException e) {

            }
        }

    }

    public void descansar() {

        try {
            System.out.println(nom
                    + " pasea por ahi");
            Thread.sleep(this.tiempoDescansar*10000);
        } catch (InterruptedException e) {

        }

    }

    public void entrar() {
        System.out.println(this.nom
                + " ha entrado en el rte");
    }

    public void salir() {
        System.out.println(this.nom
                + " ha salido del rte");
    }

    @Override
    public void run() {
        //lo que va a hacer (comer beber etc)
        while (estado) {
            entrar();
            cogerHamburguesa();
            comer();
            salir();
            descansar();

        }
    }

}
