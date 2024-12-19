package com.bootcamp.socialmeli.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private int id;
    private String name;
    private List<Integer> following;
    private List<Integer> followers;
    private Goal goal;

    public boolean follows(User userToFollow) {
        return following.contains(userToFollow.id) &&
                userToFollow.followers.contains(id);
    }

    public void follow(User userToFollow) {
        following.add(userToFollow.id);
        userToFollow.followers.add(id);
    }

    public void unfollow(User userToUnfollow) {
        following.remove((Integer) userToUnfollow.id);
        userToUnfollow.followers.remove((Integer) id);
    }

    public int followersCount() {
        return followers != null ? followers.size() : 0;
    }

    public boolean hasReachedFollowerCount(int targetFollowers) {
        return followersCount() >= targetFollowers;
    }
}

