package ifsc.projetoatividadecomplementar.Decorator;

import ifsc.projetoatividadecomplementar.Aluno;
import ifsc.projetoatividadecomplementar.ListaModalidade;

public class ParecerEmPdf extends ParecerDecorator {
    public ParecerEmPdf(ParecerComponente componente) {
        super(componente);
    }

    @Override
    public void gerar(Aluno aluno, ListaModalidade lista) {
        componente.gerar(aluno, lista);
        System.out.println("Parecer exportado em formato .pdf com sucesso!");
    }
}