package com.bootcamp.social_meli.repository.impl;

import com.bootcamp.social_meli.exception.NotFoundException;
import com.bootcamp.social_meli.model.User;
import com.bootcamp.social_meli.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Value("${api.scope}")
    private String SCOPE;
    private ObjectMapper objectMapper;
    private List<User> usersList = new ArrayList<>();

    @Autowired
    public UserRepositoryImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public User create(User user) {
        user.setFollowers(new ArrayList<>());
        user.setFollowed(new ArrayList<>());
        user.setId((long) usersList.size() + 1);
        usersList.add(user);

        try{
            if (SCOPE.equalsIgnoreCase("main")) {
                String DATA_FILE = "src/main/resources/users.json";
                objectMapper.writeValue(new File(DATA_FILE), usersList);
            }
        }catch(IOException e){
            throw new RuntimeException("Error guardando la lista", e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return usersList;
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersList.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public List<User> findFollowsByUserId(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario: " + id)).getFollowed();
    }

    @Override
    public void createBatch(List<User> users) {
        usersList.addAll(users);
    }

    @Override
    public User findByUsername(String username) {
        return usersList.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

}
