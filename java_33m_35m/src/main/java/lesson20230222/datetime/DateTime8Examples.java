package lesson20230222.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Locale;

public class DateTime8Examples {

    public static void main(String[] args) {

        // Instant
        Instant instant = Instant.now();
        System.out.println(instant);

        Instant instantBefore = Instant.now();
        long result = fibonacci(42);
        Instant instantAfter = Instant.now();
        Duration duration = Duration.between(instantBefore, instantAfter);
        System.out.println("Time elapsed, ms: " + duration.toMillis());
        System.out.println("Function result: " + result);

        long start = System.currentTimeMillis();
        result = fibonacci(42);
        long end = System.currentTimeMillis();
        System.out.println("Time elapsed, ms: " + (end - start));
        System.out.println("Function result: " + result);

        Instant instant2 = Instant.parse("2007-12-03T10:15:30.00Z");
        System.out.println(instant2);
        Instant instant3 = instant2.plus(5, ChronoUnit.DAYS);
        System.out.println(instant3);

        // LocalDate
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = LocalDate.of(2023, 2, 28);
        System.out.println(localDate);

        LocalDate localDate1 = localDate.plusMonths(2);
        System.out.println(localDate1);
        Period period = localDate.until(localDate1);
        System.out.println(period.getMonths());

        localDate.datesUntil(localDate1, Period.ofDays(7)).forEach(System.out::println);
        System.out.println(localDate.getDayOfWeek());

        // LocalTime
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        // LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_TIME;
        System.out.println(dateTimeFormatter.format(localDateTime));

        // ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("CET"));
        System.out.println(zonedDateTime);

        zonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println(zonedDateTime);

//        ZoneId.getAvailableZoneIds().forEach(System.out::println);


        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(dateTimeFormatter2.withLocale(Locale.of("ru")).format(LocalDateTime.now()));

//        Arrays.stream(Locale.getAvailableLocales()).forEach(System.out::println);

        LocalDate date = LocalDate.of(2023, 4, 1);
        System.out.println(date);
        LocalDate date1 = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println(date1);

        System.out.println(Period.between(LocalDate.now(), date1));
        System.out.println(LocalDate.now().until(date1, ChronoUnit.DAYS));


    }


    // 0 1 1 2 3 5 8
    private static long fibonacci(long i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }


}
