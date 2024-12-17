package com.bootcamp.socialmeli.exception;

import com.bootcamp.socialmeli.model.User;

public class UserNotFollowedException extends RuntimeException {
    public UserNotFollowedException(String message) {
        super(message);

    }
    public UserNotFollowedException(Long userId, Long userIdToUnfollow) {
        super(String.format("User with id: %d is not following user with id: %d", userId, userIdToUnfollow));
    }
}

