package lesson20230324;

public class A {

    private B b;

    public void setB(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public A() {
        this.b = new B("default value");
    }


    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);

        B b = a.getB();
        b.setS("new value");
        System.out.println(a);

        B b2 = new B("new object b");
        a.setB(b2);
        System.out.println(a);
        b2.setS("Ha-ha");
        System.out.println(a);

    }

    @Override
    public String toString() {
        return "A{" + "b=" + b + '}';
    }
}
