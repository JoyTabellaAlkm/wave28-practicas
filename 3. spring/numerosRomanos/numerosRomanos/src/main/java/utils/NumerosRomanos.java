package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumerosRomanos {

    public static Map<Integer, String> numerosRomanos = Stream.of(new Object[][] {
            {1, "I"},
            {5, "V"},
            {10, "X"},
            {50, "L"},
            {100, "C"},
            {500, "D"},
            {1000, "M"}
    }).collect(Collectors.toMap(p -> (Integer) p[0], p -> (String) p[1]));

    public static Integer devolverDecimal(Integer numeroDecimal) {

    }
}
