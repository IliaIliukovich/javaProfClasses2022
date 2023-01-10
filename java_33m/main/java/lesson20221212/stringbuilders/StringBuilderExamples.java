package lesson20221212.stringbuilders;

public class StringBuilderExamples {

    public static void main(String[] args) {

        String str1 = "Hello World!";
        String str2 = "Hello World!";
        String str3 = new String("Hello World!");

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str3.intern());
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));

        String str4 = "Hello" + " World!";
        System.out.println(str1 == str4);

        StringBuilder builder = new StringBuilder("Hello World!");
        StringBuilder builder2 = new StringBuilder(20);
        builder.append(" Second part");
        builder.append('o');
//        builder.toString();
        System.out.println(builder);

        // Пример типичноного использования StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            // some code to generate string
            stringBuilder.append("info ");
        }
        stringBuilder.trimToSize();
        // some other code
        System.out.println(stringBuilder.toString());

    }


}
