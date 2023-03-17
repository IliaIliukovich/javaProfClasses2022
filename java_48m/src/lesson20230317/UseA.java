package lesson20230317;

public class UseA {


    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();

        a1.method1();
        A.getTotalElementsCount();
        a1.getTotalElementsCount();
        a2.getTotalElementsCount();
        a3.getTotalElementsCount();

        A.B b = new A.B();
        A.C c = a1.new C();
    }
}
