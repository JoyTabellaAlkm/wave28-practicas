package com.mercadolibre.social.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.social.dto.response.*;
import com.mercadolibre.social.entity.User;
import com.mercadolibre.social.exception.ConflictException;
import com.mercadolibre.social.exception.IllegalOperationException;
import com.mercadolibre.social.exception.InvalidFormatException;
import com.mercadolibre.social.repository.IUserRepository;
import com.mercadolibre.social.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
    }

    @Override
    public FollowUserResponseDto followUser(int userId, int userIdToFollow) {
        if (userId <= 0 || userIdToFollow <= 0) {
            throw new InvalidFormatException("Id is invalid.");
        }
        User user = userRepository.findById(userId);
        Optional<Integer> isFollowed = user.getFollowed().stream()
                .filter(userFollowedId -> userFollowedId.equals(userIdToFollow))
                .findFirst();
        if (isFollowed.isPresent()) {
            throw new ConflictException("The user is already followed.");
        }
        User userToFollow = userRepository.findById(userIdToFollow);
        Optional<Integer> isFollower = userToFollow.getFollowers().stream()
                .filter(userFollowerId -> userFollowerId.equals(userId))
                .findFirst();
        if (isFollower.isPresent()) {
            throw new ConflictException("The user is already follower. ");
        }
        user.getFollowed().add(userIdToFollow);
        userToFollow.getFollowers().add(userId);
        return new FollowUserResponseDto(userId, userIdToFollow);
    }

    @Override
    public FollowersByUserDto followersByUser(Integer id, String order) { //Retorna el listado de seguidores de un usuario especifico

        User user = userRepository.findById(id);
        List<User> followers = userRepository.findUsersByIds(user.getFollowers());
        orderByUserName(followers, order);

        return new FollowersByUserDto(
                user.getId(),
                user.getUsername(),
                followers.stream()
                        .map(us -> new UserDto(
                                us.getId(),
                                us.getUsername()
                        ))
                        .toList()
        );
    }

    public MessageDto unfollowUser(int userId, int userIdToUnfollow) {
        // Busca los usuarios correspondientes
        User user = userRepository.findById(userId);
        User userToUnfollow = userRepository.findById(userIdToUnfollow);

        // Valida si el usuario ya no sigue al otro
        if (!user.getFollowed().contains(userIdToUnfollow)) {
            throw new IllegalOperationException("User with ID " + userId + " is not following user with ID " + userIdToUnfollow);
        }

        // Realiza las actualizaciones en las listas
        user.getFollowed().remove(userIdToUnfollow);
        userToUnfollow.getFollowers().remove(userId);
        return new MessageDto("User " + userId + " successfully unfollowed User " + userIdToUnfollow);
    }

    @Override
    public FollowedByUserDto followedByUser(Integer id, String order) { //Retorna el listado de los vendedores seguidos por un usuario específico

        User user = userRepository.findById(id);
        List<User> followed = userRepository.findUsersByIds(user.getFollowed());
        orderByUserName(followed, order);

        return new FollowedByUserDto(
                user.getId(),
                user.getUsername(),
                followed.stream()
                        .map(us -> new UserDto(
                                us.getId(),
                                us.getUsername()
                        ))
                        .toList()
        );
    }

    @Override
    public UserCountFollowersDto getCountFollowers(int userId) {
        User user = userRepository.findById(userId);
        Integer followersCount = user.getFollowers().size();
        return new UserCountFollowersDto(String.valueOf(user.getId()), user.getUsername(), followersCount);
    }


    private void orderByUserName(List<User> users, String order) {
        if (order.equalsIgnoreCase("name_desc")) {
            users.sort(Comparator.comparing(User::getUsername).reversed());
        } else {
            users.sort(Comparator.comparing(User::getUsername));
        }
    }
}
