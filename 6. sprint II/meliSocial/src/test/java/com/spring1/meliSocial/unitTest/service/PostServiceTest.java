package com.spring1.meliSocial.unitTest.service;

import com.spring1.meliSocial.dto.response.PostIndexDto;
import com.spring1.meliSocial.dto.response.ResponsePostDto;
import com.spring1.meliSocial.exception.BadRequestException;
import com.spring1.meliSocial.exception.NotFoundException;
import com.spring1.meliSocial.mapper.IMapper;
import com.spring1.meliSocial.model.Post;
import com.spring1.meliSocial.model.Product;
import com.spring1.meliSocial.model.User;
import com.spring1.meliSocial.repository.IPostRepository;
import com.spring1.meliSocial.repository.IUserRepository;
import com.spring1.meliSocial.service.impl.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    IPostRepository postRepository;

    @Mock
    IUserRepository userRepository;

    @Mock
    IMapper customMapper;

    @InjectMocks
    PostService postService;

    User seller1;
    User user2;
    User user9;
    Post post1;
    Post post2;
    Post post17;
    Post post18;
    Post post19;
    Post oldPost200;
    Post oldPost300;

    List<Post> postsEsperados;
    ResponsePostDto postDto17;
    ResponsePostDto postDto18;

    @BeforeEach
    public void setUp() {
        seller1 = new User(1, "seller1", true, List.of(2), new ArrayList<>(), new ArrayList<>(), new HashSet<>());
        user2 = new User(2, "user 2", false, new ArrayList<>(), List.of(1), new ArrayList<>(), new HashSet<>());
        post1 = new Post(1, 1, LocalDate.now(), null, 2, 100.0, false, 0.0);
        post2 = new Post(2, 1, LocalDate.now(), null, 2, 250.0, false, 0.0);

        //test de post x order
        user9= new User(9, "Lucia Quezada", false, List.of(), List.of(8), List.of(), Set.of());
        post17 = new Post(17, 8, LocalDate.now().minusDays(2), new Product(), 2, 20.99, true, 0.3);
        post18 = new Post(18, 8, LocalDate.now(), new Product(), 55, 15.99, true, 0.5);
        post19 = new Post(19, 1, LocalDate.now(), new Product(), 55, 25.99, true, 0.5);
        postsEsperados = List.of(post17, post18);
        postDto17 = new ResponsePostDto(17, 8, LocalDate.now().minusDays(2), null, 2, 20.99, true, 0.3);
        postDto18 = new ResponsePostDto(18, 8, LocalDate.now(), null, 55, 15.99, true, 0.5);
        oldPost200 = new Post(200, 1, LocalDate.now().minusDays(15), new Product(), 2, 22.00, false, 0.0);
        oldPost300 = new Post(300, 1, LocalDate.now().minusDays(15), new Product(), 2, 55.00, false, 0.0);
        postDto17 = new ResponsePostDto(17, 8, LocalDate.now().minusDays(2), null, 2, 20.99, true, 0.3);
        postDto18 = new ResponsePostDto(18, 8, LocalDate.now(), null, 55, 15.99, true, 0.5);
    }

    @Test
    @DisplayName("6- Verificar el correcto ordenamiento ascendente")
    public void testGetPostsByUser_OrderAscOK() {
        //arr
        int userId = 9;
        String order = "date_asc";

        when(userRepository.getUserById(userId)).thenReturn(Optional.of(user9));
        when(postRepository.getPosts()).thenReturn(postsEsperados);
        when(customMapper.mapToResponsePostDto(postsEsperados.get(0))).thenReturn(postDto17);
        when(customMapper.mapToResponsePostDto(postsEsperados.get(1))).thenReturn(postDto18);

        PostIndexDto resultado = postService.getPostsByUser(userId, order);

        List<ResponsePostDto> posteos = resultado.getPosts();
        assertNotNull(posteos);
        assertEquals(2, posteos.size());
        assertEquals(17, posteos.get(0).getId());
        assertEquals(18, posteos.get(1).getId());
        assertEquals(LocalDate.now().minusDays(2), posteos.get(0).getDate());
        assertEquals(LocalDate.now(), posteos.get(1).getDate());
    }

    @Test
    @DisplayName("6.1- Verificar el correcto ordenamiento descendente")
    public void testGetPostsByUser_OrderDescOK() {
        //arr
        int userId = 9;
        String order = "date_desc";

        when(userRepository.getUserById(userId)).thenReturn(Optional.of(user9));
        when(postRepository.getPosts()).thenReturn(postsEsperados);
        when(customMapper.mapToResponsePostDto(postsEsperados.get(0))).thenReturn(postDto17);
        when(customMapper.mapToResponsePostDto(postsEsperados.get(1))).thenReturn(postDto18);

        PostIndexDto resultado = postService.getPostsByUser(userId, order);

        List<ResponsePostDto> posteos = resultado.getPosts();
        assertNotNull(posteos);
        assertEquals(2, posteos.size());
        assertEquals(18, posteos.get(0).getId());
        assertEquals(17, posteos.get(1).getId());
        assertEquals(LocalDate.now(), posteos.get(0).getDate());
        assertEquals(LocalDate.now().minusDays(2), posteos.get(1).getDate());
    }

    @Test
    public void testGetPostsByUser_SortedByDateDescending() {
        when(userRepository.getUserById(user2.getId())).thenReturn(Optional.of(user2));
        when(postRepository.getPosts()).thenReturn(List.of(post1, post2));

        when(customMapper.mapToResponsePostDto(post1)).thenReturn(new ResponsePostDto(
                post1.getId(),
                post1.getUserId(),
                post1.getDate(),
                null,
                post1.getCategory(),
                post1.getPrice(),
                post1.isHasPromo(),
                post1.getDiscount()
        ));

        when(customMapper.mapToResponsePostDto(post2)).thenReturn(new ResponsePostDto(
                post2.getId(),
                post2.getUserId(),
                post2.getDate(),
                null,
                post2.getCategory(),
                post2.getPrice(),
                post2.isHasPromo(),
                post2.getDiscount()
        ));

        PostIndexDto result = postService.getPostsByUser(2, "date_desc");

        int resultUserId = result.getUserId();
        List<ResponsePostDto> resultPosts = result.getPosts();
        assertEquals(2, resultUserId);
        assertEquals(2, resultPosts.size());
    }

    @Test
    public void testGetPostsByUser_InvalidUserId() {
        assertThrows(BadRequestException.class,
                () -> postService.getPostsByUser(0, "date_desc"));
    }

    @Test
    public void testGetPostsByUser_InvalidOrderPram() {
        assertThrows(BadRequestException.class,
                () -> postService.getPostsByUser(2, "date_asccc"));
    }

    @Test
    public void testGetPostsByUser_InvalidUserNotFound() {
        assertThrows(NotFoundException.class,
                () -> postService.getPostsByUser(2, "date_asc"));
    }

    @Test
    public void testGetPostsByUser_UserIdNoResult() {
        when(userRepository.getUserById(seller1.getId())).thenReturn(Optional.of(seller1));
        when(postRepository.getPosts()).thenReturn(List.of(post1, post2));

        PostIndexDto result = postService.getPostsByUser(1, "date_desc");

        int resultUserId = result.getUserId();
        List<ResponsePostDto> resultPosts = result.getPosts();
        assertEquals(1, resultUserId);
        assertEquals(0, resultPosts.size());
    }

    @Test
    public void testGetPostsByUser_AllPostsWerePublishedMoreThanTwoWeeksAgo() {
        when(userRepository.getUserById(user2.getId())).thenReturn(Optional.of(user2));
        when(postRepository.getPosts()).thenReturn(List.of(oldPost200, oldPost300));

        PostIndexDto result = postService.getPostsByUser(user2.getId(), "date_desc");

        int resultUserId = result.getUserId();
        List<ResponsePostDto> resultPosts = result.getPosts();
        assertEquals(2, resultUserId);
        assertEquals(0, resultPosts.size());
    }

    @Test
    public void testGetPostsByUser_SomePostsWerePublishedMoreThanTwoWeeksAgo() {
        when(userRepository.getUserById(user2.getId())).thenReturn(Optional.of(user2));
        when(postRepository.getPosts()).thenReturn(List.of(post19,oldPost200));

        PostIndexDto result = postService.getPostsByUser(user2.getId(), "date_desc");

        int resultUserId = result.getUserId();
        List<ResponsePostDto> resultPosts = result.getPosts();
        assertEquals(2, resultUserId);
        assertEquals(1, resultPosts.size());
    }
}
