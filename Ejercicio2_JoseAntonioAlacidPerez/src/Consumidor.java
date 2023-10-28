public class Consumidor implements Runnable {
    private final String nombre;
    private final Producto producto;

    public Consumidor(String nombre, Producto producto) {
        this.nombre = nombre;
        this.producto = producto;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.producto.consumir(this.nombre);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
