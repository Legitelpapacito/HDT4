package Stacks;

import Listas.IList;

public class StackList<T> implements IStack<T> {

    private IList<T> list;

    public StackList(IList<T> listImplementation) {
        this.list = listImplementation;
    }

    @Override
    public void push(T element) {
        list.add(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        return list.removeLast();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacío");
        }
        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
