package lesson20230905;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExamples {

    public static void main(String[] args) {

        Map<String, Integer> hashMap = new HashMap<>(16, 0.75f);

        hashMap.put("Tom", 32);
        hashMap.put("Mary", 25);
        hashMap.put("John", 54);
        hashMap.put("Elena", 32);
        hashMap.put("Elena", 40);

        System.out.println(hashMap);

        Integer value = hashMap.get("Tom");
        System.out.println(value);
        System.out.println(hashMap.containsKey("Mary"));

        Set<String> keySet = hashMap.keySet();
        System.out.println(keySet);

        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println("Key = " + e.getKey());
            System.out.println("Value: " + e.getValue());
        }

        for (String key : hashMap.keySet()) {
            Integer v = hashMap.get(key);
            System.out.println("Key: " + key + " value: " + v);
        }


    }


}
