package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

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

    private static final Set<StudentDTO> students = Set.of(student1,student2);


    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createTest() {
        //ARRANGE
        StudentDTO student = student1;

        //ACT
        studentService.create(student);

        //ASSERT
        Mockito.verify(studentDAO).save(student);
    }

    @Test
    public void readTest() {
        //ARRANGE
        Long id = 1L;
        StudentDTO studentExpected = student1;
        Mockito.when(studentDAO.findById(id)).thenReturn(studentExpected);

        //ACT
        StudentDTO studentObtained =  studentService.read(id);

        //ASSERT
        Assertions.assertEquals(studentObtained,studentExpected,"Los estudiantes no coinciden");

    }

    @Test
    public void updateTest() {
        //ARRANGE
        StudentDTO student = student1;

        //ACT
        studentService.update(student);

        //ASSERT
        Mockito.verify(studentDAO).save(student);
    }

    @Test
    public void deleteTest() {
        //ARRANGE
        Long id = 1L;

        //ACT
        studentService.delete(id);

        //ASSERT
        Mockito.verify(studentDAO).delete(id);
    }

    @Test
    public void getAllTest() {
        //ARRANGE
        Set<StudentDTO> studentsExpected = students;
        Mockito.when(studentRepository.findAll()).thenReturn(students);

        //ACT
        Set<StudentDTO> studentsObtained = studentService.getAll();

        //ARRANGE
        Assertions.assertEquals(studentsExpected,studentsObtained,"Los conjuntos no coinciden");

    }
}
