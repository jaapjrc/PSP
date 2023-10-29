import java.util.concurrent.Semaphore;

public class CaballeroSauron implements Runnable {
    private String nombre;
    private Semaphore escudos;
    private Semaphore espadas;
    private Semaphore dagas;
    private int energia;
    private Vasija vasija;
    private ElSagas elSagas;

    public CaballeroSauron(String nombre, Semaphore escudos, Semaphore espadas, Semaphore dagas, int energia, Vasija vasija, ElSagas elSagas) {
        this.nombre = nombre;
        this.escudos = escudos;
        this.espadas = espadas;
        this.dagas = dagas;
        this.energia = energia;
        this.vasija = vasija;
        this.elSagas = elSagas;
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
                    System.out.println("Caballero Sauron " + this.nombre + " pierde energía");
                    Thread.sleep(200);
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

                this.elSagas.aumentarIluvatar();
                Thread.sleep(2000);
                System.out.println("El Sagas dice: Sauron: " + this.elSagas.getMarcadorSauron() + " Iluvatar: " + this.elSagas.getMarcadorIluatar());


                while (energia != 30) {
                    Thread.sleep(2000);
                    this.energia += this.vasija.tomarPocima();
                    System.out.println("Caballero Sauron " + this.nombre + " recupera energía");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}