package com.meli.obtenerdiploma.utils;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.text.DecimalFormat;
import java.util.Arrays;

public class StudentsDtos {

    public static StudentDTO getStudent1() {
        return createStudent(1L, "Pepe", Arrays.asList(
                new SubjectDTO("Math", 7.0),
                new SubjectDTO("Science", 8.0)
        ));
    }

    public static StudentDTO getStudent2() {
        return createStudent(2L, "Ana", Arrays.asList(
                new SubjectDTO("History", 6.5),
                new SubjectDTO("Biology", 7.8)
        ));
    }

    public static StudentDTO getStudent3() {
        return createStudent(3L, "Luis", Arrays.asList(
                new SubjectDTO("Math", 9.0),
                new SubjectDTO("Physics", 8.5)
        ));
    }

    public static StudentDTO getStudent4() {
        return createStudent(4L, "Maria", Arrays.asList(
                new SubjectDTO("Chemistry", 5.5),
                new SubjectDTO("Literature", 6.0)
        ));
    }

    public static StudentDTO getStudent5Update() {
        return createStudent(4L, "Pedro", Arrays.asList(
                new SubjectDTO("Art", 8.0),
                new SubjectDTO("Music", 9.0)
        ));
    }

    public static StudentDTO getStudent6() {
        return createStudent(6L, "Carla", Arrays.asList(
                new SubjectDTO("Math", 4.5),
                new SubjectDTO("History", 5.0)
        ));
    }

    public static StudentDTO getStudent7() {
        return createStudent(7L, "Juan", Arrays.asList(
                new SubjectDTO("Geography", 7.2),
                new SubjectDTO("English", 8.1)
        ));
    }

    public static StudentDTO getStudent8() {
        return createStudent(8L, "Lucia", Arrays.asList(
                new SubjectDTO("Science", 6.9),
                new SubjectDTO("Math", 7.4)
        ));
    }

    public static StudentDTO getStudent9() {
        return createStudent(9L, "Diego", Arrays.asList(
                new SubjectDTO("Biology", 8.3),
                new SubjectDTO("Chemistry", 7.7)
        ));
    }

    public static StudentDTO getStudent10() {
        return createStudent(10L, "Sofia", Arrays.asList(
                new SubjectDTO("History", 9.5),
                new SubjectDTO("Geography", 8.9)
        ));
    }

    private static StudentDTO createStudent(Long id, String name, java.util.List<SubjectDTO> subjects) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName(name);
        studentDTO.setSubjects(subjects);

        double averageScore = subjects.stream()
                .mapToDouble(SubjectDTO::getScore)
                .average()
                .orElse(0.0);

        studentDTO.setAverageScore(averageScore);

        studentDTO.setMessage(
                "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(averageScore)
                        + ((averageScore > 9) ? ". Felicitaciones!" : ". Puedes mejorar.")
        );

        return studentDTO;
    }
}
