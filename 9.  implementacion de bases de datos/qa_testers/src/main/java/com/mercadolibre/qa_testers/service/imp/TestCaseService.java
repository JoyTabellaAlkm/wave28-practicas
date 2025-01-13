package com.mercadolibre.qa_testers.service.imp;

import com.mercadolibre.qa_testers.dto.MessageDTO;
import com.mercadolibre.qa_testers.dto.NewTestCaseDTO;
import com.mercadolibre.qa_testers.dto.TestCaseDTO;
import com.mercadolibre.qa_testers.model.TestCase;
import com.mercadolibre.qa_testers.repository.TestCaseRepository;
import com.mercadolibre.qa_testers.service.ITestCase;
import com.mercadolibre.qa_testers.util.Utils;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class TestCaseService implements ITestCase {
    @Autowired
    private TestCaseRepository testCaseRepository;

    @Override
    public TestCaseDTO save(NewTestCaseDTO testCaseDTO) {
        TestCase testCase = Utils.getModelMapper().map(testCaseDTO, TestCase.class);
        TestCase response = testCaseRepository.save(testCase);
        return Utils.getModelMapper().map(response, TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> getAll() {
        List<TestCase> response = testCaseRepository.findAll();
        return response.stream().map(r -> Utils.getModelMapper().map(r, TestCaseDTO.class)).toList();
    }

    @Override
    public TestCaseDTO findById(Long id) {
        Optional<TestCase> response = testCaseRepository.findById(id);
        return response.map(testCase -> Utils.getModelMapper().map(testCase, TestCaseDTO.class)).orElse(null);
    }

    @Override
    public TestCaseDTO edit(Long id, TestCaseDTO testCaseDTO) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);
        if (testCase.isEmpty()) return null;
        TestCase newTestCase = Utils.getModelMapper().map(testCaseDTO, TestCase.class);
        newTestCase.setId_case(id);
        return Utils.getModelMapper().map(testCaseRepository.save(newTestCase), TestCaseDTO.class);
    }

    @Override
    public MessageDTO delete(Long id) {
        TestCaseDTO testCase = findById(id);
        if(testCase == null) return new MessageDTO("No existe el testCase con id: " + id);
        testCaseRepository.deleteById(id);
        return new MessageDTO("testCase "+ id + " eliminado.");
    }

    @Override
    public List<TestCaseDTO> filter(LocalDate date) {
        List<TestCase> response = testCaseRepository.findByLastUpdateAfter(date);
        return response.stream().map(r -> Utils.getModelMapper().map(r, TestCaseDTO.class)).toList();
    }
}
