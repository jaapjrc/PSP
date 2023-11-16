import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Scanner;

public class PalabrasRAE {
    public static void main(String[] args){
        System.out.println("Escribe la palabra a buscar en el diccionario");
        Scanner miScanner=new Scanner(System.in);
        String palabra=miScanner.next();

        if(buscarPalabra3(palabra)){
            System.out.println("La palabra: " + palabra + " está en el diccionario");
        }else{
            System.out.println("La palabra: " + palabra + " NO está en el diccionario");
        }
    }

    private static boolean buscarPalabra(String palabra){
        String st="";
        URLConnection uc;
        System.setProperty("http.agent", "");
        try {
            String urlTexto="https://dle.rae.es/" + palabra;
            URL url = new URL(urlTexto);
            Scanner s = new Scanner(url.openStream());
            while (s.hasNextLine()) {
                st +=s.nextLine();
            }
            //System.out.println(st.indexOf("no está en el Diccionario"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return (st.indexOf("Aviso: <span>La palabra")==-1);
    }

    private static boolean buscarPalabra2(String palabra){
        String st="";
        URLConnection uc;
        System.setProperty("http.agent", "");
        try {
            String urlTexto="https://dle.rae.es/" + palabra;
            URL url = new URL(urlTexto);
            uc=url.openConnection();
            uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            uc.connect();
            InputStream inputStream = uc.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                st +=inputLine;
            }
            //System.out.println(st.indexOf("no está en el Diccionario"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return (st.indexOf("Aviso: <span>La palabra")==-1);
    }

    private static boolean buscarPalabra3(String palabra){
        String st="";
        HttpsURLConnection uc;
        //System.setProperty("http.agent", "");
        System.out.println("Hola");
        try {
            String urlTexto="https://dle.rae.es/" + palabra;
            URL url = new URL(urlTexto);
            uc=(HttpsURLConnection) url.openConnection();
            uc.setRequestMethod("GET");
            uc.setRequestProperty("Content-Type", "application/json");
            uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
            uc.setReadTimeout(5000);
            uc.setConnectTimeout(5000);
            //String cookie = uc.getHeaderField( "Set-Cookie").split(";")[0];
            uc.addRequestProperty("User-Agent","MMozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
            uc.setRequestProperty("Cookie", "__cflb=0H28uu4LW7gyBBnNGST2V9mKeK4fFipqJNuNx9zPqTy;" );
            uc.connect();
            InputStream inputStream = uc.getInputStream();
            //InputStream inputStream = (InputStream) uc.getContent();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")) );
            //BufferedReader in = new BufferedReader(new InputStreamReader(uc.getResponseCode() / 100 == 2 ? uc.getInputStream() : uc.getErrorStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                st +=inputLine;
            }
            //System.out.println(st.indexOf("no está en el Diccionario"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return (st.indexOf("Aviso: <span>La palabra")==-1);
    }
}
