package lesson05122022.inputoutput;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class InputExamples {

    public static void main(String[] args) throws IOException {

        // Scanner принимает форматированный объект и преобразует его
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter n ");
        int n = scanner.nextInt();
        System.out.println("Please enter k");
        int k = scanner.nextInt();
        System.out.println("n + k = " + (n + k));

        Random random = new Random();
        int randomInt = random.nextInt(10);
        System.out.println("randomInt = " + randomInt);

//        BufferedReader читает текст из потока ввода символов, буферизуя прочитанные символы,
//        чтобы обеспечить эффективное считывание символов, массивов и строк
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        System.out.println("Please enter integer ");
        x = Integer.parseInt(br.readLine());
        System.out.println(x);


//        System.err: стандартный поток ошибок
            System.out.println("simple message");
            System.err.println("error message");

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);

            System.out.println("Enter characters, and '0' to quit.");
            char c;
            do {
                c = (char)inputStreamReader.read();
                System.err.println(c);
            } while (c != '0');

    }
}
