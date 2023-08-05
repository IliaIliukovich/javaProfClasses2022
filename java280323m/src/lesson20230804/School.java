package lesson20230804;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class School {

    public static void main(String[] args) {
        Student student1 = new Student("Ivan", "Ivanov", 12);
        Student student2 = new Student("Peter", "Ivanov", 15);
        Student student6 = new Student("Peter", "Ivanov", 11);
        Student student3 = new Student("Mary", "Sidorova", 16);
        Student student4 = new Student("John", "Smiths", 9);
        Student student5 = new Student("Mark", "Petrov", 12);

        List<Student> list = Arrays.asList(student1, student2, student3, student4, student5, student6);
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("Sort by natural ordering, reverse:");
        list.forEach(System.out::println);

        System.out.println("Sort by age:");
        Collections.sort(list, new CompareByAge());
        list.forEach(System.out::println);

        System.out.println("Sort by name:");
        Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        list.forEach(System.out::println);
    }



}
