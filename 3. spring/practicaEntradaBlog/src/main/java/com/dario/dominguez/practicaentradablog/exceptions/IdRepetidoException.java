package com.dario.dominguez.practicaentradablog.exceptions;

public class IdRepetidoException extends  RuntimeException{

    public IdRepetidoException() {
    }

    public IdRepetidoException(String mensaje) {
        super(mensaje);
    }
}
