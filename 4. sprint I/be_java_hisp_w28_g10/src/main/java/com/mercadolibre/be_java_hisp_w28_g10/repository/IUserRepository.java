package com.mercadolibre.be_java_hisp_w28_g10.repository;

import com.mercadolibre.be_java_hisp_w28_g10.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w28_g10.model.FollowRelation;
import com.mercadolibre.be_java_hisp_w28_g10.model.User;
import java.util.List;

/**
 * Interface for managing user data operations.
 * This repository interface provides methods for retrieving user information,
 * managing follow relationships, and checking the existence of users and follow relations.
 */
public interface IUserRepository {
    /**
     * Retrieves a list of all users.
     *
     * @return a List of {@link User} representing all users in the system.
     */
    public List<User> findAllUsers();

    /**
     * Retrieves a list of all follow relationships.
     *
     * @return a List of {@link FollowRelation} representing all follow relationships.
     */
    public List<FollowRelation> findAllFollowRelation();

    /**
     * Creates and saves a follow relationship between two users.
     *
     * @param followerId the ID of the user who wants to follow another user.
     * @param followedId the ID of the user to be followed.
     * @return the created {@link FollowRelation} representing the follow relationship.
     */
    public FollowRelation saveFollow(int followerId, int followedId);

    /**
     * Checks if a user exists based on their ID.
     *
     * @param userId the ID of the user to check for existence.
     * @return true if the user exists; false otherwise.
     */
    public boolean existsUser(int userId);

    /**
     * Checks if a follow relationship exists between two users.
     *
     * @param followerId the ID of the follower.
     * @param followedId the ID of the followed user.
     * @return true if the follow relationship exists; false otherwise.
     */
    public boolean existsFollow(int followerId, int followedId);

    /**
     * Finds a user by their ID.
     *
     * @param id the ID of the user to be retrieved.
     * @return the corresponding {@link User} object, or null if not found.
     */
    public User findUserById (int id);

    /**
     * Deletes a specific follow relation from the repository.
     *
     * @param followRelation the {@link FollowRelation} to be deleted.
     * @return true if the follow relation was successfully deleted; false otherwise.
     */
    public boolean deleteFollowRelation(FollowRelation followRelation);

    /**
     * Retrieves a user by their ID, throwing an exception if not found.
     *
     * @param id the ID of the user to retrieve.
     * @return the corresponding {@link User} object.
     * @throws NotFoundException if the user is not found.
     */
    public User getUserById(int id);

    /**
     * Retrieves all follow relations for a specified user being followed.
     *
     * @param id the ID of the user to retrieve follow relations for.
     * @return a List of {@link FollowRelation} where the user is the followed user.
     */
    public List<FollowRelation> getFollowRelationsByFollowedId(int id);

    /**
     * Retrieves all follow relations for a specified user that is following others.
     *
     * @param id the ID of the user to retrieve follow relations for.
     * @return a List of {@link FollowRelation} where the user is the follower.
     */
    public List<FollowRelation> getFollowRelationsByFollowerId(int id);
}
