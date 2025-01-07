package com.bootcamp.socialmeli.utils;

import com.bootcamp.socialmeli.exception.BadRequestException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

public class Utils {

    public static <T> T loadDataBase(String jsonName, TypeReference<T> typeReference) throws IOException {
        try {
            Properties properties =  new Properties();
            properties.load(new ClassPathResource("application.properties").getInputStream());
            String scope = properties.getProperty("api.scope");

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            File file = ResourceUtils.getFile("./src/" + scope + "/resources/" + jsonName + ".json");

            return objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            // TODO: handlear en ExceptionController
            throw new IOException("Error al cargar el repositorio");
        }
    }

    public static <T, U extends Comparable<? super U>> List<T> sortList(List<T> list, Function<T, U> keyExtractor, boolean ascending) {
        Comparator<T> comparator = Comparator.comparing(keyExtractor);
        return list.stream()
                .sorted((ascending) ? comparator : comparator.reversed())
                .toList();
    }

    public static void assertOrderExists(String order, String value) {

        if (order == null || (!order.toLowerCase().equals(value + "_desc") && !order.toLowerCase().equals(value + "_asc")))
            throw new BadRequestException("Es requerido un tipo de ordenamiento valido.");
    }
}
