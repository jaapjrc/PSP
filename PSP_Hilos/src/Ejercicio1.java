import java.util.Random;

public class Ejercicio1 extends Thread{
    private int[] array;
    private int inicio;
    private int fin;
    private int mayor;
    private String nombre;
    public Ejercicio1(int[] array, int inicio, int fin, String nombre){
        this.array = array;
        this.inicio = inicio;
        this.fin = fin;
        this.nombre = nombre;
    }

    @Override
    public void run(){
        mayor = array[inicio];

        for (int i = inicio + 1; i < fin; i++){
            if (array[i] > mayor){
                mayor = array[i];
            }
        }

        System.out.println(nombre + ": " + mayor);
    }

    public int getMayor(){
        return mayor;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] arrayNumeros = new int[1000];
        Ejercicio1[] hilos = new Ejercicio1[5];

        int subconjunto = arrayNumeros.length / hilos.length;

        for (int i = 0; i < arrayNumeros.length; i++){
            arrayNumeros[i] = r.nextInt(101);
        }

        for (int i = 0; i < hilos.length; i++){
            int inicio = i * subconjunto;
            int fin = 0;
            if (i == hilos.length - 1){
                fin = arrayNumeros.length;
            } else {
                fin = (i + 1) * subconjunto;
            }
            String nombre = "Hilo " + String.valueOf(i + 1);
            hilos[i] = new Ejercicio1(arrayNumeros, inicio, fin, nombre);
            hilos[i].start();
        }

        try {
            for (Ejercicio1 hilo : hilos){
                hilo.join();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        int mayorFinal = hilos[0].getMayor();
        for (int i = 1; i < hilos.length; i++){
            int mayor = hilos[i].getMayor();
            if (mayor > mayorFinal){
                mayorFinal = mayor;
            }
        }

        int suma = 0;
        for (int numero : arrayNumeros){
            suma += numero;
        }

        System.out.println("Máximo final: " + mayorFinal);
        System.out.println("Suma final: " + suma);
    }
}
