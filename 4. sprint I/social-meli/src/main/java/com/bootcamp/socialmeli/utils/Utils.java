package com.bootcamp.socialmeli.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Utils {
    public static <T> T loadDataBase(String jsonName, TypeReference<T> typeReference) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        File file = ResourceUtils.getFile("classpath:" + jsonName + ".json");

        return objectMapper.readValue(file, typeReference);
    }

    public static <T, U extends Comparable<? super U>> List<T> sortList(List<T> list, Function<T, U> keyExtractor, boolean ascending) {
        Comparator<T> comparator = Comparator.comparing(keyExtractor);
        return list.stream()
                .sorted((ascending) ? comparator : comparator.reversed())
                .toList();
    }
}
