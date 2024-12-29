package com.obtenerdiploma.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.obtenerdiploma.dto.StudentDTO;
import com.obtenerdiploma.dto.SubjectDTO;
import com.obtenerdiploma.entity.Student;
import com.obtenerdiploma.entity.Subject;
import com.obtenerdiploma.exception.StudentNotFoundException;
import com.obtenerdiploma.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepository studentRepository;

    ObjectMapper mapper= new ObjectMapper();

    @Override
    public boolean create(StudentDTO stu) {

        Student studentEntity = new Student(
                stu.id(),
                stu.studentName(),
                stu.subjects().stream().map(
                        s -> new Subject(s.name(), s.score())
                ).collect(Collectors.toSet())
        );

        return studentRepository.save(studentEntity);
    }

    @Override
    public StudentDTO read(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() ->{throw new StudentNotFoundException(id);
        });
        return new StudentDTO(
                student.getId(),
                student.getStudentName(),
                student.getSubjects().stream().map(
                        subject -> new SubjectDTO(
                                subject.getName(),
                                0D
                        )).collect(Collectors.toSet())
        );
    }



    @Override
    public boolean update(StudentDTO stu) {
        Student studentEntity = new Student(
                stu.id(),
                stu.studentName(),
                stu.subjects().stream().map(
                        s -> new Subject(s.name(), s.score())
                ).collect(Collectors.toSet())
        );

        return studentRepository.save(studentEntity);
    }

    @Override
    public boolean delete(Long id) {
        return studentRepository.delete(id);
    }

    @Override
    public Set<StudentDTO> getAll() {
        return this.studentRepository.findAll().stream()
                .map(
                        s -> new StudentDTO(
                                s.getId(),
                                s.getStudentName(),
                                s.getSubjects().stream().map(
                                        subject -> new SubjectDTO(
                                                subject.getName(),
                                                subject.getScore()
                                        )).collect(Collectors.toSet())
                                )
                        ).collect(Collectors.toSet());
    }

    @Override
    public Optional<StudentDTO> getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        Set<SubjectDTO> subjects = student.get().getSubjects().stream()
                .map(s->new SubjectDTO(s.getName(), s.getScore()))
                .collect(Collectors.toSet());

        return Optional.of(new StudentDTO(student.get().getId(), student.get().getStudentName(), subjects));
    }
}
