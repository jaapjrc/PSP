import java.util.Random;

public class Ejercicio4 {
    public static void main(String[] args) {

        Random r = new Random();
        Random r1 = new Random();
        Random r2 = new Random();
        int[] a = new int[100];
        int[] a1 = new int[100];
        int[] a2 = new int[100];

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(51);
            a1[i] = r1.nextInt(51);
            a2[i] = r2.nextInt(51);
        }

        Hilo h = new Hilo(a,0,0);
        Hilo h1 = new Hilo(a1,0,0);
        Hilo h2 = new Hilo(a2,0,0);

        if (h.getMaximo() > h1.getMaximo() && h.getMaximo() > h2.getMaximo()){
            if (h1.getMaximo() > h2.getMaximo()){
                System.out.println("Max h: " + h.getMaximo() + ", max h1: " + h1.getMaximo() + ", max h2:" + h2.getMaximo());
            }
        }
    }

}

class Hilo extends Thread {
    private int[] miarray;
    private int maximo;
    private int minimo;

    public Hilo(int[] miarray, int maximo, int minimo) {
        this.miarray = miarray;
        this.maximo = maximo;
        this.minimo = minimo;
    }

    public int[] getMiarray() {
        return miarray;
    }

    public void setMiarray(int[] miarray) {
        this.miarray = miarray;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    @Override
    public void run() {
        for (int i = 0; i < miarray.length; i++) {
            if (maximo < miarray[i]){
                maximo = miarray[i];
            }
            if (minimo > miarray[i]){
                minimo = miarray[i];
            }
        }
    }
}
