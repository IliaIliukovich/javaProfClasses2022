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

    }


}
