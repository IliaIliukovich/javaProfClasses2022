package lesson20230804;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Cat {

    private String name;
    private int age;
    private String colour;
    private boolean isHungry;

    public Cat(String name, int age, String colour, boolean isHungry) {
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.isHungry = isHungry;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", colour='" + colour + '\'' + ", isHungry=" + isHungry + '}';
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom", 3, "black", true);
        Cat cat2 = new Cat("Tom", 3, "black", false);
        Cat cat3 = new Cat("Tom", 2, "black", false);
        Cat cat4 = new Cat("Tom", 1, "black", true);
        Cat cat5 = new Cat("Tom", 1, "black", true);
        Cat cat6 = new Cat("Tom", 4, "black", false);
        Cat cat7 = new Cat("Tom", 1, "black", true);
        List<Cat> cats = Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7);

        cats.forEach(System.out::println);

        Map<Integer, Integer> map = new TreeMap<>();

        for (Cat c : cats) {
            if (c.isHungry) {
                if (map.containsKey(c.age)) {
                    int count = map.get(c.age);
                    map.put(c.age, count + 1);
                } else {
                    map.put(c.age, 1);
                }
            }
        }

        System.out.println(map);
    }


}
