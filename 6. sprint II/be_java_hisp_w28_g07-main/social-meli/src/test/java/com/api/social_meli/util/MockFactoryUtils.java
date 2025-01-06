package com.api.social_meli.util;

import com.api.social_meli.dto.*;
import com.api.social_meli.model.Post;
import com.api.social_meli.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.ResourceUtils;

import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockFactoryUtils {

    //region ENTITIES MOCK

    public static List<Post> getPostsMock() {
        List<Post> postsMock = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            File file = ResourceUtils.getFile("classpath:posts.json");
            postsMock = objectMapper.readValue(file, new TypeReference<List<Post>>() {
            });
        } catch (IOException e) {
            System.out.println("Hubo un error con la lectura del archivo");
        }
        return postsMock;
    }

    public static List<User> getUsersMock() {
        List<User> usersMock = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = ResourceUtils.getFile("classpath:users.json");
            usersMock = objectMapper.readValue(file, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            System.out.println("Hubo un error con la lectura del archivo");
        }
        return usersMock;
    }

    //endregion

    //region POSTS

    public static PostDto createPostResponseDto(){
        return new PostDto(6,
                2,
                LocalDate.parse("29-04-2021", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new ProductDto(
                        1,
                        "Silla Gamer",
                        "Gamer",
                        "Racer",
                        "RedBlack",
                        "Special Edition"
                ),
                2,
                1500.50);
    }

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

    //region SORT

    public static boolean arePostsSortedByDate(List<PostDto> posts, boolean ascending) {
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

    public static FollowedSellerPostsDto getFollowedSellersPostsDtoSortedAsc() {
        return new FollowedSellerPostsDto(
                1,
                new ArrayList<>(
                        List.of(
                                new PostDto(
                                        2,
                                        3,
                                        LocalDate.now().minusWeeks(1),
                                        new ProductDto(3, "Wireless Headphones", "Accessories",
                                                "Sony", "Black", "Noise cancellation, 30-hour battery"),
                                        3,
                                        199.99
                                ),
                                new PostDto(
                                        4,
                                        3,
                                        LocalDate.now().minusDays(10),
                                        new ProductDto(6, "Laptop HP Envy", "Electronics", "HP",
                                                "Silver", "Intel Core i7, 16GB RAM, 512GB SSD"),
                                        1,
                                        1199.99
                                )
                        )
                )
        );
    }

    public static FollowedSellerPostsDto getFollowedSellersPostsDtoSortedDesc() {
        return new FollowedSellerPostsDto(
                1,
                new ArrayList<>(
                        List.of(
                                new PostDto(
                                        4,
                                        3,
                                        LocalDate.now().minusDays(10),
                                        new ProductDto(6, "Laptop HP Envy", "Electronics", "HP",
                                                "Silver", "Intel Core i7, 16GB RAM, 512GB SSD"),
                                        1,
                                        1199.99
                                ),
                                new PostDto(
                                        2,
                                        3,
                                        LocalDate.now().minusWeeks(1),
                                        new ProductDto(3, "Wireless Headphones", "Accessories",
                                                "Sony", "Black", "Noise cancellation, 30-hour battery"),
                                        3,
                                        199.99
                                )
                        )
                )
        );
    }

    //endregion

    //endregion

    //region USER CREATION

    public static User createUserWithOnlyFollowersAndFolloweds(int userId, List<Integer> followed, List<Integer> followers) {
        return new User(userId, "test", followed, followers, new ArrayList<>(), new ArrayList<>());
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

    //endregion

    //region GET FAVOURITE POSTS

    public static GetFavouritePostsResponseDto createGetFavouritePostsResponseDtoForUser()  {
        List<PostDto> favouritePosts = new ArrayList<>();

        ProductDto product1 = new ProductDto();
        product1.setProductId(1);
        product1.setName("Smartphone Galaxy S21");
        product1.setType("Electronics");
        product1.setBrand("Samsung");
        product1.setColour("Phantom Gray");
        product1.setNotes("Latest model, 128GB storage");

        PostDto post1 = new PostDto();
        post1.setPostId(1);
        post1.setUserId(2);
        post1.setPublishDate(LocalDate.parse("15-12-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        post1.setProduct(product1);
        post1.setCategoryId(1);
        post1.setPrice(799.99);

        ProductDto product2 = new ProductDto();
        product2.setProductId(3);
        product2.setName("Wireless Headphones");
        product2.setType("Accessories");
        product2.setBrand("Sony");
        product2.setColour("Black");
        product2.setNotes("Noise cancellation, 30-hour battery");

        PostDto post2 = new PostDto();
        post2.setPostId(2);
        post2.setUserId(3);
        post2.setPublishDate(LocalDate.parse("13-12-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        post2.setProduct(product2);
        post2.setCategoryId(3);
        post2.setPrice(199.99);

        favouritePosts.add(post1);
        favouritePosts.add(post2);


        GetFavouritePostsResponseDto favouritePostsResponse = new GetFavouritePostsResponseDto();
        favouritePostsResponse.setUserId(1);
        favouritePostsResponse.setFavouritePosts(favouritePosts);

        return favouritePostsResponse;
    }

    //endregion

    //region GET POST BY CATEGORY

    public static GetByCategoryResponseDto getPostByCategoryResponseDto(){
        return new GetByCategoryResponseDto("Accessories",List.of(
                new PostDto(
                        2,
                        3,
                        LocalDate.parse("13-12-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        new ProductDto(
                                3,
                                "Wireless Headphones",
                                "Accessories",
                                "Sony",
                                "Black",
                                "Noise cancellation, 30-hour battery"
                        ),
                        3,
                        199.99
                )
        ));
    }

    //endregion
}
