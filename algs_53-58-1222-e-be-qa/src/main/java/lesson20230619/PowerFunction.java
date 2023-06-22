package lesson20230619;

public class PowerFunction {


    public static void main(String[] args) {
        System.out.println(power(2, 0));
        System.out.println(power(2, 1));
        System.out.println(power(2, 5));
        System.out.println(power(2, 10));
    }

    private static int power(int x, int n) {
        if (n == 0) return 1;
        if (n % 2 == 0) {
            int temp = power(x, n / 2);
            return temp * temp;
        } else {
            return x * power(x, n - 1);
        }
    }


}
