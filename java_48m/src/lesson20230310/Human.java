package lesson20230310;

public abstract class Human {

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Human(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract void introduceYourself();

    public void sayHello() {
        System.out.println("Hello!");
    }
}
