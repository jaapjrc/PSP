import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Batalla {
    private static volatile Semaphore escudosSauron = new Semaphore(3);
    private static volatile Semaphore espadasSauron = new Semaphore(3);
    private static volatile Semaphore dagasSauron = new Semaphore(3);
    private static volatile Semaphore escudosIluvatar = new Semaphore(3);
    private static volatile Semaphore espadasIluvatar = new Semaphore(3);
    private static volatile Semaphore dagasIluvatar = new Semaphore(3);
    private static Vasija vasija;
    private static LibroConjuros libroConjuros;
    private static LinkedList<Conjuro> conjuros;
    private static ElSagas elSagas;

    public static void main(String[] args) {
        Thread[] caballerosSauron = new Thread[10];
        Thread[] caballerosIluvatar = new Thread[10];
        Thread[] orcos = new Thread[2];
        Thread[] istaris = new Thread[3];
        vasija = new Vasija();
        conjuros = new LinkedList<>();
        libroConjuros = new LibroConjuros(conjuros, 0, false);
        elSagas = new ElSagas(0,0);


        for (int i = 0; i < caballerosSauron.length; i++) {
            caballerosSauron[i] = new Thread(new CaballeroSauron("Nazgûl " + i, escudosSauron, espadasSauron, dagasSauron, 30, vasija, elSagas));
        }

        for (Thread s : caballerosSauron){
            s.start();
        }

        for (int i = 0; i < caballerosIluvatar.length; i++) {
            caballerosIluvatar[i] = new Thread(new CaballeroIluvatar("Elfo " + i, escudosIluvatar, espadasIluvatar, dagasIluvatar, 30, libroConjuros, elSagas));
        }

        for (Thread c : caballerosIluvatar){
            c.start();
        }

        for (int i = 0; i < orcos.length; i++) {
            orcos[i] = new Thread(new Orco(vasija, "Orco " + i));
        }

        for (Thread o : orcos){
            o.start();
        }

        for (int i = 0; i < istaris.length; i++) {
            istaris[i] = new Thread(new Istari(libroConjuros, "Istari " + i));
        }

        for (Thread i : istaris){
            i.start();
        }

        for (Thread s : caballerosSauron){
            try {
                s.join();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        for (Thread c : caballerosIluvatar){
            try {
                c.join();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        for (Thread o : orcos){
            try {
                o.join();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        for (Thread i : istaris){
            try {
                i.join();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
