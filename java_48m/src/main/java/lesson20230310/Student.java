package lesson20230310;

import java.util.*;


public class Student extends Human{

    private int classNumber;

    // список уже пройденных предметов
    private Set<Subject> studiedSubjects = EnumSet.noneOf(Subject.class);

    public Set <Subject> getStudiedSubjects() {
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


