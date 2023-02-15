package lesson20230215.exceptions;

public class B extends A {

    @Override
    void someMethod() throws InputValidationException{
        throw new InputValidationException("Exception in B class");
    }

}
