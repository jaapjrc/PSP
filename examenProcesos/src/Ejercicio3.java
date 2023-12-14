import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");
        pb.redirectErrorStream(true);
        ProcessBuilder pb1 = new ProcessBuilder("cmd.exe", "/c", "dir > muestra.txt");
        pb.redirectErrorStream(true);
        Process p;
        try {
            p = pb.start();
            pb1.start();
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
