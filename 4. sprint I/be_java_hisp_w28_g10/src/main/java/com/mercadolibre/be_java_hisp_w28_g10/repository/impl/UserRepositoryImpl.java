package com.mercadolibre.be_java_hisp_w28_g10.repository.impl;

import com.mercadolibre.be_java_hisp_w28_g10.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mercadolibre.be_java_hisp_w28_g10.exception.LoadJSONDataException;
import com.mercadolibre.be_java_hisp_w28_g10.model.FollowRelation;
import com.mercadolibre.be_java_hisp_w28_g10.model.Post;
import com.mercadolibre.be_java_hisp_w28_g10.model.User;
import com.mercadolibre.be_java_hisp_w28_g10.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w28_g10.util.Utilities;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link IUserRepository} for managing user data.
 * This repository implementation provides methods for interacting with user data,
 * including loading user information and follow relationships from JSON files,
 * as well as CRUD operations regarding users and follow relations.
 */
@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Autowired
    private Utilities utilities;
    private List<User> userList = new ArrayList<>();
    private List<FollowRelation> followRelations = new ArrayList<>();


    /**
     * Initializes the repository by loading user and follow relation data from JSON files.
     *
     * This method is called after the bean is constructed.
     *
     * @throws LoadJSONDataException if there was an error loading the JSON data.
     */
    @PostConstruct
    public void init() {
        try (InputStream inputStreamUsers = getClass().getResourceAsStream("/users.json");
             InputStream inputStreamFollowRelations = getClass().getResourceAsStream("/follow_relation.json")
        ) {
            userList = utilities.readValue(inputStreamUsers, new TypeReference<>() {
            });
            followRelations = utilities.readValue(inputStreamFollowRelations, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new LoadJSONDataException("It wasn't possible to load JSON data for Users.");
        }
    }

    /**
     * {@inheritDoc}
     *
     * Retrieves all users stored in the repository.
     *
     * @return a List of {@link User} representing all users in the system.
     */
    @Override
    public List<User> findAllUsers() {
        return userList;
    }

    /**
     * {@inheritDoc}
     *
     * Retrieves all follow relations stored in the repository.
     *
     * @return a List of {@link FollowRelation} representing all follow relationships.
     */
    @Override
    public List<FollowRelation> findAllFollowRelation() {
        return followRelations;
    }

    /**
     * {@inheritDoc}
     *
     * Creates and saves a follow relationship between two users.
     *
     * @param followerId the ID of the user who wants to follow another user.
     * @param followedId the ID of the user to be followed.
     * @return the created {@link FollowRelation} instance.
     */
    @Override
    public FollowRelation saveFollow(int followerId, int followedId) {
        FollowRelation newFollow = new FollowRelation(followerId, followedId);
        followRelations.add(newFollow);
        return newFollow;
    }

    /**
     * {@inheritDoc}
     *
     * Checks for the existence of a user in the repository based on their ID.
     *
     * @param userId the ID of the user to check.
     * @return true if the user exists; false otherwise.
     */
    @Override
    public boolean existsUser(int userId) {
        return userList.stream().anyMatch(u -> u.getId() == userId );
    }

    /**
     * {@inheritDoc}
     *
     * Checks for the existence of a follow relationship between two users based on their IDs.
     *
     * @param followerId the ID of the follower user.
     * @param followedId the ID of the followed user.
     * @return true if the follow relationship exists; false otherwise.
     */
    @Override
    public boolean existsFollow(int followerId, int followedId) {
        return followRelations.stream().anyMatch(f -> f.getIdFollower() == followerId && f.getIdFollowed() == followedId);
    }

    /**
     * {@inheritDoc}
     *
     * Finds and retrieves a user by their ID. If the user is not found, null is returned.
     *
     * @param id the ID of the user to retrieve.
     * @return the corresponding {@link User} object, or null if not found.
     */
    @Override
    public User findUserById(int id) {
        return this.userList.stream().filter(u-> u.getId() == id).findFirst().orElse(null);
    }

    /**
     * {@inheritDoc}
     *
     * Deletes a specified follow relation from the repository.
     *
     * @param followRelation the {@link FollowRelation} to be deleted.
     * @return true if the follow relation was successfully deleted; false otherwise.
     */
    @Override
    public boolean deleteFollowRelation(FollowRelation followRelation) {

        return followRelations.remove(followRelation);
    }

    /**
     * {@inheritDoc}
     *
     * Retrieves a user by their ID, throwing an exception if not found.
     *
     * @param id the ID of the user to retrieve.
     * @return the corresponding {@link User} object.
     * @throws NotFoundException if the user is not found.
     */
    @Override
    public User getUserById(int id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    /**
     * {@inheritDoc}
     *
     * Retrieves all follow relations for a specified user who is followed.
     *
     * @param id the ID of the user to retrieve follow relations for.
     * @return a List of {@link FollowRelation} where the user is the followed user.
     */
    @Override
    public List<FollowRelation> getFollowRelationsByFollowedId(int id) {
        return followRelations.stream().filter(followRelation -> followRelation.getIdFollowed() == id).toList();
    }

    /**
     * {@inheritDoc}
     *
     * Retrieves all follow relations for a specified user who is following others.
     *
     * @param id the ID of the user to retrieve follow relations for.
     * @return a List of {@link FollowRelation} where the user is the follower.
     */
    @Override
    public List<FollowRelation> getFollowRelationsByFollowerId(int id) {
        return followRelations.stream()
                .filter(followRelation -> followRelation.getIdFollower() == id).toList();
    }
}
