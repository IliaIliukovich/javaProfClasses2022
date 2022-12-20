package lesson19122022.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {

    public static void main(String[] args) {

        String text = "Test";
        String reg = "Tes.";

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(text);

        System.out.println(matcher.matches());
        System.out.println(Pattern.matches(reg, text));

        System.out.println(Pattern.matches(".", "t")); // любой отдельный символ, кроме новой строки
        System.out.println(Pattern.matches("[ptk]", "i")); // p или t или k
        System.out.println(Pattern.matches("[^ptk]", "i")); // все, кроме p, t, k
        System.out.println(Pattern.matches("[ptk][^ptk]", "pi"));
        System.out.println(Pattern.matches("[ptk][^ptk]", "p1"));
        System.out.println(Pattern.matches("[a-d]", "e")); // все символы от a до d
        System.out.println(Pattern.matches("[a-h&&[c-z]]", "d")); // пересечение множеств
        System.out.println(Pattern.matches("[0-9]", "1"));
        System.out.println(Pattern.matches("\\d", "1")); // [0-9]
        System.out.println(Pattern.matches("\\D", "q")); // не [0-9]

        System.out.println("Quantifiers - ? * + {}");
        System.out.println(Pattern.matches("[\\d]?", "")); // один раз или ни разу
        System.out.println(Pattern.matches("[\\d]*", "")); // ноль или более раз
        System.out.println(Pattern.matches("[\\d]+", "12344")); // один или более раз
        System.out.println(Pattern.matches("[w]{3}", "www"));
        System.out.println(Pattern.matches("[w]{3}[\\w]+", "www123googlecom"));
        System.out.println(Pattern.matches("[w]{3}[.][\\w]+[.][\\w]+", "www.google.com"));

        // F1-F12
        String fRegex = "[F](([1][0-2])|[1-9])";
        System.out.println(Pattern.matches(fRegex, "F1"));
        System.out.println(Pattern.matches(fRegex, "F12"));
        System.out.println(Pattern.matches(fRegex, "F31"));

        String text2 = "This 2is some 22 text123";
        Pattern pattern2 = Pattern.compile("[\\d]{2}");
        Matcher matcher2 = pattern2.matcher(text2);

        while (matcher2.find()) {
            System.out.println(matcher2.group());
            System.out.println("Match starts at " + matcher2.start() + " and ends at " + matcher2.end());
        }

        // \b - cоответствует границам слов
        String REGEX = "\\bcat\\b";
        Pattern pattern4 = Pattern.compile(REGEX);
        Matcher matcher4 = pattern4.matcher("cat catty cat!cat ");

        while (matcher4.find()) {
            System.out.println(matcher4.group());
            System.out.println("Match starts at " + matcher4.start() + " and ends at " + matcher4.end());
        }

        // Методы replaceFirst и replaceAll
        String input = "The dog says meow. " + "All dogs say meow.";
        Pattern p = Pattern.compile("dog");
        Matcher m = p.matcher(input);
        System.out.println(m.replaceAll("cat"));

    //Проверка IP-адреса с помощью регулярных выражений
    //IP-адрес представляет собой строку в виде «A.B.C.D», где значение A, B, C и D может варьироваться от 0 до 255.
    //Допускаются начальные нули. Длина A, B, C или D не может быть больше 3.
    //
    // ReGex to numbers from 0 to 255
    //zeroTo255 -> (\\d{1, 2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])
    //
    //\d представляет цифры в регулярных выражениях, как [0–9]
    //\\d{1, 2} перехватывает любое однозначное или двузначное число
    //(0|1)\\d{2} перехватывает любое трехзначное число, начинающееся с 0 или 1.
    //2[0-4]\\d улавливает числа от 200 до 249.
    //25[0-5] ловит числа от 250 до 255.

        String ip1 = "000.14.22.134";
        System.out.println(ip1 + " is valid: " + isValidIPAddress(ip1));
        String ip2 = "0.0.0.0";
        System.out.println(ip2 + " is valid: " + isValidIPAddress(ip2));
        String ip3 = "00.1.23.23.23";
        System.out.println(ip3 + " is valid: " + isValidIPAddress(ip3));
        String ip4 = "i.am.not.ip";
        System.out.println(ip4 + " is valid: " + isValidIPAddress(ip4));
    }

    public static boolean isValidIPAddress(String ip) {
        if (ip == null) return false;

        // Regex for digit from 0 to 255.
        String zeroTo255
                = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";

        String regex = zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255;

        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(ip);

        return m.matches();
    }

}
