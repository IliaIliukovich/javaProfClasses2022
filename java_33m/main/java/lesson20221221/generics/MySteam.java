package lesson20221221.generics;

public class MySteam<T> extends ParentStream<T, MySteam<T>> {

    public MySteam<T> filter(){
        // ... filter impl
        return new MySteam<>();
    }

}
