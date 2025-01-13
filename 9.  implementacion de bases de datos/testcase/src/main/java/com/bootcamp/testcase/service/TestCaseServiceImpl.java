package com.bootcamp.testcase.service;

import com.bootcamp.testcase.dto.request.CreateTestCaseDTO;
import com.bootcamp.testcase.dto.request.UpdateTestCaseDTO;
import com.bootcamp.testcase.dto.response.TestCaseDTO;
import com.bootcamp.testcase.exception.BadRequestException;
import com.bootcamp.testcase.exception.TestCaseNotFoundException;
import com.bootcamp.testcase.model.TestCase;
import com.bootcamp.testcase.repository.TestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements TestCaseService {
    TestCaseRepository testCaseRepository;
    ObjectMapper objectMapper;

    @Autowired
    public TestCaseServiceImpl(ObjectMapper objectMapper, TestCaseRepository testCaseRepository) {
        this.objectMapper = objectMapper;
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseDTO create(CreateTestCaseDTO createTestCaseDTO) {
        TestCase testCase = objectMapper.convertValue(createTestCaseDTO, TestCase.class);
        TestCase createdTestCase = testCaseRepository.save(testCase);
        return objectMapper.convertValue(createdTestCase, TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> findAll() {
        return testCaseRepository.findAll()
                .stream()
                .map(testCase -> objectMapper.convertValue(testCase, TestCaseDTO.class))
                .toList();
    }

    @Override
    public List<TestCaseDTO> findAllAfterLastUpdateDate(String last_update) {
        LocalDate minDate = convertirStringAFecha(last_update);
        return testCaseRepository.findAll()
                .stream()
                .filter(test -> test.getLastUpdate().isAfter(minDate))
                .map(testCase -> objectMapper.convertValue(testCase, TestCaseDTO.class))
                .toList();
    }

    @Override
    public TestCaseDTO findById(Long id) {
        Optional<TestCase> optionalTestCase = testCaseRepository.findById(id);
        if(optionalTestCase.isPresent()) {
            return objectMapper.convertValue(optionalTestCase.get(), TestCaseDTO.class);
        }
        throw new TestCaseNotFoundException("No se encontró el Test con el id: " + id);
    }

    @Override
    public TestCaseDTO updateById(Long id, UpdateTestCaseDTO updateTestCaseDTO) {
        Optional<TestCase> optionalTestCase = testCaseRepository.findById(id);
        if(optionalTestCase.isEmpty()) {
            throw new TestCaseNotFoundException("No se encontró el Test con el id: " + id);
        }
        TestCase testCase = optionalTestCase.get();
        testCase.setIdCase(id);
        testCase.setDescription(updateTestCaseDTO.getDescription());
        testCase.setTested(updateTestCaseDTO.getTested());
        testCase.setPassed(updateTestCaseDTO.getPassed());
        testCase.setNumberOfTries(updateTestCaseDTO.getNumberOfTries());
        testCase.setLastUpdate(updateTestCaseDTO.getLastUpdate());
        testCaseRepository.save(testCase);
        return objectMapper.convertValue(testCase, TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO deleteById(Long id) {
        Optional<TestCase> optionalTestCase = testCaseRepository.findById(id);
        if(optionalTestCase.isEmpty()) {
            throw new TestCaseNotFoundException("No se encontró el Test con el id: " + id);
        }
        testCaseRepository.deleteById(id);
        return objectMapper.convertValue(optionalTestCase.get(), TestCaseDTO.class);
    }

    private LocalDate convertirStringAFecha(String fechaString) {
        // Define el patrón del formato de la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            // Intenta convertir la cadena al objeto LocalDate
            return LocalDate.parse(fechaString, formatter);
        } catch (DateTimeParseException e) {
            // Maneja el error si el formato de la cadena no es válido
            throw new BadRequestException("El formato de la fecha \""
                    + fechaString + "\" no es válido." );
        }
    }
}
