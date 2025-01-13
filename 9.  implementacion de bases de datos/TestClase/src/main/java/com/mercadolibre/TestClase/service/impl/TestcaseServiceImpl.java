package com.mercadolibre.TestClase.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.TestClase.dto.request.TestCaseRequestDTO;
import com.mercadolibre.TestClase.dto.response.TestCaseResponseDTO;
import com.mercadolibre.TestClase.entity.TestCase;
import com.mercadolibre.TestClase.repository.ITestcaseRepository;
import com.mercadolibre.TestClase.service.ITestcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestcaseServiceImpl implements ITestcaseService {
    @Autowired
    ITestcaseRepository testcaseRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public TestCaseResponseDTO saveTestcase(TestCaseRequestDTO testcase) {
        TestCase testCaseToSave = objectMapper.convertValue(testcase, TestCase.class);
        TestCase testCaseSaved = testcaseRepository.save(testCaseToSave);
        return objectMapper.convertValue(testCaseSaved, TestCaseResponseDTO.class);
    }

    @Override
    public List<TestCase> findAll() {
        return testcaseRepository.findAll();
    }

    @Override
    public TestCaseResponseDTO findById(Long id) {
        Optional<TestCase> testcase = testcaseRepository.findById(id);
        return objectMapper.convertValue(testcase, TestCaseResponseDTO.class);
    }

    @Override
    public TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testcase) {
        Optional<TestCase> testCaseToUpdateOptional = testcaseRepository.findById(id);
        if (testCaseToUpdateOptional.isEmpty()) {
            return null;
        }

        TestCase testCaseToUpdate = testCaseToUpdateOptional.get();

        testCaseToUpdate.setTested(testcase.getTested());
        testCaseToUpdate.setPassed(testcase.getPassed());
        testCaseToUpdate.setLast_update(testcase.getLast_update());
        testCaseToUpdate.setDescription(testcase.getDescription());
        testCaseToUpdate.setNumber_of_tries(testcase.getNumber_of_tries());

        TestCase updatedTestCase = testcaseRepository.save(testCaseToUpdate);

        return objectMapper.convertValue(updatedTestCase, TestCaseResponseDTO.class);
    }

    @Override
    public String deleteTestCase(Long id) {
        Optional<TestCase> testCaseToDeleteOptional = testcaseRepository.findById(id);
        if (testCaseToDeleteOptional.isEmpty()) {
            throw new RuntimeException("No existe");
        }

        testcaseRepository.delete(testCaseToDeleteOptional.get());

        return "Se borro correctamente";
    }

    @Override
    public List<TestCase> findByLastUpdate(String lastUpdate) {
        List<TestCase> testcases = testcaseRepository.findAll();
        return testcases.stream()
                .filter(testCase -> testCase.getLast_update().equals(lastUpdate))
                .collect(Collectors.toList());
    }
}
