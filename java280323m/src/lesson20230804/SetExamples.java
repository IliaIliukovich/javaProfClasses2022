package lesson20230804;

import java.util.*;

public class SetExamples {


    public static void main(String[] args) {
        Set<String> set = new HashSet<>(16, 0.75f);
        set.add("B");
        set.add("C");
        set.add("M");
        set.add("A");
        System.out.println(set);

        Set<Student> treeSet = new TreeSet<>();
        treeSet.add(new Student("Tom", "Smiths", 15));
        treeSet.add(new Student("Tom", "Smiths", 15));
        treeSet.add(new Student("Mary", "Smiths", 12));
        System.out.println(treeSet);

        String s1 = "My string";
        String s2 = "My string";
        String s3 = new String("My string");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }





}
