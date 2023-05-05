package lesson20230505;

import java.util.Arrays;
import java.util.Optional;

public class OptionalExample {


    public static void main(String[] args) {

        // Usual approach
        String string = someFunction();
        String s = (string != null) ? string : "Some other String";
        System.out.println(s.toUpperCase());

        // Approach with Optional
        Optional<String> optionalS = Optional.ofNullable(someFunction());
        s = optionalS.orElse("Some other String");
        System.out.println(s.toUpperCase());

        s = someFunctionWithOptional().orElse("Alternative Value");
        System.out.println(s.toUpperCase());


        Optional<String> optional =
                Arrays.asList("A", "C", "B", "C", "D", "E").stream().filter(str -> str.equals("F")).findAny();
        System.out.println(optional.orElse("No value"));

    }

    private static String someFunction() {
        return null;
    }

    private static Optional<String> someFunctionWithOptional() {
//        return Optional.ofNullable("Some String");
        return Optional.ofNullable(null);
    }

}
