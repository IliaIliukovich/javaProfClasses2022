package lesson20230220.junit;

import java.util.HashSet;
import java.util.Set;

public class ArrayTask {


    public Integer[] findCommon(Integer[] a, Integer[] b){
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return new Integer[0];
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                        set.add(a[i]);
                }
            }
        }
        return set.toArray(new Integer[set.size()]);
    }


}
