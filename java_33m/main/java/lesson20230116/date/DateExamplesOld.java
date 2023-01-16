package lesson20230116.date;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateExamplesOld {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        Date date1 = new Date(9121113545252L);
        System.out.println(date1);
        System.out.println(new Date(10, 0, 33));

        System.out.println(date.compareTo(date1));
        date.setYear(124);
        date.setMonth(Calendar.FEBRUARY);
        System.out.println(date);

        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar.getTime());
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        System.out.println(calendar2.getTimeZone());

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date2 = new Date();
        date2.setMonth(Calendar.FEBRUARY);
        System.out.println(format.format(date2));

        Locale locale = Locale.of("ru");
        Locale.setDefault(locale);
        Date now = new Date();
        String date3 = String.format(locale, "%tc\n", now) + // длинная строка
                String.format(locale, "%tD\n", now) + //(MM/DD/YY)
                String.format(locale, "%tF\n", now) + //(YYYY-MM-DD)
                String.format(locale, "%tr\n", now) + //Full 12-hour time
                String.format(locale, "%tz\n", now) + //Time zone GMT offset
                String.format(locale, "%tZ\n", now);//Localized time zone abbreviation

        System.out.println(date3);

        Arrays.stream(Locale.getAvailableLocales()).forEach(System.out::println);

    }


}
