import java.util.Random;

public class UsaHilos {
    public static void main(String[] args) {
        Random r = new Random();

        double[] a = new double[500];
        double[] a1 = new double[500];
        double[] a2 = new double[500];
        double[] a3 = new double[500];

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextDouble(51);
            a1[i] = r.nextDouble(101);
            a2[i] = r.nextDouble(1001);
            a3[i] = r.nextDouble(21);
        }

        Hilo h = new Hilo(a, 0, 0);
        Hilo h1 = new Hilo(a1, 0, 0);
        Hilo h2 = new Hilo(a2, 0, 0);
        Hilo h3 = new Hilo(a3, 0, 0);

        h.start();
        h1.start();
        h2.start();
        h3.start();

        double mediaTodos;
        mediaTodos = (h.getSuma() + h1.getSuma() + h2.getSuma() + h3.getSuma()) / 4;

        System.out.println("Media de los 4 arrays: " + mediaTodos);
        System.out.println("Media del primer array: " + h.getMedia());
        System.out.println("Media del segundo array: " + h1.getMedia());
        System.out.println("Media del tercer array: " + h2.getMedia());
        System.out.println("Media del cuarto array: " + h3.getMedia());
    }
}
