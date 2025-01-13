package com.bootcamp.testcase.service;

import com.bootcamp.testcase.dto.request.CreateTestCaseDTO;
import com.bootcamp.testcase.dto.request.UpdateTestCaseDTO;
import com.bootcamp.testcase.dto.response.TestCaseDTO;

import java.util.List;

public interface TestCaseService {
    List<TestCaseDTO> findAll();
    List<TestCaseDTO> findAllAfterLastUpdateDate(String last_update);
    TestCaseDTO create(CreateTestCaseDTO createTestCaseDTO);
    TestCaseDTO findById(Long id);
    TestCaseDTO updateById(Long id, UpdateTestCaseDTO updateTestCaseDTO);
    TestCaseDTO deleteById(Long id);
}
