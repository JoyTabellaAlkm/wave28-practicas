package com.mercadolibre.romanos_api.enums;

public enum RomanSymbols {
    I("I"),
    IV("IV"),
    V("V"),
    IX("IX"),
    X("X"),
    XL("XL"),
    L("L"),
    XC("XC"),
    C("C"),
    CD("CD"),
    D("D"),
    CM("CM"),
    M("M");

    private final String value;

    RomanSymbols(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
