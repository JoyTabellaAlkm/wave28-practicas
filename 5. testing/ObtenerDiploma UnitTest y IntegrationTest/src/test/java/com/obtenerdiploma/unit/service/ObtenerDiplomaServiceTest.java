package com.obtenerdiploma.unit.service;

import com.obtenerdiploma.dto.StudentWithMessageDTO;
import com.obtenerdiploma.dto.SubjectDTO;
import com.obtenerdiploma.entity.Student;
import com.obtenerdiploma.entity.Subject;
import com.obtenerdiploma.repository.IStudentRepository;
import com.obtenerdiploma.service.ObtenerDiplomaService;
import com.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;


    @Test
    @DisplayName("Test analyze score")
    void analyzeScores() {
        Long idMocked = 1L;

        Student student1 = new Student (1L, "Juan", Set.of(
                new Subject("Matemática", 9D),
                new Subject("Física", 7D),
                new Subject("Química", 6D))
        );

        StudentWithMessageDTO resultWaited = new StudentWithMessageDTO(1L, "Juan", Set.of(new SubjectDTO("Matemática", 9.0),new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0)), "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", 7.333333333333333);


        Mockito.when(studentRepository.findById(idMocked)).thenReturn(Optional.of(student1));

        StudentWithMessageDTO response = obtenerDiplomaService.analyzeScores(idMocked);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(resultWaited, response, " no coinciden");

        Mockito.verify(studentRepository, Mockito.times(1)).findById(idMocked);


    }
}