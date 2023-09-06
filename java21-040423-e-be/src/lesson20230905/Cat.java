package lesson20230905;

public class Cat {

    private String name;
    private int age;
    private String color;
    private boolean isHungry;

    public Cat(String name, int age, String color, boolean isHungry) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.isHungry = isHungry;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

//    @Override
//    public boolean equals(Object another){
//        if (another instanceof Cat){
//            Cat anotherCat = (Cat) another;
//            if (name.equals(anotherCat.getName()) && age == anotherCat.getAge()
//                    && color.equals(anotherCat.getColor()) && isHungry == anotherCat.isHungry()) return true;
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object another){
        if (another instanceof Cat){
            Cat anotherCat = (Cat) another;
            if (name.equals(anotherCat.getName())) return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }
}
