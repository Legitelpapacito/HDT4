package Listas;

public class ListaEncadenadaDoble<T> implements IList<T> {

    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public ListaEncadenadaDoble() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        size++;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vacia");
        }
        if (head.next == null) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        T data = current.data;
        current.prev.next = null;
        size--;
        return data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vacia");
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
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
