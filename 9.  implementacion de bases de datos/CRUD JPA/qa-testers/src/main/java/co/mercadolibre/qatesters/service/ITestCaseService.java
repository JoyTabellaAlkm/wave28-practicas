package co.mercadolibre.qatesters.service;

import co.mercadolibre.qatesters.dto.DeleteResponseDto;
import co.mercadolibre.qatesters.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    TestCaseDto newTest(TestCaseDto testCaseDto);

    List<TestCaseDto> getAllTest(LocalDate lastUpdate);

    TestCaseDto getTestById(Long id);

    TestCaseDto updateTestCase(Long id, TestCaseDto test);

    DeleteResponseDto deleteTestCase(Long id);

    List<TestCaseDto> getAllTestByDate(LocalDate lastUpdate);
}
