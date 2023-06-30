package lesson20230630;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionExamples {

    public static void main(String[] args) throws NoSuchFieldException {
        String s = "Some string";
        Class<? extends String> sClass = s.getClass();
        System.out.println(sClass);
        System.out.println(sClass.getCanonicalName());
        System.out.println(sClass.getName());
        System.out.println(sClass.getSimpleName());

        Number n = 10.0;
        System.out.println(n.getClass());

        List<String> list = new ArrayList<>();
        Class<? extends List> listClass = list.getClass();
        System.out.println(listClass);
        System.out.println(Arrays.toString(listClass.getDeclaredFields()));
        System.out.println(Arrays.toString(listClass.getDeclaredMethods()));

        Custom custom = new Custom(10);
        @SuppressWarnings(value = "deprecation")
        int result = custom.process(10);
        System.out.println(result);
//        custom.processInner();

        Class<? extends Custom> customClass = custom.getClass();
        try {
            Method method = customClass.getMethod("process", int.class);
            Integer result2 = (Integer) method.invoke(custom, 50);
            System.out.println(result2);

            Method innerMethod = customClass.getDeclaredMethod("processInner");
            innerMethod.setAccessible(true);
            innerMethod.invoke(custom);

            Field field = customClass.getDeclaredField("value");
            field.setAccessible(true);
            field.set(custom, 100);
            innerMethod.invoke(custom);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Class<?> clazz = Class.forName("lesson20230630.Custom");
            Constructor<?> clazzConstructor = clazz.getConstructor(int.class);
            Custom custom2 = (Custom) clazzConstructor.newInstance(50);
            System.out.println(custom2.process(100));
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }

    }



}
