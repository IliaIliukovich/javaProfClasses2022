package lesson06122022.abstractclassesandintefaces;

import java.util.List;

public interface Teachable {

    void teach(Student student, Subject subject);

    void teach(List<Student> students, Subject subject);

}
