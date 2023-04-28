package lesson20230428;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        System.out.println("Main starts");

        // 1 - create stream
        List<String> stringList = Arrays.asList("Mary", "Jane", "Tom", "Edward", "Jimmy");
        Stream<String> stringStream = stringList.stream();
        System.out.println("Stream created");

        // 2 - intermediate operations
        Stream<String> stringStream2 = stringStream.sorted()
                .peek(System.out::println)
                .sorted(Comparator.reverseOrder())
                .peek(System.err::println);
        System.out.println("Stream operations described");

        // 3 - final operations
        List<String> processedList = stringStream2.toList();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        System.out.println("New list created");


        System.out.println(processedList);

        System.out.println("Main ends");

        int[] ints = new int[]{1, 3, 2, 5, 9, 1, 2, 4, 7};
        int[] filteredAndSortedInts = Arrays.stream(ints).sorted().distinct().toArray();
        System.out.println(Arrays.toString(filteredAndSortedInts));

        Arrays.stream(ints).mapToDouble(value -> value + 2.0).forEach(System.out::println);

        Arrays.asList("A", "B", "A", "C", "Q", "P", "B").stream()
                .filter(s -> s.equals("A") || s.equals("B") || s.equals("C")).forEach(System.out::println);

        List<String> group1 = Arrays.asList("Tom", "Bob", "Jane");
        List<String> group2 = Arrays.asList("Mary", "Ivan", "Peter", "Mark");
        List<String> group3 = Arrays.asList("Tom", "Edd", "Ivan", "Harry", "Mark");
        List<List<String>> university = Arrays.asList(group1, group2, group3);

        List<String> allStudents = university.stream().flatMap(Collection::stream).distinct().toList();
        System.out.println(allStudents);


        // task1. Отсортировать с помощью стримов список из строк
        //- по алфавиту
        //- в обратном порядке
        // TODO

        // task 2. Из списка чисел типа Integer с помощью стримов создать список их строковых представлений
        // TODO

        // task 3. Создать класс Cat с полями
        //String name
        //int age
        //String colour
        //boolean isHungry
        //Создать список из экземплянов класса Cat. С помощью стримов:
        //- вывести список голодных кошек старше 2 лет filter()
        //- вывести список черных кошек с именем, начинающимся на T
        //- вывести список имен кошек возраста 1 год filter() -> map ()

        Cat cat1 = new Cat("Tom", 2, "black", true);
        Cat cat2 = new Cat("Mikky", 1, "white", false);
        Cat cat3 = new Cat("Vasya", 3, "white", true);
        Cat cat4 = new Cat("Steve", 1, "grey", false);
        Cat cat5 = new Cat("Bob", 2, "black", true);
        List<Cat> catList = Arrays.asList(cat1, cat2, cat3, cat4, cat5);

        // TODO

        // Дополнительные задания:
        // Task:
        //1. Посчитать количество неповторяющихся слов в списке
        //2. Посчитать количество людей с именем "Tom" в списке имен
        //3. Из списка имен вывести первое по алфавиту
        //4. Посчитать количество чисел от 1 до 1000, которые делятся на 7.
        //5. Посчитать сумму квадратов чисел от 1 до 10
        //6. Дан список слов "Specific" "Measurable" "Achievable" "Relevant" "Time-bound".
        // С помощью стримов вывести его аббревиатуру в виде S.M.A.R.T.

    }



}
