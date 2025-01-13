package org.bootcampmeli.qatester.service;

import org.bootcampmeli.qatester.dto.MessageDto;
import org.bootcampmeli.qatester.dto.TestCaseDto;
import org.bootcampmeli.qatester.model.TestCase;
import org.bootcampmeli.qatester.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    private TestCaseRepository testCaseRepository;


    private ModelMapper modelMapper;


    public TestCaseServiceImpl(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public TestCaseDto createTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = modelMapper.map(testCaseDto, TestCase.class);
        TestCase testResponse = this.testCaseRepository.save(testCase);
        testCaseDto.setId(testResponse.getIdCase());
        return testCaseDto;
    }

    @Override
    public List<TestCaseDto> getAllTestCases() {
        List<TestCase> testCases = this.testCaseRepository.findAll();
        return testCases.stream().map(testCase -> modelMapper.map(testCase, TestCaseDto.class)).collect(Collectors.toList());
    }

    @Override
    public TestCaseDto findById(Long id){
        TestCase testCase = this.testCaseRepository.findById(id).orElse(null);
        if (testCase == null) {
            return null;
        }
        return modelMapper.map(testCase, TestCaseDto.class);
    }


    @Override
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto){
        TestCase testCase = this.testCaseRepository.findById(id).orElse(null);
        if (testCase == null) {
            return null;
        }
        testCaseDto.setId(id);
        TestCase caseResponse = this.testCaseRepository.save(modelMapper.map(testCaseDto, TestCase.class));
        return modelMapper.map(caseResponse, TestCaseDto.class);
    }


    @Override
    public MessageDto deleteTestCase(Long id){
        TestCase testCase = this.testCaseRepository.findById(id).orElse(null);
        if (testCase == null) {
            return null;
        }
        this.testCaseRepository.delete(testCase);
        return new MessageDto("Eliminado exitosamente");
    }

    @Override
    public List<TestCaseDto> filterByDate(String date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(date, formatter);

        List<TestCase> testCases = this.testCaseRepository.findAll();
        List<TestCase> filteredTest = testCases.stream().filter(t -> t.getLastUpdate().isAfter(fecha)).toList();
        return filteredTest.stream().map(testCase -> modelMapper.map(testCase, TestCaseDto.class)).collect(Collectors.toList());

    }

}
