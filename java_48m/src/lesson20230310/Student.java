package lesson20230310;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Student extends Human{

    private int classNumber;

    // список уже пройденных предметов
    private List<Subject> studiedSubjects = new ArrayList<>();

    public List<Subject> getStudiedSubjects() {
//        List<Subject> copy = new ArrayList<>();
//        copy.addAll(studiedSubjects);
//        return copy;
        return studiedSubjects;
    }

//    public void add(Subject subject){
//        studiedSubjects.add(subject);
//    }

    public Student(String name, int id, int classNumber) {
        super(name, id);
        this.classNumber = classNumber;
    }

    @Override
    public void introduceYourself() {
        System.out.println("I'm a student!");
    }

    @Override
    public String toString() {
        return "Student{" + "classNumber=" + classNumber + ", studiedSubjects=" + studiedSubjects + "} " + super.toString();
    }
}


