package com.bootcamp.socialmeli.service.impl;

import com.bootcamp.socialmeli.dto.response.UnfollowResponseDTO;
import com.bootcamp.socialmeli.dto.response.FollowerCountDTO;
import com.bootcamp.socialmeli.dto.response.GetFollowedDTO;
import com.bootcamp.socialmeli.dto.response.GetFollowersDTO;
import com.bootcamp.socialmeli.dto.UserDto;
import com.bootcamp.socialmeli.dto.response.FollowUserDto;
import com.bootcamp.socialmeli.exception.*;
import com.bootcamp.socialmeli.dto.request.UserCreationReqDto;
import com.bootcamp.socialmeli.util.mapper.FollowedMapper;
import com.bootcamp.socialmeli.util.mapper.FollowersMapper;
import com.bootcamp.socialmeli.util.mapper.UserMapper;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.UserRepository;
import com.bootcamp.socialmeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public FollowUserDto followUser(Long userId, Long userIdToFollow) {
        if (userId.equals(userIdToFollow)) throw new IllegalFollowException("You can't follow yourself");
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User", userId));
        if (user.getFollowed().stream().anyMatch(u -> u.getId().equals(userIdToFollow)))
            throw new ExistingFollowException("You already follow this user");

        User userToFollow = userRepository.findById(userIdToFollow).orElseThrow(() -> new NotFoundException("User", userIdToFollow));
        user.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(user);

        return new FollowUserDto(user.getId(), user.getName(), user.getFollowed().stream().map(UserMapper::toUserDto).toList());
    }

    @Override
    public List<UserDto> createUsers(List<UserCreationReqDto> usersDto) {
        List<User> users = usersDto.stream().map(UserMapper::toUser).toList();
        users.forEach(userRepository::save);
        return users.stream().map(UserMapper::toUserDto).toList();
    }

    public GetFollowedDTO getFollowedByUserId(Long id, String order) {
        User user = userRepository.findById(id).orElse(null);
        if( user == null ){
            throw new NotFoundException("User", id);
        }

        if (order == null){
            return FollowedMapper.toGetFollowedDTO(user);
        } else if (order.equals("name_asc")) {
            List<User> followed = user.getFollowed().stream().sorted(Comparator.comparing(User::getName)).toList();
            return FollowedMapper.getFollowedDtoOrderByName(user, followed);
        } else if (order.equals("name_desc")) {
            List<User> followed = user.getFollowed().stream().sorted(Comparator.comparing(User::getName).reversed()).toList();
            return FollowedMapper.getFollowedDtoOrderByName(user, followed);
        } else {
            throw new OrderInvalidException("Invalid sort order");
        }
    }

    @Override
    public FollowerCountDTO getFollowersCount(Long userId){
        User user = userRepository.findById(userId).orElse(null);
        if( user == null ){
            throw new NotFoundException("User", userId);
        }
        return new FollowerCountDTO(user.getId(),user.getName(),(long) user.getFollowers().size());
    }

    public GetFollowersDTO getFollowersByUserId(Long id, String order) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("User", id);
        }
        if(order == null){
            return FollowersMapper.toGetFollowersDTO(user.get());
        } else if (order.equals("name_asc")) {
            List<User> followers = user.get().getFollowers().stream().sorted(Comparator.comparing(User::getName)).toList();
            return FollowersMapper.getFollowersDtoOrderByName(user.get(), followers);
        } else if (order.equals("name_desc")) {
            List<User> followers = user.get().getFollowers().stream().sorted(Comparator.comparing(User::getName).reversed()).toList();
            return FollowersMapper.getFollowersDtoOrderByName(user.get(), followers);
        } else {
            throw new OrderInvalidException("Invalid sort order");
        }
    }

    @Override
    public void deletePostsByUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User", id));
        userRepository.deletePosts(user);
    }

    @Override
    public UnfollowResponseDTO unfollowUser(Long userId, Long userIdToUnfollow){
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User", userId));
        User userToUnfollow = userRepository.findById(userIdToUnfollow).orElseThrow(() -> new NotFoundException("User", userIdToUnfollow));
        if (!user.getFollowed().contains(userToUnfollow)) {
            throw new UserNotFollowedException(userId, userIdToUnfollow);
        }

        user.getFollowed().remove(userToUnfollow);
        userToUnfollow.getFollowers().remove(user);
        return UserMapper.toUnfollowResponseDTO(user);
    }

    @Override
    public FollowerCountDTO getMaxFollowersCount() {
        Optional<User> user = userRepository.findByMaxFollowers();
        if (user.get().getFollowers().isEmpty()){
            throw new BadRequestException("No users have followers.");
        }
        return new FollowerCountDTO(user.get().getId(),user.get().getName(),(long)user.get().getFollowers().size() );
    }
}

