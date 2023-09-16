package lesson20230914;

import java.util.HashMap;

public class HomeTask1 {

/*
Первый элемент, встречающийся k раз в массиве
 */

    public static void main(String[] args) {
        int[] arr = new int[] {1,7,4,3,4,8,7, 7};
        int k = 3; // сколько раз встречается
        System.out.println("Answer is: number " + firstElement(arr, k));
        System.out.println("Answer is: number " + firstElementMoreEffective(arr, k));
    }

    // временная сложность O(n^2), т.к. цикл в цикле
    public static int firstElement(int[] arr, int k) {
        for (int j : arr) {
            // Count how many times selected element occurs
            int count = 0;

            for (int value : arr) {
                if (j == value) count++;
            }

            if (count == k) return j;
        }
        return -1;
    }

    // Временная сложность: O(n)
    // Вспомогательное пространство: O(n), потому что мы используем вспомогательный массив размера n для хранения
    // счетчика
    public static int firstElementMoreEffective(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            int a = 0;
            if (map.get(j) != null) a = map.get(j);
            map.put(j, a + 1);
        }

        for (int j : arr) {
            if (map.get(j) == k) return j;
        }
        return -1;
    }

}
