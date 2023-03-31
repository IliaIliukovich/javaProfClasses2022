package lesson20230331;

public class PolymorphismExample {

    public static void main(String[] args) {
        A a = new A();
        a.action();

        a = new B();
        a.action();
    }

}
