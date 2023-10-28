import java.util.LinkedList;

public class Ejercicio2 {
    static class Producto {
        String nombre;
        int cantidad;

        public Producto(String nombre, int cantidad) {
            this.nombre = nombre;
            this.cantidad = cantidad;
        }

        public String getNombre() {
            return nombre;
        }
    }

    static class Lista{
        private LinkedList<Producto> productos = new LinkedList<>();

        public synchronized void producir(Producto producto) {
            productos.add(producto);
            notifyAll();
        }

        public synchronized void consumir() throws InterruptedException {
            while (productos.isEmpty()){
                wait();
            }
            productos.remove(0);
            notifyAll();
        }
    }

    static class Productor extends Thread {
        private Lista lista;
        private static String nombre;

        public Productor(Lista lista, String nombre){
            super();
            this.lista = lista;
            this.nombre = nombre;
        }

        public static String getNombre() {
            return nombre;
        }

        @Override
        public void run(){
            Producto producto = new Producto("Berserk", 33);

            while (true){
                lista.producir(producto);
                System.out.println("Productor " + getNombre() + " produce: " + producto.getNombre());
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumidor extends Thread {
        private Lista lista;
        private String nombre;

        public Consumidor(Lista lista, String nombre){
            super();
            this.lista = lista;
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public void run(){
            Producto producto = new Producto("Berserk", 33);

            while (true){
                try {
                    lista.consumir();
                    System.out.println("Consumidor " + getNombre() + " consume: " + producto.getNombre());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Lista productos = new Lista();

        Productor p1 = new Productor(productos, "Productor 1");
        Productor p2 = new Productor(productos, "Productor 2");
        Consumidor c = new Consumidor(productos, "Consumidor");

        p1.start();
        p2.start();
        c.start();

    }
}
