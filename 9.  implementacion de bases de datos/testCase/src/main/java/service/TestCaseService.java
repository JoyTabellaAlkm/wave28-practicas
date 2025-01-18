package service;

import dto.TestCaseDTO;
import model.TestCase;
import repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService {
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private TestCaseRepository testCaseRepository;

    public TestCaseDTO createTestCase(TestCase testCase) {
        return modelMapper.map(testCaseRepository.save(testCase), TestCaseDTO.class);
    }

    public List<TestCase> getAllTestCases() {
        return testCaseRepository.findAll();
    }

    public TestCase getTestCaseById(Long id) {
        return testCaseRepository.findById(id).orElse(null);
    }

    public TestCaseDTO updateTestCase(Long id, TestCase testCase) {
        testCase.setId_case(id);
        return modelMapper.map(testCaseRepository.save(testCase), TestCaseDTO.class);
    }

    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    public List<TestCase> findTestCasesByLastUpdate(LocalDate date) {
        return testCaseRepository.findByLast_updateAfter(date);
    }

}