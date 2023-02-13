package lesson20230213.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UseSpecialClass {

    public static void main(String[] args) throws Exception{
        SpecialClass specialClass = new SpecialClass("Some important info");
        specialClass.method1();
        specialClass.method2(777);
        System.out.println(specialClass.getField());

        Class<? extends SpecialClass> clazz = specialClass.getClass();
        Arrays.asList(clazz.getDeclaredMethods()).forEach(System.out::println);
        Method method1 = clazz.getMethod("method1");
        method1.invoke(specialClass);

        Method method2 = clazz.getMethod("method2", int.class);
        method2.invoke(specialClass, 888);

        Method method3 = clazz.getDeclaredMethod("method3");
        method3.setAccessible(true);
        method3.invoke(specialClass);

        Field field = clazz.getDeclaredField("field");
        field.setAccessible(true);
        field.set(specialClass, "New value");

        System.out.println(specialClass.getField());

        Class<?> newClazz = Class.forName("lesson20230213.reflection.SpecialClass");
        System.out.println(newClazz.getName());

//        SpecialClass newSpecialClass = (SpecialClass) newClazz.newInstance();
        Constructor<?> newClazzConstructor = newClazz.getConstructor();
        SpecialClass newSpecialClass = (SpecialClass) newClazzConstructor.newInstance();
        System.out.println(newSpecialClass.getField());
        Constructor<?> newClazzConstructor2 = newClazz.getConstructor(String.class);
        SpecialClass newSpecialClass2 = (SpecialClass) newClazzConstructor2.newInstance("Hello!");
        System.out.println(newSpecialClass2.getField());
        System.out.println(newClazz.getClassLoader());

    }


}
