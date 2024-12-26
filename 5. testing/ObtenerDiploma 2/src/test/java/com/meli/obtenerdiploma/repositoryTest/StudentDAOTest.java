package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

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

    private static final StudentDTO student3 = new StudentDTO(3L, "Laura", null, null,
            List.of(
                    new SubjectDTO("Matemática", 9.0),
                    new SubjectDTO("Física", 7.0),
                    new SubjectDTO("Química", 4.5)
            ));

    @Autowired
    IStudentDAO studentDAO = new StudentDAO();

    @Autowired
    IStudentRepository studentRepository = new StudentRepository();

    @Test
    public void saveTest(){

        //ARRANGE
        Set<StudentDTO> studentsExpected = Set.of(student1,student2, student3);

        //ACT
        studentDAO.save(student3);

        //ASSERT
        Assertions.assertEquals(studentsExpected,studentRepository.findAll(), "los conjuntos no son iguales");

    }


    @Test
    public void deleteTest(){
        //ARRANGE
        Set<StudentDTO> studentsExpected = Set.of(student1,student2);

        //ACT
        studentDAO.delete(3L);

        //ASSERT
        Assertions.assertEquals(studentsExpected,studentRepository.findAll(), "los conjuntos no son iguales");
    }

    @Test
    public void deleteFailTest(){
        //ARRANGE
        Long idDelete= 3L;

        //ACT
        boolean obtained = studentDAO.delete(idDelete);

        //ASSERT
        Assertions.assertFalse(obtained, "Se muestra que eliminó un id inexistente");
    }

    @Test
    public void existsTest(){
        //ARRANGE
        StudentDTO student= student1;


        //ACT
        boolean obtained = studentDAO.exists(student);

        //ASSERT
        Assertions.assertTrue(obtained, "Se muestra que no encontró un estudiante existente");
    }

    @Test
    public void findByIdTest(){
        //ARRANGE
        Long idFind= 2L;
        StudentDTO studentExpected = student2;

        //ACT
        StudentDTO studentObtained = studentDAO.findById(idFind);

        //ASSERT
        Assertions.assertEquals(studentObtained, studentExpected, "No se encuentra un estudiante existente");
    }

}
