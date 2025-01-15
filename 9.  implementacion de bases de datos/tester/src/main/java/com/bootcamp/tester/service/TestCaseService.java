package com.bootcamp.tester.service;

import com.bootcamp.tester.dto.TestCaseCreationDto;
import com.bootcamp.tester.dto.TestCaseDto;
import com.bootcamp.tester.dto.TestCaseUpdateDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TestCaseService {
    TestCaseDto create(TestCaseCreationDto testCaseDto);
    List<TestCaseDto> getAll(Optional<LocalDate> last_updated);
    TestCaseDto getById(Long id);
    TestCaseDto update(Long id, TestCaseUpdateDto dto);
    void deleteById(Long id);
}