package lesson20221209.arrays;

import java.util.Scanner;


//Сделать программу, которая будет складывать или вычитать введенные числа многократно,
// пока не будет дана команда на выход из цикл
public class Task2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Program to sum values");

        System.out.println("Please enter integer to sum. Press q to finish");

        int sum = 0;
        while(true){
            String nextLine = scanner.nextLine();
            String q = "q";
            if (q.equals(nextLine)) break;
            sum = sum + Integer.parseInt(nextLine);
            System.out.println("Sum = " + sum);
            System.out.println("Please enter integer to sum. Press q to finish");
        }


    }

}
