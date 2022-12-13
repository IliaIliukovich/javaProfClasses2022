package lesson12122022.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TerminalOperations {

    public static void main(String[] args) {

        // Optional examples
        String stringFromMethod = someMethod();

        String str = stringFromMethod != null ? stringFromMethod : "Some other string";
        System.out.println(str.toUpperCase());

        Optional<String> optional = Optional.ofNullable(stringFromMethod);
        str = optional.orElse("Some other string");
        System.out.println(str.toUpperCase());

        str = someMethod2().orElse("Error message");
        System.out.println(str.toUpperCase());

        // Terminal operations examples
        Cat cat1 = new Cat("Tom", 3, true, "black");
        Cat cat2 = new Cat("Tim", 2, true, "grey");
        Cat cat3 = new Cat("Jeryy", 1, true, "black");
        Cat cat4 = new Cat("Mik", 4, true, "yellow");
        Cat cat5 = new Cat("Sem", 1, false, "black");
        Cat cat6 = new Cat("Kit", 0, false, "black");
        Cat cat7 = new Cat("Timmy", 1, false, "blue");
        Cat cat8 = new Cat("Set", 2, false, "red");
        Cat cat9 = new Cat("Ren", 1, false, "black");
        Cat cat10 = new Cat("Zert", 1,false, "black");
        Cat sameNameCat = new Cat("Zert", 1,true, "black");

        List<Cat> cats = Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7,cat8,cat9,cat10, sameNameCat);
        Cat someCat = cats.stream().filter(cat -> cat.getName() != null && cat.getName().startsWith("L")).findAny().orElse(cat1);
        System.out.println(someCat);

        long numberOfHungryCats = cats.stream().filter(Cat::isHungry).count();
        System.out.println(numberOfHungryCats);

        Optional<String> names = cats.stream().map(cat -> cat.getName()).reduce((c1, c2) -> c1 + "|" + c2);
        System.out.println(names);

        // генерация последовательности чисел и вычисление их суммы квадратов
        int sunInt = IntStream.rangeClosed(1, 4).reduce(0, (left, right) -> left + right * right);
        System.out.println(sunInt);

        cats.stream().map(Cat::getColour).collect(Collectors.collectingAndThen(Collectors.toList(), Collection::stream)).forEach(System.out::println);


        Map<String, Boolean> namesWithIsHungryInfo = cats.stream().collect(Collectors.toMap(Cat::getName, Cat::isHungry, (aBoolean, aBoolean2) -> aBoolean));
        System.out.println(namesWithIsHungryInfo);

        Map<String, Set<String>> colourWithNamesGroup = cats.stream().collect(Collectors.groupingBy(Cat::getColour, Collectors.mapping(Cat::getName, Collectors.toSet())));
        System.out.println(colourWithNamesGroup);

        Map<String, Long> countColours = cats.stream().collect(Collectors.groupingBy(Cat::getColour, Collectors.counting()));
        System.out.println(countColours);

    }

    private static String someMethod() {
        // code to generate string
        return null;
    }

    private static Optional<String> someMethod2() {
        // code to generate string
        return Optional.ofNullable(null);
    }


}
