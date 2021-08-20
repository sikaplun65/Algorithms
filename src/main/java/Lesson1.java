
/*  1. Определить сложность следующих алгоритмов:
    -. Поиск элемента массива с известным индексом                  = O(1)
    -. Дублирование одномерного массива через foreach               = O(n)
    -. Удаление элемента массива с известным индексом без сдвига    = O(1)
    -. Удаление элемента массива с неизвестным индексом без сдвига  = O(n)
    -. Удаление элемента массива с неизвестным индексом со сдвига   = O(n)
    .

    2. Определить сложность следующих алгоритмов. Сколько произойдет итераций?
    a)

            int n = 10000;                                   O(1)
            List<Integer> arrayList = new ArrayList<>();     O(1)
            for (int i = 0; i < n; i++) {                    O(n)
                for (int j = 1; j < n; j *= 2) {             O(log n)
                    arrayList.add(i * j);                    O(1)
                }
            }
                                                              O(1 + 1 + n * (log n) + 1) = O(n)   // false

    b)

            int n = 10000;                                   O(1)
            List<Integer> arrayList = new ArrayList<>();     O(1)
            for (int i = 0; i < n; i += 2) {                 O(n)
                for (int j = i; j < n; j++) {                O(n)
                    arrayList.add(i * j);                    O(1)
                }
            }
                                                             O(1 + 1 + n*n + 1) = O(n^2)

    с)

            int n = 10000;                                   O(1)
            List<Integer> arrayList = new ArrayList<>();     O(1)
            for (int i = 0; i < n; i ++) {                   O(n)
                for (int j = 0; j < n; j++) {                O(n)
                    arrayList.add(i * j);                    O(1)
                    n--;                                     O(1)
                }
            }
                                                             O(1 + 1 + n*n + 1 + 1) = O(n^2)  //false
    d)
    ```

        factorial(BigInteger.valueOf(10000))                              O(1)

    public static BigInteger factorial(BigInteger n) {                    O(n)
        if (n.equals(BigInteger.ONE)) {                                   O(1)
            return n;                                                     O(1)
        }
        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));  O(1)
    }
                                                                          O(1 + n + 1 + 1 + 1) = O(n)

    e)
    fib(BigInteger.valueOf(50));                                                       O(1)

    public static BigInteger fib(BigInteger n) {                                       O(n)
        if (n.equals(BigInteger.ONE)) {                                                O(1)
            return BigInteger.ZERO;                                                    O(1)
        }
        if (n.equals(BigInteger.TWO)) {                                                O(1)
            return BigInteger.ONE;                                                     O(1)
        }
        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.TWO)));   O(1)
    }
                                                                                       O(1 + n + 1 + 1 + 1 + 1 + 1) = O(n)  // false
*/


public class Lesson1 {
    public static void main(String[] args) {


    }

}
