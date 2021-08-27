
/*
    1. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1). Но в массиве гарантированно 1 число пропущено. Необходимо вывести на экран пропущенное число.
    Примеры:
    [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
    [1, 2, 4, 5, 6] => 3
    [] => 1

    2. Создать класс для реализации Deque.
 */

package Lesson3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Задача 1
        System.out.println("\n Задача 1");
        int[] array = createIntArr();
        int missingIntNum = getMissingInt(array);
        System.out.println(Arrays.toString(array) + " => " + missingIntNum);

        System.out.println("\n Задача 2");
        testDeque();
    }

    private static void testDeque() {
        Deque<Integer> deque = new DequeImpl<>(5);
        deque.display();
        System.out.println(("Show First element  " + deque.peekFirst() ));
        System.out.println(("Show Last element   " + deque.peekLast() ));
        System.out.println("addLast element:     " + 12 +" -> "+ deque.addLast(12));
        System.out.println("addFirst element:    " + 7 +" -> "+ deque.addFirst(7));
        System.out.println("addLast element:     " + 20 +" -> "+ deque.addLast(20));
        System.out.println("addLast element:     " + 16 +" -> "+ deque.addLast( 16));
        deque.display();
        System.out.println("removeFirst element: " + deque.removeFirst());
        System.out.println("removeFirst element: " + deque.removeFirst());
        System.out.println("removeFirst element: " + deque.removeFirst());
        deque.display();
        System.out.println("addLast element:     " + 1 +" -> "+ deque.addLast( 1));
        System.out.println("addLast element:     " + 2 +" -> "+ deque.addLast( 2));
        System.out.println("addLast element:     " + 3 +" -> "+ deque.addLast( 3));
        System.out.println("addLast element:     " + 4 +" -> "+ deque.addLast( 4));
        System.out.println("addFirst element:    " + 14 +" -> "+ deque.addFirst(14));
        deque.display();
        System.out.println("removeFirst element: " + deque.removeFirst());
        deque.display();
        System.out.println("addLast element:     " + 5 +" -> "+ deque.addLast(5));
        System.out.println("addLast element:     " + 6 +" -> "+ deque.addLast( 6));
        deque.display();
        System.out.println("removeLast element:    " + deque.removeLast());
        deque.display();
        System.out.println("addFirst element:    " + 11 +" -> "+ deque.addFirst(11));
        deque.display();
        System.out.println(("Show First element  " + deque.peekFirst() ));
        System.out.println(("Show Last element   " + deque.peekLast() ));
    }

    //заполнение массива к задаче 1
    private static int[] createIntArr() {
        Random rnd = new Random();

        int lenght = rnd.ints(1, 0, 15).findFirst().getAsInt();
        int randomNum = rnd.ints(1, 1, lenght).findFirst().getAsInt();

        int[] array = new int[lenght];

        for (int i = 0; i < array.length; i++) {
            int add = i < randomNum ? 1 : 2;
            array[i] = i + add;
        }

        return array;
    }

    // бинарный поиск пропущенного элемента. Работает только с этим условием задачи,
    public static int getMissingInt(int[] intArray) {
        int start = 0, end = intArray.length - 1;

        if(intArray.length == 0)
            return 1;
        else {
            while (true){
                if (end == start + 1){
                    return intArray[end] - 1;
                }
                int midle = start + (end - start) / 2;

                if (intArray[midle] == intArray[start] + (intArray[end] - intArray[start]) / 2 - (end - start) % 2)
                    start = midle;
                else
                    end = midle;
            }
        }

    }
}
