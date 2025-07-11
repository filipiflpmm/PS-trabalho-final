package ifsc.projetoatividadecomplementar.Decorator;

import ifsc.projetoatividadecomplementar.Aluno;
import ifsc.projetoatividadecomplementar.ListaModalidade;

public class ParecerComAssinatura extends ParecerDecorator {
    public ParecerComAssinatura(ParecerComponente componente) {
        super(componente);
    }

    @Override
    public void gerar(Aluno aluno, ListaModalidade lista) {
        componente.gerar(aluno, lista);
        System.out.println("Assinado eletronicamente pelo Coordenador do Curso.");
    }
}