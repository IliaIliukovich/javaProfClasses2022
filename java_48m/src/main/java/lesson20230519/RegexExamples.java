package lesson20230519;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {

    public static void main(String[] args) {

//        String regex = "[a-z0-9]+@[a-z]+\\.[a-z]+";
        String regex = "[a-z]+";
        String stringToAnalyse = "tom@gmail.com";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringToAnalyse);

        System.out.println(matcher.find());
        System.out.println(matcher.matches());

        System.out.println(stringToAnalyse.matches(regex));

        while (matcher.find()){
            System.out.print(matcher.start() + " ");
            System.out.print(matcher.end() + "\n");
        }

    }

}
