package com.demo.romanify.dto.request;

public class RomanNumberToDecimalRequest {
    private static final String romanNumberRegex = "^[IVXLCDM]+$";
    private String romanNumber;

    public RomanNumberToDecimalRequest() {}

    public RomanNumberToDecimalRequest(String romanNumber) { this.romanNumber = romanNumber;}

    public String getRomanNumber() { return romanNumber; }
    public void setRomanNumber(String romanNumber) { this.romanNumber = romanNumber; }
}
