package org.ejercicios.qatesters.service;

import org.ejercicios.qatesters.dto.TestCaseDto;
import org.ejercicios.qatesters.entity.TestCase;
import org.ejercicios.qatesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TestCaseService implements ITestCaseService{
    @Autowired
    ITestCaseRepository testCaseRepository;

    ModelMapper mapper = new ModelMapper();


    @Override
    public TestCaseDto create(TestCaseDto testCase) {
        TestCase testCase1 = mapper.map(testCase,TestCase.class);
        return mapper.map(testCaseRepository.save(testCase1), TestCaseDto.class);
    }

    @Override
    public List<TestCaseDto> getAll() {
        List<TestCase> testCaseList = testCaseRepository.findAll();
        return testCaseList.stream().map(t -> mapper.map(t, TestCaseDto.class)).toList();
    }

    @Override
    public TestCaseDto getById(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        return mapper.map(testCase, TestCaseDto.class);
    }

    @Override
    public TestCaseDto update(Long id, TestCaseDto testCase) {
        TestCase testCase1 = testCaseRepository.findById(id).orElse(null);
        testCase1.setTested(testCase.getTested());
        testCase1.setDescripcion(testCase.getDescripcion());
        testCase1.setPassed(testCase.getPassed());
        testCase1.setNumberOfTries(testCase.getNumberOfTries());
        testCase1.setLastUpdate(LocalDate.now());

        TestCase testCaseUpd = testCaseRepository.save(testCase1);
        return mapper.map(testCaseUpd, TestCaseDto.class);
    }

    @Override
    public void delete(Long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        assert testCase != null;
        testCaseRepository.delete(testCase);
    }

    @Override
    public List<TestCaseDto> getTestsByLastUpdate(LocalDate date) {
        List<TestCase> testCaseList = testCaseRepository.findByLastUpdateAfter(date);
        return testCaseList.stream().map(t -> mapper.map(t, TestCaseDto.class)).toList();
    }
}