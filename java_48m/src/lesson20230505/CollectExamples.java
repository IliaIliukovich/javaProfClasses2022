package lesson20230505;

import java.util.*;
import java.util.stream.Collectors;

public class CollectExamples {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("A", "C", "B", "C", "D", "E", "A");

//        List<String> collect = stringList.stream().collect(Collectors.toCollection(LinkedList::new));

        List<String> newList = stringList.stream().toList();
        System.out.println(newList.getClass());

        Set<String> newSet = stringList.stream().collect(Collectors.toSet());
        System.out.println(newSet);

        List<String> names = Arrays.asList("Mary", "Tom", "Timothy", "Edd", "Anthony", "Mary", "Ivan", "Mary");

        Map<String, Integer> namesWithCount = names.stream().collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));
        System.out.println(namesWithCount);

        Map<String, Integer> namesWithNumberOfSimbols = names.stream().distinct().collect(Collectors.toMap(s -> s, String::length));
        System.out.println(namesWithNumberOfSimbols);

        Map<Integer, Set<String>> lengthSet = names.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.mapping(s -> s, Collectors.toSet())));
        System.out.println(lengthSet);
    }


}
