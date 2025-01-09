package com.bootcamp.socialmeli.unit.service;

import com.bootcamp.socialmeli.dto.response.RecentPostDto;
import com.bootcamp.socialmeli.dto.response.RecentPostsDto;
import com.bootcamp.socialmeli.entity.Post;
import com.bootcamp.socialmeli.entity.User;
import com.bootcamp.socialmeli.exception.BadRequestException;
import com.bootcamp.socialmeli.factory.PostFactory;
import com.bootcamp.socialmeli.factory.UserFactory;
import com.bootcamp.socialmeli.repository.PostRepository;
import com.bootcamp.socialmeli.repository.UserRepository;
import com.bootcamp.socialmeli.service.PostService;
import com.bootcamp.socialmeli.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    static List<Post> unOrderedPost;
    @Mock
    UserRepository userRepository;
    @Mock
    PostRepository postRepository;
    @InjectMocks
    PostService service;

    @BeforeEach
    public void createPosts() {
        User seller1 = UserFactory.createSellerWithIdFollowedBy(1, 10);
        User seller2 = UserFactory.createSellerWithIdFollowedBy(2, 10);
        User seller3 = UserFactory.createSellerWithIdFollowedBy(3, 10);
        User seller4 = UserFactory.createSellerWithIdFollowedBy(4, 10);
        User seller5 = UserFactory.createSellerWithIdFollowedBy(5, 10);
        User seller6 = UserFactory.createSellerWithIdFollowedBy(6, 8);
        User seller7 = UserFactory.createSellerWithIdFollowedBy(7, 8);
        User user8 = UserFactory.createAmmyBlanton();

        lenient().when(userRepository.getUserById(1)).thenReturn(Optional.of(seller1));
        lenient().when(userRepository.getUserById(2)).thenReturn(Optional.of(seller2));
        lenient().when(userRepository.getUserById(3)).thenReturn(Optional.of(seller3));
        lenient().when(userRepository.getUserById(4)).thenReturn(Optional.of(seller4));
        lenient().when(userRepository.getUserById(5)).thenReturn(Optional.of(seller5));
        lenient().when(userRepository.getUserById(6)).thenReturn(Optional.of(seller6));
        lenient().when(userRepository.getUserById(7)).thenReturn(Optional.of(seller7));
        lenient().when(userRepository.getUserById(8)).thenReturn(Optional.of(user8));

        Post post1 = PostFactory.generatePostWithIdXDaysAgo(1, 1, 20);
        Post post2 = PostFactory.generatePostWithIdXDaysAgo(2, 2, 30);
        Post post3 = PostFactory.generatePostWithIdXDaysAgo(3, 3, 1);
        Post post4 = PostFactory.generatePostWithIdXDaysAgo(4, 4, 5);
        Post post5 = PostFactory.generatePostWithIdXDaysAgo(5, 5, 13);
        Post post6 = PostFactory.generatePostWithIdXDaysAgo(6, 6, 5);
        Post post7 = PostFactory.generatePostWithIdXDaysAgo(7, 7, 13);
        unOrderedPost = List.of(post1, post2, post3, post4, post5);

        lenient().when(postRepository.findAll()).thenReturn(List.of(post1, post2, post3, post4, post5, post6, post7));
    }

    @Test
    public void givenUserId_whenGettingPostListWithInvalidOrder_thenReturnsBadRequestException() {

        // ARRANGE
        int userId = 8;
        String ordering = "invalid";

        // ACT & ASSERT
        assertThrows(
                BadRequestException.class,
                () -> service.getRecentFollowedPosts(userId, ordering));
    }

    @Test
    public void givenUserId_whenGettingPostListWithDescOrder_thenReturnsCorrectly() {

        //ARRANGE
        int userId = 8;
        int postId = 6;
        String ordering = "date_desc";

        //ACT
        RecentPostsDto response = service.getRecentFollowedPosts(userId, ordering);

        //ASSERT
        Assertions.assertEquals(postId, response.getPosts().getFirst().getId());

    }

    @Test
    public void givenUserId_whenGettingPostListWithNullOrder_thenReturnBadRequestException() {
        //ARRANGE
        int userId = 8;
        String ordering = null;

        // ACT & ASSERT
        assertThrows(
                BadRequestException.class,
                () -> service.getRecentFollowedPosts(userId, ordering));

    }

    @Test
    public void givenUserId_whenGettingPostListWithAscOrder_thenReturnsCorrectly() {

        //ARRANGE
        int userId = 8;
        int postId = 7;
        String ordering = "date_asc";

        //ACT
        RecentPostsDto response = service.getRecentFollowedPosts(userId, ordering);

        //ASSERT
        Assertions.assertEquals(postId, response.getPosts().getFirst().getId());

    }

    @Test
    public void givenListOfPost_whenDescOrdering_thenReturnOrderedListByDate() {
        /* ARRANGE */
        List<Integer> expectedIdOrder = List.of(3, 4, 5, 1, 2);
        boolean ascending = false;

        /* ACT */
        List<Post> orderedPost = Utils.sortList(unOrderedPost, Post::getDate, ascending);

        /* ASSERT */
        assertThat(orderedPost).extracting(Post::getId).isEqualTo(expectedIdOrder);
    }

    @Test
    public void givenListOfPost_whenAscOrdering_thenReturnOrderedListByDate() {
        /* ARRANGE */
        List<Integer> expectedIdOrder = List.of(2, 1, 5, 4, 3);
        boolean ascending = true;

        /* ACT */
        List<Post> orderedPost = Utils.sortList(unOrderedPost, Post::getDate, ascending);

        /* ASSERT */
        assertThat(orderedPost).extracting(Post::getId).isEqualTo(expectedIdOrder);
    }

    @Test
    public void givenListOfPost_whenGettingRecentPost_thenReturnRecentOrderedPosts() {
        /* ARRANGE */
        int userId = 10;
        String ordering = "date_desc";

        User user = UserFactory.createUserWithIdThatFollows(userId, List.of(1, 2, 3, 4, 5));
        List<Integer> expectedIdsWithOrder = List.of(3, 4, 5);
        int expectedPostsSize = 3;

        lenient().when(userRepository.getUserById(userId)).thenReturn(Optional.of(user));
        lenient().when(postRepository.findAll()).thenReturn(unOrderedPost);

        /* ACT */
        RecentPostsDto response = service.getRecentFollowedPosts(userId, ordering);

        /* ASSERT */
        verify(userRepository, times(6)).getUserById(anyInt());
        verify(postRepository, atLeastOnce()).findAll();
        assertThat(response.getPosts()).hasSize(expectedPostsSize);
        assertThat(response.getPosts()).extracting(RecentPostDto::getId).isEqualTo(expectedIdsWithOrder);
    }

    @Test
    public void givenListOfPost_whenGettingRecentPost_thenReturnPostsWithin2Weeks() {
        /* ARRANGE */
        int userId = 10;
        String ordering = "date_desc";

        User user = UserFactory.createUserWithIdThatFollows(userId, List.of(1, 2, 3));
        int expectedPostsSize = 1;

        lenient().when(userRepository.getUserById(userId)).thenReturn(Optional.of(user));
        lenient().when(postRepository.findAll()).thenReturn(unOrderedPost);

        /* ACT */
        RecentPostsDto response = service.getRecentFollowedPosts(userId, ordering);

        /* ASSERT */
        verify(userRepository, atLeastOnce()).getUserById(userId);
        verify(postRepository, atLeastOnce()).findAll();
        assertThat(response.getPosts()).hasSize(expectedPostsSize);
    }
}
