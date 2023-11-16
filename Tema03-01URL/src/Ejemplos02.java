import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ejemplos02 {

    public static void main(String[] args) {
        URL url;
        try {
            System.out.println("Constructor simple para una URL:");
            url = new URL("http://docs.oracle.com/");
            Visualizar(url);

            System.out.println("Otro constructor simple para una URL:");
            url = new URL("http://www.xataka.com");
            Visualizar(url);

            System.out.println("Constructor para protocolo + URL + puerto + directorio:");
            url = new URL("http", "localhost", 8069,"/");
            Visualizar(url);

            System.out.println("Constructor para un objeto URL en un contexto:");
            URL urlBase = new URL("https://docs.oracle.com/");
            url = new URL(urlBase, "/javase/9/docs/api/java/net/URL.html");
            Visualizar(url);

        } catch (MalformedURLException e) {	System.out.println(e);}

        //Segundo ejemplo, leer URL (Sin conexión
        URL miUrl= null;
        try {
            miUrl = new URL("https://www.microsiervos.com/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.setProperty("http.agent", "Chrome");
        leerURLsimple(miUrl);

        //Tercer ejemplo leer URL con conexión (Usamos la URL creada más arriba
        leerURL(miUrl);

    }// main

    private static void Visualizar(URL url) {
        System.out.println("\tURL completa: " + url.toString());
        System.out.println("\tgetProtocol(): " + url.getProtocol());
        System.out.println("\tgetHost(): " + url.getHost());
        System.out.println("\tgetPort(): " + url.getPort());
        System.out.println("\tgetFile(): " + url.getFile());
        System.out.println("\tgetUserInfo(): " + url.getUserInfo());
        System.out.println("\tgetPath(): " + url.getPath());
        System.out.println("\tgetAuthority(): " + url.getAuthority());
        System.out.println("\tgetQuery(): " + url.getQuery());
        System.out.println("\tgetDefaultPort(): "+ url.getDefaultPort());
        System.out
                .println("==================================================");
    }

    public static void leerURLsimple(URL url) {
        BufferedReader in;
        try {
            InputStream inputStream = url.openStream();
            in = new BufferedReader(new  InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        }catch (IOException e) {e.printStackTrace();}
    }

    //Crea un objeto URLConnection para leer el contenido de la URL
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
