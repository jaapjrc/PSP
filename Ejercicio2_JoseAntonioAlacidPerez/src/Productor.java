public class Productor implements Runnable {
    private final String nombre;
    private final Producto producto;

    public Productor(String nombre, Producto producto) {
        this.nombre = nombre;
        this.producto = producto;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.producto.producir(this.nombre);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
