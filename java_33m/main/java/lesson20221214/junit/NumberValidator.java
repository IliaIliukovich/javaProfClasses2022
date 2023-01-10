package lesson20221214.junit;

import java.util.regex.Pattern;

public class NumberValidator {
//    Решение задачи:
//    Написать метод проверки номера банковского счета public boolean isValidAccountNumber(String accountNumber)
//    и тесты проверки корректной работы метода
//    - БС может содержать только 14 цифр
//    - Все 14 цифр не могут быть нулями
//    - Номер счета не может быть нулевым или пустым.
//    Задачу выполнить способом test-driven development, TDD (сначала написать тесты на метод, после чего напиcать сам метод).

    public boolean isValidAccountNumber(String accountNumber) {

        if (accountNumber == null || accountNumber.length() != 14) return false;

        int numberOfZero = 0;
        for (int i = 0; i < accountNumber.length(); i++) {
            if (!Character.isDigit(accountNumber.charAt(i))) return false;
            if (Character.getNumericValue(accountNumber.charAt(i)) == 0) {
                numberOfZero++;
            }
        }
        return numberOfZero != 14;
    }

    public boolean regexIsValidAccountNumber(String accountNumber) {
        if (accountNumber == null) return false;
        return Pattern.matches("(?![0]{14})([\\d]{14})", accountNumber);
    }

}
