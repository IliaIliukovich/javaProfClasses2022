package lesson20230907;

import lesson20230905.Cat;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExamples {

    public static void main(String[] args) {
        Map<String, String> treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.put("Tom", "groupA");
        treeMap.put("Mary", "groupB");
        treeMap.put("Bill", "groupD");
        treeMap.put("Jane", "groupA");
        treeMap.put("Tim", "groupB");
        treeMap.put("Tim", "groupC");

        System.out.println(treeMap);
        System.out.println(treeMap.get("Jane"));

        Map<Cat, Integer> catMap = new TreeMap<>();
        Cat cat1 = new Cat("Tom", 1, "black", true);
        Cat cat2 = new Cat("Tim", 2, "white", false);
        Cat cat3 = new Cat("Jerry", 1, "yellow", true);
        Cat cat4 = new Cat("Stepan", 3, "black", false);
        Cat cat5 = new Cat("Bob", 1, "black", false);
        Cat cat6 = new Cat("Jinny", 2, "grey", true);
        Cat cat7 = new Cat("Timmy", 4, "white", true);
        Cat extra = new Cat("Tom", 9, "black", true);

        catMap.put(cat1, 3211);
        catMap.put(cat2, 1231);
        catMap.put(cat3, 4321);
        catMap.put(cat4, 4321);
        catMap.put(cat5, 4321);
        catMap.put(cat6, 4321);
        catMap.put(cat7, 4321);
        catMap.put(extra, 4321);
        System.out.println(catMap.size());

        for (Map.Entry<Cat, Integer> e : catMap.entrySet()) {
            System.out.println(e);
        }
    }




}
