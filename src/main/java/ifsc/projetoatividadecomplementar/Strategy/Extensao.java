package ifsc.projetoatividadecomplementar.Strategy;

import ifsc.projetoatividadecomplementar.Modalidade;

public class Extensao implements ValidadorHoras {
    @Override
    public double calcularHorasValidas(Modalidade modalidade) {
        return modalidade.getTotalDeclarado() * 0.4;
    }
}