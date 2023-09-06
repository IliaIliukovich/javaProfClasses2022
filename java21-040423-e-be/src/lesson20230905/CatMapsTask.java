package lesson20230905;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatMapsTask {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Tom", 1, "black", true);
        Cat cat2 = new Cat("Tim", 2, "white", false);
        Cat cat3 = new Cat("Jerry", 1, "yellow", true);
        Cat cat4 = new Cat("Stepan", 3, "black", false);
        Cat cat5 = new Cat("Bob", 1, "black", false);
        Cat cat6 = new Cat("Jinny", 2, "grey", true);
        Cat cat7 = new Cat("Timmy", 4, "white", true);
        List<Cat> cats = Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7);


// 1. Получить Map<String, Boolean> имя / информация, голодна ли кошка
        Map<String, Boolean> nameInfoTable = task1(cats);
        System.out.println(nameInfoTable);


// 2. Получить Map<String, Long> цвет / количество кошек данного цвета
        Map<String, Long> colorInfoTable = task2(cats);
        System.out.println(colorInfoTable);

// 3. Получить Map<String, Set<String>> цвет / список имен кошек данного цвета

    }



    public static Map<String, Boolean> task1(List<Cat> cats) {
        Map<String, Boolean> map = new HashMap<>();
        for (Cat c : cats) {
            map.put(c.getName(), c.isHungry());
        }
        return map;
    }

    public static Map<String, Long> task2(List<Cat> cats) { // TODO
        return null;
    }


}
