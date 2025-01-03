package com.spring1.meliSocial.service.impl;

import com.spring1.meliSocial.dto.response.*;
import com.spring1.meliSocial.exception.BadRequestException;
import com.spring1.meliSocial.exception.InternalServerErrorException;
import com.spring1.meliSocial.exception.NotFoundException;
import com.spring1.meliSocial.exception.NotSellerException;

import com.spring1.meliSocial.mapper.IMapper;
import com.spring1.meliSocial.model.User;
import com.spring1.meliSocial.repository.IPostRepository;
import com.spring1.meliSocial.repository.IUserRepository;
import com.spring1.meliSocial.service.IUserService;
import com.spring1.meliSocial.validation.OrderValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;

    private IPostRepository postRepository;


    @Autowired
    private IMapper customMapper;

    public UserService(IUserRepository userRepository, IPostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public SellerFollowersDto getFollowersFromSeller(int sellerId, String orderMethod) {
        Optional<User> optionalUser = userRepository.getUserById(sellerId);

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("El id ingresado no se corresponde a un user existente");
        }
        User userFound = optionalUser.get();

        if(!userFound.isSeller()) {
            throw new NotSellerException("El usuario ingresado no se trata de un vendedor y por lo tanto no puede tener seguidores");
        }

        List<User> userFollowers = getUsersByListOfId(userFound.getFollowers());
        List<FollowerDto> userFollowersDto = getFollowerDtoSortedList(orderMethod, userFollowers);

        return new SellerFollowersDto(userFound.getId(), userFound.getUserName(), userFollowersDto);
    }

    private List<FollowerDto> getFollowerDtoSortedList(String orderMethod, List<User> userFollowers) {
        OrderValidation.validateOrderMethodParam(orderMethod);

        Stream<FollowerDto> userFollowersDtoStream = userFollowers
                .stream()
                .map(
                follower -> customMapper.mapToFollowerDto(follower));

        if (orderMethod.equalsIgnoreCase("name_desc")) {
            userFollowersDtoStream = userFollowersDtoStream.sorted(Comparator.comparing(FollowerDto::getUserName).reversed());
        } else {
            userFollowersDtoStream = userFollowersDtoStream.sorted(Comparator.comparing(FollowerDto::getUserName));
        }
        return userFollowersDtoStream.toList();
    }

    @Override
    public FollowedByUserDto getFollowedByUser(int userId, String orderMethod) {
        Optional<User> optionalUser = userRepository.getUserById(userId);

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("El id ingresado no se corresponde a un user existente");
        }

        User userFound = optionalUser.get();

        List<User> usersFollowedByUser = getUsersByListOfId(userFound.getFollowed());

        List<FollowedDto> usersFollowedByUserDto = getFollowedDtoSortedList(orderMethod, usersFollowedByUser);

        return new FollowedByUserDto(userFound.getId(), userFound.getUserName(), usersFollowedByUserDto);
    }

    private List<FollowedDto> getFollowedDtoSortedList(String orderMethod, List<User> usersFollowedByUser) {
        OrderValidation.validateOrderMethodParam(orderMethod);

        Stream<FollowedDto> usersFollowedByUserStream = usersFollowedByUser
                .stream()
                .map(followed -> customMapper.mapToFollowedDto(followed));

        if (orderMethod != null && orderMethod.equalsIgnoreCase("name_desc")) {
            usersFollowedByUserStream = usersFollowedByUserStream.sorted(Comparator.comparing(FollowedDto::getUserName).reversed());
        } else {
            usersFollowedByUserStream = usersFollowedByUserStream.sorted(Comparator.comparing(FollowedDto::getUserName));
        }
        return usersFollowedByUserStream.toList();
    }

    private List<User> getUsersByListOfId(List<Integer> usersId) {
        return usersId
                .stream()
                .map(
                        userId -> userRepository.getUserById(userId)
                )
                .filter(
                        Optional::isPresent
                )
                .map(
                        Optional::get
                )
                .toList();
    }

    @Override
    public ResponseDto unfollowUser(int userId, int userIdToUnfollow) {
        Optional<User> mainUser = userRepository.getUserById(userId);
        Optional<User> userToUnfollow = userRepository.getUserById(userIdToUnfollow);

        if(mainUser.isEmpty() || userToUnfollow.isEmpty())
            throw new NotFoundException("No se encontraron los usuarios");

        if(userRepository.followedCount(userId) == 0)
            throw new NotFoundException("El usuario no tiene seguidos");

        if(mainUser.get().getFollowed()
                .stream().filter(u -> u == userIdToUnfollow).findFirst().orElse(null) == null)
            throw new NotFoundException("El usuario no contiene ese seguido");

        if(!userRepository.unfollowUser(userId,userIdToUnfollow)) {
           throw new InternalServerErrorException("Ocurrió un problema al eliminar seguido");
        }
        return new ResponseDto("El usuario dejó de seguir a " + userRepository.getUserNameById(userIdToUnfollow));
    }

    @Override
    public UserFollowersDto findFollowers(int id) {
        int followersCount = userRepository.followersCount(id);
        Optional<User> user = userRepository.getUserById(id);

        if(user.isEmpty()) {
            throw new NotFoundException("El id que busca no existe");
        }

        return new UserFollowersDto(id,user.get().getUserName(), followersCount);
    }

    @Override
    public ResponseDto followUser(int userId, int userIdToFollow) {
        User user = userRepository.getUserById(userId)
                .orElseThrow(() -> new NotFoundException("El usuario con ID: " + userId + " no existe."));

        User userToFollow = userRepository.getUserById(userIdToFollow)
                .orElseThrow(() -> new NotFoundException("El usuario a seguir con ID: " + userIdToFollow + " no existe."));

        if (userId == userIdToFollow) {
            throw new BadRequestException("Un usuario no puede seguirse a sí mismo.");
        }

        if (user.getFollowed().contains(userIdToFollow)) {
            throw new BadRequestException("El usuario con ID: " + userId + " ya sigue al usuario con ID: " + userIdToFollow);
        }

        if (!user.isSeller() && !userToFollow.isSeller()) {
            throw new BadRequestException("Un comprador solo puede seguir a un usuario vendedor.");
        }

        if (!userToFollow.isSeller()) {
            throw new BadRequestException("Solo se puede seguir a un usuario vendedor.");
        }

        userRepository.addFollow(userId,userIdToFollow);

        return new ResponseDto("Siguiendo al usuario: " + userRepository.getUserNameById(userIdToFollow) + " con ID: " + userIdToFollow);
    }

    @Override
    public ResponseDto addFavouritePost(int userId, int postId) {
        if (!userRepository.existsUserWithId(userId)) {
            throw new NotFoundException("El usuario con ID: " + userId + " no existe.");
        }
        if (!postRepository.existsPost(postId)) {
            throw new NotFoundException("El post con ID: " + postId + " no existe.");
        }

        User user = userRepository.getUserById(userId).get();
        if (user.getFavouritesPosts().stream().anyMatch(p -> p == postId)) {
            throw new BadRequestException("El post con id " + postId + " ya está agregado a favoritos");
        }

        userRepository.addFavouritePost(userId, postId);

        return new ResponseDto("El post fue agregado a favoritos de forma exitosa");
    }

    @Override
    public void removeFavouritePost(int userId, int postId) {
        if (!userRepository.existsUserWithId(userId)) {
            throw new NotFoundException("El usuario con ID: " + userId + " no existe.");
        }

        User user = userRepository.getUserById(userId).get();
        if (user.getFavouritesPosts().stream().noneMatch(p -> p == postId)) {
            throw new BadRequestException("El post con id " + postId + " no está agregado a favoritos para el usuario");
        }

        userRepository.removeFavouritePost(userId, postId);
    }

    @Override
    public FavouritePostsDto getFavouritePostsFromUser(int userId) {
        User user = userRepository.getUserById(userId)
                .orElseThrow(() -> new NotFoundException("El usuario con ID: " + userId + " no existe."));

        if(user.getFavouritesPosts().isEmpty()) {
            throw new NotFoundException("El usuario no posee ningun post en favoritos");
        }

        return new FavouritePostsDto(
                userId,
                user.getFavouritesPosts()
                        .stream()
                        .map(postId -> postRepository.getPostById(postId))
                        .map(post -> customMapper.mapToResponsePostDto(post))
                        .toList()
        );
    }
}
