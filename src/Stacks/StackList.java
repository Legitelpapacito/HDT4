package Stacks;

import Listas.IList;

public class StackList<E> implements IStack<E> {

    private IList<E> list;

    public StackList(IList<E> list) {
        this.list = list;
    }

    @Override
    public void push(E item) {
        list.add(item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        return list.removeLast();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 🔥 ESTE ES EL QUE FALTABA
    @Override
    public int size() {
        return list.size();
    }
}