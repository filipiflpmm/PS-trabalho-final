package ifsc.projetoatividadecomplementar.Decorator;

public abstract class ParecerDecorator implements ParecerComponente {
    protected ParecerComponente componente;

    public ParecerDecorator(ParecerComponente componente) {
        this.componente = componente;
    }
}