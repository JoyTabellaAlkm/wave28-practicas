package com.bootcamp.concesionaria.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate localDateFrom(String s) {
        return LocalDate.parse(s, formatter);
    }

    public static String toString(LocalDate manufacturingDate) {
        return manufacturingDate.format(formatter);
    }
}
