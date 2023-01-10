package lesson20221205.inputoutput;

import java.io.*;
import java.util.Arrays;

public class FileExamples {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        //в нужной папке
        File file2 = new File("./resources/input.txt");

        System.out.println(file.exists()); // файл существует?
        System.out.println(file2.exists()); // файл существует?
        System.out.println(file.createNewFile()); // файл создался?
        System.out.println(file2.createNewFile()); // файл создался?
        System.out.println(file.exists()); // файл существует?
        System.out.println(file2.exists()); // файл существует?

        FileOutputStream out = new FileOutputStream("./resources/input.txt"); // Запись в файл
        Writer writer = new OutputStreamWriter(out);
        writer.write("This is text in file");
        writer.close();
        System.out.println("\nsuccess...");

        InputStream input = new FileInputStream(file2); // чтение из InputStream
        int data = input.read();
        while(data != -1) {
            System.out.print((char) data);
            data = input.read();
        }
        input.close();
        System.out.println();

//        Чтение с помощью Reader. InputStreamReader — считывает байты и декодирует в символы
        InputStream stream = new FileInputStream(file2);
        Reader reader = new InputStreamReader(stream);
        int data2 = reader.read();
        while (data2 != -1) {
            System.out.print((char) data2);
            data2 = reader.read();
        }
        System.out.println();

        File newdir = new File("./resources/newdir");
        boolean wasCreated = newdir.mkdir();
        System.out.println("newdir created " + wasCreated);
        long length = newdir.length();
        System.out.println(length);
        boolean success = newdir.delete();
        System.out.println(success);

        File newdir2 = new File("./resources/newdir2");
        newdir2.mkdir();
        File newFile1 = new File("./resources/newdir2/newFile1.txt");
        File newFile2 = new File("./resources/newdir2/newFile2.txt");
        newFile1.createNewFile();
        newFile2.createNewFile();
        String[] fileNames = newdir2.list();
        System.out.println(Arrays.toString(fileNames));
        File[] files = newdir2.listFiles();
        System.out.println(Arrays.toString(files));

    }
}
