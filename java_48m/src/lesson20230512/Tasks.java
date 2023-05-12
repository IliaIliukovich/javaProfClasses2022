package lesson20230512;

import lesson20230428.Cat;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tasks {

    public static void main(String[] args) {

        // task 1
        Cat cat1 = new Cat("Tom", 2, "black", true);
        Cat cat2 = new Cat("Mikky", 1, "white", false);
        Cat cat3 = new Cat("Vasya", 3, "white", true);
        Cat cat4 = new Cat("Steve", 1, "grey", false);
        Cat cat5 = new Cat("Bob", 2, "black", true);
        List<Cat> catList = Arrays.asList(cat1, cat2, cat3, cat4, cat5);
        feed(catList);
        feedWithStream(catList);

        // task 2
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = getSum(integers);
        int sum2 = getSumWithStream(integers);

        // task 3
        Map<Boolean, List<Integer>> map = getMap();
        System.out.println(map);
        Map<Boolean, List<Integer>> map2 = getMapWithStream();
        System.out.println(map2);
        Map<Boolean, List<Integer>> map3 = getMapWithStream();
        System.out.println(map3);


    }

    private static void feed(List<Cat> catList) {
        for (int i = 0; i < catList.size(); i++) {
            if (catList.get(i).isHungry()) {
                catList.get(i).setHungry(false);
            }
        }
    }

    private static void feedWithStream(List<Cat> catList) {
        catList.stream().filter(Cat::isHungry).forEach(cat -> cat.setHungry(false));
    }

    private static int getSum(List<Integer> integers) {
        int oddSum = 0;
        for(Integer i: integers) {
            if(i % 2 != 0) {
                oddSum += i;
            }
        }
        return oddSum;
    }

    private static int getSumWithStream(List<Integer> integers) {
//        integers.stream().filter(integer -> integer % 2 == 0).reduce(Integer::sum);
        return integers.stream().mapToInt(value -> value).filter(value -> value % 2 == 0).sum();
    }

    private static Map<Boolean, List<Integer>> getMap() {
        Map<Boolean, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                if (map.containsKey(true)) {
                    map.get(true).add(i);
                } else {
                    map.put(true, new ArrayList<>());
                    map.get(true).add(i);
                }
            } else {
                if (map.containsKey(false)) {
                    map.get(false).add(i);
                } else {
                    map.put(false, new ArrayList<>());
                    map.get(false).add(i);
                }
            }
        }
        return map;
    }

    private static Map<Boolean, List<Integer>> getMapWithStream() {
        return IntStream.range(0, 100).boxed().collect(Collectors.groupingBy(integer -> integer % 3 == 0,
                Collectors.mapping(t -> t, Collectors.toList())));
    }

    private static Map<Boolean, List<Integer>> getMapWithStream2() {
        return IntStream.range(0,100).boxed().collect(Collectors.partitioningBy(el -> (el % 3 == 0), Collectors.toList()));
    }






}
