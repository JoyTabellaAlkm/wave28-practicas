package com.meli.be_java_hisp_w28_g01.exception;

public class FollowNotFoundException extends RuntimeException{

    public FollowNotFoundException(int userId, int userToUnfollowId) {
        super("El comprador con id '" + userId + "' no sigue al vendedor con el id '" + userToUnfollowId + "'.");
    }
}
