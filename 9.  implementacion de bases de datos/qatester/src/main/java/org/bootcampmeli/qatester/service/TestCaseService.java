package org.bootcampmeli.qatester.service;


import org.bootcampmeli.qatester.dto.MessageDto;
import org.bootcampmeli.qatester.dto.TestCaseDto;

import java.util.List;

public interface TestCaseService {

    TestCaseDto createTestCase(TestCaseDto testCaseDto);


    List<TestCaseDto> getAllTestCases();

    TestCaseDto findById(Long id);

    TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto);

    MessageDto deleteTestCase(Long id);

    List<TestCaseDto> filterByDate(String date);
}
