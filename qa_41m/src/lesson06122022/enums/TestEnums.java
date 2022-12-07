package lesson06122022.enums;

import java.util.Arrays;

public class TestEnums {

    public static void main(String[] args) {

        Color red = Color.RED;
        Color blue = Color.BLUE;
        System.out.println(red);
        System.out.println(blue);

        Color[] values = Color.values();
        System.out.println(Arrays.asList(values));

        MyDay myDay = MyDay.TUESDAY;
        dayIsNice(myDay);
        dayIsNice(MyDay.FRIDAY);

        red.someMethod();
        blue.someMethod();

        red.specialMethod();
        blue.specialMethod();

//        MyDay myDay1 = new MyDay(); impossible!

    }

    public static void dayIsNice(MyDay day) {
        switch (day) {
            case MONDAY -> System.out.println("bad");
            case FRIDAY -> System.out.println("better");
            case SATURDAY, SUNDAY -> System.out.println("best");
            default -> System.out.println("so-so");
        }
    }

}
