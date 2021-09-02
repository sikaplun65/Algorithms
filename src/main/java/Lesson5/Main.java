package Lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Задача 1
        testTask1();
        // Задача 2
        testTask2();
    }

    private static void testTask2() {
        System.out.println("\nЗадача 2");
        System.out.println("Исходный список предметов для заполнения рюкзака");
        AppTask2 app = new AppTask2();
        app.showListItems(app.getItems());
        System.out.print("\nНаилучший список предметов для заполнения рюкзака весом ");
        app.solveTask();
    }


    private static void testTask1() {
        RaisingNumberToPower[] examples = new RaisingNumberToPower[]{
                new RaisingNumberToPower(2, -3),
                new RaisingNumberToPower(3, 3),
                new RaisingNumberToPower(4, 4),
                new RaisingNumberToPower(5, 5),
                new RaisingNumberToPower(6, 0)
        };
        System.out.println("Задача 1\nРезультаты возведения числа в степень:");
        Arrays.stream(examples).forEach(e -> {
            System.out.println(e.getNumber() + "^" + e.getDegree() + " = " + e.getResult());
        });
    }
}
