package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.Student;
import com.meli.obtenerdiploma.model.Subject;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    //@Autowired
    //IStudentDAO studentDAO;

    @Override
    public Student analyzeScores(Long studentId) {
        //StudentDTO stu = studentDAO.findById(studentId);

        //stu.setAverageScore(calculateAverage(stu.getSubjects()));
        //stu.setMessage(getGreetingMessage(stu.getStudentName(), stu.getAverageScore()));

        //return stu;
        return null;
    }

    private String getGreetingMessage(String studentName, Double average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private Double calculateAverage(List<Subject> scores) {
        return scores.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / scores.size();
    }
}
