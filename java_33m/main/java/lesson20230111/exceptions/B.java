package lesson20230111.exceptions;

import java.io.IOException;

public class B extends A {

    @Override
    public void doSometh() throws IOException { // throws PrintException - impossible to declare
        throw new IOException();
    }


}
