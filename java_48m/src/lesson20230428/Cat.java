package lesson20230428;

public class Cat {

    private String name;
    private int age;
    private String colour;
    private boolean isHungry;

    public Cat(String name, int age, String colour, boolean isHungry) {
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.isHungry = isHungry;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", age=" + age + ", colour='" + colour + '\'' + ", isHungry=" + isHungry + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
}
