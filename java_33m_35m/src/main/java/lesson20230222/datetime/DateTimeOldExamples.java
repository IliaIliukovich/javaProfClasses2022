package lesson20230222.datetime;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateTimeOldExamples {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);

        Date date1 = new Date(90, 11, 12);
        System.out.println(date1);
        System.out.println(date1.getTime());

        date1.setTime(-111111111111L);
        System.out.println(date1);

        System.out.println(date1.compareTo(date));
        System.out.println(new Date(123, 1, 29));

//        Calendar calendar = new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
//        calendar.add(2, 1);
        calendar.set(2024, 2, 1);
        System.out.println(calendar.getTime());
//
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd | hh:mm:ss");
        System.out.println(dateFormat.format(calendar.getTime()));

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("hh 'o''clock' a, zzzz", Locale.GERMAN);
        System.out.println(dateFormat1.format(calendar.getTime()));

        Locale locale2 = Locale.of("ru");
        Locale.setDefault(locale2);
        Date now = new Date();
        String date3 = String.format(locale2, "%tc\n", now) + // длинная строка
                String.format(locale2, "%tD\n", now) + //(MM/DD/YY)
                String.format(locale2, "%tF\n", now) + //(YYYY-MM-DD)
                String.format(locale2, "%tr\n", now) + //Full 12-hour time
                String.format(locale2, "%tz\n", now) + //Time zone GMT offset
                String.format(locale2, "%tZ\n", now);//Localized time zone abbreviation
        System.out.println(date3);

//        System.out.println(Arrays.toString(Locale.getAvailableLocales()));
    }



}
