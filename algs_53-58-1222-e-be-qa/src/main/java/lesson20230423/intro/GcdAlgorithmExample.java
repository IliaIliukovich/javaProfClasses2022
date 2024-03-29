package lesson20230423.intro;

public class GcdAlgorithmExample {

    public static void main(String[] args) {

        // search of greatest common divisor of (a, b)

        int a = 1_000_000;
        int b = 17_000;

        // Euclidean algorithm
        // Формула НОД: НОД (a, b) = НОД (b, с), где с — остаток от деления a на b.
        //1 Большее число поделить на меньшее.
        //2 Меньшее число поделить на остаток, который получается после деления.
        //3 Первый остаток поделить на второй остаток.
        //4 Второй остаток поделить на третий и т. д.
        //5 Деление продолжается до тех пор, пока в остатке не получится нуль. Последний делитель и есть наибольший общий делитель.
        //
        // НОД(28, 12)
        //1. 28 / 12 -> ост. 4
        //2. 12 / 4 -> ост. 0
        // итого НОД(28, 12) = 4


        long start = System.nanoTime();
        int result = greatestCommonDivisorEuclidean(a, b);
        long end = System.nanoTime();
        System.out.println("Euclidean algorithm time = " + (end - start));
        System.out.println("Result = " + result);

        // Brute force solution
        start = System.nanoTime();
        result = bruteForceAlgorithm(a, b);
        end = System.nanoTime();
        System.out.println("Brute force algorithm time = " + (end - start));
        System.out.println("Result = " + result);
    }

    public static int greatestCommonDivisorEuclidean(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
//        System.out.println(a);
        return a;
    }

    public static int bruteForceAlgorithm(int a, int b){
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0){
//                System.out.println(i);
                return i;
            }
        }
        return 1;
    }

}
