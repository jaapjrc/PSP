import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        int Puerto=6000;
        ServerSocket servidor=null;
        Socket c1=null;
        try {
            servidor = new ServerSocket(Puerto);
            System.out.println("Esperando al cliente...");
            c1 = servidor.accept();
        }catch (Exception e){
            e.printStackTrace();
        }

        InputStream entrada=null;
        DataInputStream flujoEntrada=null;
        try{
            entrada=c1.getInputStream();
            flujoEntrada=new DataInputStream(entrada);
            System.out.println("Recibiendo información del cliente..." + flujoEntrada.readUTF());
        }catch (IOException io){
            io.printStackTrace();
        }

        OutputStream salida=null;
        DataOutputStream flujoSalida;
        try{
            salida=c1.getOutputStream();
            flujoSalida=new DataOutputStream(salida);
            flujoSalida.writeUTF("Saludos desde el servidor");
            entrada.close();
            flujoEntrada.close();
            salida.close();
            flujoSalida.close();
            c1.close();
            servidor.close();
        }catch(IOException io){
            io.printStackTrace();
        }

    }
}