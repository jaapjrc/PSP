public class Orco implements Runnable{
    private Vasija vasija;

    public Orco(Vasija vasija) {
        this.vasija = vasija;
    }

    @Override
    public void run(){
        while (true){
            this.vasija.generarPocima();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
