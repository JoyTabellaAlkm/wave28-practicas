package com.bootcamp.social_meli.service.impl;

import com.bootcamp.social_meli.dto.UserDTO;
import com.bootcamp.social_meli.dto.response.*;
import com.bootcamp.social_meli.exception.BadRequestException;
import com.bootcamp.social_meli.exception.ConflictException;
import com.bootcamp.social_meli.model.Post;
import com.bootcamp.social_meli.repository.IPostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.bootcamp.social_meli.exception.NotFoundException;
import com.bootcamp.social_meli.model.User;
import com.bootcamp.social_meli.repository.IUserRepository;
import com.bootcamp.social_meli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IPostRepository postRepository;
    private final ObjectMapper objectMapper;
    @Autowired
    public UserServiceImpl(IPostRepository postRepository, IUserRepository userRepository, ObjectMapper objectMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> objectMapper.convertValue(user, UserDTO.class))
                .toList();
    }

    @Override
    public String followUser(Long userId, Long userToFollowId) {
        if (userId.equals(userToFollowId)) {
            throw new BadRequestException("El usuario no puede seguirse a si mismo.");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userId));

        User userToFollow = userRepository.findById(userToFollowId)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userToFollowId));

        List<User> userFollowedList = user.getFollowed();
        List<User> userToFollowFollowersList = userToFollow.getFollowers();

        if (userFollowedList.stream().anyMatch(u -> u.getId().equals(userToFollowId))) {
            throw new BadRequestException("El usuario " + user.getUsername() + " ya sigue al usuario " + userToFollow.getUsername());
        } else if (userToFollowFollowersList.stream().anyMatch(u -> u.getId().equals(userId))) {
            throw new BadRequestException("El usuario " + user.getUsername() + " ya se encuentra en la lista de seguidores de: " + userToFollow.getUsername());
        }

        userFollowedList.add(userToFollow);
        userToFollowFollowersList.add(user);

        return "¡El usuario " + user.getUsername() + " ha comenzado a seguir a " + userToFollow.getUsername() + " exitosamente!";
    }

    @Override
    public String unfollowUser(Long userId, Long userToFollowId) {
        if (userId.equals(userToFollowId)) {
            throw new BadRequestException("El usuario no puede dejarse de seguir a si mismo.");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userId));

        User userToUnfollow = userRepository.findById(userToFollowId)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userToFollowId));

        List<User> userFollowedList = user.getFollowed();
        List<User> userToUnfollowFollowersList = userToUnfollow.getFollowers();

        if (userFollowedList.stream().noneMatch(u -> u.getId().equals(userToFollowId))) {
            throw new BadRequestException("El usuario " + user.getUsername() + " no sigue al usuario " + userToUnfollow.getUsername());
        } else if (userToUnfollowFollowersList.stream().noneMatch(u -> u.getId().equals(userId))) {
            throw new BadRequestException("El usuario " + user.getUsername() + " no se encuentra en la lista de seguidores de: " + userToUnfollow.getUsername());
        }

        userFollowedList.remove(userToUnfollow);
        userToUnfollowFollowersList.remove(user);
        return "¡El usuario " + user.getUsername() + " ha dejado de seguir a " + userToUnfollow.getUsername() + " exitosamente!";

    }

    @Override
    public FollowersListDTO findFollowersList(String userId) {
        Long idLong;

        try {
            idLong = Long.parseLong(userId);
        } catch (NumberFormatException e) {
            throw new BadRequestException("El ID del usuario debe ser un número entero");
        }

        User user = userRepository.findById(idLong)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userId));

        List<User> followersList = user.getFollowers();

        List<SimpleUserDTO> followersDtos = followersList.stream()
                .map(follower -> new SimpleUserDTO(follower.getId(), follower.getUsername()))
                .toList();

        FollowersListDTO followersDTO = new FollowersListDTO();
        followersDTO.setUser_id(user.getId());
        followersDTO.setUser_name(user.getUsername());
        followersDTO.setFollowers(followersDtos);

        return followersDTO;
    }

    @Override
    public FollowedListDTO findFollowedList(String userId) {
        Long idLong;

        try {
            idLong = Long.parseLong(userId);
        } catch (NumberFormatException e) {
            throw new BadRequestException("El ID del usuario debe ser un número entero");
        }

        User user = userRepository.findById(idLong)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userId));

        List<User> followedList = user.getFollowed();

        List<SimpleUserDTO> followedDtos = followedList.stream()
                .map(follower -> new SimpleUserDTO(follower.getId(), follower.getUsername()))
                .toList();

        FollowedListDTO followedDTO = new FollowedListDTO();

        followedDTO.setUser_id(user.getId());
        followedDTO.setUser_name(user.getUsername());
        followedDTO.setFollowed(followedDtos);

        return followedDTO;

    }

    @Override
    public FollowersListDTO findFollowersList(String userId, String order) {
        Long idLong;

        try {
            idLong = Long.parseLong(userId);
        } catch (NumberFormatException e) {
            throw new BadRequestException("El ID del usuario debe ser un número entero");
        }

        User user = userRepository.findById(idLong)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userId));

        List<User> followersList = user.getFollowers();

        if (order != null && !order.isEmpty()) {
            if (order.equals("name_asc")) {
                followersList.sort(Comparator
                        .comparing(User::getUsername));
            } else if (order.equals("name_desc")) {
                followersList.sort(Comparator
                        .comparing(User::getUsername)
                        .reversed());
            } else {
                throw new BadRequestException("El parámetro 'order' no es válido. Los valores aceptables son 'name_asc' o 'name_desc'.");
            }
        }

        List<SimpleUserDTO> followersDtos = followersList.stream()
                .map(follower -> new SimpleUserDTO(follower.getId(), follower.getUsername()))
                .toList();

        FollowersListDTO followersDTO = new FollowersListDTO();
        followersDTO.setUser_id(user.getId());
        followersDTO.setUser_name(user.getUsername());
        followersDTO.setFollowers(followersDtos);

        return followersDTO;
    }

    @Override
    public FollowedListDTO findFollowedList(String userId, String order) {
        Long idLong;

        try {
            idLong = Long.parseLong(userId);
        } catch (NumberFormatException e) {
            throw new BadRequestException("El ID del usuario debe ser un número entero");
        }

        User user = userRepository.findById(idLong)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userId));

        List<User> followedList = user.getFollowed();

        if (order != null && !order.isEmpty()) {
            if (order.equals("name_asc")) {
                followedList.sort(Comparator
                        .comparing(User::getUsername));
            } else if (order.equals("name_desc")) {
                followedList.sort(Comparator
                        .comparing(User::getUsername)
                        .reversed());
            } else {
                throw new BadRequestException("El parámetro 'order' no es válido. Los valores aceptables son 'name_asc' o 'name_desc'.");
            }
        }

        List<SimpleUserDTO> followedDtos = followedList.stream()
                .map(follower -> new SimpleUserDTO(follower.getId(), follower.getUsername()))
                .toList();

        FollowedListDTO followedDTO = new FollowedListDTO();

        followedDTO.setUser_id(user.getId());
        followedDTO.setUser_name(user.getUsername());
        followedDTO.setFollowed(followedDtos);

        return followedDTO;

    }

    public FollowerCountResponse getFollowerCount(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userId));
        Long followersCount = (long) user.getFollowers().size();
        FollowerCountResponse followerCountResponse = new FollowerCountResponse();
        followerCountResponse.setUser_id(userId);
        followerCountResponse.setUser_name(user.getUsername());
        followerCountResponse.setFollowers_count(followersCount);
        return followerCountResponse;
    }

    @Override
    public MostFollowersResponseDTO mostFollowers() {
        return mostFollowers(5);
    }

    @Override
    public MostFollowersResponseDTO mostFollowers(Integer rank) {
        if(rank <= 0) {
            throw new BadRequestException("'rank' no puede ser <= 0");
        }

        List<User> usersSortedByFollowers = userRepository.findAll()
                .stream()
                .sorted((a, b) -> -(a.getFollowers().size() - b.getFollowers().size()))
                .toList();

        List<User> results;
        if (usersSortedByFollowers.size() < rank) {
            results = usersSortedByFollowers;
        } else {
            results = usersSortedByFollowers.subList(0, rank);
        }

        List<SimpleUserWithFollowersCountDTO> mappedResults = results
                .stream()
                .map(u -> new SimpleUserWithFollowersCountDTO(u.getId(), u.getUsername(), u.getFollowers().size()))
                .toList();

        MostFollowersResponseDTO mostFollowersResponseDTO = new MostFollowersResponseDTO();
        mostFollowersResponseDTO.setMost_followers(mappedResults);
        return mostFollowersResponseDTO;
    }

    @Override
    public UserDetailsDTO metricsUserDetails(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + userId));

        List<User> followers = user.getFollowers();
        List<User> followed = user.getFollowed();

        Integer countPost = postRepository.findAmountOfPromosByUserId(user).size();

        List<User> notFollowedBack = new ArrayList<>(followed);
        notFollowedBack.removeAll(followers);
        List<SimpleUserDTO> followerNotFollowed =
                notFollowedBack.stream()
                        .map(u -> new SimpleUserDTO(u.getId(),u.getUsername()))
                        .toList();

        List<User> notFollowingBack = new ArrayList<>(followers);
        notFollowingBack.removeAll(followed);
        List<SimpleUserDTO> followedNotFollower =
                notFollowingBack.stream()
                        .map(u -> new SimpleUserDTO(u.getId(),u.getUsername()))
                        .toList();

        return new UserDetailsDTO(
                userId,
                user.getUsername(),
                followers.size(),
                followed.size(),
                countPost,
                followerNotFollowed,
                followedNotFollower
        );
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        if(userDto.getUsername() == null || userDto.getUsername().isEmpty() || userDto.getFirst_name() == null || userDto.getFirst_name().isEmpty() || userDto.getLast_name() == null ||userDto.getLast_name().isEmpty()){
            throw new BadRequestException("Faltan datos del nuevo usuario.");
        }
        if(userRepository.findByUsername(userDto.getUsername()) != null){
            throw new ConflictException("Ya existe un usuario con ese 'username'");
        }

        User user = userRepository.create(objectMapper.convertValue(userDto, User.class));

        return objectMapper.convertValue(user, UserDTO.class);
    }
}
