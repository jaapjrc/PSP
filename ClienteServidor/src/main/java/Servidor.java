import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
        public static void main(String[] args) {
            int Puerto=6000;
            while((true)) {
                ServerSocket servidor = null;
                Socket cliente = null;
                try {
                    servidor = new ServerSocket(Puerto);
                    System.out.println("Esperando al cliente...");
                    cliente = servidor.accept();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String mensaje = null;
                InputStream entrada = null;
                DataInputStream flujoEntrada = null;
                try {
                    entrada = cliente.getInputStream();
                    flujoEntrada = new DataInputStream(entrada);
                    mensaje = flujoEntrada.readUTF();
                    System.out.println("Recibiendo información del cliente: " + mensaje);
                } catch (IOException io) {
                    io.printStackTrace();
                }

                OutputStream salida = null;
                DataOutputStream flujoSalida;
                try {
                    salida = cliente.getOutputStream();
                    flujoSalida = new DataOutputStream(salida);
                    flujoSalida.writeUTF(mensaje + ". Recibido.");
                    entrada.close();
                    flujoEntrada.close();
                    salida.close();
                    flujoSalida.close();
                    cliente.close();
                    servidor.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        }
    }
