import java.util.concurrent.Semaphore;

public class CaballeroSauron implements Runnable {
    private String nombre;
    private Semaphore escudos;
    private Semaphore espadas;
    private Semaphore dagas;
    private int energia;
    private Vasija vasija;

    public CaballeroSauron(String nombre, Semaphore escudos, Semaphore espadas, Semaphore dagas, int energia, Vasija vasija) {
        this.nombre = nombre;
        this.escudos = escudos;
        this.espadas = espadas;
        this.dagas = dagas;
        this.energia = energia;
        this.vasija = vasija;
    }

    @Override
    public void run() {
        try {
            while (true) {
                escudos.acquire();
                System.out.println("Caballero Sauron " + this.nombre + " coge el escudo. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(800);
                espadas.acquire();
                System.out.println("Caballero Sauron " + this.nombre + " coge la espada. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(800);
                dagas.acquire();
                System.out.println("Caballero Sauron " + this.nombre + " coge la daga. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(800);

                System.out.println("Caballero Sauron " + this.nombre + " puede luchar");

                while (this.energia > 0) {
                    energia--;
                    Thread.sleep(1000);
                }

                escudos.release();
                System.out.println("Caballero Sauron " + this.nombre + " deja el escudo. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(200);
                espadas.release();
                System.out.println("Caballero Sauron " + this.nombre + " deja la espada. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(200);
                dagas.release();
                System.out.println("Caballero Sauron " + this.nombre + " deja la daga. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(200);

                while (energia != 30) {
                    Thread.sleep(2000);
                    this.energia += this.vasija.tomarPocima();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}