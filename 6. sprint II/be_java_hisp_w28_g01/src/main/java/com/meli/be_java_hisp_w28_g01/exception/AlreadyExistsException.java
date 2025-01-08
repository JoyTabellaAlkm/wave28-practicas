package com.meli.be_java_hisp_w28_g01.exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int id, String type) {
        super("El '" + type + "' con el id '" + id + "' ya existe.");
    }
}
