package lesson20230320.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SynchronizedCollectionExamples {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> synchronizedList = Collections.synchronizedList(list);

        // ArrayList -- Vector
        // HashMap -- HashTable

        synchronizedList.add("A");

        synchronized (synchronizedList) {
            String a = synchronizedList.get(0);
            synchronizedList.set(0, a + a);
        }

        // см. примеры применения https://java-online.ru/concurrent-collections.xhtml
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    }



}
