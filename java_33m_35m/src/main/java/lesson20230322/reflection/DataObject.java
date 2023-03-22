package lesson20230322.reflection;

public class DataObject {

    private int count;
    private String name;

    public DataObject() {
    }

    public DataObject(int count, String name) {
        this.count = count;
        this.name = name;
    }



    public void method1() {
        System.out.println("public method: " + " count = " + count + ", name = " + name);
    }


    private int updateCount(int newValue) {
        System.out.println("private method invoked");
        count = newValue;
        return count;
    }
}
