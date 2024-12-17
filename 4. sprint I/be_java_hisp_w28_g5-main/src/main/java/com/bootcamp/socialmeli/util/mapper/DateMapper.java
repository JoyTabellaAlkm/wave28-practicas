package com.bootcamp.socialmeli.util.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateMapper {
    private DateMapper() {}

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate toLocalDate(String date) {
        return LocalDate.parse(date, formatter);
    }

    public static String toString(LocalDate date) {
        return formatter.format(date);
    }
}
