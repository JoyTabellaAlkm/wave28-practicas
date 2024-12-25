package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    public void createStudent() {
        StudentDTO dto = new StudentDTO(null, "Tomas", null, null, Collections.emptyList());
        when(studentDAO.save(Mockito.any(StudentDTO.class))).thenReturn(dto);
        StudentDTO saved = studentService.create(dto);
        Assertions.assertSame(dto, saved);
    }

    @Test
    public void readStudent() {
        Long id = 10L;
        StudentDTO dto = new StudentDTO(id, "Tomas", null, null, Collections.emptyList());
        when(studentDAO.findById(id)).thenReturn(dto);

        StudentDTO reading  = studentService.read(id);
        Assertions.assertEquals(dto, reading);
    }

    @Test
    public void readNotExistingStudent() {
        when(studentDAO.findById(Mockito.anyLong())).thenThrow(new StudentNotFoundException(-1L));
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.read(10L));
    }

    @Test
    public void updateStudentName() {
        StudentDTO dto = new StudentDTO(null, "Tomas", null, null, Collections.emptyList());
        when(studentDAO.save(Mockito.any(StudentDTO.class))).thenReturn(dto);

        String newName = "Otro nombre";
        dto.setStudentName(newName);
        StudentDTO updated = studentService.update(dto);
        Assertions.assertEquals(newName, updated.getStudentName());
    }

    @Test
    public void updateStudentSubjectsWithNewSubject() {
        StudentDTO dto = new StudentDTO(null, "Tomas", null, null, new ArrayList<>());
        when(studentDAO.save(Mockito.any(StudentDTO.class))).thenReturn(dto);

        SubjectDTO subject = new SubjectDTO("Maths", 23.2);
        dto.getSubjects().add(subject);
        StudentDTO updated = studentService.update(dto);
        Assertions.assertEquals(subject, updated.getSubjects().get(0));
    }

    @Test
    public void removeSubjectsFromStudentAndUpdate() {
        SubjectDTO subject1 = new SubjectDTO("Maths", 23.2);
        SubjectDTO subject2 = new SubjectDTO("Computer Science", 32.2);

        StudentDTO dto = new StudentDTO(null, "Tomas", null, null, new ArrayList<>(List.of(subject2, subject2)));
        when(studentDAO.save(Mockito.any(StudentDTO.class))).thenReturn(dto);

        dto.getSubjects().clear();
        StudentDTO updated = studentService.update(dto);
        Assertions.assertEquals(Collections.emptyList(), updated.getSubjects());
    }

    // para el delete no se me han ocurrido tests

    @Test
    public void findAllWithEmptyResultTest() {
        when(studentRepository.findAll()).thenReturn(Collections.emptySet());
        Assertions.assertEquals(Collections.emptySet(), studentRepository.findAll());
    }

    @Test
    public void findAllTest() {
        StudentDTO studentDTO = new StudentDTO(1L, "Tomas", null, null, null);
        when(studentRepository.findAll()).thenReturn(Set.of(studentDTO));
        Set<StudentDTO> students = studentRepository.findAll();
        Assertions.assertEquals(1, students.size());
        Assertions.assertTrue(students.contains(studentDTO));
    }
}