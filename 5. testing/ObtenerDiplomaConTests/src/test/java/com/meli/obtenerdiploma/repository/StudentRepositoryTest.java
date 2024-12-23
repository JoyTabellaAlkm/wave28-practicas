package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Set;

@SpringBootTest

public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    //@Value("${api.scope}")
    //private String SCOPE;

    @Test
    public void testFindAll(){
        Set<StudentDTO> studentDTOSet = studentRepository.findAll();
        assertThat(studentDTOSet).isNotNull();
        assertThat(studentDTOSet).isNotEmpty();
        assertThat(studentDTOSet.size()).isGreaterThan(0);
        assertThat(studentDTOSet).anyMatch(s->s.getStudentName().equals("Juan"));

    }
}
