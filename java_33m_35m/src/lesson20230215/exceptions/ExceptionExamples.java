package lesson20230215.exceptions;

public class ExceptionExamples {

    public static void main(String[] args) {

        // ArithmeticException
//        int i = 0;
//        System.out.println(i / 0);

        // NullPointerException
//        String s = null;
//        System.out.println(s.toUpperCase());

//        throw new RuntimeException("Some serious exception occured");

        // StackOverflowError
//        recursiveMethod();

        // ClassCastException
//        String string = "Some string";
//        Object o = string;
//        Integer s2 = (Integer) o;
//        System.out.println(s2);

        System.out.println("In main before arithmeticMethod");
        arithmeticMethod(3);
        System.out.println("In main after arithmeticMethod");

        String output = processString("input string");
        System.out.println(output);
        output = processString(null);
        System.out.println(output);
        output = processString("123");
        System.out.println(output);

        A a = new B();
        try {
            a.someMethod();
        } catch (InputValidationException e) {
            e.printStackTrace();
        }

    }

    private static String processString(String input) {
        try {
            if (input == null) throw new InputValidationException("input string is null");
            if (input.length() <= 4) throw new InputValidationException("input string is too short");

            String newString = input.substring(2, 5).toUpperCase();
            return newString;
        } catch (InputValidationException e) {
            System.out.println("Exception: " + e.getMessage());
            return "default string";
        }
    }

    private static void arithmeticMethod(int j) {
            try {
                int i = 5;
                int m = 0;
                int k = i / m;

                int[] ints = {1, 2, 3};
                System.out.println(ints[j]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException");
                System.out.println(e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException");
                System.out.println(e.getMessage());
            } finally {
                System.out.println("In finally block");
            }
    }

    static int i = 0;
    private static void recursiveMethod() {
        System.out.println(i++);
        recursiveMethod();
    }

}
