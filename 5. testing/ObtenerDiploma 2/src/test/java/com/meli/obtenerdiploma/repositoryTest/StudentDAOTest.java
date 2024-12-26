package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentDAOTest {
    private static final StudentDTO student1 = new StudentDTO(1L, "Juan", null, null,
            List.of(
                    new SubjectDTO("Matemática", 9.0),
                    new SubjectDTO("Física", 7.0),
                    new SubjectDTO("Química", 6.0)
            ));

    private static final StudentDTO student2 = new StudentDTO(2L, "Pedro", null, null,
            List.of(
                    new SubjectDTO("Matemática", 10.0),
                    new SubjectDTO("Física", 8.0),
                    new SubjectDTO("Química", 4.0)
            ));

    IStudentDAO studentDAO = new StudentDAO();

    @Test
    public void saveTest(StudentDTO stu){

    }


    @Test
    public void deleteTest(Long id){

    }

    @Test
    public void existsTest(StudentDTO stu){

    }

    @Test
    public void findByIdTest(Long id){

    }

}
