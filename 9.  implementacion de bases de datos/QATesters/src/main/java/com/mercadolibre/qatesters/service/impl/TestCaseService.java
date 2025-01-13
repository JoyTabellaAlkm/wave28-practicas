package com.mercadolibre.qatesters.service.impl;

import com.mercadolibre.qatesters.dto.request.TestCaseRequestDto;
import com.mercadolibre.qatesters.dto.response.TestCaseResponseDto;
import com.mercadolibre.qatesters.entity.TestCase;
import com.mercadolibre.qatesters.repository.ITestCaseRepository;
import com.mercadolibre.qatesters.service.ITestCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;
    private final ModelMapper mapper;
    private final ModelMapper modelMapper;

    public TestCaseService(ITestCaseRepository testCaseRepository, ModelMapper mapper, ModelMapper modelMapper) {
        this.testCaseRepository = testCaseRepository;
        this.mapper = mapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public TestCaseResponseDto save(TestCaseRequestDto testCaseRequestDto) {
        TestCase testCaseToSave = mapper.map(testCaseRequestDto, TestCase.class);
        return modelMapper.map(testCaseRepository.save(testCaseToSave), TestCaseResponseDto.class);
    }

    @Override
    public List<TestCaseResponseDto> findAll(String lastUpdate) {
        List<TestCase> testCases;

        if (lastUpdate != null) {
            LocalDate dateToQuery = parseDate(lastUpdate);
            testCases = testCaseRepository.findByLastUpdateIsAfter(dateToQuery);
        } else {
            testCases = testCaseRepository.findAll();
        }

        return testCases.stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseResponseDto.class))
                .toList();
    }

    @Override
    public TestCaseResponseDto findById(Long id) {
        return modelMapper.map(findTestCaseById(id), TestCaseResponseDto.class);
    }

    @Override
    public TestCaseResponseDto update(TestCaseRequestDto testCaseRequestDto, Long id) {
        TestCase testCaseToUpdate = findTestCaseById(id);

        testCaseToUpdate.setDescription(testCaseRequestDto.getDescription());
        testCaseToUpdate.setPassed(testCaseRequestDto.getPassed());
        testCaseToUpdate.setTested(testCaseRequestDto.getTested());
        testCaseToUpdate.setNumberOfTries(testCaseRequestDto.getNumberOfTries());
        testCaseToUpdate.setLastUpdate(LocalDate.now());

        TestCase updatedTestCase = testCaseRepository.save(testCaseToUpdate);

        return modelMapper.map(updatedTestCase, TestCaseResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        TestCase testCaseToDelete = findTestCaseById(id);
        testCaseRepository.delete(testCaseToDelete);
    }

    private TestCase findTestCaseById(Long id) {
        return testCaseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No se encontró el Test Case con id " + id)
        );
    }

    private LocalDate parseDate(String dateString) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(dateString, dateFormatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha no valido, debe ser dd/MM/yyyy");
        }
    }
}
