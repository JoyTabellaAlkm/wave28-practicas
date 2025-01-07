package com.api.social_meli.service.impl;

import com.api.social_meli.dto.*;
import com.api.social_meli.exception.BadRequestException;
import com.api.social_meli.exception.ConflictException;
import com.api.social_meli.exception.NotFoundException;
import com.api.social_meli.model.User;
import com.api.social_meli.repository.IPostRepository;
import com.api.social_meli.repository.IUserRepository;
import com.api.social_meli.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IPostRepository postRepository;

    @Autowired
    private PostServiceImpl postServiceImpl;

    @Autowired
    ObjectMapper mapper;

    public GetFollowerCountDto getFollowerCount(int userId) {
        User user = userRepository.findById(userId);
        if(user == null)
            throw new NotFoundException("Usuario no encontrado");

        int followerCount = user.getFollowers().size();
        return new GetFollowerCountDto(user.getUserId(), user.getName(), followerCount);
    }

    @Override
    public FollowerListDto getFollowersOrderedByName(int userId, String order) {
        //Verifica que el usuario exista
        User searchedUser = userRepository.findById(userId);
        if(!userRepository.exists(userId))
            throw new NotFoundException("No se encontró el usuario.");

        //Verifica si el usuario es un vendedor
        if(!searchedUser.isSeller())
            throw new BadRequestException("El usuario no es un vendedor y no puede tener seguidores.");

        List<FollowDto> followerDtos = searchedUser.getFollowers().stream()
                .map(followerId -> mapper.convertValue(userRepository.findById(followerId), FollowDto.class))
                .toList();

        if (order != null)
            followerDtos = sortList(followerDtos, order);

        return new FollowerListDto(searchedUser.getId(),searchedUser.getName(), followerDtos);
    }

    @Override
    public FollowedListDto getFollowedsOrderedByName(int userId, String order){
        //Verifica que el usuario exista
        User searchedUser = userRepository.findById(userId);
        if(!userRepository.exists(userId))
            throw new NotFoundException("No se encontró el usuario.");

        List<FollowDto> followedDtos = searchedUser.getFollowed().stream()
                .map(followedId -> mapper.convertValue(userRepository.findById(followedId), FollowDto.class))
                .toList();

        if (followedDtos.isEmpty())
            throw new NotFoundException("El usuario, no sigue a ningún vendedor.");

        if (order != null) {
            followedDtos = sortList(followedDtos, order);
        }

        return new FollowedListDto(searchedUser.getId(),searchedUser.getName(), followedDtos);
    }

    @Override
    public MessageDto unfollowUser(int userId, int userIdToUnfollow) {
        User user = userRepository.findById(userId);
        User userToUnfollow = userRepository.findById(userIdToUnfollow);
        if(user == null)
            throw new NotFoundException("Usuario no encontrado");

        if (userToUnfollow == null)
            throw new NotFoundException("Usuario a seguir no encontrado");

        if (!user.getFollowed().contains(userToUnfollow.getUserId()))
            throw new BadRequestException("Actualmente no sigue a ese usuario");

        user.getFollowed().remove(Integer.valueOf(userToUnfollow.getUserId()) );
        userToUnfollow.getFollowers().remove(Integer.valueOf(user.getUserId()));
        return new MessageDto("El usuario se dejo de seguir exitosamente");
    }

    @Override
    public MessageDto followUser(int userId, int userIdToFollow) {
        User user = userRepository.findById(userId);
        User userToFollow = userRepository.findById(userIdToFollow);

        if (user == null || userToFollow == null)
            throw new NotFoundException("Usuario o vendedor no encontrado");

        if (!userToFollow.isSeller())
            throw new BadRequestException("El usuario a seguir no es vendedor");

        // Validar si el usuario ya está siguiendo al usuario objetivo

        if (user.getFollowed().contains(userIdToFollow))
            throw new BadRequestException("Ya estás siguiendo a este usuario");

        // Agrega el usuario vendedor a la lista del usuario seguidor

        user.getFollowed().add(userIdToFollow);

        // Agrega el usuario seguidor a la lista del usuario vendedor
        if (!userToFollow.getFollowers().contains(userId))
            userToFollow.getFollowers().add(userId);

        return new MessageDto("El usuario se comenzo a seguir exitosamente");
    }

    @Override
    public List<UserDto> searchAllUsers() {
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = userRepository.findAll();
        if(userList.isEmpty())
            throw new NotFoundException("No se encontró ningun usuario en el sistema.");

        return userList.stream()
                .map(v -> mapper.convertValue(v, UserDto.class))
                .toList();
    }

    @Override
    public MessageDto favouritePost(FavouritePostRequestDto dto) {
        if (!postRepository.exists(dto.getPostId()))
            throw new NotFoundException("No se encontró ningún post con ese ID.");

        User user = userRepository.findById(dto.getUserId());
        if (user == null)
            throw new NotFoundException("No se encontró ningún usuario con ese ID.");

        if (user.getFavourites().stream().anyMatch(x -> x == dto.getPostId()))
            throw new ConflictException("El post ya está en favoritos");

        user.getFavourites().add(dto.getPostId());
        return new MessageDto("Publicación agregada a favoritos exitosamente");
    }

    @Override
    public MessageDto unfavouritePost(FavouritePostRequestDto dto) {
        if (!postRepository.exists(dto.getPostId()))
            throw new NotFoundException("No se encontro el post");

        User user = userRepository.findById(dto.getUserId());

        if (user == null){
            throw new NotFoundException("No se encontro el usuario");
        }

        if(user.getFavourites().stream().noneMatch(x -> x == dto.getPostId())){
            throw new BadRequestException("El post no esta en favoritos");
        }

        user.getFavourites().remove(Integer.valueOf(dto.getPostId()));
        return new MessageDto("Post sacado de favoritos correctamente");

    }

    @Override
    public GetFavouritePostsResponseDto getFavouritePosts(int userId) {
        User user = userRepository.findById(userId);
        if (user == null)
            throw new NotFoundException("No se encontró ningún usuario con ese ID.");

        List<PostDto> posts = user.getFavourites()
                .stream()
                .map(x -> postServiceImpl.getPostById(x))
                .toList();
        return new GetFavouritePostsResponseDto(userId, posts);
    }

    private List<FollowDto> sortList (List<FollowDto> list, String order){
        List<FollowDto> sortList = new ArrayList<>(list);
        switch (order) {
            case "name_asc":
                sortList.sort((followed1, followed2) -> followed1.getName().compareTo(followed2.getName()));
                break;
            case "name_desc":
                sortList.sort((followed1, followed2) -> followed2.getName().compareTo(followed1.getName()));
                break;
            default:
                throw new BadRequestException("No es un ordenamiento válido.");
        }
        return sortList;
    }
}
