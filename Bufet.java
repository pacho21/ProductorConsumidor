package main;

class Bufet {

    private int hamburguesas;
    private final int maxHamburguesas;

    public Bufet() {
        this.hamburguesas = 0;
        this.maxHamburguesas = 50;
    }

    public synchronized void addHamburguesa() {
        while (this.maxHamburguesas == this.hamburguesas) {
            try {                
                this.wait();
            } catch (InterruptedException e) {

            }
        }

        this.hamburguesas++;
        notifyAll();

    }

    public synchronized void removeHamburguesa() {
        while (this.hamburguesas == 0) {
            try {                
                this.wait();
            } catch (InterruptedException e) {

            }
        }

        this.hamburguesas--;
        notifyAll();
    }
}
