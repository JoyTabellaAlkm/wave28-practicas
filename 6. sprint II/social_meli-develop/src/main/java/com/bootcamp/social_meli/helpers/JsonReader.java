package com.bootcamp.social_meli.helpers;

import com.bootcamp.social_meli.exception.NotFoundException;
import com.bootcamp.social_meli.model.Post;
import com.bootcamp.social_meli.model.Product;
import com.bootcamp.social_meli.model.User;
import com.bootcamp.social_meli.repository.IPostRepository;
import com.bootcamp.social_meli.repository.IProductRepository;
import com.bootcamp.social_meli.repository.IUserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JsonReader {

    @Value("${api.scope}")
    private String SCOPE;

    private IPostRepository postRepository = null;
    private IUserRepository userRepository = null;
    private IProductRepository productRepository = null;
    private final ObjectMapper objectMapper;

    public JsonReader(IPostRepository postRepository, IUserRepository userRepository, IProductRepository productRepository, ObjectMapper objectMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
        objectMapper.registerModule(new JavaTimeModule());
    }

    private void loadUsers() {
        String DATA_FILE = "src/" + SCOPE + "/resources/users.json";
        try {
            List<User> usersList = objectMapper.readValue(new File(DATA_FILE), new TypeReference<List<User>>() {
            });

            usersList.forEach(user -> {
                user.setFollowers(new ArrayList<>());
                user.setFollowed(new ArrayList<>());
            });

            followUser(usersList.get(0), usersList.get(1));
            followUser(usersList.get(0), usersList.get(2));
            followUser(usersList.get(0), usersList.get(3));

            followUser(usersList.get(1), usersList.get(2));
            followUser(usersList.get(1), usersList.get(3));
            followUser(usersList.get(1), usersList.get(0));

            followUser(usersList.get(2), usersList.get(0));
            followUser(usersList.get(2), usersList.get(1));
            followUser(usersList.get(2), usersList.get(3));

            followUser(usersList.get(3), usersList.get(1));
            followUser(usersList.get(3), usersList.get(2));
            followUser(usersList.get(3), usersList.get(4));

            userRepository.createBatch(usersList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadProducts() {
        String DATA_FILE = "src/" + SCOPE + "/resources/products.json";
        try {

            productRepository.createBatch(objectMapper.readValue(new File(DATA_FILE), new TypeReference<List<Product>>() {
            }));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadPosts() {
        String DATA_FILE = "src/" + SCOPE + "/resources/posts.json";
        try {
            List<Post> postList = new ArrayList<>();
            List<PostConvert> postConvertList = objectMapper.readValue(new File(DATA_FILE), new TypeReference<List<PostConvert>>() {
            });
            postConvertList.forEach(postConvert -> {
                User user = userRepository.findById(postConvert.getUserId()).orElseThrow(() -> new NotFoundException("No se ha encontrado al usuario:" + " " + postConvert.getUserId()));
                Product product = productRepository.findById(postConvert.getProductId()).orElseThrow(() -> new NotFoundException("No se ha encontrado al " + "product: " + postConvert.getProductId()));
                Post post = objectMapper.convertValue(postConvert, Post.class);
                post.setCreatorUser(user);
                post.setProduct(product);
                postList.add(post);
            });
            postRepository.createBatch(postList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    void loadData() {
        loadUsers();
        loadProducts();
        loadPosts();
    }

    private void followUser(User user, User userToFollow) {
        List<User> userFollowedList = user.getFollowed();
        List<User> userToFollowFollowersList = userToFollow.getFollowers();
        userFollowedList.add(userToFollow);
        userToFollowFollowersList.add(user);
    }

}
