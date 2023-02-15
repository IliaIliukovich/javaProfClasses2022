package lesson20230315.exceptions;

import java.io.IOException;

public class B extends A {

    @Override
    void someMethod() throws InputValidationException{
        throw new InputValidationException("Exception in B class");
    }

}
