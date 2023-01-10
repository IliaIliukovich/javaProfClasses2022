package lesson20221222.dynamicarrays;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray implements Iterable<Integer>{

    private int[] array;
    private int size;
    private int count;

    DynamicArray(){
        array = new int[1];
        size = 1;
        count = 0;
    }

    DynamicArray(int capacity){
        array = new int[capacity];
        size = capacity;
        count = 0;
    }

    public void add(int input){
        if (count >= size){
            growSize();
        }
        array[count++] = input;
    }

    private void growSize() {
        int[] newArray = new int[size*2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        size = array.length;
    }

    public void growSize(int capacity) {
        int[] newArray = new int[capacity];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        size = array.length;
    }

    public void addAt(int index, int element){
        if (index >= size - 1){
            growSize(index + 1);
            array[index] = element;
            count = index +1;
        } else {
            for (int i = count; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = element;
            count++;
        }
    }

    public void remove() {
        if (count > 0) {
//            array[count - 1] = 0;
            count--;
        }
    }

    public void removeAt(int index) {
        if (index < count) {
            for (int i = index; i < count - 1; i++) {
                array[i] = array[i + 1];
            }
//            array[count - 1] = 0;
            count--;
        }
    }

    public void shrinkSize(){
        if (count < size){
            int[] newArray = new int[count];
            for (int i = 0; i < count; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            size = count;
        }
    }

    @Override
    public String toString() {

        String out = "[";
        for (int i = 0; i < count; i++) {
            out = out + " " + array[i];
        }
        out = out + "]";
        return out;
    }

    public void set(int index, int element){
        if (index >= count - 1) {
            addAt(index, element);
        } else {
            array[index] = element;
        }
    }

    public int get(int index){
        if (index >= count - 1) throw new ArrayIndexOutOfBoundsException();
        return array[index];
    }

    public void clear(){
        count = 0;
    }


    public static void main(String[] args) {

//        DynamicArray<String> dynamicArray = new DynamicArray<>();
//        DynamicArray<Object> objectDynamicArray = new DynamicArray<>();
        DynamicArray dynamicArray = new DynamicArray();
        System.out.println(Arrays.toString(dynamicArray.array));
        dynamicArray.add(1);
        System.out.println(Arrays.toString(dynamicArray.array));
        dynamicArray.add(2);
        System.out.println(Arrays.toString(dynamicArray.array));
        dynamicArray.add(3);
        System.out.println(Arrays.toString(dynamicArray.array));
        dynamicArray.add(4);
        System.out.println(Arrays.toString(dynamicArray.array));
        dynamicArray.add(5);
        System.out.println(Arrays.toString(dynamicArray.array));

        dynamicArray.addAt(5, 6);
        System.out.println(Arrays.toString(dynamicArray.array));
        System.out.println(dynamicArray.size);
        System.out.println(dynamicArray.count);

        dynamicArray.remove();
        System.out.println(Arrays.toString(dynamicArray.array));
        System.out.println(dynamicArray.size);
        System.out.println(dynamicArray.count);

        dynamicArray.removeAt(0);
        System.out.println(Arrays.toString(dynamicArray.array));
        System.out.println(dynamicArray);

        dynamicArray.remove();
        System.out.println(dynamicArray);
        System.out.println(Arrays.toString(dynamicArray.array));
        dynamicArray.shrinkSize();
        System.out.println(dynamicArray);
        System.out.println(Arrays.toString(dynamicArray.array));

        dynamicArray.set(0, 10);
        System.out.println(dynamicArray);
        dynamicArray.set(10, 10);
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.get(0));
        dynamicArray.clear();
        System.out.println(dynamicArray);
        System.out.println(Arrays.toString(dynamicArray.array));

    }

    public boolean contains(int data) { // todo
        return false;
    }

    public boolean isEmpty() { // todo
        return false;
    }

    @Override
    public Iterator<Integer> iterator() { // todo
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
    }
}
