package com.mercadolibre.blogyoutuber.exceptions;

public class BlogNotFoundException extends RuntimeException{

    public BlogNotFoundException(){}

    public BlogNotFoundException(String message){
        super(message);
    }
}
