package ifsc.projetoatividadecomplementar.Specification;

public class SpecificationE<T> implements Specification<T> {
    
    private Specification<T> regra1, regra2;

    public SpecificationE(Specification<T> regra1, Specification<T> regra2) {
        this.regra1 = regra1;
        this.regra2 = regra2;
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return regra1.isSatisfiedBy(t) && regra2.isSatisfiedBy(t);
    }
}