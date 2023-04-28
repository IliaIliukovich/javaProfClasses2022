package lesson20230428;

import java.util.Random;
import java.util.function.*;

public class FunctionalInterfacesExamples {

    public static void main(String[] args) {
        System.out.println("Main starts");

        Consumer<String> consumer = System.out::println;
        Consumer<String> combinedConsumer = consumer.andThen(System.err::println);

        System.out.println("Some other operations ...");

        combinedConsumer.accept("String data");

        Consumer<String> consumer3 = s -> {
            System.out.println(s);
            System.err.println(s);
        };
        consumer3.accept("String data 2");


        // task 1 Создать Supplier, который генерирует случайные значения типа Integer
        Supplier<Integer> generateRandomInteger = () -> new Random().nextInt();
        System.out.println(generateRandomInteger.get());
        System.out.println(generateRandomInteger.get());
        System.out.println(generateRandomInteger.get());

        // task 2 Создать BiFunction, которая возводит первый аргумент типа int в степень второго аргумента типа int
        BinaryOperator<Integer> myPow = (integer, integer2) -> (int) Math.pow(integer, integer2);
        System.out.println(myPow.apply(2, 3));

        // task 3 Создать функцию, которая обрезает входную строку до 5 символов, делает их upper case
        //и добавляет ____ в конец.
        Function<String, String> function =
                ((UnaryOperator<String>) s1 -> s1.substring(0, 5)).andThen(String::toUpperCase).andThen(s -> s + "______");

        Function<String, String> function2 = s1 -> s1.substring(0, 5).toUpperCase() + "_______";

        System.out.println(function.apply("Test string"));
        System.out.println(function.apply("Hello!"));
        System.out.println(function.apply("World!"));
        System.out.println(function2.apply("Test string 2"));

        Function<String, String> function3 = s -> s.substring(0, 5);
        System.out.println(function3.andThen(String::length).apply("Data to process"));
    }


}
