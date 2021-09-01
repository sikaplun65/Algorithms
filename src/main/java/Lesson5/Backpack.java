package Lesson5;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Backpack {
    private List<Item> bestItems ;
    private double bestPrice;
    private double maxWeight;

    public Backpack(double maxW) {
        this.maxWeight = maxW;
    }

    // вычисляет общий вес набора предметов
    private double calcWeight(List<Item> items){
        return items.stream().mapToDouble(Item::getWeight).sum();
    }

    //вычисляет общую стоимость набора предметов
    private double calcPrice(List<Item> items){
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    // проверка, является ли данный набор решением задачи
    private void checkSet(List<Item> items){
        if(bestItems == null){
            if(calcWeight(items) <= maxWeight){
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        }else {
            if(calcWeight(items) <= maxWeight && calcPrice(items) > bestPrice){
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        }
    }

    // создание всех наборов перестановкой значений
    public void makeAllSets(List<Item> items){
        if (items.size() > 0)
            checkSet(items);
        for(var i : items){
            List<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            makeAllSets(newSet);
        }
    }
}
