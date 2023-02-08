package lesson20221221.generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class GenericExamples {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        String o = list.get(0);
        System.out.println(o);

        Executor<String, Double> executor = new Executor<>();
        Executor<Double, Integer> executor2 = new Executor<>();
        executor.execute("some string");
        executor2.execute(10.0);

        executor.doSometh(123, "One, Two, Three");


//        List<? extends SomeClass> PECS - Producer Extends, Consumer Super
//        List<? super SomeClass>

        List<BMW> bmws = new ArrayList<BMW>();
        List<Volwo> volwos = new ArrayList<>();
        bmws.add(new BMW());
        bmws.add(new BMW());

        List<? extends Car> carsInShop = bmws; // Producer
//        carsInShop.add(new Volwo());
//        carsInShop.add(new BMW());
//        carsInShop.add(new Car());
        Car newCar = carsInShop.get(0);
        carsInShop.forEach(System.out::println);

        List<? super BMW> list2 = new ArrayList<>(); // Consumer
        list2.add(new BMW2());
        list2.add(new BMW());
//        list2.add(new Car());
//        Car car = list2.get(0);
        Object object = list2.get(0);


//        T T -> List<T>
        List<Integer> listInts = createList(1, 2);
        List<String> listStrings = createList("1", "2");

//  Задание: напишите метод filter(Object[] ints, ()->()), который принимает на вход массив (любого типа)
//  и реализацию интерфейса Filter c методом apply (Object o), чтобы убрать из массива лишнее.
//  Проверьте как он работает на строках или других объектах.
//  interface Filter {
//    boolean apply(o);
//  }

        String[] strings = new String[]{"One", "Two", "Three"};
        String[] filtered = filter2(strings, o1 -> o1.length() == 3);
        System.out.println(Arrays.toString(filtered));

        Integer[] ints = new Integer[]{0, 1, 2, 3, 4, 5};
        Integer[] filteredInts = filter2(ints, new Predicate<Number>() {
            @Override
            public boolean test(Number i) {
                return ((Integer)i % 2 == 0);
            }
        });
        System.out.println(Arrays.toString(filteredInts));

        Integer[] newInts = (Integer[]) Array.newInstance(Integer.class, 10);
        System.out.println(Arrays.toString(newInts));

        Number someNumber = 10;
        Class<? extends Number> aClass = someNumber.getClass();
        System.out.println(aClass);
        someNumber = 2.0;
        System.out.println(someNumber.getClass());

        MyStream<Integer> myStream = new MyStream<Integer>().filter().filter().parallel();
    }

    public static  <T> List<T>  createList (T t1, T t2) {
        return Arrays.asList(t1, t2);
    }

    public static <T> T[] filter(T[] t, Filter<? super T> filter) {
//        T[] filteredTs = new T[t.length]; // impossible
//        T[] filteredTs = (T[]) new Object[t.length]; // can cause exceptions!
//        filteredTs[0] = t[0];
//        System.out.println(filteredTs[0]);
        int size = 0;
        for (int i = 0; i < t.length; i++) {
            boolean isValid = filter.apply(t[i]);
            if (isValid) {
                t[size++] = t[i];
            }
        }
        return Arrays.copyOf(t, size);
    }

    // same filter function with Predicate
    public static <T> T[] filter2(T[] t, Predicate<? super T> predicate) {
        int size = 0;
        for (int i = 0; i < t.length; i++) {
            boolean isValid = predicate.test(t[i]);
            if (isValid) {
                t[size++] = t[i];
            }
        }
        return Arrays.copyOf(t, size);
    }


}
