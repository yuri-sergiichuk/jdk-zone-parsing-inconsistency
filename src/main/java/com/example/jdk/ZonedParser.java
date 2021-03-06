package com.example.jdk;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.util.Objects.requireNonNull;

/**
 * This class provides a test implementation that allows to showcase inconsistency between
 * parsing of {@link java.time.ZonedDateTime} instances through {@link java.time.format.DateTimeFormatter}s
 * with {@code UTC} zone.
 */
final class ZonedParser {

    /**
     * US zoned date-time formatter.
     */
    private static final DateTimeFormatter ZONED_FORMATTER =
            DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a z", Locale.US);

    /**
     * Prevents instantiation of this utility class.
     */
    private ZonedParser() {
    }

    /**
     * Parses supplied {@code dateTime} using zoned US date-time formatter.
     */
    static ZonedDateTime parse(String dateTime) {
        requireNonNull(dateTime);
        ZonedDateTime result = ZONED_FORMATTER.parse(dateTime, ZonedDateTime::from);
        return result;
    }

    /**
     * Formats supplied {@code dateTime} using zoned US date-time formatter.
     */
    static String format(ZonedDateTime dateTime) {
        requireNonNull(dateTime);
        String result = ZONED_FORMATTER.format(dateTime);
        return result;
    }
}
