
import java.net.*;

public class Ejercicio {
    public static void main(String[] args) {
        InetAddress dir = null;

        try {
            //LOCALHOST
            System.out.println("========================================================");
            System.out.println("SALIDA PARA : " + args[0]);
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);

        }// main
        catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


        //pruebaMetodos
    }//fin

    private static void pruebaMetodos(InetAddress dir) {
        System.out.println("\tMetodo getByName():  " + dir);
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // USAMOS METODOS DE LA CLASE
        System.out.println("\tMetodo getHostName(): " + dir.getHostName());
        System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
        System.out.println("\tMetodo toString(): " + dir.toString());
        System.out.println("\tMetodo getCanonicalHostName(): " +
                dir.getCanonicalHostName());
    }
}