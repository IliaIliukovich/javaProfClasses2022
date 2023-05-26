package lesson20230526;

import java.util.ArrayList;
import java.util.List;

public class PECSExamples {

    public static void main(String[] args) {

        List<Double> doubles = new ArrayList<Double>();
        doubles.add(10.0);
        doubles.add(20.0);
        doubles.add(30.0);

        List<Integer> integers = new ArrayList<Integer>();
        integers.add(10);
        integers.add(20);
        integers.add(30);

        // "Producer extends"
        List<? extends Number> numbers;
        numbers = integers; // possible
        numbers = doubles; // possible
//        numbers.add(10.0); // impossible
        Number number = numbers.get(0); // possible

        // Plain parameter
        List<Number> numbers2 = new ArrayList<>();
        numbers2.add(10.0); // possible
        numbers2.add(1); // possible
//        numbers2 = doubles; // impossible

        // "Consumer super"
        List<? super Double> list;
        list = doubles; // possible
//        list = integers; // impossible
//        Double d = list.get(0); // impossible
        Object o = list.get(0); // possible
        list.add(40.0);  // possible
//        list.add(new Object()); // impossible

    }

}
