package lesson20221206.abstractclassesandintefaces;

import com.telran.abstractclassesandintefaces.*;

import java.util.List;

public class Teacher extends Human implements Teachable, Playable {

    public Teacher(String name, int id) {
        super(name, id);
        // teacher fields init
    }

//    @Override
//    public String getName() {
//        return "Teacher " + super.getName();
//    }

    @Override
    public void introduceYourself() {
        System.out.println("I'm a teacher!");
    }

    // todo
    @Override
    public void teach(Student student, Subject subject) {
        System.out.println("Teacher " + this.getName() + " teaches student " + student.getName());
    }

    // todo
    @Override
    public void teach(List<Student> students, Subject subject) {
        for (Student student: students) {
            this.teach(student, subject);
        }
    }

    @Override
    public void play() {
        System.out.println("I play chess!");
    }
}
