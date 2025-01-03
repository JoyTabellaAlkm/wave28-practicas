package com.mercadolibre.be_java_hisp_w28_g10.service;

import com.mercadolibre.be_java_hisp_w28_g10.exception.BadRequestException;

/**
 * Interface for managing back-office operations related to reporting.
 * This service provides a method to generate various types of reports based on provided criteria.
 */
public interface IBackOfficeService {
    /**
     * US 0012
     * Retrieves a report based on the specified report name, sorting order, and top limit.
     *
     * @param reportName the name of the report to generate (should match a valid report type).
     * @param order the desired order for displaying results (e.g., ascending or descending).
     * @param top the maximum number of results to return.
     * @return a String containing the generated report in CSV format.
     * @throws BadRequestException if the report name is invalid, or the order or top limit are out of bounds.
     */
    String getReport(String reportName, String order, int top);
}
