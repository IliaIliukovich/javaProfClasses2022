package lesson20230119.stacksandqueues;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExamples {


    public static void main(String[] args) {

        Queue<String> queue = new PriorityQueue<>(Comparator.comparingInt(String::length));
        Queue<String> queue2 = new PriorityQueue<>();

        queue.add("One");
        queue.add("Two");
        queue.add("Three");
        queue.add("Four");
        queue.add("Five");

        queue2.add("One");
        queue2.add("Two");
        queue2.add("Three");
        queue2.add("Four");
        queue2.add("Five");

        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue);

        System.out.println(queue2);
        System.out.println(queue2.remove());
        System.out.println(queue2.remove());
        System.out.println(queue2);

        queue.forEach(System.out::println);

    }


}
