package ifsc.projetoatividadecomplementar.Strategy;

import ifsc.projetoatividadecomplementar.Modalidade;

public class Complementacao implements ValidadorHoras {
    @Override
    public double calcularHorasValidas(Modalidade modalidade) {
        return modalidade.getTotalDeclarado() * 0.2;
    }
}
