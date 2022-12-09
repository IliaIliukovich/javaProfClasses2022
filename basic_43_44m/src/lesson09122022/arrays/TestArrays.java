package lesson09122022.arrays;

public class TestArrays {


//     Создать массивы типа: int, double и создать методы, для их вывода на консоль
    public static void main(String[] args) {

        int[] intArray = new int[10];
        intArray[5] = 6;
        double[] doubleArray = new double[10];
        String[] stringArray = new String[10];

        int i = intArray[7];
        System.out.println(i);
//        String s = stringArray[7];
//        System.out.println(s.length());

//        TestArrays testArrays = new TestArrays();
        printIntArray(intArray);
        printDoubleArray(doubleArray);
        printStringArray(stringArray);
        String s = "a";

        char charFromString = s.charAt(0);
    }


    public static void printIntArray(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.print("\n");
    }

    public static void printDoubleArray(double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            System.out.print(doubles[i] + " ");
        }
        System.out.print("\n");
    }

    public static void printStringArray(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.print("\n");
    }
}
