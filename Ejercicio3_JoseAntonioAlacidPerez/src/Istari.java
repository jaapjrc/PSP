public class Istari implements Runnable {
    private LibroConjuros libroConjuros;
    private String nombre;

    public Istari(LibroConjuros libroConjuros, String nombre) {
        this.libroConjuros = libroConjuros;
        this.nombre = nombre;
    }

    @Override
    public void run(){
        while (true) {
            try {
                this.libroConjuros.generarConjuro();
                Thread.sleep(10000);
                this.libroConjuros.terminarEscribir();
                System.out.println(this.nombre + " genera conjuro");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
