public class Orco implements Runnable{
    private Vasija vasija;
    private String nombre;

    public Orco(Vasija vasija, String nombre) {
        this.vasija = vasija;
        this.nombre = nombre;
    }

    @Override
    public void run(){
        while (true){
            this.vasija.generarPocima();
            System.out.println(this.nombre + " genera pócima");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
