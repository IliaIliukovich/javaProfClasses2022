package lesson20221206.abstractclassesandintefaces;

import java.util.Arrays;
import java.util.List;

public class School {

    public static void main(String[] args) {

        Student student1 = new Student("Tom", 1);
        Student student2 = new Student("Bob", 2);
        Student student3 = new Student("Mary", 3);
        Teacher teacher = new Teacher("Mr. Thompson", 4);

        List<Human> peopleAtSchool = Arrays.asList(student1, student2, student3, teacher);
        List<Student> studentsAtSchool = Arrays.asList(student1, student2, student3);
        for (Human human: peopleAtSchool) {
            System.out.println(human.getName());
            human.introduceYourself();
        }

        student1.play();
        teacher.play();

        List<Playable> players = Arrays.asList(student1, student2, student3, teacher);
        for (Playable player : players) {
            player.play();
        }

        Subject subject = null;
        teacher.teach(studentsAtSchool, subject); // todo



    }
}
