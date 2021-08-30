package Lesson4;

import java.util.Iterator;

public interface TwoSideLinkedList<E> extends Iterable<E> {

    void insertFirst(E value);

    void insertLast(E value);

    E removeFirst();

    E removeLast();

    boolean remove(E value);

    E getFirst();

    E getLast();

    boolean contains(E value);

    int size();

    boolean isEmpty();

    class Node<E> {

        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> previous) {
            this.item = item;
            this.next = next;
            this.prev = previous;
        }
    }

}
