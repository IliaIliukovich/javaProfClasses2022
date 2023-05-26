package lesson20230526;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class GenericExamples {

    public static void main(String[] args) {

        List<Boolean> list2 = new ArrayList<>(); // boolean -> Boolean

//        List list = new ArrayList<>(); // no paramertisation
        List<String> list = new ArrayList<>();
        list.add("text A");
        list.add("text B");
//        list.add(100); // impossible
        list.add("100");

        Object o = list.get(0);
        String s = (String) o;
//        Integer i = (Integer) o; // exception
        list.stream().map(o1 -> ((String) o1).toUpperCase()).toList().forEach(System.out::println);

        MyGenericClass<String, String, Integer> myGenericClass = new MyGenericClass<>();
        myGenericClass.action("String");

        MyGenericClass<String, Double, Integer> myGenericClass2 = new MyGenericClass<>();
        myGenericClass2.action(100.0);

        // Task 1.a  - Написать Generic метод <T> List<T> makeList(T[] t), который преобразует массив в список
        List<Integer> integers = makeList(new Integer[]{1, 2, 3});
        List<Double> doubles = makeList(new Double[]{1.0, 2.0, 3.0});


        // Task 1.b - Написать Generic метод <T> T[] makeArray(List<T> list), который преобразует список в массив
        //	(Возможно ли это?)
        Object[] strings = GenericExamples.makeArray(Arrays.asList("One", "Two", "Three"));
        System.out.println(Arrays.toString(strings));
//        String[] strings2 = GenericExamples.makeArray(Arrays.asList("One", "Two", "Three")); // impossible


        // Task 2.Напишите метод filter(Object[] ints, ()->()), который принимает на вход массив (любого
        // типа) и реализацию интерфейса Filter c методом apply (Object o), чтобы убрать из массива лишнее.
        //  Проверьте как он работает на строках или других объектах.
        //  interface Filter {
        //   boolean apply(o);
        //  }

        Integer[] integersToFilter = new Integer[]{1, 2 ,3 ,4, 5};
        String[] stringsToFilter = new String[] {"Hello", "A", "B", "C", "World"};
        Integer[] filtered1 = filterWithPredicate(integersToFilter, i -> i % 2 == 0);
        String[] filtered2 = filterWithPredicate(stringsToFilter, str -> str.length() == 5);

        System.out.println(Arrays.toString(filtered1));
        System.out.println(Arrays.toString(filtered2));
    }

    public static <T> List<T> makeList(T[] t) {
        return Arrays.asList(t);
    }

    public static <T> T[] makeArray(List<T> list){
        return (T[]) list.toArray();

////         Solution explanation:
////         List<T> list2 = new ArrayList<T>(list.size()); // possible for list
////         T t = new T[list.size()]; // impossible for array
//
////         list.toArray() is equal to:
//          Object[] objects = new Object[list.size()];
//          int i = 0;
//          for (T e : list) {
//              objects[i++] = e;
//          }
//          return (T[]) objects; // unchecked cast
    }

    private static <T> T[] filter(T[] objectsToFilter, Filter<T> filter) {
        int newSize = 0;
        for (int i = 0; i < objectsToFilter.length; i++) {
            if (filter.apply(objectsToFilter[i])) {
                objectsToFilter[newSize++] = objectsToFilter[i];
            }
        }
        T[] filteredObjects = Arrays.copyOf(objectsToFilter, newSize);
        return filteredObjects;
    }

    private static <T> T[] filterWithPredicate(T[] objectsToFilter, Predicate<? super T> filter) {
        int newSize = 0;
        for (int i = 0; i < objectsToFilter.length; i++) {
            if (filter.test(objectsToFilter[i])) {
                objectsToFilter[newSize++] = objectsToFilter[i];
            }
        }
        T[] filteredObjects = Arrays.copyOf(objectsToFilter, newSize);
        return filteredObjects;
    }


}




