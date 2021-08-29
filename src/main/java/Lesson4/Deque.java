package Lesson4;

public interface Deque<E> extends Iterable<E>{
    // добавляет элемент obj в самое начало очереди. Если элемент удачно добавлен, возвращает true, иначе - false
    boolean addFirst(E obj);

    // добавляет элемент obj в конец очереди. Если элемент удачно добавлен, возвращает true, иначе - false
    boolean addLast(E obj);

    // возвращает без удаления элемент из начала очереди. Если очередь пуста, возвращает значение null
    E peekFirst();

    // возвращает без удаления последний элемент очереди. Если очередь пуста, возвращает значение null
    E peekLast();

    //возвращает с удалением элемент из начала очереди. Если очередь пуста, возвращает значение null
    E removeFirst();

    // возвращает с удалением элемент из конца очереди. Если очередь пуста, возвращает значение null
    E removeLast();

    boolean remove(E value);

    int size();

    boolean isEmpty();

    boolean isFull();

}
