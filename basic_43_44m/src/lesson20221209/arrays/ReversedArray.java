package lesson20221209.arrays;

public class ReversedArray {


//    Задание: перевернуть массив(реверсировать) и вывести из него все значения на нечетных позициях.
    public static void main(String[] args) {

        String[] strings = new String[6];
        strings[0] = "One";
        strings[1] = "Two";
        strings[2] = "Three";
        strings[3] = "Four";
        strings[4] = "Five";
        strings[5] = "Six";

        printArray(strings);
//        printReverseArr(strings);
//        printArray(strings);
        revertArray(strings);
        printOdd(strings);

//        revertArray(strings);
//        printArray(strings);
//        revertArray2(strings);
//        printArray(strings);
    }

    private static void printOdd(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            if (i % 2 == 1) {
                System.out.println(strings[i]);
            }
        }
    }


    private static void revertArray(String[] strings) {
        String tmpString;
        for (int i = 0; i < strings.length / 2; i++) {
            tmpString = strings[i];
            strings[i] = strings[strings.length - 1 - i];
            strings[strings.length - 1 - i] = tmpString;
        }
    }

    private static void revertArray2(String[] strings) {
        String tmpString;
        for (int i = strings.length - 1; i > strings.length / 2; i--) {
            tmpString = strings[i];
            strings[i] = strings[strings.length - 1 - i];
            strings[strings.length - 1 - i] = tmpString;
        }
    }

    private static void printReverseArr(String[] arr) {
        for (int i =  arr.length-1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }


    private static void printArray(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + " ");
        }
        System.out.println();
    }
}
