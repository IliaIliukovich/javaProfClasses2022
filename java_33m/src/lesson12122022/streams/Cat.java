package lesson12122022.streams;

public class Cat {

    private String name;
    private int age;
    private boolean isHungry;
    private String colour;

    public Cat(String name, int age, boolean isHungry, String colour) {
        this.name = name == null ? "Default name" : name;
        this.age = age;
        this.isHungry = isHungry;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isHungry=" + isHungry +
                ", colour='" + colour + '\'' +
                '}';
    }
}
