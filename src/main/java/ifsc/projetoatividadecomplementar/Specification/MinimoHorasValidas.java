package ifsc.projetoatividadecomplementar.Specification;

import ifsc.projetoatividadecomplementar.ListaModalidade;
import ifsc.projetoatividadecomplementar.Modalidade;

public class MinimoHorasValidas implements Specification<ListaModalidade> {
    
    @Override
    public boolean isSatisfiedBy(ListaModalidade lista) {
        int[] limites = {32, 32, 32, 16};
        int total = 0;
        int i = 0;
        for (Modalidade m : lista.getTodas()) {
            total += Math.min(m.getTotalValidado(), limites[i++]);
        }
        return total >= 80;
    }
}