package ifsc.projetoatividadecomplementar.Specification;

import ifsc.projetoatividadecomplementar.ListaModalidade;

public class PossuiAtividades implements Specification<ListaModalidade> {
    @Override
    public boolean isSatisfiedBy(ListaModalidade lista) {
        long modalidadesComAtividades = lista.getTodas().stream()
            .filter(m -> !m.getAtividades().isEmpty())
            .count();

        // Pelo menos 3 modalidades devem ter atividades
        return modalidadesComAtividades >= 3;
    }
}