public interface Heuristic<T> {

    int estimate(T actual, T goal);

}