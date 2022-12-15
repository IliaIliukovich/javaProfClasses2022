package lesson14122022.junit;

public class StringBuilderFunctions {


    public String genarateReversedString(String s1, String s2) {
        return new StringBuilder().append(s1).append(s2).reverse().toString();
    }


}
