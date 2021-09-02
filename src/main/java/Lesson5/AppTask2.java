package Lesson5;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class AppTask2 {
    private List<Item> items;
    private double maxWeightBackpack;

    public AppTask2() {
        fillListItems();
    }

    private void fillListItems() {
        items = new ArrayList<>();
        items.add(new Item("Ноутбук", 2, 40000));
        items.add(new Item("Книга", 1, 600));
        items.add(new Item("Бинокль", 2, 5000));
        items.add(new Item("Видеокамера", 1.5, 20000));
        items.add(new Item("Иг.приставка", 1.7, 20000));
        items.add(new Item("Котелок", 0.7, 500));
    }

    public void showListItems(List<Item> items) {
        items.forEach(i -> {
            System.out.printf("%-12s вес: %.1f    цена: %.1f %n", i.getName(), i.getWeight(), i.getPrice());
        });
    }

    public void solveTask() {
        double lower = 0;
        double upper = 10;
        maxWeightBackpack = Math.random() * (upper - lower) + 1;
        System.out.printf("%.1f.кг %n",maxWeightBackpack);

        Backpack bp = new Backpack(maxWeightBackpack);
        bp.makeAllSets(items);

        if (bp.getBestItems() == null){
            System.out.println("\nМаксимальный вес рюкзака очень маленький \nиз данного набора предметов в него ничего не влезет!!!");
        } else {
            items = bp.getBestItems();
            showListItems(items);
        }
    }
}
