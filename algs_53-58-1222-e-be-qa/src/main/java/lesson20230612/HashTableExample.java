package lesson20230612;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashTableExample {

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>(100, 0.5f);
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        hashMap2.put("B", 1);
        hashMap2.put("A", 1);
        hashMap2.put("C", 1);
        hashMap2.put("D", 1);
        hashMap2.put("E", 1);
        hashMap2.put("F", 1);
        hashMap2.remove("B");
        hashMap2.put("B", 1);


        Set<Map.Entry<String, Integer>> entries = hashMap2.entrySet();

        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e);
        }
    }


}
