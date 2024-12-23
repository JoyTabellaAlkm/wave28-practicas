package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.iObtenerDiplomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {


    @Autowired
    iObtenerDiplomaRepository repository;

    @Override
    public StudentDTO analyzeScores(StudentDTO rq) {
        rq.setAverageScore(calculateAverage(rq.getSubjects()));
        rq.setMessage(getGreetingMessage(rq.getStudentName(), rq.getAverageScore()));
        repository.addStudent(rq);
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
        return repository.addStudent(student);
    }

    @Override
    public List<StudentDTO> getAll() {
        return repository.getAll();
    }

    @Override
    public StudentDTO findByName(String student) {
        StudentDTO s = repository.findByName(student);
        if(s != null)
            return s;
        throw new RuntimeException("no se encontro el alumno");

    }

    @Override
    public String deleteByName(String name) {
        if(repository.deleteByName(name))
            return "Alumno eliminado con éxito";
        return "hubo un problema eliminando al alumno";
    }
}
