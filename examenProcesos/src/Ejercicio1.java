
public class Ejercicio1 {
    public static void main(String[] args) {
        ProcessBuilder pb1 = new ProcessBuilder();

        pb1.command("notepad");

        ProcessBuilder pb = new ProcessBuilder();

        pb.command("mspaint");

        for (int i = 0; i < 2; i++) {
            try {
                pb.start();
                pb1.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
