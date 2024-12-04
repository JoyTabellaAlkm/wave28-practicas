package com.ejercicio.numerosromanos.services;

public class numerosRomanos {
    private static final int[] numbersToCompare = new int[]{1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
    private static final String[] romanNumbers = new String[]{"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

    public static String aNumeroRomano(Integer number) {
        StringBuilder romanNumber = new StringBuilder();
        for (int i = 0; i < numbersToCompare.length; i++)
            for (;number >= numbersToCompare[i]; number -= numbersToCompare[i])
                romanNumber.append(romanNumbers[i]);

        return romanNumber.toString();
    }


}
