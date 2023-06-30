package lesson20230630;

import java.lang.reflect.Field;

public class Persons {

    @Person(name = "Tom", age = 23)
    private String person1;

    @Person(name = "Peter")
    private String person2;

    @Person(name = "Ivan")
    private String person3;

    public static void main(String[] args) throws Exception {
        Persons persons = new Persons();
        Injector.inject(persons);

        System.out.println(persons.person1);
        System.out.println(persons.person2);
        System.out.println(persons.person3);

        Class<? extends Persons> personsClass = persons.getClass();
        Field field = personsClass.getDeclaredField("person1");
        Person annotation = field.getAnnotation(Person.class);
        System.out.println(annotation.age());
        System.out.println(annotation.name());
    }

    static class Injector {
        public static void inject(Object instance) {
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Person.class)) {
                    Person annotation = field.getAnnotation(Person.class);
                    field.setAccessible(true); // should work on private fields
                    try {
                        field.set(instance, annotation.name());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
