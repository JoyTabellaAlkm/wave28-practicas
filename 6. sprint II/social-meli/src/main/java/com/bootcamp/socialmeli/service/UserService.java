package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.request.GoalDto;
import com.bootcamp.socialmeli.dto.response.*;
import com.bootcamp.socialmeli.entity.Goal;
import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.exception.BadRequestException;
import com.bootcamp.socialmeli.exception.NotFoundException;
import com.bootcamp.socialmeli.mapper.GoalMapper;
import com.bootcamp.socialmeli.mapper.UserMapper;
import com.bootcamp.socialmeli.repository.IGoalRepository;
import com.bootcamp.socialmeli.repository.IUserRepository;
import com.bootcamp.socialmeli.utils.Utils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IGoalRepository goalRepository;

    public UserService(IUserRepository userRepository, IGoalRepository goalRepository) {
        this.userRepository = userRepository;
        this.goalRepository = goalRepository;
    }

    @Override
    public UserFollowedDto addFollower(int userId, int userIdToFollow) {
        assertIsSameUser(userId, userIdToFollow);

        User user = getUserIfExists(userId);
        User userToFollow = getUserIfExists(userIdToFollow);

        assertIsAlreadyFollowing(user, userToFollow);
        user.follow(userToFollow);

        List<User> followingUsers = userRepository.getUsersByIds(user.getFollowing());
        return UserMapper.mapToUserFollowedDto(user, followingUsers);
    }

    @Override
    public UserFollowedDto getFollowingList(int userId, String order) {
        Utils.assertOrderExists(order, "name");
        User user = getUserIfExists(userId);

        List<User> followingUsers = userRepository.getUsersByIds(user.getFollowing());
        UserFollowedDto userFollowedDto = UserMapper.mapToUserFollowedDto(user, followingUsers);

        userFollowedDto.setFollowing(
                Utils.sortList(
                        userFollowedDto.getFollowing(),
                        UserIdentificationDto::getName,
                        order.contains("name_asc")
                )
        );

        return userFollowedDto;
    }

    @Override
    public UserFollowedDto removeFollower(int userId, int userIdToUnfollow) {
        assertIsSameUser(userId, userIdToUnfollow);

        User user = getUserIfExists(userId);
        User userToUnfollow = getUserIfExists(userIdToUnfollow);

        assertIsNotFollowing(user, userToUnfollow);
        user.unfollow(userToUnfollow);

        List<User> followingUsers = userRepository.getUsersByIds(user.getFollowing());
        return UserMapper.mapToUserFollowedDto(user, followingUsers);
    }

    @Override
    public UserFollowersCountResponseDto getAllUsersFollowersCount(int userId) {
        User user = getUserIfExists(userId);

        return UserMapper.mapToUsersFollowersCountResponseDTO(user, user.followersCount());
    }

    @Override
    public UserFollowingSellerResponseDto getAllUsersFollowingSeller(int userId, String order) {
        Utils.assertOrderExists(order, "name");
        User user = getUserIfExists(userId);

        List<User> followers = userRepository.getUsersByIds(user.getFollowers());
        List<UserIdentificationDto> followersDto = UserMapper.mapUsersToUserIdentificationDto(followers);

        List<UserIdentificationDto> followersDtoSorted = Utils.sortList(
                followersDto,
                UserIdentificationDto::getName,
                order.contains("asc")
        );

        return UserMapper.mapToUsersFollowingSellerResponseDto(user, followersDtoSorted);
    }

    @Override
    public GoalResponseDto addGoal(int userId, GoalDto goalDto) {
        assertGoalAlreadyExists(goalDto.getId());
        assertIsValidDeadline(goalDto.getDeadline());

        Goal goal = GoalMapper.mapToGoal(goalDto);

        User user = getUserIfExists(userId);
        user.setGoal(goal);

        goalRepository.addGoal(goal);

        return GoalMapper.mapToGoalResponseDto(goal, user);
    }

    @Override
    public GoalResponseDto getGoal(int userId) {
        User user = getUserIfExists(userId);
        Goal goal = getGoalIfExists(user);

        return GoalMapper.mapToGoalResponseDto(goal, user);
    }


    private User getUserIfExists(int userId) {
        return userRepository.getUserById(userId)
                .orElseThrow(() -> new NotFoundException("No existe usuario con ese id"));
    }

    private void assertIsNotFollowing(User user, User userToUnfollow) {
        if (!user.follows(userToUnfollow))
            throw new BadRequestException("No está siguiendo al usuario");
    }

    private void assertIsSameUser(int userId, int userIdToFollow) {
        if (userId == userIdToFollow)
            throw new BadRequestException("No se puede seguir a si mismo");
    }

    private void assertIsAlreadyFollowing(User user, User userToFollow) {
        if (user.follows(userToFollow))
            throw new BadRequestException("Ya sigue al usuario");
    }

    private void assertIsValidDeadline(LocalDate deadline) {
        if (!isValidDeadline(deadline)) throw new BadRequestException("La fecha debe ser mayor a la actual");
    }

    private boolean isValidDeadline(LocalDate deadline) {
        return deadline.isAfter(LocalDate.now());
    }

    private Goal getGoalIfExists(User user) {
        if (user.getGoal() == null)
            throw new NotFoundException("No existe goal con ese id");

        return user.getGoal();
    }

    private void assertGoalAlreadyExists(int goalId) {
        if (goalAlreadyExists(goalId))
            throw new BadRequestException("Un goal con ese id ya existe");
    }

    private boolean goalAlreadyExists(int goalId) {
        return goalRepository
                .findAll()
                .stream()
                .anyMatch(goal -> goal.getId() == goalId);
    }
}
