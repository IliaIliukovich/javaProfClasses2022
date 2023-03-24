package lesson20230324;

public class B {

    private String s;

    public B(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "B{" + "s='" + s + '\'' + '}';
    }
}
