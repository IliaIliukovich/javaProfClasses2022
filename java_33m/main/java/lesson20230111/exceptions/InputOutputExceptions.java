package lesson20230111.exceptions;

import java.io.*;
import java.util.Scanner;

public class InputOutputExceptions {

    public static void main(String[] args) {

        readFromFile();

        readFromFileWithScanner();
    }

    private static void readFromFile() {
        try {
            FileReader fileReader = new FileReader("java_33m/main/resources/data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(line);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFileWithScanner() {
        try (Scanner scanner = new Scanner(new File("java_33m/main/resources/data.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
