package com.spring1.meliSocial.repository;

import com.spring1.meliSocial.model.Post;
import com.spring1.meliSocial.model.User;
import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    String getUserNameById(int id);

    boolean unfollowUser(int userId, int userIdToUnfollow);

    List<User> getUsers();

    Optional<User> getUserById(int id);

    boolean existsUserWithId(int id);

    int followersCount(int id);

    int followedCount(int userId);

    void addFollow(int userId, int userIdToFollow);

    void addFavouritePost(int userId, int postId);

    void removeFavouritePost(int userId, int postId);
}
