package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    private final List<StudentDTO> studentsList = new ArrayList<>();
    @Override
    public StudentDTO analyzeScores(StudentDTO rq) {
        rq.setAverageScore(calculateAverage(rq.getSubjects()));
        rq.setMessage(getGreetingMessage(rq.getStudentName(), rq.getAverageScore()));

        return rq;
    }

    @Override
    public StudentDTO addStudent(StudentDTO rq) {
        StudentDTO student = new StudentDTO();

        student.setStudentName(rq.getStudentName());
        student.setSubjects(rq.getSubjects());

        studentsList.add(student);
        return student;
    }

    @Override
    public StudentDTO getNameRqParam(String studentName) {
        StudentDTO student = studentsList.stream()
                .filter(s -> s.getStudentName().equals(studentName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("El estudiante no existe."));

        return student;
    }

    @Override
    public StudentDTO getName(String studentName) {
        StudentDTO student = studentsList.stream()
                .filter(s -> s.getStudentName().equals(studentName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("El estudiante no existe."));

        return student;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }


}
