package com.example.testcasesapi.service.impl;

import com.example.testcasesapi.dto.request.RequestTestCaseDto;
import com.example.testcasesapi.dto.response.ResponseDto;
import com.example.testcasesapi.model.TestCase;
import com.example.testcasesapi.repository.TestCaseRepository;
import com.example.testcasesapi.service.ITestCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    @Autowired
    private TestCaseRepository testCaseRepository;

    @Override
    public ResponseDto create(RequestTestCaseDto requestTestCaseDto) {
        ModelMapper modelMapper = new ModelMapper();
        TestCase testCase1 = modelMapper.map(requestTestCaseDto, TestCase.class);
        testCase1.setId(null);
        TestCase testCase = testCaseRepository.save(testCase1);
        return new ResponseDto("Se creo correctamente el TestCase con ID: " + testCase.getId());
    }

    @Override
    public List<TestCase> getAll() {
        return testCaseRepository.findAll();
    }

    @Override
    public TestCase show(Long id) {
        Optional<TestCase> testCaseOptional = testCaseRepository.findById(id);
        if (testCaseOptional.isEmpty()){
            throw new RuntimeException("No se encontro el test case");
        }
        return testCaseOptional.get();
    }

    @Override
    public TestCase update(Long id, RequestTestCaseDto requestTestCaseDto) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<TestCase> testCaseOptional = testCaseRepository.findById(id);
        if (testCaseOptional.isEmpty()){
            throw new RuntimeException("No se encontro el test case");
        }

        TestCase testCase = modelMapper.map(requestTestCaseDto, TestCase.class);
        testCase.setId(id);

        return testCaseRepository.save(testCase);
    }

    @Override
    public ResponseDto delete(Long id) {
        Optional<TestCase> testCaseOptional = testCaseRepository.findById(id);
        if (testCaseOptional.isEmpty()){
            throw new RuntimeException("No se encontro el test case");
        }

        testCaseRepository.delete(testCaseOptional.get());
        return new ResponseDto("Se elimino el registro con ID: " + id);
    }

    @Override
    public List<TestCase> getAllByDate(LocalDate lastUpdate) {
        return testCaseRepository.findByLastUpdateAfter(lastUpdate);
    }
}

