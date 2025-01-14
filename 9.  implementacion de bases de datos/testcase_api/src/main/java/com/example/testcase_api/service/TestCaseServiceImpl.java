package com.example.testcase_api.service;

import com.example.testcase_api.dto.TestCaseDTO;
import com.example.testcase_api.exception.NotFoundException;
import com.example.testcase_api.model.TestCase;
import com.example.testcase_api.repository.TestCaseRepository;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements TestCaseService {
    private final TestCaseRepository testCaseRepository;
    private final ModelMapper mapper;

    public TestCaseServiceImpl(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setSkipNullEnabled(true);

    }


    @Override
    public Long createTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = testCaseRepository.save(mapper.map(testCaseDTO,TestCase.class));
        return testCase.getIdCase();
    }


    @Override
    public List<TestCaseDTO> getTestCase() {
        List<TestCaseDTO> testCaseDTOList = testCaseRepository.findAll().stream()
                .map(m->mapper.map(m,TestCaseDTO.class))
                .toList();
        if(testCaseDTOList.isEmpty()){throw new NotFoundException("TestCases not found");}
        return testCaseDTOList;
    }


    @Override
    public TestCaseDTO findTestCaseById(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TestCase with id '" + id + "' not found"));
        return mapper.map(testCase,TestCaseDTO.class);
    }

    @Override
    public Long updateTestCase(Long id, TestCaseDTO testCaseDTO) {
        TestCase testCaseFinded = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("TestCase with id '" + id + "' not found"));
        mapper.map(testCaseDTO, testCaseFinded);
        testCaseRepository.save(testCaseFinded);
        return id;
    }


    @Override
    public Long deleteTestCase(Long id) {
        if (!testCaseRepository.existsById(id)) {
            throw new NotFoundException("TestCase with id '" + id + "' not found");
        }
        testCaseRepository.deleteById(id);
        return id;
    }


    public List<TestCaseDTO> findTestCaseByLastUpdate(LocalDate lastUpdate) {
        List<TestCaseDTO> testCaseDTOList = testCaseRepository.findByLastUpdate(lastUpdate).stream()
                .map(m->mapper.map(m,TestCaseDTO.class))
                .toList();
        if(testCaseDTOList.isEmpty()){throw new NotFoundException("TestCase with date '" + lastUpdate + "' not found");}
        return testCaseDTOList;
    }
}
