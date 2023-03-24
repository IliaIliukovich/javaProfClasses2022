package lesson20230324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListExamples {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list);

        List<String> list2 = list;
        list2.add("D");

        System.out.println(list);
        System.out.println(list2);
        System.out.println(list.get(0));
        System.out.println(list.size());
        List<String> subList = list.subList(1, 3);
        System.out.println(subList);


        String[] array = new String[3];
        array[0] = "A";
        array[1] = "B";
        array[2] = "C";
//        array[3] = "D";
        String[] array2 = array;
        System.out.println(array);
        System.out.println(array2);
        System.out.println(array[0]);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String s : list) {
            System.out.println(s);
        }

        List<String> names = Arrays.asList("Mary", "Jane", "Tom", "Tim", "Mark", "Ann", null, "");

        // 1 - Вывести список со словом student в начале
        // 2 - написать метод, который бы возвращал список имен, начинающихся на определенную букву s
        // 3 - написать метод, который выводил бы имена, в которых количество букв больше n и печатал их в CAPSLOCK

        List<String> namesLetter = getNamesByLetter(names, "m");
        System.out.println(namesLetter);
    }

    private static List<String> getNamesByLetter(List<String> names, String letter) {
        List<String> newNames = new ArrayList<>();
        for (String name : names) {
            if (name != null && name.toLowerCase().startsWith(letter.toLowerCase())) {
                newNames.add(name);
            }
        }
        return newNames;
    }


}
