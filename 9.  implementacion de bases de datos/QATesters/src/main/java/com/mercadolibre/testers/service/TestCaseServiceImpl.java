package com.mercadolibre.testers.service;

import com.mercadolibre.testers.dto.CreateTestCaseDTO;
import com.mercadolibre.testers.dto.MessageDTO;
import com.mercadolibre.testers.dto.TestCaseDTO;
import com.mercadolibre.testers.entity.TestCase;
import com.mercadolibre.testers.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public MessageDTO createTestCase(CreateTestCaseDTO test) {
        TestCase testCase = new TestCase();
        modelMapper.map(test, testCase);

        testCaseRepository.save(testCase);
        return new MessageDTO("TestCase con identificatorio " + testCase.getIdCase() + " creado exitosamente.");
    }

    @Override
    public List<TestCaseDTO> findAllTestCases() {
        return testCaseRepository.findAll()
                .stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .toList();
    }

    @Override
    public TestCaseDTO findTestCaseById(Long id) {
        TestCaseDTO testCaseDTO = new TestCaseDTO();
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        modelMapper.map(testCase, testCaseDTO);

        return testCaseDTO;
    }

    @Override
    public MessageDTO updateTestCase(Long id, CreateTestCaseDTO test) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if (testCase == null) {
            return new MessageDTO("No existe el TestCase");
        }

        testCase.setDescription(test.getDescription());
        testCase.setTested(test.getTested());
        testCase.setPassed(test.getPassed());
        testCase.setNumberOfTries(test.getNumberOfTries());
        testCase.setLastUpdate(test.getLastUpdate());

        testCaseRepository.save(testCase);
        return new MessageDTO("TestCase con identificatorio " + testCase.getIdCase() + " actualizado exitosamente.");
    }

    @Override
    public MessageDTO deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
        return new MessageDTO("TestCase con identificatorio " + id + " actualizado exitosamente.");
    }

    @Override
    public List<TestCaseDTO> findTestCasesAfterDate(LocalDate date) {
        return testCaseRepository.findByLastUpdateAfter(date)
                .stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .toList();
    }
}
