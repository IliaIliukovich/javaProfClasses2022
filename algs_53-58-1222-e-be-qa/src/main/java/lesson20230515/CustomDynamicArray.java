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
        if (count > size - 1){
            growSize();
        }
        array[count++] = data;
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
        System.out.println(dynamicArray);
        dynamicArray.add(1);
        System.out.println(dynamicArray);
        dynamicArray.add(2);
        System.out.println(dynamicArray);
        dynamicArray.add(3);
        System.out.println(dynamicArray);
        dynamicArray.add(4);
        System.out.println(dynamicArray);
        dynamicArray.add(5);
        System.out.println(dynamicArray);
        dynamicArray.add(6);
        System.out.println(dynamicArray);




    }

    @Override
    public String toString() {
        return "CustomDynamicArray{" + "array=" + Arrays.toString(array) + ", size=" + size + ", count=" + count + '}';
    }
}
