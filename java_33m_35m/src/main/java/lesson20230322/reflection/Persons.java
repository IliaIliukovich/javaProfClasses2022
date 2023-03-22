package lesson20230322.reflection;

import java.lang.reflect.Field;

public class Persons {

    // пример использования самописной аннотации  @MyName для инициализации полей в класе


    @MyName(value = "Tom", count = 5)
    private String name1;

    @MyName(value = "Peter", count = 6)
    private String name2;

    @MyName(count = 1)
    private String name3;




    public static void main(String[] args) throws Exception{
        Persons persons = new Persons();

        System.out.println(persons.name1);
        System.out.println(persons.name2);
        System.out.println(persons.name3);

        Injector.inject(persons);

        System.out.println(persons.name1);
        System.out.println(persons.name2);
        System.out.println(persons.name3);

        Class<? extends Persons> clazz = persons.getClass();
        Field field1 = clazz.getDeclaredField("name1");
        MyName annotation = field1.getAnnotation(MyName.class);
        System.out.println(annotation);
        System.out.println(annotation.value());
        System.out.println(annotation.count());
    }


    static class Injector {
        public static void inject(Object instance) {
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(MyName.class)) {
                    MyName annotation = field.getAnnotation(MyName.class);
                    field.setAccessible(true); // should work on private fields
                    try {
                        field.set(instance, annotation.value());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



}
