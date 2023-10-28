import java.util.concurrent.Semaphore;

public class CaballeroSauron implements Runnable{
    private String nombre;
    private Semaphore escudo;
    private Semaphore espada;
    private Semaphore daga;

    public CaballeroSauron(String nombre, Semaphore escudo, Semaphore espada, Semaphore daga) {
        this.nombre = nombre;
        this.escudo = escudo;
        this.espada = espada;
        this.daga = daga;
    }

    @Override
    public void run() {

    }
}
