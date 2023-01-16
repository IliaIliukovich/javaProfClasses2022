package lesson20221221.generics;

public class ParentStream<T, S extends ParentStream<T, S>> {

    public S parallel(){
        // ... parallel impl
        return null;
    }

    public S sequential(){
        // ... sequential impl
        return null;
    }

}
