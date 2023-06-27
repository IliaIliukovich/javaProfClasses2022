package lesson20230626;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SelectionSort {


    private static void selectionSort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int indMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[indMin].compareTo(array[j]) > 0){
                    indMin = j;
                }
            }
            Comparable tmp = array[i];
            array[i] = array[indMin];
            array[indMin] = tmp;
        }
    }

    public static boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void shuffle(Comparable[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int j = random.nextInt(i + 1);
            Comparable tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {23, 23, 18, 20, 1, 4, 7};
        System.out.println("Original array: " + Arrays.toString(ints));

        selectionSort(ints);
        System.out.println(isSorted(ints));
        System.out.println("Sorted array: " + Arrays.toString(ints));

        shuffle(ints);
        System.out.println(isSorted(ints));
        System.out.println("Shuffled array: " + Arrays.toString(ints));

        Student[] students = {
                new Student("Ivan", "Ivanov", 23),
                new Student("Ivan", "Sidorov", 23),
                new Student("Peter", "Sidorov", 23),
                new Student("Tom", "Smiths", 20),
                new Student("Ivan", "Sidorov", 18)
        };

//        Arrays.sort(students, Comparator.comparing(Student::getSurname));
//        Arrays.sort(students);
        selectionSort(students);

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
     }

}
