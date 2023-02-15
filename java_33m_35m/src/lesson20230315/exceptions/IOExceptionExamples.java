package lesson20230315.exceptions;

import java.io.*;

public class IOExceptionExamples {

    public static void main(String[] args) {

        File file1 = new File("./newFile1.txt");

        Writer writer1 = null;
        try {
            writer1 = new FileWriter(file1);
            writer1.write("Some important data");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer1 != null) {
                    writer1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File file2 = new File("./newFile2.txt");

        try (Writer writer2 = new FileWriter(file2)) {
            writer2.write("Some important data2");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
