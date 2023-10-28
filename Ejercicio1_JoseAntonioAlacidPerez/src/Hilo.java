public class Hilo extends Thread {
    private final int[] array;
    private final int inicio;
    private final int fin;
    private int mayor;
    private final String nombre;

    public Hilo(int[] array, int inicio, int fin, String nombre) {
        super();
        this.array = array;
        this.inicio = inicio;
        this.fin = fin;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        mayor = array[inicio];

        for (int i = inicio + 1; i < fin; i++) {
            if (array[i] > mayor) {
                mayor = array[i];
            }
        }

        System.out.println(nombre + ": " + mayor);
    }

    public int getMayor() {
        return mayor;
    }
}
