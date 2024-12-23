package com.meli.obtenerdiploma.uniTest.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.impl.StudentRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

public class StudentRepositoryTests {
    IStudentRepository studentRepo;

    @BeforeEach
    @AfterEach
    private void setUp() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/test/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"studentName\": \"Juan\",\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matemática\",\n" +
                "        \"score\": 9\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Física\",\n" +
                "        \"score\": 7\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Química\",\n" +
                "        \"score\": 6\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"studentName\": \"Pedro\",\n" +
                "    \"message\": null,\n" +
                "    \"averageScore\": null,\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matemática\",\n" +
                "        \"score\": 10.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Física\",\n" +
                "        \"score\": 8.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Química\",\n" +
                "        \"score\": 4.0\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]");
        writer.close();
        this.studentRepo = new StudentRepository();
    }

    @Test
    public void findAllExistentStudents() {
        // arrange
        Set<StudentDTO> students = Set.of(
                new StudentDTO(1L,
                        "Juan",
                        List.of(
                                new SubjectDTO("Matemática", 9.0),
                                new SubjectDTO("Física", 7.0),
                                new SubjectDTO("Química", 6.0)
                        )
                ),
                new StudentDTO(2L,
                        "Pedro",
                        List.of(
                                new SubjectDTO("Matemática", 10.0),
                                new SubjectDTO("Física", 8.0),
                                new SubjectDTO("Química", 4.0)
                        )
                )
        );


        // act
        Set<StudentDTO> foundSet = studentRepo.findAll();

        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students, foundSet));
    }
}
