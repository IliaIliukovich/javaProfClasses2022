package lesson20230111.exceptions;

import javax.print.PrintException;
import java.io.IOException;

public class A {

    public void doSometh() throws IOException {
        throw new IOException();
    }

}
