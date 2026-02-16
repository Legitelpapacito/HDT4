package Listas;

public interface IList<T> {
    void add(T element);
    T removeLast();
    T getLast();
    boolean isEmpty();
    int size();
}
