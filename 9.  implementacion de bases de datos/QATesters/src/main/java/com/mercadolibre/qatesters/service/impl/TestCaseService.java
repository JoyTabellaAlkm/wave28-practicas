package com.mercadolibre.qatesters.service.impl;

import com.mercadolibre.qatesters.dto.TestCaseDto;
import com.mercadolibre.qatesters.model.TestCase;
import com.mercadolibre.qatesters.repository.ITestCaseRepository;
import com.mercadolibre.qatesters.service.ITestCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public TestCaseService(ITestCaseRepository testCaseRepository){
        this.testCaseRepository = testCaseRepository;
    }


    @Override
    public void post(TestCaseDto testCaseDto) {
        TestCase testCase = new TestCase();
        modelMapper.map(testCaseDto, testCase);
        testCaseRepository.save(testCase);
    }

    @Override
    public List<TestCaseDto> getAll() {
        return testCaseRepository.findAll()
                .stream()
                .map(x -> modelMapper.map(x, TestCaseDto.class))
                .toList();
    }

    @Override
    public TestCaseDto getById(Long id) {
        return modelMapper.map(testCaseRepository.findById(id), TestCaseDto.class);
    }

    @Override
    public void put(Long id, TestCaseDto testCaseDto) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encuentra el test con ese id."));
        modelMapper.map(testCaseDto, testCase);
        testCaseRepository.save(testCase);
    }

    @Override
    public void delete(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCaseDto> filter(LocalDate lastUpdate) {
        return testCaseRepository.findTestCaseByLastUpdateAfter(lastUpdate)
                .stream()
                .map(x -> modelMapper.map(x, TestCaseDto.class))
                .toList();
    }
}
