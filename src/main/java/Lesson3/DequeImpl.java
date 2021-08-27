package Lesson3;

public class DequeImpl<E> implements Deque<E> {

    private int size;
    private final int HEAD; // голова
    private int tail;       // хвост
    private E[] data;

    public DequeImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        HEAD = 0;
        tail = -1;
    }


    // добавляет элемент obj в самое начало очереди. Если элемент удачно добавлен, возвращает true, иначе - false
    @Override
    public boolean addFirst(E obj) {
        if (isFull()) {
            return false;
        } else {
            System.arraycopy(data, HEAD, data, HEAD + 1, size);
            size++;
            tail++;
            data[HEAD] = obj;
            return true;
        }
    }


    // добавляет элемент obj в конец очереди. Если элемент удачно добавлен, возвращает true, иначе - false
    @Override
    public boolean addLast(E obj) {
        if (isFull()) {
            return false;
        } else {
            data[++tail] = obj;
            size++;
            return true;
        }
    }


    // возвращает без удаления элемент из начала очереди. Если очередь пуста, возвращает значение null
    @Override
    public E peekFirst() {
        return isEmpty() ? null : data[HEAD];
    }

    // возвращает без удаления последний элемент очереди. Если очередь пуста, возвращает значение null
    @Override
    public E peekLast() {
        return isEmpty() ? null : data[tail];
    }


    //возвращает с удалением элемент из начала очереди.Если очередь пуста, возвращает значение null
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E value = data[HEAD];
        size--;
        tail--;
        System.arraycopy(data, HEAD + 1, data, HEAD, size);
        return value;
    }

    // возвращает с удалением последний элемент очереди. Если очередь пуста, возвращает значение null
    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E value = data[tail--];
        size--;
        return value;
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
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" --> [");
        for (int i = HEAD; i <= tail; i++) {
            sb.append(data[i]);
            if (i < tail) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
