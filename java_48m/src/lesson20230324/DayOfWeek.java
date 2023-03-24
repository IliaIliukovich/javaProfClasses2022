package lesson20230324;

public enum DayOfWeek {

    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    WEEKDAY("End of week");


    private final String value;

    DayOfWeek(String s) {
        this.value = s;
    }

    @Override
    public String toString() {
        return value;
    }

}
