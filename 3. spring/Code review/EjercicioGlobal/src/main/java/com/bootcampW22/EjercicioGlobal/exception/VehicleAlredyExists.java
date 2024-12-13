package com.bootcampW22.EjercicioGlobal.exception;

public class VehicleAlredyExists extends RuntimeException {
    public VehicleAlredyExists(String message) {
        super(message);
    }
}
