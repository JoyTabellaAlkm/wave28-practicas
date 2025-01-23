package com.example.qatesters.service;

import com.example.qatesters.dto.TestCaseRequestDto;
import com.example.qatesters.dto.TestCaseResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCaseResponseDto createPost(TestCaseRequestDto post);
    List<TestCaseResponseDto> getAllPosts();
    TestCaseResponseDto getPostById(Long id);
    TestCaseResponseDto updatePost(Long id, TestCaseRequestDto post);
    String deletePostById(Long id);
    List<TestCaseResponseDto> getPostsByDate(LocalDate date);
}
