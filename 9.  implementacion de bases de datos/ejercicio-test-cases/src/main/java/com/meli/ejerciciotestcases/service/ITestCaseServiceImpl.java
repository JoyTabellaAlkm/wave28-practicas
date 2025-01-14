package com.meli.ejerciciotestcases.service;

import com.meli.ejerciciotestcases.dto.TestCaseDto;
import com.meli.ejerciciotestcases.model.TestCase;
import com.meli.ejerciciotestcases.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
@Service
public class ITestCaseServiceImpl implements ITestCaseService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ITestCaseRepository testCaseRepository;

    @Override
    public List<TestCaseDto> getTestCases() {
        List<TestCase> allTestCases = testCaseRepository.findAll();
        List<TestCaseDto> testCases = allTestCases.stream().map(t -> modelMapper.map(t, TestCaseDto.class)).toList();
        return testCases;
    }

    @Override
    public void saveTestCase(TestCaseDto testCase) {
        TestCase testCase1 = modelMapper.map(testCase, TestCase.class);
        testCaseRepository.save(testCase1);
    }

    @Override
    public void updateTestCase(Long id, TestCaseDto testCase) {

        System.out.println("id: " + id);

        Optional<TestCase> testCaseToUpdate = testCaseRepository.findById(id);

        System.out.println("testCaseToUpdate: " + testCaseToUpdate);

        if (testCaseToUpdate.isEmpty()) {
            throw new RuntimeException("Test Case does not exist");
        }

        TestCase testCaseFinal = testCaseToUpdate.get();
        testCaseFinal.setDescription(testCase.getDescription());
        testCaseFinal.setLastUpdate(testCase.getLastUpdate());
        testCaseFinal.setNumberOfTries(testCase.getNumberOfTries());
        testCaseFinal.setPassed(testCase.getPassed());
        testCaseFinal.setTested(testCase.getTested());

        testCaseRepository.save(testCaseFinal);
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public TestCaseDto findTestCase(Long id) {
        return modelMapper.map(testCaseRepository.findById(id), TestCaseDto.class);
    }
}
