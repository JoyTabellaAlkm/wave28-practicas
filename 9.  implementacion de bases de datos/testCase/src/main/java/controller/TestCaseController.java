package controller;

import dto.TestCaseDTO;
import model.TestCase;
import service.TestCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/testcases")
public class TestCaseController {
    @Autowired
    private TestCaseService testCaseService;

    private final ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/new")
    public TestCaseDTO createTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        TestCaseDTO savedTestCase = testCaseService.createTestCase(testCase);
        return modelMapper.map(savedTestCase, TestCaseDTO.class);
    }

    @GetMapping
    public List<TestCaseDTO> getAllTestCases() {
        return testCaseService.getAllTestCases().stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TestCaseDTO getTestCaseById(@PathVariable Long id) {
        TestCase testCase = testCaseService.getTestCaseById(id);
        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    @PutMapping("/{id}")
    public TestCaseDTO updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO) {
        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        return modelMapper.map(testCaseService.updateTestCase(id, testCase), TestCaseDTO.class);
    }

    @DeleteMapping("/{id}")
    public void deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
    }

    @GetMapping(params = "last_update")
    public List<TestCaseDTO> findTestCasesByLastUpdate(@RequestParam("last_update") String lastUpdate) {
        LocalDate date = LocalDate.parse(lastUpdate, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return testCaseService.findTestCasesByLastUpdate(date).stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDTO.class))
                .collect(Collectors.toList());
    }
}