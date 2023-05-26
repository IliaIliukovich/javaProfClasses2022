package lesson20230519;

import java.io.*;
import java.util.Scanner;

public class ReadWriteFileExample {

    public static void main(String[] args) {

        File dir = new File("java_48m/resources/newDir");
        dir.mkdir();

        File file = new File("java_48m/resources/text.txt");

//        BufferedReader bufferedReader = null;
//        try {
//            FileReader reader = new FileReader(file);
//            bufferedReader = new BufferedReader(reader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null){
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (bufferedReader != null){
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        try (FileReader reader2 = new FileReader(file);
             BufferedReader bufferedReader2 = new BufferedReader(reader2)){
            String line;
            while ((line = bufferedReader2.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please, enter text...");
            System.out.println("Input text: " + scanner.nextLine());
        }

//        FileOutputStream fileOutputStream = new FileOutputStream("java_48m/resources/text.txt");
        try (FileWriter writer = new FileWriter("java_48m/resources/text.txt", true)) {
            writer.append("Added to the EOF");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}