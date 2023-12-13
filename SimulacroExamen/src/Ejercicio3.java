/*Crea una aplicación con Swing o JavaFX en la que haya un cuadro de texto
        y un botón. Cuando se pulse el botón, se abrirá el número de procesos del bloc de
        notas que se indique en el cuadro de texto.*/

import javax.swing.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Introduce cuantos bloc de notas quieres abrir"));
        ProcessBuilder pb1 = new ProcessBuilder();

        pb1.command("notepad");

        for (int i = 0; i < n; i++) {
            try {
                pb1.start();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
