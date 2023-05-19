package lesson20230519;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadPictureExample {
        static String path = "java_48m/resources/kitten.png";

    public static void main(String[] args) throws IOException {
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        System.out.println("Info about image height from BufferedImage: " + image.getHeight());

        System.out.println("Reading info from binary file:");
        readBinaryFile();
    }


    private static void readBinaryFile() throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(path, "r")) {

            for (int i = 0; i < 8; i++) {
                int uByte = file.readUnsignedByte();
                System.out.println(uByte + " " + Integer.toHexString(uByte) + " " + (char) uByte);
            }

            for (int i = 0; i < 8; i++) {
                int uByte = file.readUnsignedByte();
                System.out.println(uByte + " " + Integer.toHexString(uByte) + " " + (char) uByte);
            }

            System.out.println("Width: " + file.readInt());
            System.out.println("Height: " + file.readInt());
            System.out.println("Bit depth: " + file.readUnsignedByte());
            System.out.println("Colour type: " + file.readUnsignedByte());
            System.out.println("Compression method: " + file.readUnsignedByte());
            System.out.println("Filter method: " + file.readUnsignedByte());
            System.out.println("Interlace method: " + file.readUnsignedByte());
        }
    }

}
