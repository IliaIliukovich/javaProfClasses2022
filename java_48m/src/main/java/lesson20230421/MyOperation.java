package lesson20230421;

@FunctionalInterface
public interface MyOperation<T> {

    T operation(T x, T y, T z);

}
