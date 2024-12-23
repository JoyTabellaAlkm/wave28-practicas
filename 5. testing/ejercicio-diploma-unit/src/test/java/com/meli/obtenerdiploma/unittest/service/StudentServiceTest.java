package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    IObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void findNotFoundStudent() {
        Long id = 4L;
        
    }
}
