package com.bootcamp.ejercicio_testers.service;

import com.bootcamp.ejercicio_testers.dto.TestCaseDTO;
import com.bootcamp.ejercicio_testers.exception.NotFoundException;
import com.bootcamp.ejercicio_testers.model.TestCase;
import com.bootcamp.ejercicio_testers.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TestCaseDTO createTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        TestCase savedTestCase = testCaseRepository.save(testCase);
        return modelMapper.map(savedTestCase, TestCaseDTO.class);
    }

    public List<TestCaseDTO> getAllTestCases() {
        return testCaseRepository.findAll()
                .stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .toList();
    }

    public TestCaseDTO getTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha" +
                " encontrado el testCase con id: " + id));

        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    public TestCaseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO) {
        TestCase existingTestCase =
                testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha" +
                        " encontrado el testCase con id: " + id));

        modelMapper.map(testCaseDTO, existingTestCase);
        existingTestCase.setIdCase(id);
        TestCase updatedTestCase = testCaseRepository.save(existingTestCase);
        return modelMapper.map(updatedTestCase, TestCaseDTO.class);
    }

    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    public List<TestCaseDTO> getTestCasesUpdatedAfter(LocalDate date) {
        return testCaseRepository.findByLastUpdateAfter(date)
                .stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .toList();
    }
}
