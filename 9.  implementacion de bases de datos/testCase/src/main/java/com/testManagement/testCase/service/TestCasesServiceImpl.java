package com.testManagement.testCase.service;

import com.testManagement.testCase.dto.request.NewTestCaseDTO;
import com.testManagement.testCase.dto.response.MessageDTO;
import com.testManagement.testCase.dto.response.TestCaseDTO;
import com.testManagement.testCase.exception.NotFoundException;
import com.testManagement.testCase.model.TestCase;
import com.testManagement.testCase.repository.ITestcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.testManagement.testCase.utils.MapperTestCases.toDTO;
import static com.testManagement.testCase.utils.MapperTestCases.toEntity;

@Service
public class TestCasesServiceImpl implements ITestCasesService{

    @Autowired
    ITestcaseRepository testcaseRepository;

    @Override
    public TestCaseDTO createTestCase(NewTestCaseDTO testCaseDTO) {
        TestCase testCase = toEntity(testCaseDTO);
        TestCaseDTO testCaseDTO1 = toDTO(testcaseRepository.save(testCase));

        return testCaseDTO1;
    }

    @Override
    public List<TestCaseDTO> getAllTestCases() {
        List<TestCaseDTO> testCases = testcaseRepository.findAll().stream()
                .map(t -> toDTO(t))
                .toList();

        return testCases;
    }

    @Override
    public TestCaseDTO getById(Long id) {
        TestCase testCase = testcaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró un test con el id: " +id));
        return toDTO(testCase);
    }

    @Override
    public TestCaseDTO update(NewTestCaseDTO testCaseDTO, Long id) {
        TestCase testCase = testcaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró un test con el id: " +id));

        TestCase testCaseTomodify = toEntity(testCaseDTO);
        testCaseTomodify.setIdCase(id);

        return toDTO(testcaseRepository.save(testCaseTomodify));

    }

    @Override
    public MessageDTO deleteById(Long id) {
        TestCase testCase = testcaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró un test con el id: " +id));

        testcaseRepository.deleteById(id);
        return new MessageDTO("Se eliminó correctamente el TestCase con id: " +id);
    }

    @Override
    public List<TestCaseDTO> getTestCasesWithFilter(LocalDate date) {
        List<TestCaseDTO> testCases = testcaseRepository.findTestCasesUpdatedAfter(date)
                .stream().map( t -> toDTO(t))
                .toList();
        return testCases;
    }
}
