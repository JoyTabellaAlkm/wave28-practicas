package com.mercadolibre.be_java_hisp_w28_g10.service;

import com.mercadolibre.be_java_hisp_w28_g10.dto.follow.FollowRelationDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.follow.FollowersDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.follow.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.follow.UserFollowersDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.post.PostDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ResponseMessageDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.response.ResponseUserDTO;
import com.mercadolibre.be_java_hisp_w28_g10.dto.user.UserDTO;
import com.mercadolibre.be_java_hisp_w28_g10.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w28_g10.exception.ConflictException;
import com.mercadolibre.be_java_hisp_w28_g10.exception.NotFoundException;

import java.util.List;

/**
 * Interface for managing user-related operations within the application.
 * This service provides methods for retrieving user information, managing follow relationships,
 * and obtaining follower statistics. The methods include functionality for unfollowing users,
 * following users, and sorting users by various criteria.
 */
public interface IUserService {

    /**
     * Retrieves a list of all users and converts them into UserDTO objects.
     * This method fetches all users from the user repository and maps each user entity to a UserDTO
     * using the ObjectMapper.
     *
     * @return a List of {@link PostDTO} objects representing all users in the system
     */
    public List<UserDTO> getAllUsers();

    /**
     * Retrieves a list of all follow relationships and converts them into {@link FollowRelationDTO} objects.
     * This method fetches all follow relations from the user repository and maps each follow relation
     * entity to a {@link FollowRelationDTO} using the ObjectMapper.
     *
     * @return a List of {@link FollowRelationDTO} objects representing all follow relationships
     */
    public List<FollowRelationDTO> getAllFollowRelation();

    /**
     * US 0007
     * Unfollows a user by removing the follow relationship between two users.
     * This method retrieves all follow relations from the user repository and searches for the specific
     * follow relationship based on the provided follower and followed user IDs. If a matching follow
     * relation is found, it attempts to delete it. If the follow relation does not exist, a NotFoundException
     * is thrown. If the deletion operation fails, a BadRequestException is raised.
     *
     * @param userId the ID of the user who wants to unfollow another user
     * @param userIdToUnfollow the ID of the user to be unfollowed
     * @return a {@link ResponseMessageDTO} indicating the success of the unfollow operation
     * @throws NotFoundException if no follower relationship is found for the given user IDs
     * @throws BadRequestException if the follow relation could not be deleted
     */
    public ResponseMessageDTO unfollowUserById(int userId, int userIdToUnfollow);

    /**
     * US 0001
     * Creates a follow relationship between two users.
     * This method allows a user (identified by followerId) to follow another user (identified by followedId).
     * It performs the following validations before establishing the follow:
     * 1. Checks if the followerId corresponds to an existing user; throws NotFoundException if not.
     * 2. Checks if the followedId corresponds to an existing user; throws NotFoundException if not.
     * 3. Checks if a follow relationship already exists between the two users; throws ConflictException if it does.
     * 4. Verifies that a user cannot follow themselves; throws ConflictException if followerId equals followedId.
     * If all checks pass, it creates a new follow relationship and saves it in the repository.
     * Finally, it converts the saved FollowRelation entity into a FollowRelationDTO.
     *
     * @param followerId the ID of the user who wants to follow another user
     * @param followedId the ID of the user to be followed
     * @return {@link FollowRelationDTO} representing the newly created follow relationship
     * @throws NotFoundException if either user does not exist
     * @throws ConflictException if the follow relationship already exists or if a user tries to follow themselves
     */
    public FollowRelationDTO follow(int followerId, int followedId);

    /**
     * US 0002
     * Retrieves the number of followers for a specified user.
     * This method checks if a user exists in the repository by their ID. If the user is found,
     * it counts the number of follow relations where the user is the followed individual.
     * If the user does not exist, a NotFoundException is thrown.
     *
     * @param id the ID of the user whose followers count is to be retrieved
     * @return a {@link FollowersDTO} containing the user ID, name, and the number of followers
     * @throws NotFoundException if the user is not found
     */
    public FollowersDTO getFollowersAmountById(int id);

    /**
     * US 0003 + US 0008
     * Retrieves the followers of a specified user.
     * This method checks if the user exists by their user ID. If the user is found, it fetches
     * the follow relations for the user's followers. It then generates a list of {@link ResponseUserDTO}
     * objects representing the followers of the user, which includes their IDs and names.
     *
     * @param userId the ID of the user whose followers are to be retrieved
     * @param order the order in which to sort the followers (e.g., "name_asc", "name_desc")
     * @return a {@link UserFollowersDTO} containing the user ID, name, and a list of followers
     * @throws NotFoundException if the user is not found
     */
    public UserFollowersDTO getUserFollowersById(int userId, String order);

    /**
     * US 0004 + US 0008
     * Retrieves the users that a specified user is following.
     * This method checks if the user exists by their user ID. If the user is found, it fetches
     * the follow relations for the users that the user is following. It then creates a list of
     * {@link ResponseUserDTO} objects representing those users, which includes their IDs and names.
     *
     * @param userId the ID of the user whose followed users are to be retrieved
     * @param order the order in which to sort the followed users (e.g., "name_asc", "name_desc")
     * @return a {@link UserFollowedDTO} containing the user ID, name, and a list of followed users
     * @throws NotFoundException if the user is not found
     */
    public UserFollowedDTO getUserFollowedById(Integer userId, String order);

}
