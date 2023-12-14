public class Hilo extends Thread {
    private double[] array;
    private double suma;
    private double media;

    public Hilo(double[] array, double suma, double media) {
        this.array = array;
        this.suma = suma;
        this.media = media;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            suma += i;
        }
        media = suma / array.length;
    }

    public double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
