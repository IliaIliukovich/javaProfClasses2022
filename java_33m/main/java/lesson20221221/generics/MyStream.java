package lesson20221221.generics;

public class MyStream<T> extends ParentStream<T, MyStream<T>> {

    public MyStream<T> filter(){
        // ... filter impl
        return new MyStream<>();
    }

}
