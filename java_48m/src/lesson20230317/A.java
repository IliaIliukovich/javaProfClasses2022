package lesson20230317;

public class A {

    private int i;

    private static int count;

    public void method1() {
        System.out.println(i++);
    }

    public static void getTotalElementsCount(){
        System.out.println(count);
    }

    public A() {
        count++;
    }

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();

        a1.method1();
        A.getTotalElementsCount();
        a1.getTotalElementsCount();
        a2.getTotalElementsCount();
        a3.getTotalElementsCount();

        B b = new B();
        C c = a1.new C();

    }

    static class B {
        static int k = count;
        int p;

    }

    class C {
        static int r;
        int s = i;
    }


}
