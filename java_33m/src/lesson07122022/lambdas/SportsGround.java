package lesson07122022.lambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SportsGround {

    public static void main(String[] args) {

        // Пример работы интерфейсов и анонимных классов
        Playable footballPlayer = new FootballPlayer();
        Playable hockeyPlayer = new HockeyPlayer();
        footballPlayer.play();
        hockeyPlayer.play();

//  В анонимном классе возможно иметь много методов, но в таком случае его не представить в виде лямбда-выражения
        Playable chessPlayer = new Playable() {
            @Override
            public void play() {
                System.out.println("I play chess!");
            }
//            @Override
//            public void play2() {
//
//            }
        };
        chessPlayer.play();

        Playable tennisPlayer = () -> System.out.println("I play tennis!");

        Consumer<String> somePlayer = s -> System.out.println("I play some game!");
        somePlayer.accept(null);


        // void -> void
        // void -> value Supplier
        // value -> void Consumer
        // value -> value Function
        // value -> boolean Predicate

        BiFunction<Integer, Integer, Integer> biFunction = Integer::sum;

        List<String> list = Arrays.asList("Info 1", "Info 2", "Info 3");
        SportsGround sportsGround = new SportsGround();
        list.forEach(sportsGround::someConsumer);
        list.forEach(System.out::println);

        for (String l:list) {
            System.out.println(sportsGround.someFunction(l));
        }
        List<String> newList = list.stream().map(SportsGround::someFunction).toList();
        System.out.println(newList);

        int x = 0;
        Consumer<Integer> number = integer -> {
//            x = 1; невозможно менять
            System.out.println(integer + x);
            System.out.println();
        };
        number.andThen(integer -> System.out.println(++integer)).accept(5);

        Function<String, String> function = s -> s.toUpperCase();
        Function<String, String> beforeFunction = v -> "Text before " + v;
        Function<String, String> afterFunction = s -> s + " Text after";
        Function<String, String> combinedFunction = function.compose(beforeFunction).andThen(afterFunction);
        System.out.println(combinedFunction.apply("Some string"));


        Function<String, String> f = s -> s.substring(0, 5);
        String str = "SomeString";
        System.out.println(f.compose(p-> p+"_").andThen(String::toUpperCase).apply(str));

        // Создание потоков
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> stringList = Arrays.asList("One", "Two", "Three", "One");
        Stream<String> stringStream = stringList.stream();


        Stream<String> streamAfterPeak = stringStream.peek(System.out::println);
        System.out.println("peek is still not called");
        List<String> newStringList = streamAfterPeak.toList();
        System.out.println(newStringList);

        stringList.stream().filter(s -> s.length() > 3).forEach(System.out::println);
        System.out.println("____");
        stringList.stream().distinct().forEach(System.out::println);

        List<Integer> stringLength = stringList.stream().map(s -> s.length()).toList();
        System.out.println(stringLength);

        List<String> stringList1 = Arrays.asList("One", "Two", "Three", "One");
        List<String> stringList2 = Arrays.asList("Four", "Five", "Zero");
        List<String> stringList3 = Arrays.asList("One");
        List<List<String>> bigList = Arrays.asList(stringList1, stringList2, stringList3);

        List<String> flatList = bigList.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
        System.out.println(flatList);

    }


    public void someConsumer(String string) {
        System.out.println(string + " some additional info");
    }

    public static String someFunction(String string) {
        return string + " some additional info in function";
    }

}
