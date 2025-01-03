package com.mercadolibre.be_java_hisp_w28_g10.controller;

import com.mercadolibre.be_java_hisp_w28_g10.service.IBackOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing back-office report operations.
 * <p>
 * This controller exposes RESTful endpoints for generating and downloading reports
 * in CSV format, providing various filtering options for end-users.
 * </p>
 */
@RestController
@Validated
@RequestMapping("/reports/")
public class BackOfficeController {

    @Autowired
    IBackOfficeService backOfficeService;

    /**
     * US 0012
     * Endpoint to retrieve a report in CSV format.
     *
     * @param reportName the name of the report to be retrieved.
     * @param order      the order in which the report data should be returned.
     * @param top        the number of top entries to include in the report.
     * @return ResponseEntity containing the report data as CSV and appropriate HTTP headers for download.
     */
    @GetMapping("getReport/{reportName}")
    public ResponseEntity<String> getReport(@PathVariable String reportName,
                                            @RequestParam String order,
                                            @RequestParam int top) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + reportName + ".csv");
        headers.set(HttpHeaders.CONTENT_TYPE, "text/csv");
        return new ResponseEntity<>(backOfficeService.getReport(reportName, order, top), headers, HttpStatus.OK);
    }
}
