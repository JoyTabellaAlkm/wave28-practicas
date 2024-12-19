package com.mercadolibre.social.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.social.entity.User;
import com.mercadolibre.social.exception.NotFoundException;
import com.mercadolibre.social.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepository implements IUserRepository {

    private List<User> users;

    public UserRepository() throws IOException {
        this.users = loadDataBase();
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findById(Integer id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));
    }

    @Override
    public List<User> findUsersByIds(Set<Integer> ids) {
        return new ArrayList<>(users.stream()
                .filter(user -> ids.contains(user.getId()))
                .toList());
    }

    private List<User> loadDataBase() throws IOException {
        String FILE_PATH = "src/main/resources/users.json";
        ObjectMapper objectMapper = new ObjectMapper();
        try (FileInputStream inputStream = new FileInputStream(FILE_PATH)) {
            return objectMapper.readValue(inputStream, new TypeReference<List<User>>() {
            });
        }
    }


}
