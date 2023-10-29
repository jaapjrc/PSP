public class Istari implements Runnable {
    private LibroConjuros libroConjuros;

    public Istari(LibroConjuros libroConjuros) {
        this.libroConjuros = libroConjuros;
    }

    @Override
    public void run(){
        while (true) {
            try {
                this.libroConjuros.generarConjuro();
                Thread.sleep(10000);
                this.libroConjuros.terminarEscribir();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
