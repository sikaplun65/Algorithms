package Lesson5;

import lombok.Data;

@Data
public class Item {
    private String name;
    private double weight;
    private double price;

    public Item(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
}
