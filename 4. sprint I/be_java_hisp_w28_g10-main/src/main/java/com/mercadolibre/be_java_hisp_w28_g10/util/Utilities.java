package com.mercadolibre.be_java_hisp_w28_g10.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Utility class for data conversion and CSV generation.
 * <p>
 * This class provides methods for converting between different data types,
 * namely mapping Java objects using Jackson's ObjectMapper, and generating
 * CSV representations of lists using OpenCSV.
 * </p>
 */
@Component
public class Utilities {

    private ObjectMapper mapper;

    /**
     * Constructs a Utilities instance with a configured ObjectMapper.
     * <p>
     * The ObjectMapper is set up to handle LocalDate serialization and deserialization
     * using the pattern "dd-MM-yyyy".
     * </p>
     */
    public Utilities() {
        this.mapper = new ObjectMapper();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDate.class,
                new LocalDateDeserializer(dateFormatter));
        javaTimeModule.addSerializer(LocalDate.class,
                new LocalDateSerializer(dateFormatter));
        mapper.registerModule(javaTimeModule);
    }

    /**
     * Converts a value from one type to another.
     *
     * @param origin the object to convert.
     * @param targetClass the class of the target type.
     * @param <T> the target type.
     * @param <U> the source type.
     * @return the converted object of type T.
     */
    public <T, U> T convertValue(U origin, Class<T> targetClass) {
        return mapper.convertValue(origin, targetClass);
    }

    /**
     * Converts a value from one type to another using a TypeReference.
     *
     * @param fromValue the object to convert.
     * @param toValueTypeRef the TypeReference for the target type.
     * @param <T> the target type.
     * @return the converted object of type T.
     * @throws IllegalArgumentException if fromValue is null.
     */
    public <T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef) throws IllegalArgumentException {
        if (fromValue == null) {
            throw new IllegalArgumentException("fromValue must not be null");
        }
        return mapper.convertValue(fromValue, toValueTypeRef);
    }

    /**
     * Converts a value from one type to another using a JavaType.
     *
     * @param fromValue the object to convert.
     * @param toValueType the JavaType for the target type.
     * @param <T> the target type.
     * @return the converted object of type T.
     * @throws IllegalArgumentException if fromValue is null.
     */
    public <T> T convertValue(Object fromValue, JavaType toValueType) throws IllegalArgumentException {
        if (fromValue == null) {
            throw new IllegalArgumentException("fromValue must not be null");
        }
        return mapper.convertValue(fromValue, toValueType);
    }

    /**
     * Reads and converts an InputStream into a specified type using a TypeReference.
     *
     * @param src the InputStream containing the data to read.
     * @param valueTypeRef the TypeReference for the target type.
     * @param <T> the target type.
     * @return the converted object of type T.
     * @throws IOException if an error occurs while reading the InputStream.
     * @throws IllegalArgumentException if src is null.
     */
    public <T> T readValue(InputStream src, TypeReference<T> valueTypeRef) throws IOException {
        if (src == null) {
            throw new IllegalArgumentException("InputStream must not be null");
        }
        return mapper.readValue(src, valueTypeRef);
    }

    /**
     * Generates a CSV representation of a list of objects.
     *
     * @param data the list of data to be converted to CSV format.
     * @param headers the headers for the CSV file.
     * @param <T> the type of the objects in the list.
     * @return a String containing the CSV representation of the data.
     * @throws RuntimeException if an error occurs while generating CSV.
     */
    public <T> String generateCsv(List<T> data, String[] headers) {

        try {
        StringWriter writer = new StringWriter();

        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeNext(headers);

        StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        beanToCsv.write(data);

        return writer.toString();

        } catch (Exception e) {
            throw new RuntimeException("Error generating CSV");
        }
    }
}
