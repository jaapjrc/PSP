/*Crea un programa que ejecute el comando DIR con el parámetro /D y que
        muestre su resultado en la pantalla*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir /D");
        pb.redirectErrorStream(true);
        Process p;
        try {
            p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String linea;
        do {
            try {
                linea = r.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(linea);
        } while (linea != null);
    }
}
