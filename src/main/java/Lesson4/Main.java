
/*
  1. Реализовать цикл forEach для простого связанного списка
  2. Реализовать Deque на основе двунаправленного списка
*/

package Lesson4;

public class Main {
    public static void main(String[] args) {
        testDeque();
    }

    private static void testDeque() {
        Deque<Integer> deque = new LinkedDequeImpl<>();

        System.out.println("addLast element:     " + 12 +" -> "+ deque.addLast(12));
        System.out.println("addFirst element:    " + 7 +" -> "+ deque.addFirst(7));
        System.out.println("addLast element:     " + 20 +" -> "+ deque.addLast(20));
        System.out.println("addLast element:     " + 16 +" -> "+ deque.addLast( 16));
        showDeque(deque);
        System.out.println("removeFirst element: " + deque.removeFirst());
        System.out.println("removeFirst element: " + deque.removeFirst());
        System.out.println("removeFirst element: " + deque.removeFirst());
        showDeque(deque);
        System.out.println("addLast element:     " + 1 +" -> "+ deque.addLast( 1));
        System.out.println("addLast element:     " + 2 +" -> "+ deque.addLast( 2));
        System.out.println("addLast element:     " + 3 +" -> "+ deque.addLast( 3));
        System.out.println("addLast element:     " + 4 +" -> "+ deque.addLast( 4));
        System.out.println("addFirst element:    " + 14 +" -> "+ deque.addFirst(14));
        showDeque(deque);
        System.out.println("remove element:      " + 16 + " -> " + deque.remove(16) );
        System.out.println("removeFirst element: " + deque.removeFirst());
        showDeque(deque);
        System.out.println("addLast element:     " + 5 +" -> "+ deque.addLast(5));
        System.out.println("addLast element:     " + 6 +" -> "+ deque.addLast( 6));
        showDeque(deque);
        System.out.println("removeLast element:    " + deque.removeLast());
        showDeque(deque);
        System.out.println("addFirst element:    " + 11 +" -> "+ deque.addFirst(11));
        showDeque(deque);
        System.out.println(("Show First element  " + deque.peekFirst() ));
        System.out.println(("Show Last element   " + deque.peekLast() ));
    }

    private static void showDeque(Deque<Integer> deque) {
        int elementsCount = 0;
        System.out.print("  [");
        for (var item : deque) {
            System.out.print(item);
            elementsCount++;
            if(elementsCount < deque.size())
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
