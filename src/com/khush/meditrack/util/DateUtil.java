package com.khush.meditrack.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    private DateUtil() {}

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }
}
