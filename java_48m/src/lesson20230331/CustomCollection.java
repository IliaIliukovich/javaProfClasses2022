package lesson20230331;

import java.util.Iterator;
import java.util.ListIterator;

public class CustomCollection implements Iterable<Integer>{
//public class CustomCollection implements ListIterator<Integer> {

    private int[] data;

    public CustomCollection(int[] data) {
        this.data = data;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int current = 0;
            @Override
            public boolean hasNext() {
                return current < data.length;
            }

            @Override
            public Integer next() {
                return data[current++];
            }
        };
    }
}
