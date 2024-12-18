package com.meli.be_java_hisp_w28_g01.exception;

public class IsEmptyException extends RuntimeException{
    public IsEmptyException(String type)
    {
        super("La lista de '"+type+"' está vacía.");
    }}
