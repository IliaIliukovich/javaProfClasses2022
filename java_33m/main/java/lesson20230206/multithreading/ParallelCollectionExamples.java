package lesson20230206.multithreading;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ParallelCollectionExamples {

    public static void main(String[] args) {

    //  ArrayList <-> Vector

        List<String> list = Arrays.asList("One", "Two", "Three");
        List<String> synchronizedList = Collections.synchronizedList(list);

        synchronized (synchronizedList) {
            String s = synchronizedList.get(0);
            String newS = s + s;
            synchronizedList.add(newS);
        }

        // см. примеры применения https://java-online.ru/concurrent-collections.xhtml
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();




    }


}
