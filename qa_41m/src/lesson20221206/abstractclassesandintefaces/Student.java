package lesson20221206.abstractclassesandintefaces;

public class Student extends Human implements Playable {

    Subject[] subjects = new Subject[10]; // Массив либо можно с помощью List<Subject>

    public Student(String name, int id) {
        super(name, id);
    }

    @Override
    public void introduceYourself() {
        System.out.println("I'm a student!");
    }

    @Override
    public void play() {
        System.out.println("I'm playing football!");
    }
}
