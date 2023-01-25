package lesson20230116.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.stream.Stream;

public class DateExamplesFromJava8 {


    public static void main(String[] args) {

        // Instant
        Instant start = Instant.now();
        System.out.println(start);
        System.out.println(fibonacci(40));
        Duration between = Duration.between(start, Instant.now());
        System.out.println(between.toMillis());

        Instant instant2 = start.plusSeconds(10);
        System.out.println(instant2);

        // LocalDate
        LocalDate date = LocalDate.of(2005, Month.JANUARY, 12);
        System.out.println(date);
        System.out.println(date.plusDays(50));

        Stream<LocalDate> dateStream = LocalDate.of(2023, 2, 1)
                .datesUntil(LocalDate.of(2023, 3, 1), Period.ofDays(7));
        dateStream.forEach(System.out::println);

        LocalDate day1 = LocalDate.of(2023, 2, 1);
        System.out.println(day1.getDayOfWeek());
        LocalDate day2 = LocalDate.of(2023, 2, 3);
        Period period = Period.between(day1, day2);
        System.out.println(period.getDays());

        LocalDate firstTuesdayInFebruary = day1.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.println(firstTuesdayInFebruary);

        // LocalTime
        LocalTime localTime = LocalTime.of(12, 12, 12);
        System.out.println(localTime);
        System.out.println(localTime.plusMinutes(70));
        Duration duration = Duration.between(localTime, LocalTime.now());
        System.out.println(duration.getSeconds());

        // LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        // ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(zonedDateTime);
        ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(localDateTime, ZoneOffset.UTC, ZoneId.of("UTC"));
        System.out.println(zonedDateTime1);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;
        System.out.println(formatter.format(zonedDateTime));
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("ss/mm/hh");
        System.out.println(myFormatter.format(zonedDateTime));

        DateTimeFormatter formatterLocalized = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(formatterLocalized.withLocale(Locale.ITALIAN).format(zonedDateTime));

        LocalDate localDate = LocalDate.of(2023, 3, 1).with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println(localDate);
        Period until = LocalDate.now().until(localDate);
//        Period.between(LocalDate.now(), localDate);
        System.out.println(until.getMonths());
        System.out.println(until.getDays());
        long days = LocalDate.now().until(localDate, ChronoUnit.DAYS);
        System.out.println(days);


        // Рейс из Лос-Анджелеса во Франкфурт отправляется в 15:05 по местному времени и длится 10 ч. 50 м.
        // Во сколько он прилетит? Написать метод, который мог бы совершать подобные вычисления.
        LocalDateTime departure = LocalDateTime.of(LocalDate.of(2023, 1, 1), LocalTime.of(15, 5, 0));
        Duration flightDuration = Duration.ofHours(10).plusMinutes(50);
        System.out.println(calculateArrivalTime(departure, flightDuration, ZoneId.of("America/Los_Angeles"), ZoneId.of("Europe/Berlin")));
    }

    public static ZonedDateTime calculateArrivalTime(LocalDateTime departure, Duration duration, ZoneId idDeparture,
                                                     ZoneId idArrival){
        return ZonedDateTime.of(departure, idDeparture).plus(duration).withZoneSameInstant(idArrival);
    }


    // fibonacci sequence 0 1 1 2 3 5 8
    private static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
