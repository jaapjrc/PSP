public class Vasija {
    private double litros;

    public Vasija() {
        this.litros = 0;
    }

    public synchronized void generarPocima() {
        if (litros < 5) {
            litros++;
            System.out.println("Se ha generado 1 litro de pócima. Cantidad actual: " + litros + " litros.");
        }
    }

    public synchronized int tomarPocima() {
        if (litros >= 0.5) {
            litros -= 0.5;
            System.out.println("Un orco ha tomado medio litro de pócima. Cantidad actual: " + litros + " litros.");
            return 3;
        }
        return 0;
    }
}
