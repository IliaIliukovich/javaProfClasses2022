package lesson22122022.dynamicarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysExamples {

    public static void main(String[] args) {

        int[] ints = new int[5];
        ints[0] = 1;
        System.out.println(Arrays.toString(ints));
        String[] strings = new String[5];
        System.out.println(Arrays.toString(strings));
//        strings[0].length(); // Exception

//        int s = ints[5]; // Exception

        List<String> arrayList = new ArrayList<>();
//        arrayList.add(1);
        arrayList.add("String");

    }


}
