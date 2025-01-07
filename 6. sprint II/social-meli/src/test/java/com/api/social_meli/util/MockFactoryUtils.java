package com.api.social_meli.util;

import com.api.social_meli.dto.*;
import com.api.social_meli.model.Post;
import com.api.social_meli.model.PostCategory;
import com.api.social_meli.model.Product;
import com.api.social_meli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MockFactoryUtils {

    //region ENTITIES MOCK
    public static List<Product> getProductsMock() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = ResourceUtils.getFile("classpath:products.json");
        return objectMapper.readValue(file, new TypeReference<List<Product>>() {});
    }

    public static List<Post> getPostsMock() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        File file = ResourceUtils.getFile("classpath:posts.json");
        return objectMapper.readValue(file, new TypeReference<List<Post>>() {});
    }

    public static List<PostCategory> getPostCategoriesMock() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = ResourceUtils.getFile("classpath:postcategory.json");
        return objectMapper.readValue(file, new TypeReference<List<PostCategory>>() {});
    }

    public static List<User> getUsersMock() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        file = ResourceUtils.getFile("classpath:users.json"); // obtencion de archivo
        return objectMapper.readValue(file, new TypeReference<List<User>>() {});
    }
    //endregion

    //region POSTS OF FOLLOWED SELLERS
    public static void setPostsAsPostedOneWeekAgo(List<Post> postsMock, List<Integer> postIds) {
        postIds.forEach(postId ->
                postsMock.stream()
                        .filter(post -> post.getPostId() == postId)
                        .forEach(post -> post.setPublishDate(LocalDate.now().minusWeeks(1)))
        );
    }

    public static void setPostsFromFollowedUsersAsPostedThreeWeeksAgo(List<Post> postMock, List<Integer> followedUserIds) {
        followedUserIds.forEach(followedUserId ->
                postMock.stream()
                        .filter(post -> post.getUserId() == followedUserId)
                        .forEach(post -> post.setPublishDate(LocalDate.now().minusWeeks(3))));
    }

    public static List<Post> filterPostsByUserId(List<Post> postsMock, int userId) {
         return postsMock.stream()
                .filter(post -> post.getUserId() == userId)
                .toList();
    }

    public static List<Integer> getFollowedsByUserId(List<User> userMocks, int userId) {
        return userMocks.stream()
                .filter(x -> x.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No existe el user con ese id entre los mocks."))
                .getFollowed();
    }
    //endregion

    //region USER CREATION
    public static User createUserWithOnlyFollowersAndFolloweds(int userId, List<Integer> followed, List<Integer> followers) {
        return new User(userId,"test",followed,followers,new ArrayList<>(),new ArrayList<>());
    }

    public static User createUserWithIdAndFollowed(int userId) {
        User user = new User();
        user.setId(userId);
        user.setFollowed(new ArrayList<>());
        return user;
    }

    public static User createUserWithFollowersAndPost(int userId) {
        User user = new User();
        user.setId(userId);
        user.setFollowers(new ArrayList<>());
        user.setPosts(new ArrayList<>(List.of(1)));
        return user;
    }
    //endregion

    //region GET FOLLOW SORTED LIST
    public static User createUserWithIdNameAndFolloweds(int userId, String name, List<Integer> followeds) {
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setFollowed(followeds);
        return user;
    }

    public static User createUserWithIdNameFollowersAndPost(int userId, String name, List<Integer> followers, List<Integer> posts) {
        User user = new User();
        user.setId(userId);
        user.setName(name);
        user.setFollowers(followers);
        user.setPosts(posts);
        return user;
    }

    public static FollowDto convertUserToFollowDto (User user) {
        return new FollowDto(user.getUserId(), user.getName());
    }

    public static boolean isSortedByDate(List<PostDto> posts, boolean ascending) {
        for (int i = 1; i < posts.size(); i++) {
            boolean condition = ascending
                    ? posts.get(i).getPublishDate().isBefore(posts.get(i - 1).getPublishDate())
                    : posts.get(i).getPublishDate().isAfter(posts.get(i - 1).getPublishDate());
            if (condition) {
                return false;
            }
        }
        return true;
    }
    //endregion


    public static GetFavouritePostsResponseDto createGetFavouritePostsResponseDtoForUser(int userId) throws IOException {
        List<User> users = getUsersMock();
        List<Post> posts = getPostsMock();

        Optional<User> optionalUser = users.stream().filter(u -> u.getId() == userId).findFirst();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            List<PostDto> favouritePosts = user.getFavourites().stream()
                    .flatMap(postId -> posts.stream()
                            .filter(post -> post.getId() == postId)
                            .findFirst()
                            .stream()
                    )
                    .map(post -> new PostDto(
                            post.getPostId(),
                            post.getUserId(),
                            post.getPublishDate(),
                            new ProductDto(
                                    post.getProduct().getProductId(),
                                    post.getProduct().getName(),
                                    post.getProduct().getType(),
                                    post.getProduct().getBrand(),
                                    post.getProduct().getColour(),
                                    post.getProduct().getNotes()
                            ),
                            post.getCategoryId(),
                            post.getPrice()
                    ))
                    .collect(Collectors.toList());


            return new GetFavouritePostsResponseDto(userId, favouritePosts);
        }

        throw new IllegalArgumentException("User with ID " + userId + " not found");
    }


}
