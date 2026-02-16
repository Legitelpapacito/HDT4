package Listas;

public class ListaEncadenadaSimple<T> implements IList<T> {

    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListaEncadenadaSimple() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    @Override
    public T removeLast() {
        if (head == null) {
            throw new RuntimeException("Lista vacía");
        }

        if (head.next == null) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }

        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        T data = temp.next.data;
        temp.next = null;
        size--;
        return data;
    }

    @Override
    public T getLast() {
        if (head == null) {
            throw new RuntimeException("Lista vacía");
        }

        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        return temp.data;
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
