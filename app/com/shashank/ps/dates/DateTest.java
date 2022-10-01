package com.shashank.ps.dates;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTest {

    private static final String PATTERN_FORMAT1 = "dd-MM-yyyy";
    private static final String PATTERN_FORMAT2 = "dd-MM-yyyy hh:mm:ss";
    private static final String PATTERN_FORMAT3 = "dd/MM/yyyy hh:mm:ss:z";
    private static final String PATTERN_FORMAT4 = "EEEE, MMMM dd, YYYY hh:mm:ssa z";

    public static void main(String[] args) {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(PATTERN_FORMAT1)
                .withZone(ZoneId.systemDefault());
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(PATTERN_FORMAT2);
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern(PATTERN_FORMAT3)
                .withZone(ZoneId.of("Australia/Sydney"));
        DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withZone(ZoneId.of("Australia/Sydney"));
        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern(PATTERN_FORMAT4)
                .withZone(ZoneId.of("Australia/Sydney"));

        Instant instant = Instant.now();
        System.out.println("Instant Time Display: " + formatter1.format(instant));

        OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Offset Date Time Display: " + formatter2.format(offsetDateTime));

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Zoned Date Time Display: " + formatter3.format(zonedDateTime));
        System.out.println("Zoned Date Time Display: " + formatter4.format(zonedDateTime));
        System.out.println("Zoned Date Time Display: " + formatter5.format(zonedDateTime));

    }
}
