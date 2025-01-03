package com.meli.be_java_hisp_w28_g01.exception;

public class FollowAlreadyExistsException extends RuntimeException{
    public FollowAlreadyExistsException(int id, int idToFollow){
        super("El usuario con id '"+id+"' ya sigue al usuario con id '"+idToFollow+"'.");
    }
}
