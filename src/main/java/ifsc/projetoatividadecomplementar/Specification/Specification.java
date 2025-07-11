package ifsc.projetoatividadecomplementar.Specification;

public interface Specification<T> {
    boolean isSatisfiedBy(T t);
}