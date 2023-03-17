package lesson20230310;

public abstract class Human implements Playable{

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

    @Override
    public void play(){
        System.out.println("Human " + this.getName() + " plays");
    }
}
