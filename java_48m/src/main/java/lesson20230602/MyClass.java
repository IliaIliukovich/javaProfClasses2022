package lesson20230602;

import jdk.jfr.Unsigned;

import java.util.Collections;
import java.util.List;

public class MyClass {

    private String data;

    public String myFunction(int count){
        return "Result for " + data + " = " + (100 / count);
    }

    public List<String> myStreamFunction(List<String> people){
        if (people == null) return Collections.emptyList();
        return people.stream().filter(s -> s.startsWith("M")).toList();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
