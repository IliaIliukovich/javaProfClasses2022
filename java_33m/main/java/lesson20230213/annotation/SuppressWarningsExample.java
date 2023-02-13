package lesson20230213.annotation;

import lesson20230213.reflection.SpecialClass;

public class SuppressWarningsExample<T> {

    public static void main(String[] args) throws Exception{
        Class<?> newClazz = Class.forName("lesson20230213.reflection.SpecialClass");

        @SuppressWarnings("deprecation") SpecialClass newSpecialClass = (SpecialClass) newClazz.newInstance();

    }


    private T[] getRandomCopy(T[] itemArray, int numberOfItems, int realNumberOfItems) {
        @SuppressWarnings("unchecked")
        T[] copy = (T[]) new Object[realNumberOfItems];

        return null;
    }

}
