public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto(0);

        Thread productor = new Thread(new Productor("Productor", producto));
        Thread productor2 = new Thread(new Productor("Productor2", producto));
        Thread consumidor = new Thread(new Consumidor("Consumidor", producto));

        productor.start();
        productor2.start();
        consumidor.start();

        try {
            productor.join();
            productor2.join();
            consumidor.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
