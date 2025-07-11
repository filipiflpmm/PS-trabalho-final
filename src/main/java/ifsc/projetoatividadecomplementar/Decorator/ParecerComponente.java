package ifsc.projetoatividadecomplementar.Decorator;

import ifsc.projetoatividadecomplementar.Aluno;
import ifsc.projetoatividadecomplementar.ListaModalidade;

public interface ParecerComponente {
    void gerar(Aluno aluno, ListaModalidade lista);
}