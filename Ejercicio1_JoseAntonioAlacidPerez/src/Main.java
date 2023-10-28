import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arrayNumeros = new int[1000];
        Hilo[] hilos = new Hilo[5];
        int suma = 0;
        int subconjunto = arrayNumeros.length / hilos.length;

        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = r.nextInt(101);
        }

        for (int i = 0; i < hilos.length; i++) {
            int inicio = i * subconjunto;
            int fin;
            if (i == hilos.length - 1) {
                fin = arrayNumeros.length;
            } else {
                fin = (i + 1) * subconjunto;
            }
            String nombre = "Hilo " + (i + 1);
            hilos[i] = new Hilo(arrayNumeros, inicio, fin, nombre);
            hilos[i].start();
        }

        try {
            for (Hilo hilo : hilos) {
                hilo.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int mayorFinal = hilos[0].getMayor();
        for (int i = 1; i < hilos.length; i++) {
            int mayor = hilos[i].getMayor();
            if (mayor > mayorFinal) {
                mayorFinal = mayor;
            }
        }

        for (int numero : arrayNumeros) {
            suma += numero;
        }

        System.out.println("Máximo final: " + mayorFinal);
        System.out.println("Suma final: " + suma);
    }
}
