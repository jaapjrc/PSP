/*Crea un programa que ejecute el comando DIR con el parámetro /D y que
        muestre su resultado en la pantalla*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {
    public static void main(String[] args) {
    /*    ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("cmd.exe", "/c", "dir /D");

        try {
            processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "dir /D");
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            try {
                line = r.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line == null) { break; }
            System.out.println(line);
        }
    }
}
