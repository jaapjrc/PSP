import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ejercicio2 {
    public static void main(String[] args) {
        String direccion= JOptionPane.showInputDialog("Dime la web");
        String nuevo = "https://" + direccion;
        try {
            leerURL(new URL(nuevo));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerURL(URL url){
        URLConnection urlCon=null;
        try {
            urlCon= url.openConnection();
            BufferedReader in;
            InputStream inputStream = urlCon.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        }
        catch (MalformedURLException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }
}
