package com.spring1.meliSocial.validation;

import com.spring1.meliSocial.exception.BadRequestException;

public class OrderValidation {
    public static void validateOrderMethodParam(String orderMethod) {
        if (orderMethod != null && !orderMethod.isEmpty() && !orderMethod.equalsIgnoreCase("name_asc") &&
                !orderMethod.equalsIgnoreCase("name_desc")) {
            throw new BadRequestException("Parámetros inválidos.");
        }
    }
}
