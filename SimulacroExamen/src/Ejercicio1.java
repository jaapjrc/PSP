/*(1 punto) Crea un programa que:
        a. Abra un proceso del Bloc de notas y otro de Paint
        b. Espere hasta que terminen ambos de ejecutarse
        c. Después muestre un mensaje en pantalla con el mensaje "Ya han terminado
        ellos y ahora termino yo".*/

import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        ProcessBuilder pb1 = new ProcessBuilder();

        pb1.command("notepad");

        ProcessBuilder pb2 = new ProcessBuilder();

        pb2.command("mspaint");


        try {
            Process process = pb1.start();
            Process p = pb2.start();
            process.waitFor();
            p.waitFor();
            System.out.println("Ya han terminado ellos y ahora termino yo");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
