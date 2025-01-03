package com.spring1.meliSocial.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring1.meliSocial.exception.BadRequestException;
import com.spring1.meliSocial.exception.InternalServerErrorException;
import com.spring1.meliSocial.exception.NotFoundException;
import com.spring1.meliSocial.model.Post;
import com.spring1.meliSocial.model.User;
import com.spring1.meliSocial.repository.IUserRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Repository
public class UserRepository implements IUserRepository {

    private List<User> users = new ArrayList<>();
    private String SCOPE;

    public UserRepository() throws IOException {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        file= ResourceUtils.getFile("./src/" + SCOPE + "/resources/user.json");
        users= objectMapper.readValue(file,new TypeReference<List<User>>(){});
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public Optional<User> getUserById(int id) {
        return users.stream().filter(x -> x.getId() == id).findFirst();
    }

    @Override
    public boolean existsUserWithId(int id) {
        return users.stream().anyMatch(u -> u.getId() == id);
    }

    @Override
    public String getUserNameById(int id) {
        return users.stream()
                .filter(x -> x.getId() == id)
                .map(User::getUserName)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Usuario con ID: " + id + " no encontrado."));
    }


    @Override
    public boolean unfollowUser(int userId, int userIdToUnfollow) {
        Optional<User> user = getUserById(userId);
        Optional<User> userUnfollowed = getUserById(userIdToUnfollow);

        boolean followed = user.get().getFollowed().remove(Integer.valueOf(userIdToUnfollow));
        boolean followers = userUnfollowed.get().getFollowers().remove(Integer.valueOf(userId));

        return  followed && followers;
    }

    @Override
    public int followersCount(int id) {
        Optional<User> user = getUserById(id);
        return user.map(value -> value.getFollowers().size()).orElse(-1);
    }

    @Override
    public int followedCount(int userId) {
        Optional<User> user = getUserById(userId);
        return user.map(value -> value.getFollowed().size()).orElse(-1);
    }

    @Override
    public void addFollow(int userId, int userIdToFollow) {
        User user = getUserById(userId)
                .orElseThrow(() -> new NotFoundException("El usuario con ID: " + userId + " no existe."));

        User userToFollow = getUserById(userIdToFollow)
                .orElseThrow(() -> new NotFoundException("El usuario a seguir con ID: " + userIdToFollow + " no existe."));

        user.getFollowed().add(userIdToFollow);
        userToFollow.getFollowers().add(userId);
    }

    @Override
    public void addFavouritePost(int userId, int postId) {
        User user = getUserById(userId)
                .orElseThrow(() -> new NotFoundException("El usuario con ID: " + userId + " no existe."));

        Set<Integer> userFavouritesPosts = user.getFavouritesPosts();
        boolean succesfulAdd = userFavouritesPosts.add(postId);
        if (!succesfulAdd) {
            throw new InternalServerErrorException("No se pudo agregar el post con id " + postId + " a los favoritos para el user con id " + userId);
        }
    }

    @Override
    public void removeFavouritePost(int userId, int postId) {
        User user = getUserById(userId)
                .orElseThrow(() -> new NotFoundException("El usuario con ID: " + userId + " no existe."));

        Set<Integer> userFavouritesPosts = user.getFavouritesPosts();
        boolean succesfulRemove = userFavouritesPosts.remove(postId);
        if (!succesfulRemove) {
            throw new InternalServerErrorException("No se pudo remover el post con id " + postId + " de los favoritos para el user con id " + userId);
        }

        user.setFavouritesPosts(userFavouritesPosts);
    }


}

