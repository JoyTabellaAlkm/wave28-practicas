package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) //o usamos esto o llamamos a MockitoAnnotations para inicializar los mocks
class ObtenerDiplomaServiceTest {
    @Mock //objeto simulado q permite controlar su comportamiento y definir lo q debe devolver
    IStudentDAO studentDAOMock;

    @InjectMocks //permite que el servicio interactúe con el mock en lugar de un objeto real
    ObtenerDiplomaService obtenerDiplomaService;

    StudentDTO student;
    @BeforeEach
    void setUp() {
        //inicializa las anotaciones @Mock y @InjectMocks antes de ejecutar cada prueba
        //MockitoAnnotations.openMocks(this);

        // Creación de datos de prueba
        SubjectDTO subject1 = new SubjectDTO("Matemáticas", 8.5);
        SubjectDTO subject2 = new SubjectDTO("Historia", 9.0);
        List<SubjectDTO> subjects = Arrays.asList(subject1, subject2);

        student = new StudentDTO(1L, "Mateo", null, null, subjects);
        when(studentDAOMock.findById(1L)).thenReturn(student);
    }
//    Test con datos válidos (promedio y mensaje correctos).
    @Test
    void TestAnalizeScoreValid(){
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        assertEquals(8.75,result.getAverageScore());
        String expectedMessage = "El alumno Mateo ha obtenido un promedio de 8,75. Puedes mejorar.";
        assertEquals(expectedMessage,result.getMessage());
    }


//    Test con un promedio inválido (por ejemplo, si la lista de materias es null).
@Test
void testAnalyzeScoresNullSubjects() {
    student.setSubjects(null);
    assertThrows(NullPointerException.class, () -> {
        obtenerDiplomaService.analyzeScores(1L);
    });
}
//    Test para verificar si el mensaje contiene "Felicitaciones!" cuando el promedio es mayor a 9.
    @Test
    void testAnalyzeScoresAverageHigher(){
        student.getSubjects().get(0).setScore(10.0);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        String expectedMessage = "El alumno Mateo ha obtenido un promedio de 9,5. Felicitaciones!";
        assertEquals(expectedMessage, result.getMessage(), "El mensaje de saludo es incorrecto.");
    }

}
