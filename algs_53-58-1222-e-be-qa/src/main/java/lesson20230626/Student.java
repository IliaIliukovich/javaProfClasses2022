package lesson20230626;

public class Student implements Comparable<Student> {

    private String name;
    private String surname;
    private Integer age;

    public Student(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", age=" + age + '}';
    }

    @Override
    public int compareTo(Student o) {
        int compare = this.surname.compareTo(o.surname);
        if (compare == 0) return this.age - o.age;
        return compare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
