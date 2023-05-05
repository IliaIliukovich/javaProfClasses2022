package lesson20230505;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> integerStream = integerList.stream();
        Stream<Integer> integerStream2 = integerStream.filter(i -> i % 2 == 0);
//        Stream<Integer> integerStream3 = integerStream2.filter(i -> i % 3 == 0);

        // ... some other code ...

        List<Integer> filteredList = integerStream2.toList();

//        List<Integer> filteredList2 = integerStream3.toList();

        System.out.println(filteredList);
        System.out.println(filteredList.getClass());

        List<Integer> filteredList2 = filteredList.stream().filter(i -> i % 3 == 0).toList();
        System.out.println(filteredList2);

        IntStream intStream = IntStream.rangeClosed(1, 1_000_000).peek(System.err::println).map(i -> i * i);
        intStream.skip(10).limit(10).forEach(System.out::println);

        List<Integer> boxedIntegers = IntStream.rangeClosed(1, 10).boxed().toList();
        IntStream intStream1 = boxedIntegers.stream().mapToInt(value -> value);

        int reduce = IntStream.rangeClosed(1, 3).reduce(0, (result, element) -> result + element * element);
        System.out.println(reduce);

        reduce = IntStream.rangeClosed(1, 7).reduce(0, (result, element) -> result * 10 + element);
        System.out.println(reduce);

        reduce = IntStream.rangeClosed(1, 7).reduce(5, (result, element) -> Math.min(result, element));
        System.out.println(reduce);

    }



}
