package ifsc.projetoatividadecomplementar;

public class AtividadePredefinida {
    private String nome;
    private int limiteHoras;

    public AtividadePredefinida(String nome, int limiteHoras) {
        this.nome = nome;
        this.limiteHoras = limiteHoras;
    }

    public String getNome() {
        return nome;
    }

    public int getLimiteHoras() {
        return limiteHoras;
    }

    @Override
    public String toString() {
        return nome + " (" + limiteHoras + "h)";
    }
}
