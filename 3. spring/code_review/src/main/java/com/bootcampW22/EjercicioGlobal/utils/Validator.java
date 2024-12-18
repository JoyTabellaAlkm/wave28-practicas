package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;

import java.util.List;

public class Validator {
    private static void validateString(String str) {
        if (str == null) {
            throw new BadRequestException("El String no puede ser nulo");
        }
        if (str.isEmpty() || str.length() < 2) {
            throw new BadRequestException("El String " + str + " debe tener al menos 4 caracteres");
        }
    }

    private static void validateNumber(Number num) {
        if (num == null) {
            throw new BadRequestException("El Number " + num + " no puede ser nulo");
        }
        if (num.doubleValue() <= 0) {
            throw new BadRequestException("El Number " + num + " debe ser mayor que cero");
        }
    }

    public static void validateObject(Object obj) {
        if (obj instanceof String) {
            validateString((String) obj);
        } else if (obj instanceof Number) {
            validateNumber((Number) obj);
        } else {
            throw new BadRequestException("El objeto de tipo " + obj.getClass().getName() + " no es válido");
        }
    }

    public static void validateObjectList(List<Object> objects) {
        for (Object obj : objects) {
            validateObject(obj);
        }
    }
}
