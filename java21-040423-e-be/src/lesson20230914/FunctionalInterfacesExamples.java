package lesson20230914;

import java.util.Random;
import java.util.function.*;

public class FunctionalInterfacesExamples {


    public static void main(String[] args) {

        // void -> void
        // void -> data  - Supplier ----- get()
        // data -> void  - Consumer ---- accept()
        // data1 -> data2 - Function ---- apply()
        // data -> boolean - Predicate ---- test()

        RandomGenerator randomGenerator = () -> {
            Random random = new Random();
          return random.nextInt();
        };

        RandomGenerator positiveIntsGenerator = () -> {
            Random random = new Random();
            return random.nextInt(0, 100);
        };

        // void -> data  - Supplier ----- get()
        Supplier<Integer> negativeIntsGenerator = () -> {
            Random random = new Random();
            return random.nextInt(-100, 0);
        };

        System.out.println(randomGenerator.generate());
        System.out.println(randomGenerator.generate());
        System.out.println(randomGenerator.generate());
        System.out.println(positiveIntsGenerator.generate());
        System.out.println(positiveIntsGenerator.generate());
        System.out.println(positiveIntsGenerator.generate());
        System.out.println(negativeIntsGenerator.get());
        System.out.println(negativeIntsGenerator.get());
        System.out.println(negativeIntsGenerator.get());


        // data -> void  - Consumer ---- accept()
        Consumer<String> printData = (myData) -> {
            System.out.println("(" + myData + ")");
        };

        printData.accept("Data to print 1");
        printData.accept("Data to print 2");
        printData.accept("Data to print 3");

        // composite consumer
        Consumer<String> printAndPostProcessData = printData
                .andThen(data -> System.out.println(data.toUpperCase()));
        printAndPostProcessData.accept("data");

        // data1 -> data2 - Function ---- apply()
        Function<Integer, String> intConverter = (number) -> "----" + number + "----";
        String result = intConverter.apply(20);
        System.out.println(result);
        System.out.println(intConverter.apply(1000));

        // data -> boolean - Predicate ---- test()
        Predicate<String> isLongEnough = (s) -> {
            if (s.length() >= 5) return true;
            return false;
        };
        System.out.println(isLongEnough.test("Hi there!"));
        System.out.println(isLongEnough.test("Hi!"));

        // (data1, data2) -> data3 - BiFunction ---- apply()
        BiFunction<Integer, Integer, Integer> multiply = (n1, n2) -> n1 * n2;
        System.out.println(multiply.apply(10, 20));

        // x / 10
        UnaryOperator<Integer> del = (x) -> x / 10;
        del.apply(23000);

        // x^y
        BinaryOperator<Integer> pow = (x, y) -> (int) Math.pow(x, y);
        pow.apply(2, 10);


        // composite function
        Function<String, String> processString = s -> s.substring(6, 14);
        Function<String, String> before = s -> s.toUpperCase();
        Function<String, String> after = s -> s + " extra info";
        Function<String, String> finalFunction = processString.compose(before).andThen(after);

//        Function<String, String> finalFunction = ((Function<String, String>) s -> s.substring(6, 14))
//                .compose((Function<String, String>) s1 -> s1.toUpperCase())
//                .andThen(s2 -> s2 + " extra info");

        System.out.println(finalFunction.apply("input function data"));
    }

}
