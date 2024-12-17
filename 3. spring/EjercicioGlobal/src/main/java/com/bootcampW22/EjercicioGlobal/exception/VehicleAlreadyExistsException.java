package com.bootcampW22.EjercicioGlobal.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VehicleAlreadyExistsException extends RuntimeException {

    public VehicleAlreadyExistsException(String message){
        super(message);
    }
}
