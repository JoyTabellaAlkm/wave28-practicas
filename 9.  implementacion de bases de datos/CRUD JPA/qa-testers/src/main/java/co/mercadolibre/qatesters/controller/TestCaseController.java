package co.mercadolibre.qatesters.controller;

import co.mercadolibre.qatesters.dto.DeleteResponseDto;
import co.mercadolibre.qatesters.dto.TestCaseDto;
import co.mercadolibre.qatesters.service.ITestCaseService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("testcases/new")
    public ResponseEntity<TestCaseDto> newTestCase(@RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(testCaseService.newTest(testCaseDto), HttpStatus.CREATED);
    }

    @GetMapping("testcases")
    public ResponseEntity<List<TestCaseDto>> getTestCases(
            @RequestParam(value = "last_update", required = false)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate){
        return ResponseEntity.ok(testCaseService.getAllTest(lastUpdate));
    }

    @GetMapping("testcases/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.getTestById(id));
    }

    @PutMapping("testcases/{id}")
    public ResponseEntity<TestCaseDto> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDto test){
        return ResponseEntity.ok(testCaseService.updateTestCase(id, test));
    }

    @DeleteMapping("testcases/{id}")
    public ResponseEntity<DeleteResponseDto> deleteTestCase(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.deleteTestCase(id));
    }
}
