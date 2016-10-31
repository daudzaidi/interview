package java8.Lambda;

/**
 * Created by shalvi on 23/06/16.
 */
public interface Computation<T> {
    public T compute(T n, T m);
}
