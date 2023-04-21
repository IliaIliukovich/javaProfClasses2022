package lesson20230421;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {

        PriorityQueue<String> names = new PriorityQueue<>((o1, o2) -> {
            int v = o1.length() - o2.length();
            if (v == 0) {
                return o1.compareTo(o2);
            }
            return v;
        });

        names.add("Tom");
        names.add("Martin");
        names.add("Jenny");
        names.add("Bob");


        System.out.println(names.poll());
        System.out.println(names.poll());
        System.out.println(names.poll());
        System.out.println(names.poll());
//        System.out.println(names.remove());

    }



}
