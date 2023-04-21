package lesson20230421;

import lesson20230331.Person;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExamples {

    public static void main(String[] args) {

        MyFunctionalInterface my = () -> "my string";
        MyFunctionalInterface my2 = () -> "my string 2";

        System.out.println(my.generateString());
        System.out.println(my2.generateString());

        MyOperation<String> sum = (x, y, z) -> x + y + z;
        MyOperation<Double> multiply = (x, y, z) -> x * y * z;
        System.out.println(sum.operation("1", "2", "3"));
        System.out.println(multiply.operation(2.0, 2.0 ,2.0));


        // Supplier: void -> Object
        Supplier<Person> personSupplier = () -> new Person("Name", "Surname", 1);

        // Consumer: Object -> void
        Consumer<String> consumer = s -> System.out.println(s);
        Consumer<String> consumer2 = System.out::println;

        consumer2.accept("123");
        consumer2.accept("456");

        Consumer<String> stringConsumer = LambdaExamples::doSomething;
        LambdaExamples se = new LambdaExamples();
        Consumer<String> stringConsumer2 = se::doSomethingNonStatic;

        // Function Object -> Object
        Function<Integer, String> function = integer -> "integer: " + integer.toString();
        Function<Object, Integer> beforeFunction = o -> (Integer) o + 1;
        Function<String, String> afterFunction = s1 -> s1 + " string after";
        Function<Object, String> finalFunction = function.compose(beforeFunction).andThen(afterFunction);

        String s = finalFunction.apply(777);
        System.out.println(s);

        // Predicate: Object -> Boolean
        Predicate<String> isLongerThanFive = s1 -> s1.length() > 5;
        boolean tested = isLongerThanFive.test("Hello!");
        System.out.println(tested);
    }

    public static void doSomething(String s) {
        System.out.println("Doing something with: " + s);
    }

    public void doSomethingNonStatic(String s) {
        System.out.println("DoSomethingNonStatic with: " + s);
    }

}
