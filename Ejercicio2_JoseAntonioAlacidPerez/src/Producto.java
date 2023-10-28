public class Producto {
    private int cantidad;
    private static final int MAXIMO = 5;

    public Producto(int cantidad) {
        this.cantidad = cantidad;
    }

    public synchronized void consumir(String nombre) throws InterruptedException {
        while (this.cantidad == 0) {
            wait();
        }

        this.cantidad--;
        System.out.println(nombre + " consume, cantidad actual: " + this.cantidad);
        notify();
        Thread.sleep(2000);
    }

    public synchronized void producir(String nombre) throws InterruptedException {
        while (this.cantidad == MAXIMO) {
            wait();
        }

        this.cantidad++;
        System.out.println(nombre + " produce, cantidad actual: " + this.cantidad);
        notify();
        Thread.sleep(1000);
    }

}
