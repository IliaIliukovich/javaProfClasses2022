package lesson20230515;

import java.util.Arrays;

public class CustomDynamicArray {

    private int[] array;

    private int size;

    private int count;

    public CustomDynamicArray() {
        array = new int[1];
        size = 1;
        count = 0;
    }

    public CustomDynamicArray(int capacity){
        array = new int[capacity];
        size = capacity;
        count = 0;
    }

    public void add(int data){
        if (count >= size){
            growSize();
        }
        array[count++] = data;
    }

    public void set(int data, int index) {
        if (index >= count) throw new ArrayIndexOutOfBoundsException();
        array[index] = data;
    }

    public void addAt(int data, int index){
        if (index >= count) throw new ArrayIndexOutOfBoundsException();
        if (count >= size) {
            growSize();
        }
        for (int i = count - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = data;
        count++;
    }



    private void growSize() {
        int[] newArray = new int[size * 2];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        size = newArray.length;
    }


    public static void main(String[] args) {
        CustomDynamicArray dynamicArray = new CustomDynamicArray();
        dynamicArray.printInnerStructure();
        dynamicArray.add(1);
        dynamicArray.printInnerStructure();
        dynamicArray.add(2);
        dynamicArray.printInnerStructure();
        dynamicArray.add(3);
        dynamicArray.printInnerStructure();
        dynamicArray.add(4);
        dynamicArray.printInnerStructure();
        dynamicArray.add(5);
        dynamicArray.printInnerStructure();
        dynamicArray.add(6);
        dynamicArray.printInnerStructure();

        dynamicArray.addAt(100, 0);
        dynamicArray.printInnerStructure();
        dynamicArray.addAt(100, 6);
        dynamicArray.printInnerStructure();
        dynamicArray.addAt(100, 7);
        dynamicArray.printInnerStructure();
        System.out.println(dynamicArray);

    }

    public void printInnerStructure() {
        System.out.println("CustomDynamicArray{" + "array=" + Arrays.toString(array)
                + ", size=" + size + ", count=" + count + '}');
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < count; i++) {
            s = s + " " + array[i];
        }
        return "CustomDynamicArray{" + "array=" + s + ", count=" + count + '}';
    }
}
