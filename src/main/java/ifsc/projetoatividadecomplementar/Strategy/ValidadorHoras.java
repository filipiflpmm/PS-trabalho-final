package ifsc.projetoatividadecomplementar.Strategy;

import ifsc.projetoatividadecomplementar.Modalidade;

public interface ValidadorHoras {
    double calcularHorasValidas(Modalidade modalidade);
}