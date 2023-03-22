package lesson20230322.reflection;

import java.util.Arrays;

public class ReflectionExamples {

    public static void main(String[] args) {

        String s = "Some string";
        System.out.println(s);
        Class<? extends String> stringClass = s.getClass();
        System.out.println(stringClass.getSimpleName());
        System.out.println(stringClass.getName());
        System.out.println(stringClass.getCanonicalName());

        Class<Integer> integerClass = int.class;
        Class<Void> voidClass = void.class;

        int[] ints = new int[]{1, 2, 3};
        Class<? extends int[]> intsClass = ints.getClass();
        System.out.println(intsClass.getSimpleName());
        System.out.println(intsClass.getName());
        System.out.println(intsClass.getCanonicalName());

        System.out.println(Arrays.toString(stringClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(stringClass.getDeclaredFields()));
        System.out.println(Arrays.toString(stringClass.getDeclaredMethods()));
    }



}
