package lesson05122022.inputoutput;

import java.io.PrintStream;
import java.util.Date;

public class OutputExamples {

    public static void main(String[] args) {
        System.err.println("1");
        System.out.println("2");
        System.out.println("3");
        System.err.println("4"); // порядок вывода потока err и out в консоль не определен

        PrintStream out = System.out;
        out.print("One ");
        out.print("Two ");
        out.print("Three ");
        out.println();
        out.println("Line 1");
        out.println("Line 2");
        out.println("Line 3");

// В таких случаях необходимо использовать BigDecimal!
        double myMoney = 0.2;
        System.out.println("Sum = " + myMoney * 100);
        for (int i = 1; i < 100; i++) {
            myMoney+=0.2;
        }
        System.out.println("Sum = " + myMoney);

//        printf
        double x = 1.0 / 3.0;
        out.println(x);
        out.printf("%2.2f%n", x);
        out.printf("%e\n", x);
        System.out.println(String.format("%6.3e",223.45654543434)); // альтернатива printf

//%a Шестнадцатеричное значение с плавающей точкой
//%b Логическое (булево) значение аргумента
//%c Символьное представление аргумента
//%d Десятичное целое значение аргумента
//%e Экспоненциальное представление аргумента
//%f Десятичное значение с плавающей точкой
//%o Восьмеричное целое значение аргумента
//%n Вставка символа новой строки
//%s Строковое представление аргумента
//%t Время и дата
//%x Шестнадцатеричное целое значение аргумента

        System.out.printf("one%ntwo%nthree%n");
        System.out.printf("%b%n", null);
        System.out.printf("%B%n", false);
        System.out.printf("%B%n", 2);
        System.out.printf("%b%n", "text");
        System.out.printf("%2.4s%n", "Hi guys!");
        System.out.printf("%c%n", 'a');
        System.out.printf("%C%n", 'a');

        int z = 100;
        System.out.printf("Printing simple integer: x = %d\n", z);
        System.out.printf("Formatted with precision: PI = %.2f\n", Math.PI);

        float y = 3.14f;
        System.out.printf("Formatted to specific width: n = %.6f\n", y);

        y = 1234567.3f;
        System.out.printf("Formatted to right margin: n = %50.4f\n", y);

        Date date = new Date();
        System.out.printf("%tT%n", date); // Символы H, M, S отвечают за часы, минуты и секунды

        System.out.printf("hours %tH: minutes %tM: seconds %tS%n", date, date, date);

    }
}
