package com.meli.obtenerdiploma.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class TestUtilsGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;

    public static void emptyUsersFile() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static StudentDTO getStudentWithThreeSubjects(String name) {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 8.0),
                new SubjectDTO("Lengua", 6.0),
                new SubjectDTO("Física", 4.0)
        );
        return new StudentDTO(9999L, name, null, null, subjects);
    }

    public static StudentDTO getStudentWithThreeSubjectsAverageOverNine(String name) {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 8.0),
                new SubjectDTO("Lengua", 9.0),
                new SubjectDTO("Física", 10.0)
        );
        return new StudentDTO(9999L, name, null, null, subjects);
    }

    public static StudentDTO getStudentWithId(Long id) {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 8.0),
                new SubjectDTO("Lengua", 6.0),
                new SubjectDTO("Física", 4.0)
        );
        return new StudentDTO(id, "student1", null, null, subjects);
    }

    public static Set<StudentDTO> getStudentSet() {
        return new HashSet<StudentDTO>(){{add(getStudentWithThreeSubjects("Marco"));
            add(getStudentWithThreeSubjects("Marco Polo"));
            add(getStudentWithThreeSubjects("Julio"));
            add(getStudentWithThreeSubjects("Julio Cesar"));}};
    }

    public static void appendNewStudent(StudentDTO stu) {
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        PrintWriter writer = null;

        try {
            String content = Files.readString(new File("./src/" + SCOPE + "/resources/users.json").getAbsoluteFile().toPath(), StandardCharsets.US_ASCII);
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/users.json"));

            try {
                String studentAsString = mapper.writeValueAsString(stu);
                writer.print(content.substring(0, content.length()-1));
                if (content.length()>2) writer.print(", ");
                writer.print(studentAsString);
                writer.print("]");
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.close();
    }

}
