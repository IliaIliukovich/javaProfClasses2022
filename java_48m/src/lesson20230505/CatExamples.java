package lesson20230505;

import lesson20230428.Cat;

import java.util.Arrays;
import java.util.List;

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
        // 2. Получить Map<String, Long> цвет / количество кошек данного цвета
        // 3. Получить Map<String, Set<String>> цвет / список имен кошек данного цвета
        // 4. Получить Map<Integer, Integer> возраст / количество голодных кошек данного возраста


    }


}
