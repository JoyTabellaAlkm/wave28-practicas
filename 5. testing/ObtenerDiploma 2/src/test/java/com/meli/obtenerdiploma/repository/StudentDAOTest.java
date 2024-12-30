package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;
import java.util.List;

public class StudentDAOTest {

    IStudentDAO studentDAO = new StudentDAO();

    //guardar estuduante nuevo
    @Test
    public void save_ok(){
        //arrange - preparar los datos a usar
        StudentDTO alumnoParam = new StudentDTO(2L,"Luis", "mensaje1",4.0,
                List.of(
                        new SubjectDTO("Matematica", 8.0)
                ));

        StudentDTO devolution = alumnoParam;

        //act - correr el metodo a probar
        studentDAO.save(alumnoParam);

        //assert - probar alguna condicion para ver si funciono o no el metodo
        Assertions.assertTrue(studentDAO.exists(alumnoParam));
        Assertions.assertEquals(devolution,alumnoParam);


    }

    // guardar estudiante que existe
    @Test
    public void save_student_exist(){
        //arrange - preparar los datos a usar
        StudentDTO alumnoParam = new StudentDTO(1L,"", "mensaje1",4.0,
                List.of(
                        new SubjectDTO("Matematica", 8.0)
                ));

        StudentDTO devolution = alumnoParam;

        //act - correr el metodo a probar
        studentDAO.save(alumnoParam);

        //assert - probar alguna condicion para ver si funciono o no el metodo
        Assertions.assertTrue(studentDAO.exists(alumnoParam));
        Assertions.assertEquals(1L, alumnoParam.getId());
        Assertions.assertEquals(studentDAO.findById(alumnoParam.getId()), alumnoParam);

    }


    @Test
    public void save_empty_name_error(){
        // Arrange
        StudentDTO alumnoParam = new StudentDTO(1L,
                "",
                "mensaje1", 4.0,
                List.of());

        // Act & Assert - esperar una excepción al intentar guardar
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            studentDAO.save(alumnoParam);
        });

    }

    @Test
    public void save_studentWithSameIdUpdates() {
        // Arrange
        StudentDTO existingStudent = new StudentDTO(1L, "Uriel", "mensaje1", 4.0, List.of());
        studentDAO.save(existingStudent);

        StudentDTO updatedStudent = new StudentDTO(1L, "Uriel", "mensaje2", 5.0, List.of());

        // Act
        studentDAO.save(updatedStudent);

        // Assert
        Assertions.assertTrue(studentDAO.exists(updatedStudent));
        Assertions.assertEquals(updatedStudent.getAverageScore(), 5.0);
        Assertions.assertEquals(updatedStudent.getStudentName(), existingStudent.getStudentName(), "El nombre del estudiante debería haber sido actualizado.");
    }

    //consultar si un estudiante existe
    @Test
    public void studentDoesExist() {
        // Arrange
        StudentDTO alumnoParam = new StudentDTO(2L, "Alumno", "NotFound", 4.0,
                List.of(
                        new SubjectDTO("Matematica", 8.0)
                ));
        var x = studentDAO.exists(alumnoParam);

        // Act & Assert
        Assertions.assertTrue(x);
    }

    //consultar si un estudiante no existe
    @Test
    public void studentDoesNotExist() {
        // Arrange
        StudentDTO alumnoParam = new StudentDTO(500L, "Alumno", "NotFound", 4.0,
                List.of(
                        new SubjectDTO("Matematica", 8.0)
                ));

        // Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class, ()-> {
            studentDAO.exists(alumnoParam);
        });
    }

    //Eliminar un estudiante que existe
    @Test
    public void deleteStudentOk(){
        Long studentId= 1L;
        var x = studentDAO.delete(studentId);

        Assertions.assertTrue(x, "el estudiante fue eliminado");

    }

    //Eliminar un estudiante que no existe
    @Test
    public void deleteStudentNoOk(){
        Long studentId= 1L;
        var x = studentDAO.delete(studentId);

        Assertions.assertFalse(x, "el estudiante fue eliminado");

    }
}
