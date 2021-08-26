
/*
 1. Отсортировать массив, состоящий из экземпляров класса Notebook в количестве 5000 штук.
    Условия для сортировки:
    `1)` по цене. От 500 до 2000 долларов с шагом в 100
    если цена равная, то
    `2)` по кол-ву оперативной памяти (от 4 до 16 с шагом 4)
    если памяти тоже равное количество, то
    `3)` по производителю:
    Lenuvo > Asos > MacNote > Eser > Xamiou
    Добиваться максимально оптимальной сложности О-большая
 2. Дан массив из n элементов, начиная с 1. Каждый следующий элемент равен (предыдущий + 1). Но в массиве гарантированно 1 число пропущено.
    Необходимо вывести на экран пропущенное число.
    Примеры:
    [1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16] => 11
    [1, 2, 4, 5, 6] => 3
    [] => 1
*/

import java.util.*;

public class Lesson2 {
    private static Random rnd = new Random();

    // количество ноутбуков по заданию
    private static final int NUMBER_OF_LAPTOPS = 5000;

    // бренды ноубуков по заданию
    private static final String[] MANUFACTURER = new String[]{"Lenuvo", "Asos", "MacNote","Eser","Xamiou"};

    public static void main(String[] args) {
        // Задача 1
        ListNotebooks listNotebooks = new ListNotebooks();
        var sortedArr = quickSort(listNotebooks.getListNotebooks(), 0, listNotebooks.getListNotebooks().length - 1);
//        var sortedArr = selectionSort(listNotebooks.getListNotebooks());
        Arrays.stream(sortedArr).forEach(System.out::println);

        // Задача 2
        System.out.println("\n Задача 2");
        int[] array = createIntArr();
        int missingIntNum = getMissingInt2(array);
        System.out.println(Arrays.toString(array) + " => " + missingIntNum);
    }

    // быстрая сортировка
    private static Notebook[] quickSort(Notebook[] items, int firstInd, int lastInd) {
        if (firstInd < lastInd) {
            int midleInd = firstInd + (lastInd - firstInd) / 2;
            int newMidleInd = partition(items, firstInd, lastInd, midleInd);

            quickSort(items, firstInd, newMidleInd - 1);
            quickSort(items, newMidleInd + 1, lastInd);
        }
        return items;
    }

    private static int partition(Notebook[] items, int left, int right, int pivotIndex) {
        var pivotValue = items[pivotIndex];

        swap(items, pivotIndex, right);

        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (compare(items[i], pivotValue, MANUFACTURER)) {
                swap(items, i, storeIndex);
                storeIndex += 1;
            }
        }

        swap(items, storeIndex, right);
        return storeIndex;
    }

    private static void swap(Notebook[] items, int left, int right) {
        if (left != right) {
            var temp = items[left];
            items[left] = items[right];
            items[right] = temp;
        }
    }

    //=================================================================================================================
    // сортировка выбором
    private static Notebook[] selectionSort(Notebook[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {    // i - номер текущего шага
            int posMin = i;
            // цикл выбора наименьшего и наибольшего элементов
            for (int j = i + 1; j < arr.length; j++) {
                if (compare( arr[j], arr[posMin], MANUFACTURER)) {
                    posMin = j;    // posMin - индекс наименьшего элемента
                }
            }
            swap(arr, i, posMin);    // меняем местами наименьший с arr[startPos]
        }

        return arr;
    }

//общий компаратор для обеих сортировок===========================================================================

    public static boolean compare(Notebook a, Notebook b, String[] listBrands) {
        if (a.price != b.price) {
            return a.price < b.price;
        } else {
            if (a.ramSize != b.ramSize) {
                return a.ramSize < b.ramSize;
            } else {
                var arr = Arrays.stream(listBrands).toList();
                var indA = arr.indexOf(a.brand);
                var indB= arr.indexOf(b.brand);

                return indA < indB;
            }
        }
    }
//===================================================================================================================

    public static class Notebook {
        private String brand;
        private final int ramSize;
        private final int price;

        public Notebook(String brand, int ramSize, int price) {
            this.brand = brand;
            this.ramSize = ramSize;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format(" Производитель: %-10s  RAM: %2d   Цена: %4d", brand, ramSize, price);
        }
    }

    public static class ListNotebooks {

        private  Notebook[] notebooks;

        public ListNotebooks() {
            notebooks = new Notebook[NUMBER_OF_LAPTOPS];
            createListsNotebooks();
        }

        public Notebook[] getListNotebooks() {
            return notebooks;
        }

        // фабрика
        private  void createListsNotebooks() {
            int ramMin = 1, ramMax = 4, ramStep = 4;
            int priceMin = 5, priceMax = 20, priceStep = 100;

            for (int i = 0; i < NUMBER_OF_LAPTOPS; i++) {
                String brand = MANUFACTURER[rnd.nextInt(MANUFACTURER.length)];
                int ramSize = (ramMin + rnd.nextInt(ramMax - ramMin + 1)) * ramStep;
                int price = (priceMin + rnd.nextInt(priceMax - priceMin + 1)) * priceStep;

                notebooks[i] = new Notebook(brand, ramSize, price);
            }
        }
    }

    //========================================================================================================
    //заполнение массива к задаче 2
    private static int[] createIntArr() {
        int lenght = rnd.ints(1, 0, 11).findFirst().getAsInt();
        int randomNum = rnd.ints(1, 0, lenght).findFirst().getAsInt();

        int[] array = new int[lenght];

        for (int i = 0; i < array.length; i++) {
            int add = i < randomNum ? 1 : 2;
            array[i] = i + add;
        }
        return array;
    }

    // линейный поиск
    private static int getMissingInt(int[] arr) {
        int num = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 != arr[i]) {
                num = arr[i] - 1;
                break;
            }
        }
        return num;
    }

    private static int getMissingInt2(int[]arr){
        return (arr.length + 1)*(arr.length + 2)/2 - Arrays.stream(arr).sum();
    }
}
