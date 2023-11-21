import java.io.*;
import java.net.Socket;

public class Actividad33 {
    public static void main(String[] args) throws Exception {
        String Host = "localhost";
        int Puerto = 6000;//puerto remoto

        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket Cliente = new Socket(Host, Puerto);

        // CREO FLUJO DE ENTRADA AL SERVIDOR
        DataInputStream flujoEntrada = new
                DataInputStream(Cliente.getInputStream());
        String mensaje=flujoEntrada.readUTF().toLowerCase();

        // EL SERVIDOR ME ENVIA UN MENSAJE
        System.out.println("Recibiendo del SERVIDOR: \n\t" +
                mensaje);

        // CREO FLUJO DE SALIDA AL SERVIDOR
        DataOutputStream flujoSalida = new
                DataOutputStream(Cliente.getOutputStream());

        // ENVIO UN SALUDO AL SERVIDOR
        flujoSalida.writeUTF(mensaje);
        flujoSalida.writeChars("jarl");

        // CERRAR STREAMS Y SOCKETS
        flujoEntrada.close();
        flujoSalida.close();
        Cliente.close();
    }
}
