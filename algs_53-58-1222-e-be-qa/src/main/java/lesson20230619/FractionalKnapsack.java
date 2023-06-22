package lesson20230619;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FractionalKnapsack {

    static class Item{
        int weight;
        int price;
        int fraction;

        public Item(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" + "weight=" + weight + ", price=" + price + ", fraction=" + fraction + '}';
        }
    }

    public static void main(String[] args) {
        Item item1 = new Item(10, 3000);
        Item item2 = new Item(5, 1500);
        Item item3 = new Item(5, 600);
        Item item4 = new Item(2, 100);
        Item item5 = new Item(1, 150);
        List<Item> itemList = Arrays.asList(item1, item2, item3, item4, item5);

        int totalPrice = fillFractionalKnapsack(itemList, 19);
        System.out.println("Max price = " + totalPrice);
    }

    private static int fillFractionalKnapsack(List<Item> items, int maxCapacity) {
        // sorting items by cost;
        items.sort((o1, o2) -> o2.price/ o2.weight - o1.price / o1.weight);

        List<Item> bag = new ArrayList<>(items.size());
        int totalPrice = 0;
        int currentCapacity = maxCapacity;

        for (Item item : items) {
            if (currentCapacity - item.weight >= 0) {
                // this weight can be picked whole
                totalPrice += item.price;
                currentCapacity = currentCapacity - item.weight;
                item.fraction = item.weight;
                bag.add(item);
            } else {
                // item can't be picked whole
                item.fraction = item.weight - (item.weight - currentCapacity);
                totalPrice += (item.price * item.fraction)/item.weight;
                currentCapacity = 0;
                bag.add(item);
                break;
            }
        }
        System.out.println(bag);
        System.out.println("Capacity left = " + currentCapacity);

        return totalPrice;
    }


}
