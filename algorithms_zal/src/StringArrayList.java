import java.util.Arrays;
import java.util.Iterator;

public class StringArrayList implements Iterable<String>{

    private String[] strings;
    //count of stored elements
    private int size;

    public StringArrayList() {
        strings = new String[3];
        size = 0;
    }

    public StringArrayList(int capacity) {
        strings = new String[capacity];
        size = 0;
    }

    public boolean add(String element) {
        if (size > strings.length - 1) {
            String[] tempArray = new String[strings.length];
            System.arraycopy(strings, 0, tempArray, 0, strings.length);
            strings = new String[tempArray.length * 2];
            //this.printElements();
            System.arraycopy(tempArray, 0, strings, 0, tempArray.length);
            //this.printElements();

        }
        strings[size] = element;
        size++;
        return true;

    }

    public void printElements() {
        System.out.println(Arrays.toString(strings));
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int current = 0;
            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public String next() {
                return strings[current++];
            }
        };
    }
}
