package com.bootcamp.tester.service;

import com.bootcamp.tester.dto.TestCaseCreationDto;
import com.bootcamp.tester.dto.TestCaseDto;
import com.bootcamp.tester.dto.TestCaseUpdateDto;
import com.bootcamp.tester.entity.TestCase;
import com.bootcamp.tester.exception.NotFoundException;
import com.bootcamp.tester.repository.TestCaseRepository;
import com.bootcamp.tester.util.TestCaseMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;
    @Override
    public TestCaseDto create(TestCaseCreationDto testCaseDto) {
        TestCase nuevo = TestCaseMapper.toTestCase(testCaseDto);
        nuevo.setLastUpdate(LocalDate.now());
        nuevo = testCaseRepository.save(nuevo);
        return TestCaseMapper.toTestCaseDto(nuevo);
    }

    @Override
    public List<TestCaseDto> getAll(Optional<LocalDate> lastUpdate) {
        if(lastUpdate.isPresent()) {
            return testCaseRepository.findAll().stream()
                    .filter(tc -> tc.getLastUpdate().isAfter(lastUpdate.get()))
                    .map(TestCaseMapper::toTestCaseDto)
                    .toList();
        }
        return testCaseRepository.findAll().stream()
                .map(TestCaseMapper::toTestCaseDto)
                .toList();
    }

    @Override
    public TestCaseDto getById(Long id) {
        var testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        return TestCaseMapper.toTestCaseDto(testCase);
    }

    @Override
    public TestCaseDto update(Long id, TestCaseUpdateDto dto) {
        var testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        testCase.setTested(dto.getTested());
        testCase.setDescription(dto.getDescription());
        testCase.setPassed(dto.getPassed());
        testCase.setNumberOfTries(dto.getNumberOfTries());
        testCase.setLastUpdate(LocalDate.now());
        testCaseRepository.save(testCase);
        return TestCaseMapper.toTestCaseDto(testCase);
    }

    @Override
    public void deleteById(Long id) {
        var testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        testCaseRepository.delete(testCase);
    }
}
