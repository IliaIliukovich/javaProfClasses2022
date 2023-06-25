package lesson20230623;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentCollectionExamples {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        List<String> synchronizedList = Collections.synchronizedList(list);

        synchronized (synchronizedList) {
            for (String e : synchronizedList) {
                System.out.println(e);
            }
        }

        ConcurrentLinkedDeque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

    }



}
