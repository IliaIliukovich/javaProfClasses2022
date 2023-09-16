package lesson20230914;

import java.util.Arrays;
import java.util.HashMap;

public class HomeTask2 {

/*
3. Проверьте, равны ли два массива или нет
Учитывая два массива, arr1 и arr2 одинаковой длины N, задача состоит в том, чтобы определить, равны ли данные массивы
или нет.

Два массива называются равными, если:
оба они содержат один и тот же набор элементов,
расположение (или перестановки) элементов может/не может быть одинаковым.
Если есть повторения, то количество повторяющихся элементов также должно быть одинаковым, чтобы два массива были равны.

Ввод: arr1[] = {1, 2, 5, 4, 0}, arr2[] = {2, 4, 5, 0, 1}
Вывод: Да
 */

    public static void main(String[] args) {
        int[] a = new int[] {1,2,5,4,0};
        int[] b = new int[] {2,4,5,0,1};

        System.out.println(areEqual(a, b));
        System.out.println(areEqualMoreEffectively(a, b));
    }

    /* Временная сложность: O(N*log(N))
    Вспомогательное пространство: O(1) */
    public static boolean areEqual(int[] arr1, int[] arr2) {
        // if length of arrays are not equal
        if (arr1.length != arr2.length) return false;

        // sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // linearly compare elements
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        // otherwise
        return true;
    }

    /*
    Сначала проверьте, не равна ли длина arr1 длине arr2, затем верните false.
    Затем перейдите по первому массиву и сохраните количество каждого элемента в хэш-карте.
    Затем перейдите ко второму массиву и уменьшите количество его элементов в хэш-карте. Если этот элемент
    отсутствует или количество этого элемента равно нулю в хэш-карте, верните false, иначе уменьшите количество
    этого элемента.
    Верните true в конце, так как оба массива на данный момент равны.
     */

    /*
    Временная сложность: O(N)
    Вспомогательное пространство: O(N)
     */
    public static boolean areEqualMoreEffectively(int[] arr1, int[] arr2) {
        // if length of arrays are not equal
        if (arr1.length != arr2.length) return false;

        // Store arr1[] elements and their counts in hash map
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int j : arr1) {
            if (map.get(j) == null) map.put(j, 1);
            else {
                count = map.get(j);
                count++;
                map.put(j, count);
            }
        }

        // Traverse arr2[] elements and check if all elements of arr2[] are present same number of times or not.
        for (int j : arr2) {
            if (!map.containsKey(j)) return false;

            if (map.get(j) == 0) return false;

            count = map.get(j);
            --count;
            map.put(j, count);
        }
        return true;
    }

}
