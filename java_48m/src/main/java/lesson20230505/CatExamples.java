package lesson20230505;

import lesson20230428.Cat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CatExamples {

    public static void main(String[] args) {


        Cat cat1 = new Cat("Tom", 2, "black", true);
        Cat cat2 = new Cat("Mikky", 1, "white", false);
        Cat cat3 = new Cat("Vasya", 3, "white", true);
        Cat cat4 = new Cat("Steve", 1, "grey", false);
        Cat cat5 = new Cat("Bob", 2, "black", true);
        List<Cat> catList = Arrays.asList(cat1, cat2, cat3, cat4, cat5);

        List<Cat> white = catList.stream().filter(cat -> cat.getColour().equals("white")).toList();
        catList.get(1).setColour("black");
        System.out.println(white);

        // 1. Получить Map<String, Boolean> имя / информация, голодна ли кошка
        Map<String, Boolean> map = catList.stream().collect(Collectors.toMap(Cat::getName, Cat::isHungry));
        System.out.println(map);
        // 2. Получить Map<String, Long> цвет / количество кошек данного цвета
        Map<String, Long> map1 = catList.stream().collect(Collectors.groupingBy(Cat::getColour, Collectors.counting()));
        Map<String, Long> map2 = catList.stream().collect(Collectors.toMap(Cat::getColour, cat -> 1L, Long::sum));
        System.out.println(map1);
        // 3. Получить Map<String, Set<String>> цвет / список имен кошек данного цвета
        Map<String, Set<String>> map3 = catList.stream().collect(Collectors.groupingBy(Cat::getColour, Collectors.mapping(Cat::getName, Collectors.toSet())));
        System.out.println(map3);
        // 4. Получить Map<Integer, Integer> возраст / количество голодных кошек данного возраста
        Map<Integer, Integer> map4 = catList.stream().collect(Collectors.toMap(Cat::getAge, cat -> cat.isHungry() ? 1 : 0, Integer::sum));
        System.out.println(map4);


    }


}
