package lesson20230213.reflection;

public class SpecialClass {

    private String field;

    public SpecialClass(String field) {
        this.field = field;
    }

    public SpecialClass() {
    }

    public String getField() {
        return field;
    }

    public void method1(){
        System.out.println("Method1");
    }

    public void method2(int n){
        System.out.println("Method2 with n = " + n);
    }

    private void method3(){
        System.out.println("Private method");
    }


}
