// Explicación del nombre de la clase: https://scryfall.com/card/ltr/234/tom-bombadil
public class ElSagas {
    private int marcadorSauron;
    private int marcadorIluatar;

    public ElSagas(int marcadorSauron, int marcadorIluatar) {
        this.marcadorSauron = marcadorSauron;
        this.marcadorIluatar = marcadorIluatar;
    }

    public synchronized void aumentarSauron() {
        this.marcadorSauron++;
    }

    public synchronized void aumentarIluvatar() {
        this.marcadorIluatar++;
    }

    public synchronized int getMarcadorSauron() {
        return marcadorSauron;
    }

    public synchronized int getMarcadorIluatar() {
        return marcadorIluatar;
    }
}
