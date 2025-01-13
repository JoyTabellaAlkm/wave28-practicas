package com.mercadolibre.be_java_hisp_w28_g10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCsvPostDTO {
    @CsvBindByName(column = "ID")
    private int id;
    @CsvBindByName(column = "DATE")
    private String date;
    @CsvBindByName(column = "CATEGORY")
    private int category;
    @CsvBindByName(column = "PRICE")
    private double price;
    @CsvBindByName(column = "PRODUCT_NAME")
    private String productName;
    @CsvBindByName(column = "PRODUCT_TYPE")
    private String productType;
    @CsvBindByName(column = "PRODUCT_BRAND")
    private String productBrand;
    @CsvBindByName(column = "PROMO")
    private boolean hasPromo;
    @CsvBindByName(column = "DISCOUNT")
    private double discount;
}