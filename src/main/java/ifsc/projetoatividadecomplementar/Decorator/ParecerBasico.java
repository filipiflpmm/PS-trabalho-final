package ifsc.projetoatividadecomplementar.Decorator;

import ifsc.projetoatividadecomplementar.Aluno;
import ifsc.projetoatividadecomplementar.ListaModalidade;
import ifsc.projetoatividadecomplementar.Parecer;

public class ParecerBasico implements ParecerComponente {
    @Override
    public void gerar(Aluno aluno, ListaModalidade lista) {
        Parecer.gerarParecer(aluno, lista);
    }
}