import java.util.LinkedList;
import java.util.Random;

public class LibroConjuros {
    private LinkedList<Conjuro> conjuros = new LinkedList<>();
    private int lectores;
    private boolean escribiendo;

    public LibroConjuros(LinkedList<Conjuro> conjuros, int lectores, boolean escribiendo) {
        this.conjuros = conjuros;
        this.lectores = lectores;
        this.escribiendo = escribiendo;
    }

    public synchronized int leerConjuro() throws InterruptedException {
        Random r = new Random();
        while (this.lectores == 3 || this.escribiendo){
            wait();
        }
        this.lectores++;
        if (this.conjuros.toArray().length > 0) {
            notifyAll();
            return conjuros.get(r.nextInt(this.conjuros.toArray().length)).getEnergia();
        } else {
            notifyAll();
            return 0;
        }
    }

    public synchronized void generarConjuro() throws InterruptedException {
        Random r = new Random();
        Conjuro c = new Conjuro(r.nextInt(5) + 1);
        while (this.lectores > 0 || this.escribiendo) {
            wait();
        }
        this.escribiendo = true;
        this.conjuros.add(c);
        notifyAll();
    }

    public synchronized void terminarEscribir() {
        this.escribiendo = false;
        notifyAll();
    }

    public synchronized void terminarLeer() {
        this.lectores--;
        notifyAll();
    }

}
