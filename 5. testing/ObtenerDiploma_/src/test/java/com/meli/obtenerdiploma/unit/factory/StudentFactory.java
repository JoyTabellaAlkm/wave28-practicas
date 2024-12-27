package com.meli.obtenerdiploma.unit.factory;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;

public class StudentFactory {
    public static StudentDTO createJuanStudentDTO() {
        StudentDTO juanStudentDTO = new StudentDTO();
        juanStudentDTO.setId(1L);
        juanStudentDTO.setStudentName("Juan");
        juanStudentDTO.setSubjects(createJuanSubjects());

        return juanStudentDTO;
    }

    public static StudentDTO createPedroStudentDTO() {
        StudentDTO pedroStudentDTO = new StudentDTO();
        pedroStudentDTO.setId(2L);
        pedroStudentDTO.setStudentName("Pedro");
        pedroStudentDTO.setSubjects(createPedroSubjects());

        return pedroStudentDTO;
    }

    public static StudentDTO createSofiaStudentDTO() {
        StudentDTO sofiaStudentDTO = new StudentDTO();
        sofiaStudentDTO.setId(3L);
        sofiaStudentDTO.setStudentName("Sofia");
        sofiaStudentDTO.setSubjects(createSofiaSubjects());

        return sofiaStudentDTO;
    }

    public static StudentDTO createInvalidStudentDTO() {
        StudentDTO sofiaStudentDTO = new StudentDTO();
        sofiaStudentDTO.setId(4L);

        return sofiaStudentDTO;
    }

    public static final StudentDTO juanStudentWithScoresDTO = new StudentDTO(
            1L,
            "Juan",
            "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
            (double) 22 / 3,
            createJuanSubjects()
    );

    public static final StudentDTO pedroStudentWithScoresDTO = new StudentDTO(
            2L,
            "Pedro",
            "El alumno Pedro ha obtenido un promedio de 9,33. Felicitaciones!",
            (double) 28 / 3,
            createPedroSubjects()
    );

    private static List<SubjectDTO> createJuanSubjects() {
        return List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        );
    }

    private static List<SubjectDTO> createPedroSubjects() {
        return List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 9.0),
                new SubjectDTO("Química", 9.0)
        );
    }

    private static List<SubjectDTO> createSofiaSubjects() {
        return List.of(
                new SubjectDTO("Matemática", 8.5),
                new SubjectDTO("Física", 8.5),
                new SubjectDTO("Química", 8.5)
        );
    }
}
