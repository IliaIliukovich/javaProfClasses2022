package lesson20230331;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;

    private String surname;

    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public int compareTo(Person o) {
        int result = this.surname.compareTo(o.surname);
        if (result != 0) return result;
        result = this.name.compareTo(o.name);
        if (result != 0) return result;
        return this.age - o.age;
    }

}
