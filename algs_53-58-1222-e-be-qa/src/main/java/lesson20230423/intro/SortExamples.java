package lesson20230423.intro;

import java.util.Arrays;
import java.util.Random;

public class SortExamples {

    public static void main(String[] args) {

//        int[] ints1 = new int[]{1, 4, 5, 1, 2, 4, 7, 0, 2, 3};

        int n = 100_000;
        int[] ints1 = new int[n];
        fillWithRandomInts(ints1);

        long start = System.nanoTime();
        sortBruteForce(ints1);
        long end = System.nanoTime();
        System.out.println("BruteForce alg time elapsed: " + (end - start));
//        System.out.println(Arrays.toString(ints1));

        int[] ints2 = new int[n];
        fillWithRandomInts(ints2);

        start = System.nanoTime();
        Arrays.sort(ints2);
        end = System.nanoTime();
        System.out.println("Arrays.sort() alg time elapsed: " + (end - start));
    }

    private static void fillWithRandomInts(int[] ints) {
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(100);
        }
    }

    private static void sortBruteForce(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]){
                    int tmp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = tmp;
                }
            }
        }
    }


}
