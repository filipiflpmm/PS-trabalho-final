package ifsc.projetoatividadecomplementar;

public class Atividade {
    private String nome;
    private int horasDeclaradas;
    private int limiteHoras;

    public Atividade(String nome, int horasDeclaradas, int limiteHoras) {
        this.nome = nome;
        this.horasDeclaradas = horasDeclaradas;
        this.limiteHoras = limiteHoras;
    }

    public String getNome() {
        return nome;
    }

    public int getHorasDeclaradas() {
        return horasDeclaradas;
    }

    public int getLimiteHoras() {
        return limiteHoras;
    }

    public int getHorasValidadas() {
        return Math.min(horasDeclaradas, limiteHoras);
    }

    public String gerarObservacao() {
        if (horasDeclaradas == 0) {
            return "nenhuma hora declarada.";
        } else if (horasDeclaradas > limiteHoras) {
            return "horas declaradas (" + horasDeclaradas + "h) excedem o limite (" + limiteHoras + "h). Horas ajustadas para " + limiteHoras + "h.";
        } else {
            return "sem ajustes.";
        }
    }

    @Override
    public String toString() {
        return "Atividade: " + nome + "\n" +
               "Horas declaradas: " + horasDeclaradas + "h\n" +
               "Limite Máximo: " + limiteHoras + "h\n" +
               "Horas validadas: " + getHorasValidadas() + "h\n" +
               "Observação: " + gerarObservacao() + "\n";
    }
}