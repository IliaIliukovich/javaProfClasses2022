package lesson20230605;

import java.util.*;

public class UseTrees {

    public static void main(String[] args) {

        TreeMap<String, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put("B", "value B");
        map.put("C", "value C");
        map.put("A", "value A");

        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println(e);
        }

        for (String e : map.keySet()) {
            System.out.println(e);
        }


        Set<String> set = new TreeSet<>();

    }



}
