package lesson20230310;

public class School {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Thomson", 1, "Maths");
        Student student = new Student("Peter", 2, 5);

        teacher.sayHello();
        teacher.introduceYourself();

        student.sayHello();
        student.introduceYourself();

        teacher.teach(student);

    }


}
