package lesson20221221.generics;

public class Car implements Comparable<Car> {

    @Override
    public int compareTo(Car o) {
        return o.getClass().getSimpleName().compareTo(this.getClass().getSimpleName());
    }

// Cannot add compareTo(Object o) because of generic erasure
//    public int compareTo(Object o) {
//        return 0;
//    }
}
