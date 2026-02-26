package Listas;

public class ListaEncadenadaDoble<T> implements IList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    public ListaEncadenadaDoble() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addLast(T element) {

        Node<T> newNode = new Node<>(element);

        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    @Override
    public T removeLast() {

        if (size == 0)
            throw new RuntimeException("Lista vacía");

        T data = tail.data;

        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return data;
    }

    @Override
    public T getLast() {

        if (size == 0)
            throw new RuntimeException("Lista vacía");

        return tail.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}