package com.bootcamp.socialmeli.utils;

import com.bootcamp.socialmeli.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FollowedFactory {
    public static List<User> createFollowed(){
        return Arrays.asList(
                new User(1L, "user1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),
                new User(5L, "user5",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),
                new User(3L, "user3",new ArrayList<>(),new ArrayList<>(),new ArrayList<>())
        );
    }
}
