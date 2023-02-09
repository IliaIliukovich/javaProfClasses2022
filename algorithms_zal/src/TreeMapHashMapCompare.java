import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class TreeMapHashMapCompare {

    public static void main(String[] args) {

        Random random = new Random();

        HashMap<Integer, String> hashMap = new HashMap<>(1_000_000);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            hashMap.put(random.nextInt(10_000_000), "Value");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            treeMap.put(random.nextInt(10_000_000),"Value");
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
