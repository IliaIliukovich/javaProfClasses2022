package lesson20230526;

import java.io.FileNotFoundException;

public class ExceptionExamples {

    public static void main(String[] args) {

//        throw new RuntimeException("Something went wrong");

        try {
            someMethod();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        } finally {
            System.err.println("Final operations");
        }

        MyException exception = new MyException("My custom exception");
        try {
            throw exception;
        } catch (MyException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }


    private static void someMethod() throws FileNotFoundException {
        throw new FileNotFoundException("someMethod exception");
//        someMethod();
    }


}
