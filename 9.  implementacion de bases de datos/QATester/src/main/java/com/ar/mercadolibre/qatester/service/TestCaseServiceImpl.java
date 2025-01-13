package com.ar.mercadolibre.qatester.service;

import com.ar.mercadolibre.qatester.dto.MessageDTO;
import com.ar.mercadolibre.qatester.dto.TestCaseDTO;
import com.ar.mercadolibre.qatester.entity.TestCase;
import com.ar.mercadolibre.qatester.exceptions.NotFoundException;
import com.ar.mercadolibre.qatester.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements ITestCaseService{
    private final ITestCaseRepository testCaseRepository;
    private final ObjectMapper mapper;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        this.mapper = new ObjectMapper();
        // Esto asegura que las fechas sean procesadas correctamente por Jackson. (por el cambio de formato en que se guarda a el que se envía)
        mapper.registerModule(new JavaTimeModule());;
    }

    @Override
    public TestCaseDTO createTestCase(TestCaseDTO testCaseDTO) {
        TestCase newTestCase =  mapper.convertValue(testCaseDTO, TestCase.class);
        newTestCase.setLastUpdate(LocalDate.now());

        return mapper.convertValue(testCaseRepository.save(newTestCase), TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> findAll() {
        List<TestCase> testCaseList = testCaseRepository.findAll();
        List<TestCaseDTO> foundTestCases = testCaseList.stream().map(testCase -> mapper.convertValue(testCase, TestCaseDTO.class)).toList();

        if(foundTestCases.isEmpty()) {
            throw new NotFoundException("No Test cases have been found with the provided last update date");
        }

        return foundTestCases;
    }

    @Override
    public TestCaseDTO findById(Long id) {
        TestCase existingTestCase = validateTestCase(id);
        return mapper.convertValue(existingTestCase, TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO update(Long id, TestCaseDTO testCaseDTO) {
        validateTestCase(id);

        TestCase testCaseToUpdate = mapper.convertValue(testCaseDTO, TestCase.class);
        testCaseToUpdate.setIdCase(id);
        testCaseToUpdate.setLastUpdate(LocalDate.now());
        TestCase savedTested = testCaseRepository.save(testCaseToUpdate);

        return mapper.convertValue(savedTested, TestCaseDTO.class);
    }

    @Override
    public MessageDTO delete(Long id) {
        validateTestCase(id);
        testCaseRepository.deleteById(id);

        return new MessageDTO("The test case has been erased");
    }

    @Override
    public List<TestCaseDTO> findAfterLastUpdate(String lastUpdate) {
        String[] date = lastUpdate.split("-");
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        LocalDate filerDate = LocalDate.of(year, month, day);
        List<TestCase> testCaseList = testCaseRepository.findByLastUpdateAfter(filerDate);

        List<TestCaseDTO> foundTestCases = testCaseList.stream().map(testCase -> mapper.convertValue(testCase, TestCaseDTO.class)).toList();

        if(foundTestCases.isEmpty()) {
            throw new NotFoundException("No Test cases have been found with the provided last update date");
        }

        return foundTestCases;
    }

    private TestCase validateTestCase(Long id) {
        Optional<TestCase> existingTestCase = testCaseRepository.findById(id);
        if(existingTestCase.isEmpty()) {
            throw new NotFoundException("No Test Case found with the provided id");
        }

        return existingTestCase.get();
    }

}
