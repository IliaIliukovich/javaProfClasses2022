package lesson20230213.reflection;

import lesson20230208.basicprinciples.openclosedprinciple.BMW;
import lesson20230208.basicprinciples.openclosedprinciple.BMW2;
import lesson20230208.basicprinciples.openclosedprinciple.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionExamples {

    public static void main(String[] args) {
        Class<Integer> integerClass = int.class;
        Class<Void> voidClass = void.class;
        Integer t = 12;
        Class<? extends Integer> tClass = t.getClass();

        String s = "Some text";

        Class<? extends String> sClass = s.getClass();
        System.out.println(sClass.getSimpleName());
        System.out.println(sClass.getName());
        System.out.println(sClass.getCanonicalName());

        int[] ints = {1, 2, 3};
        Class<? extends int[]> intsClass = ints.getClass();
        System.out.println(intsClass.getSimpleName());
        System.out.println(intsClass.getName());
        System.out.println(intsClass.getCanonicalName());

        BMW car = new BMW2();
        Class<? extends Car> carClass = car.getClass();
        System.out.println(carClass.getSimpleName());
        System.out.println(carClass.getName());
        System.out.println(carClass.getCanonicalName());

        List<String> list = new ArrayList<>();
        Class<? extends List> listClass = list.getClass();
        System.out.println(listClass.getName());
        System.out.println(Arrays.toString(listClass.getMethods()));
        System.out.println(Arrays.toString(listClass.getDeclaredFields()));
        System.out.println(Arrays.toString(listClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(listClass.getInterfaces()));
    }




}
