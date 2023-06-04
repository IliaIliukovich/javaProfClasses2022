package lesson20230310;

import java.util.List;
import java.util.Set;

public class Teacher extends Human{

    private Subject subject;
// enum Subject -

    public Teacher(String name, int id, Subject subject) {
        super(name, id);
        this.subject = subject;
    }

    @Override
    public void introduceYourself() {
        System.out.println("I'm a teacher!");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, dear students!");
    }

    public void teach(Student student) {
        System.out.println("Teacher " + this.getName() + " teaches " + student.getName()
                + ". Subject: " + subject);

        Set<Subject> studiedSubjects = student.getStudiedSubjects();
        studiedSubjects.add(subject);
    }

    public void teach(Student[] students) {
        for (Student s : students) {
            this.teach(s);
        }
    }
}
