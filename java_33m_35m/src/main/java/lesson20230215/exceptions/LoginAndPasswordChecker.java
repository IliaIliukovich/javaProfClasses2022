package lesson20230215.exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginAndPasswordChecker {
    /*
   Exceptions. Проверка логина и пароля
   Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
   Login должен содержать только латинские буквы, цифры и знак подчеркивания.
   Длина login должна быть меньше 20 символов.
   Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
   Password должен содержать только латинские буквы, цифры и знак подчеркивания.
   Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.
   Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
   WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию,
   второй принимает сообщение исключения и передает его в конструктор класса Exception.
   Обработка исключений проводится внутри метода.
   Используем multi-catch block. Метод возвращает true, если значения верны или false в другом случае.
    */
    private static final Pattern LOGIN_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{1,19}$");
    private static final Pattern PASS_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{1,19}$");

    public boolean checkLoginAndPassword(String login, String password, String confirmPassword) {
        try {
            Matcher loginMatcher = LOGIN_PATTERN.matcher(login);
            Matcher passMatcher = PASS_PATTERN.matcher(password);

            if (!confirmPassword.equals(password)) {
                throw new WrongPasswordException("Password does not match confirmPassword");
            }

            if (!passMatcher.matches()) {
                throw new WrongPasswordException("Password does not match the requirements");
            }

            if (!loginMatcher.matches()) {
                throw new WrongLoginException("Login does not match the requirements");
            }

            System.out.println("Login and Password are correct");
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }
}
