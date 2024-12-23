package com.meli.obtenerdiploma.unitTest.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentDAOTest {

    private final StudentDAO studentDAO;

    private final ObjectMapper objectMapper;

    private Set<StudentDTO> initialData;


    public StudentDAOTest() {
        this.studentDAO = new StudentDAO();
        this.objectMapper = new ObjectMapper();
        try {
            loadInitialData();
        }catch (IOException e){
            throw new RuntimeException("Problemas al cargar la data inicial");
        }
    }

    @AfterEach
    public void setUp() throws Exception {

        Path path = Paths.get("./src/main/resources/users.json");
        if (Files.exists(path)) {
            Files.delete(path);
        }
        objectMapper.writeValue(path.toFile(), initialData);
    }

    private void loadInitialData() throws IOException {
        initialData = new HashSet<>();
        File file = ResourceUtils.getFile("./src/main/resources/users.json");
        initialData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>() {});
    }


    @Test
    public void saveStudentTest(){
        StudentDTO studentDTO= new StudentDTO();
        studentDTO.setStudentName("Gabriel");

        studentDAO.save(studentDTO);
        StudentDTO studentFound = studentDAO.findById(studentDTO.getId());

        assertThat(studentFound.getStudentName()).isEqualTo(studentDTO.getStudentName());
        assertThat(studentFound).isNotNull();

    }


    @Test
    public void deleteStudentTest(){
        StudentDTO studentFound = studentDAO.findById(2L);
        boolean result = studentDAO.delete(studentFound.getId());

        assertThat(result).isTrue();
    }
}
