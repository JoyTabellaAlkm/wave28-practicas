package com.meli.obtenerdiploma.unit.factory;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;

public class StudentFactory {
    public static final StudentDTO juanStudentDTO = new StudentDTO(
            1L,
            "Juan",
            "mensaje1",
            4.0,
            createJuanSubjects()
    );

    public static final StudentDTO pedroStudentDTO = new StudentDTO(
            2L,
            "Pedro",
            "mensaje2",
            8.0,
            createPedroSubjects()
    );

    public static final StudentDTO sofiaStudentDTO = new StudentDTO(
            3L,
            "Sofia",
            "mensaje3",
            8.5,
            createSofiaSubjects()
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
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
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
