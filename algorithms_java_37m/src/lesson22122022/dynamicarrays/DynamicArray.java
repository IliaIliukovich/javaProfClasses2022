package lesson22122022.dynamicarrays;

import java.util.Arrays;

public class DynamicArray {

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

    private void growSize(int capacity) {
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

    public static void main(String[] args) {

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

//        dynamicArray.addAt(2, 10);
//        System.out.println(Arrays.toString(dynamicArray.array));

        dynamicArray.addAt(10, 10);
        System.out.println(Arrays.toString(dynamicArray.array));
        System.out.println(dynamicArray.size);
        System.out.println(dynamicArray.count);


    }


}
