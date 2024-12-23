package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    List<StudentDTO> students = new ArrayList<>();

    @Override
    public StudentDTO analyzeScores(StudentDTO rq) {
        rq.setAverageScore(calculateAverage(rq.getSubjects()));
        rq.setMessage(getGreetingMessage(rq.getStudentName(), rq.getAverageScore()));
        students.add(rq);
        return rq;
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

    @Override
    public StudentDTO addStudent(StudentDTO student) {
        students.add(student);
        return student;
    }

    @Override
    public List<StudentDTO> getAll() {
        return students.stream().toList();
    }

    @Override
    public StudentDTO findByName(String student) {
        return students.stream().filter(value -> value.getStudentName().equals(student)).findAny().orElse(null);
    }
}
