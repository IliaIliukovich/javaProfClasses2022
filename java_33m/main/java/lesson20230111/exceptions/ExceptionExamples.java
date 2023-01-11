package lesson20230111.exceptions;

import java.io.IOException;

public class ExceptionExamples {


    public static void main(String[] args) {

        int[] ints = new int[]{1, 2, 3};
//        ints[3] = 5; // Runtime Exception

//        System.out.println(1 / 0); // Runtime Exception

        try {
            stringOperations();
        } catch (MyException e) {
            e.printStackTrace();
        }

//        infiniteRecursions(); // Error

//        throw new ArithmeticException("My arithmetic exception");

        arithmeticMethod(0);
        System.out.println("Some other actions");

        try {
            new B().doSometh();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Integer intFromString = Integer.parseInt("x"); // NumberFormatException
//        System.out.println(intFromString);

        try {
            C c = new C();
            c.method();
            C c2 = new C();
            c2.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void arithmeticMethod(int z) {
        try {
            int x = 5 / z;
            int[] y = new int[1];
            y[1] = 2;
//        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
//            System.out.println("Exception occurred");
//        }
        } catch (Exception e) {
            if (e instanceof ArithmeticException) {
                System.out.println("Cannot delete by zero");
//                throw new RuntimeException();
            } else if (e instanceof ArrayIndexOutOfBoundsException) {
                System.out.println("Problem with array index");
            } else {
                System.out.println("Some unknown problem");
            }
        } finally {
            System.out.println("In finally block");
        }

    }

    private static void stringOperations() throws MyException {
        String s = null;
        try {
            s.length();
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new MyException("string is null");
        }
    }

    private static void infiniteRecursions() {
        infiniteRecursions();
    }

}
