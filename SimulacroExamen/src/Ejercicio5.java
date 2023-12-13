import java.util.LinkedList;

public class Ejercicio5 {
    public static void main(String[] args) {
        LinkedList<Globo> a = new LinkedList<Globo>();
        Globo g = new Globo("Azul", true, false);
        Globo g2 = new Globo("A", true, false);
        Globo g3 = new Globo("z", true, false);
        Globo g4 = new Globo("ul", true, false);
        Globo g5 = new Globo("l", true, false);
        a.add(g);
        a.add(g2);
        a.add(g3);
        a.add(g4);
        a.add(g5);
        BolsaDeGlobos globos = new BolsaDeGlobos(a);
        Inflador p = new Inflador(globos, 1);
        Pinchador c = new Pinchador(globos, 1);
        p.start();
        c.start();
    }
}

class Globo {
    private String color;
    private boolean pinchado;
    private boolean inflado;

    public Globo(String color, boolean pinchado, boolean inflado) {
        this.color = color;
        this.pinchado = pinchado;
        this.inflado = inflado;
    }

    public boolean isPinchado() {
        return pinchado;
    }

    public void setPinchado(boolean pinchado) {
        this.pinchado = pinchado;
    }

    public boolean isInflado() {
        return inflado;
    }

    public void setInflado(boolean inflado) {
        this.inflado = inflado;
    }
}

class Inflador extends Thread {
    private BolsaDeGlobos globos;
    private int n;

    public Inflador(BolsaDeGlobos globos, int n) {
        this.globos = globos;
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < globos.getGlobos().size(); i++) {
            if (globos.getGlobos().get(i).isInflado() == false && globos.getGlobos().get(i).isPinchado() == true) {
                globos.getGlobos().get(i).setInflado(true);
                globos.getGlobos().get(i).setPinchado(false);
                System.out.println("Inflador: " + n + ", infla el globo: " + i);
            }
        }
    }
}

    class Pinchador extends Thread {
        private BolsaDeGlobos globos;
        private int n;

        public Pinchador(BolsaDeGlobos globos, int n) {
            this.globos = globos;
            this.n = n;
        }

        @Override
        public void run() {
            for (int i = 0; i < globos.getGlobos().size(); i++) {
                if (globos.getGlobos().get(i).isInflado() == true && globos.getGlobos().get(i).isPinchado() == false) {
                    globos.getGlobos().get(i).setInflado(false);
                    globos.getGlobos().get(i).setPinchado(true);
                    System.out.println("Pinchador: " + n + ", pincha el globo: " + i);
                }
            }
        }
    }
    class BolsaDeGlobos {
        private LinkedList<Globo> globos;

        public BolsaDeGlobos(LinkedList<Globo> globos) {
            this.globos = globos;
        }

        public LinkedList<Globo> getGlobos() {
            return globos;
        }

        public void setGlobos(LinkedList<Globo> globos) {
            this.globos = globos;
        }
    }

