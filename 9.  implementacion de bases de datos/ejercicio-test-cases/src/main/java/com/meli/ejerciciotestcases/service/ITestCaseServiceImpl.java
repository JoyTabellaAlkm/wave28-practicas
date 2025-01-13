package com.meli.ejerciciotestcases.service;

import com.meli.ejerciciotestcases.dto.TestCaseDto;
import com.meli.ejerciciotestcases.model.TestCase;
import com.meli.ejerciciotestcases.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public void deleteStudend(long id) {

    }

    @Override
    public TestCaseDto findTestCase(Long id) {
        return modelMapper.map(testCaseRepository.findById(id), TestCaseDto.class);
    }
}
