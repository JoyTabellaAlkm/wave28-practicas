package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest  {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    IObtenerDiplomaService obtenerDiplomaService;

    @Test
    void testFinalCases(){

    }
}
