package com.meli.be_java_hisp_w28_g01.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(int id, String type) {
        super("El '" + type + "' con el id '" + id + "' no existe.");
    }
}
