package lesson20230324;

public class MyCalendar {


    public static void main(String[] args) {
        DayOfWeek monday = DayOfWeek.valueOf("MONDAY");
        System.out.println(monday);

        DayOfWeek day = DayOfWeek.WEEKDAY;
        morningGreeting(day);

        System.out.println(DayOfWeek.MONDAY == monday);
    }


    private static void morningGreeting(DayOfWeek day) {
        switch (day){
            case MONDAY -> System.out.println("Hard day");
            case TUESDAY -> System.out.println("Better");
            case WEDNESDAY -> System.out.println("Middle of the week");
            case THURSDAY -> System.out.println("Thursday greeting!");
            case FRIDAY -> System.out.println("End of week");
            default -> System.out.println("Time to have rest!");
        }


    }

}
