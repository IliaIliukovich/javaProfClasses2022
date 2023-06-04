package lesson20230331;

import java.util.*;

public class Persons {

    public static void main(String[] args) {

        Person person1 = new Person("Mary", "Smiths", 25);
        Person person2 = new Person("Mary", "Smiths", 25);
        System.out.println(person1 == person2);
        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode() == person2.hashCode());

        Person person3 = new Person("Bob", "Smiths", 33);
        Person person4 = new Person("Tom", "Smiths", 12);
        Person person5 = new Person("Tom", "Jennings", 44);
        Person person6 = new Person("Tom", "Jennings", 20);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        System.out.println(personList.size());
        System.out.println(personList);

        Collections.sort(personList);
        for (Person p : personList) {
            System.out.println(p);
        }

        Set<Person> personSet = new TreeSet<>(new PersonCompareBySurname());
        personSet.addAll(personList);
        System.out.println(personSet.size());
        for (Person p : personSet) {
            System.out.println(p);
        }


    }


}
