package com.meli.obtenerdiploma.factory;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentFactory {

    public static StudentDTO createStudent() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Student");
        studentDTO.setSubjects(createSubjects(2));

        return studentDTO;
    }

    public static Set<StudentDTO> createStudents(int number) {
        Set<StudentDTO> studentsDto = new HashSet<>();
        for (int i = 1; i <= number; i++) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId((long) i);
            studentDTO.setStudentName("Student " + 1);
            studentDTO.setSubjects(createSubjects(i));
        }
        return studentsDto;
    }

    private static List<SubjectDTO> createSubjects(int number) {
        List<SubjectDTO> subjectsDto = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            subjectsDto.add(new SubjectDTO("Subject " + i, Math.random() * 10));
        }
        return subjectsDto;
    }
}
