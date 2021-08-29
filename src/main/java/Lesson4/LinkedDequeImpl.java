package Lesson4;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedDequeImpl<E> implements Deque<E> {

    private final TwoSideLinkedList<E> data;

    public LinkedDequeImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }


    @Override
    public boolean addFirst(E obj) {
        data.insertFirst(obj);
        return true;
    }

    @Override
    public boolean addLast(E obj) {
        data.insertLast(obj);
        return true;
    }

    @Override
    public E peekFirst() {
        return data.getFirst();
    }

    @Override
    public E peekLast() {
        return data.getLast();
    }

    @Override
    public E removeFirst() {
        return data.removeFirst();
    }

    @Override
    public E removeLast() {
        return data.removeLast();
    }

    @Override
    public boolean remove(E value) {
        return data.remove(value);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        data.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return data.spliterator();
    }
}
