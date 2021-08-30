package Lesson4;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TwoSideLinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected Node<E> firstElement;
    protected Node<E> lastElement;
    protected int size;

    @Override
    public void insertFirst(E value) {
        Node<E> newNode = new Node<>(value, firstElement, null);
        if (!isEmpty()) {
            firstElement.prev = newNode;
        } else {
            lastElement = newNode;
        }
        firstElement = newNode;
        size++;
    }

    @Override
    public void insertLast(E value) {
        Node<E> last = lastElement;

        Node<E> newNode = new Node<E>(value, null, last);

        lastElement = newNode;

        if (isEmpty()) {
            firstElement = newNode;
        } else {
            last.next = newNode;
        }

        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removeNode = firstElement;
        firstElement = removeNode.next;
        removeNode.next = null;
        size--;
        return removeNode.item;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removeNode = lastElement;
        lastElement = removeNode.prev;
        lastElement.next = null;
        size--;
        return removeNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else if (current == lastElement) {
            lastElement = previous;
            previous.next = null;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;

        return true;
    }

    @Override
    public E getFirst() {
        return isEmpty() ? null : firstElement.item;
    }

    @Override
    public E getLast() {
        return isEmpty() ? null : lastElement.item;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current.next != null){
            if(current.item.equals(value)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = firstElement;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                Node<E> c = current;
                current = current.next;
                return c.item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        //
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

}
