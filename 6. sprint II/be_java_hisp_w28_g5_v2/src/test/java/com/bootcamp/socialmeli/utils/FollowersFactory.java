package com.bootcamp.socialmeli.utils;

import com.bootcamp.socialmeli.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FollowersFactory {
    public static List<User> createFollowers(){
        return Arrays.asList(
                new User(3L, "user3",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),
                new User(2L, "user2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()),
                new User(4L, "user4",new ArrayList<>(),new ArrayList<>(),new ArrayList<>())
        );
    }
}
