package com.mjmspred.common.util;

import com.mjmspred.common.ApplicationSettings;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author : chunf
 */
public class CalendarUtils {
    private static final Set<String> WORKDAYS;

    static {
        URL url = CalendarUtils.class.getResource("/holiday.txt");
        Objects.requireNonNull(url);
        try {
            WORKDAYS = Collections.unmodifiableSet(new HashSet<>(Files.readAllLines(Paths.get(url.toURI()), StandardCharsets.UTF_8)));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isWorkday(String date) {
        return !WORKDAYS.contains(date);
    }

    public static boolean isHoliday(String date) {
        return WORKDAYS.contains(date);
    }

    public static boolean isHoliday(LocalDate date) {
        return WORKDAYS.contains(ApplicationSettings.DATE_FORMATTER.format(date));
    }

    public static boolean isWorkday(LocalDate date) {
        return !WORKDAYS.contains(ApplicationSettings.DATE_FORMATTER.format(date));
    }
}
