package lesson20230310;

public class School {

    public static void main(String[] args) {
        Teacher mathTeacher = new Teacher("Mr. Thomson", 1, Subject.MATHS);
        Teacher literureTeacher = new Teacher("Mrs. Simmons", 7, Subject.LITERATURE);
        Student student = new Student("Peter", 2, 5);

        mathTeacher.sayHello();
        mathTeacher.introduceYourself();

        student.sayHello();
        student.introduceYourself();

        System.out.println(student);
        mathTeacher.teach(student);
        System.out.println(student);

        Cat cat = new Cat("Tom");

        restTime(mathTeacher, student, cat);

        Student student2 = new Student("Ann", 3, 6);
        Student student3 = new Student("Mary", 4, 6);
        mathTeacher.teach(student2);
        mathTeacher.teach(student2);
        System.out.println(student2);

        Student[] class6Students = {student2, student3};
        literureTeacher.teach(class6Students);
        System.out.println(student2);
    }

    private static void restTime(Playable ... players) {
        for (Playable p : players) {
            p.play();
        }
    }


}
