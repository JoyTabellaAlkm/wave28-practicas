package com.spring1.meliSocial.validation;

import com.spring1.meliSocial.exception.BadRequestException;

public class UserValidation {

    public static void validateGetPostsByUserParams(int userId, String order) {
        if (userId == 0 ||
                (order != null && !order.isEmpty() &&
                        !order.equalsIgnoreCase("date_asc") &&
                        !order.equalsIgnoreCase("date_desc"))) {
            throw new BadRequestException("Parámetros inválidos.");
        }
    }
}
