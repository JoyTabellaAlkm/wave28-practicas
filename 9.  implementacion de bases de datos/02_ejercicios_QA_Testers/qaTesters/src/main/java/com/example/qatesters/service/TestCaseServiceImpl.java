package com.example.qatesters.service;

import com.example.qatesters.dto.TestCaseRequestDto;
import com.example.qatesters.dto.TestCaseResponseDto;
import com.example.qatesters.model.TestCase;
import com.example.qatesters.repository.ITestCaseRepository;
import com.example.qatesters.util.Utils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements ITestCaseService{

    private final ITestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository){
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseResponseDto createPost(TestCaseRequestDto post) {
        TestCase testCase = Utils.getModelMapper().map(post, TestCase.class);
        TestCase testCaseInsert = testCaseRepository.save(testCase);

        return Utils.getModelMapper().map(testCaseInsert, TestCaseResponseDto.class);
    }

    @Override
    public List<TestCaseResponseDto> getAllPosts() {
        List<TestCase> testCases = testCaseRepository.findAll();
        return testCases.stream()
                .map(testCase -> Utils.getModelMapper().map(testCase, TestCaseResponseDto.class))
                .toList();
    }

    @Override
    public TestCaseResponseDto getPostById(Long id) {
        Optional<TestCase> testCaseFind = testCaseRepository.findById(id);
        return testCaseFind.map(testCase -> Utils.getModelMapper().map(testCase, TestCaseResponseDto.class))
                .orElse(null);
    }

    @Override
    public TestCaseResponseDto updatePost(Long id, TestCaseRequestDto post) {
        Optional<TestCase> testCaseFind = testCaseRepository.findById(id);

        if(testCaseFind.isPresent()){
            TestCase testCase =  Utils.getModelMapper().map(post, TestCase.class);
            testCase.setIdCase(id);
            return Utils.getModelMapper().map(testCaseRepository.save(Utils.getModelMapper().map(testCase, TestCase.class)), TestCaseResponseDto.class);
        }
        return null;
    }

    @Override
    public String deletePostById(Long id) {
        Optional<TestCase> testCaseFind = testCaseRepository.findById(id);

        if(testCaseFind.isPresent()){
            testCaseRepository.deleteById(id);
            return "Post eliminado correctamente.";
        }
        return "El post con ese id no existe.";
    }

    @Override
    public List<TestCaseResponseDto> getPostsByDate(LocalDate date) {

        List<TestCase> testCase = testCaseRepository.findByLastUpdateAfter(date);

        return testCase.stream().map(testCase1 -> Utils.getModelMapper().map(testCase1, TestCaseResponseDto.class)).toList();
    }
}
