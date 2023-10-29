import java.util.concurrent.Semaphore;

public class CaballeroIluvatar implements Runnable {
    private String nombre;
    private Semaphore escudos;
    private Semaphore espadas;
    private Semaphore dagas;
    private int energia;
    private LibroConjuros libroConjuros;
    private ElSagas elSagas;

    public CaballeroIluvatar(String nombre, Semaphore escudos, Semaphore espadas, Semaphore dagas, int energia, LibroConjuros libroConjuros, ElSagas elSagas) {
        this.nombre = nombre;
        this.escudos = escudos;
        this.espadas = espadas;
        this.dagas = dagas;
        this.energia = energia;
        this.libroConjuros = libroConjuros;
        this.elSagas = elSagas;
    }

    @Override
    public void run() {
        try {
            while (true) {
                escudos.acquire();
                System.out.println("Caballero Ilúvatar " + this.nombre + " coge el escudo. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(800);
                espadas.acquire();
                System.out.println("Caballero Ilúvatar " + this.nombre + " coge la espada. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(800);
                dagas.acquire();
                System.out.println("Caballero Ilúvatar " + this.nombre + " coge la daga. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(800);

                System.out.println("Caballero Ilúvatar " + this.nombre + " puede luchar");

                while (this.energia > 0) {
                    energia--;
                    System.out.println("Caballero Ilúvatar " + this.nombre + " pierde energía");
                    Thread.sleep(200);
                }

                escudos.release();
                System.out.println("Caballero Ilúvatar " + this.nombre + " deja el escudo. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(200);
                espadas.release();
                System.out.println("Caballero Ilúvatar " + this.nombre + " deja la espada. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(200);
                dagas.release();
                System.out.println("Caballero Ilúvatar " + this.nombre + " deja la daga. " + "Escudos disponibles: "
                        + escudos.availablePermits() + " Espadas disponibles: " + espadas.availablePermits() + " Dagas disponibles: " + dagas.availablePermits());
                Thread.sleep(200);

                this.elSagas.aumentarSauron();
                Thread.sleep(2000);
                System.out.println("El Sagas dice: Sauron: " + this.elSagas.getMarcadorSauron() + " Iluvatar: " + this.elSagas.getMarcadorIluatar());


                while (energia != 30) {
                    this.energia += this.libroConjuros.leerConjuro();
                    Thread.sleep(5000);
                    this.libroConjuros.terminarLeer();
                    System.out.println("Caballero Ilúvatar " + this.nombre + " recupera energía");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}