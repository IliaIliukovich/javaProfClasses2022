package lesson20221209.arrays;

public class TaskPow {

//    Создать метод для возведения в степень числа и *извлечения корня 3 степени из числа.
    public static void main(String[] args) {

        double z = powerMethod(3, 4);
        double sqrt = sqrt3Method(3);
        double sqrt2 = sqrt3Method(4);
        double sqrt3 = sqrt3Method(27);
        double sqrt4 = sqrt3Method(81);

        System.out.println("Input: z = " + z);
        System.out.println("Input: sqrt = " + sqrt);
        System.out.println("Input: sqrt = " + sqrt2);
        System.out.println("Input: sqrt = " + sqrt3);
        System.out.println("Input: sqrt = " + sqrt4);

    }

    private static double sqrt3Method(int x) {
        double z = 1.0/3.0;
        return Math.pow(x, z);
    }

    private static double powerMethod(int x, int y) {

        return Math.pow(x, y);

    }

}
