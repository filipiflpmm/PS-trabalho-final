package ifsc.projetoatividadecomplementar;

import java.util.ArrayList;
import java.util.List;

public class ListaModalidade {
    private List<Modalidade> modalidades;

    public ListaModalidade() {
        modalidades = new ArrayList<>();
        modalidades.add(new Modalidade(1, "Ensino"));
        modalidades.add(new Modalidade(2, "Pesquisa e Inovação"));
        modalidades.add(new Modalidade(3, "Extensão"));
        modalidades.add(new Modalidade(4, "Complementação"));
    }

    public Modalidade getPorCodigo(int codigo) {
        return modalidades.stream()
                .filter(m -> m.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    public List<Modalidade> getTodas() {
        return modalidades;
    }
}