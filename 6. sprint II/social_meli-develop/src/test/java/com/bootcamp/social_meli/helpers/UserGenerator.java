package com.bootcamp.social_meli.helpers;

import com.bootcamp.social_meli.model.User;

import java.util.ArrayList;

public class UserGenerator {
    public static User userWithFollowersAndFollowed(Long userId) {
        User user = new User(userId, "Robert", "Firminho", "firminho10", new ArrayList<>(), new ArrayList<>());

        User user2 = new User(userId + 1, "Alexander", "Arnold", "aarnold", new ArrayList<>(),
                new ArrayList<>());
        User user3 = new User(userId + 2, "Mohamed", "Salah", "msalah", new ArrayList<>(),
                new ArrayList<>());
        User user4 = new User(userId + 3, "Sadio", "Mane", "smane", new ArrayList<>(),
                new ArrayList<>());
        User user5 = new User(userId + 4, "Trent", "Alexander-Arnold", "tarnold", new ArrayList<>()
                , new ArrayList<>());

        user.getFollowed().add(user2);
        user.getFollowed().add(user3);
        user.getFollowed().add(user4);

        user2.getFollowers().add(user);
        user3.getFollowers().add(user);
        user4.getFollowers().add(user);


        user.getFollowers().add(user2);
        user.getFollowers().add(user3);
        user.getFollowers().add(user5);


        user2.getFollowed().add(user);
        user3.getFollowed().add(user);
        user5.getFollowed().add(user);

        return user;
    }

}
