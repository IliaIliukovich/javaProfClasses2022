package lesson20230310;

public class Student extends Human{

    private int classNumber;

    public Student(String name, int id, int classNumber) {
        super(name, id);
        this.classNumber = classNumber;
    }

    @Override
    public void introduceYourself() {
        System.out.println("I'm a student!");
    }
}
