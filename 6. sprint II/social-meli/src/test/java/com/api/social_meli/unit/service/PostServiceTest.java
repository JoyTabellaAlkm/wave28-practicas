package com.api.social_meli.unit.service;

import com.api.social_meli.dto.FollowedSellerPostsDto;
import com.api.social_meli.dto.PostDto;
import com.api.social_meli.exception.BadRequestException;
import com.api.social_meli.exception.NotFoundException;
import com.api.social_meli.model.Post;
import com.api.social_meli.model.User;
import com.api.social_meli.repository.IPostCategoryRepository;
import com.api.social_meli.repository.IPostRepository;
import com.api.social_meli.repository.IUserRepository;
import com.api.social_meli.service.impl.PostServiceImpl;
import com.api.social_meli.util.MockFactoryUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    private List<User> usersMock;
    private List<Post> postsMock;

    @Mock
    private IPostRepository postRepository;

    @Mock
    private IPostCategoryRepository postCategoryRepository;

    @Mock
    private IUserRepository userRepository;

    @Spy
    static ObjectMapper objectMapper;

    @InjectMocks
    private PostServiceImpl postService;

    @BeforeAll
    public static void setUp() {
        objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
    }


    @BeforeEach
    public void beforeEach() throws IOException {
        usersMock = MockFactoryUtils.getUsersMock();
        postsMock = MockFactoryUtils.getPostsMock();
    }

    //region FOLLOWER POSTS FROM LAST TWO WEEKS
    @Test
    @DisplayName("Obtención exclusiva de posts de las últimas dos semanas de los usuarios seguidos por un usuario válido.")
    public void shouldReturnFollowedSellerPostsFromLastTwoWeeksOnly() {
        // ARRANGE
        int userId = 1;
        List<Integer> followedByUser = MockFactoryUtils.getFollowedsByUserId(usersMock, userId);
        MockFactoryUtils.setPostsAsPostedOneWeekAgo(postsMock, List.of(2, 4)); // Se que los posts 2 y 4 son algunos de los posts de usuarios que el usuario 1 sigue

        when(userRepository.findAll()).thenReturn(usersMock);
        when(userRepository.exists(userId)).thenReturn(true);
        followedByUser.forEach(followedUserId ->
                when(postRepository.findByUserId(followedUserId)).thenReturn(MockFactoryUtils.filterPostsByUserId(postsMock, followedUserId))
        );

        // ACT
        FollowedSellerPostsDto result = postService.getFollowedSellersPosts(userId, null);

        // ASSERT
        assertNotNull(result, "El resultado no puede llegar nulo");
        assertNotNull(result.getPosts(), "La lista de posts tiene que existir");
        assertFalse(result.getPosts().isEmpty(), "Tiene que haber posts");
        assertTrue(result.getPosts().stream()
                        .noneMatch(post -> post.getPublishDate().isBefore(LocalDate.now().minusWeeks(2))),
                "Todos los posts deberían tener una fecha de publicación dentro de las últimas dos semanas.");
    }

    @Test
    @DisplayName("Caso en el que no hay posts (de usuarios seguidos por usuario válido) dentro de las últimas dos semanas")
    public void shouldReturnEmptyListWhenFollowedUsersHaveNoRecentPosts() {
        // ARRANGE
        int userId = 1;
        List<Integer> followedByUser = MockFactoryUtils.getFollowedsByUserId(usersMock, userId);
        MockFactoryUtils.setPostsFromFollowedUsersAsPostedThreeWeeksAgo(postsMock, followedByUser);

        when(userRepository.findAll()).thenReturn(usersMock);
        when(userRepository.exists(userId)).thenReturn(true);
        followedByUser.forEach(followedUserId ->
                when(postRepository.findByUserId(followedUserId)).thenReturn(MockFactoryUtils.filterPostsByUserId(postsMock, followedUserId))
        );

        // ACT
        FollowedSellerPostsDto result = postService.getFollowedSellersPosts(userId, null);

        // ASSERT
        assertNotNull(result, "El resultado no puede llegar nulo");
        assertNotNull(result.getPosts(), "La lista de posts tiene que existir");
        assertTrue(result.getPosts().isEmpty(), "Se esperaba que la lista esté vacía");
    }

    @Test
    @DisplayName("Devuelve excepción con mensaje específico cuando el usuario con ese ID no existe.")
    public void shouldThrowExWhenGetFollowedSellersPostsUserNotExists() {
        // ARRANGE
        int userId = 999;
        when(userRepository.exists(userId)).thenReturn(false);

        // ACT & ASSERT
        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            postService.getFollowedSellersPosts(userId, null);
        });
        assertEquals("No se encontró ningún usuario con ese ID.", thrown.getMessage(), "El mensaje de la excepción no es el esperado.");
    }

    //region VERIFY POST ORDER EXISTING BY DATE
    @Test
    @DisplayName("Verificar que el tipo de ordenamiento ascendente por fecha exista")
    void shouldAscOrderExistSuccessfullyWhenSortPostByDate() throws IOException {
        //ARRANGE
        int userId = 1;
        String order = "date_asc";
        List<Integer> followedByUser = MockFactoryUtils.getFollowedsByUserId(usersMock, userId);

        when(userRepository.exists(userId)).thenReturn(true);
        when(userRepository.findAll()).thenReturn(usersMock);
        followedByUser.forEach(followedUserId ->
                when(postRepository.findByUserId(followedUserId)).
                        thenReturn(MockFactoryUtils.filterPostsByUserId(postsMock, followedUserId))
        );

        //ACT & ASSERT
        assertDoesNotThrow(() -> postService.getFollowedSellersPosts(userId, order),
                "El método lanzó una excepción inesperada");
    }
    @Test
    @DisplayName("Verificar que el tipo de ordenamiento descendente por fecha exista")
    void shouldDescOrderExistSuccessfullyWhenSortPostByDate() throws IOException {
        //ARRANGE
        int userId = 1;
        String order = "date_desc";
        List<Integer> followedByUser = MockFactoryUtils.getFollowedsByUserId(usersMock, userId);

        when(userRepository.exists(userId)).thenReturn(true);
        when(userRepository.findAll()).thenReturn(usersMock);
        followedByUser.forEach(followedUserId ->
                when(postRepository.findByUserId(followedUserId)).
                        thenReturn(MockFactoryUtils.filterPostsByUserId(postsMock, followedUserId))
        );

        //ACT & ASSERT
        assertDoesNotThrow(() -> postService.getFollowedSellersPosts(userId, order),
                "El método lanzó una excepción inesperada");
    }
    @Test
    @DisplayName("Notifica la no existencia mediante una excepción.")
    void shouldNotOrderExistenceWhenSortPostByDate() {
        //ARRANGE
        int userId = 6;
        String order = "incorrect";
        //ACT & ASSERT
        assertThrows(BadRequestException.class, () -> postService.getFollowedSellersPosts(userId, order));
    }
    //endregion

    //region VERIFICAR CORRECTO ORDENAMIENTO ASC Y DESC POR FEECHA
    @Test
    @DisplayName("Verificar el correcto ordenamiento ascendente por fecha")
    void shouldAscOrderCorrectWhenSortPostByDate() throws IOException {
        //ARRANGE
        int userId = 1;
        String order = "date_asc";
        MockFactoryUtils.setPostsAsPostedOneWeekAgo(postsMock, List.of(2, 4));
        // Se que los posts 2 y 4 son algunos de los posts de usuarios que el usuario 1 sigue

        when(userRepository.exists(userId)).thenReturn(true);
        when(userRepository.findAll()).thenReturn(usersMock);

        List<Integer> followedByUser = MockFactoryUtils.getFollowedsByUserId(usersMock, userId);
        followedByUser.forEach(followedUserId ->
                when(postRepository.findByUserId(followedUserId)).
                        thenReturn(MockFactoryUtils.filterPostsByUserId(postsMock, followedUserId))
        );

        //ACT
        FollowedSellerPostsDto result = postService.getFollowedSellersPosts(userId, order);

        // ASSERT
        assertNotNull(result, "El resultado no puede ser nulo");
        assertNotNull(result.getPosts(), "La lista de posteos tiene que existir");
        assertFalse(result.getPosts().isEmpty(), "Tiene que haber posts");
        List<PostDto> sortedPosts = result.getPosts();
        assertTrue(MockFactoryUtils.isSortedByDate(sortedPosts, true),
                "La lista no está ordenada ascendentemente por fecha");
    }

    @Test
    @DisplayName("Verificar el correcto ordenamiento descendente por fecha")
    void shouldDescOrderCorrectWhenSortPostByDate() throws IOException {
        //ARRANGE
        int userId = 1;
        String order = "date_desc";
        MockFactoryUtils.setPostsAsPostedOneWeekAgo(postsMock, List.of(2, 4));
        // Se que los posts 2 y 4 son algunos de los posts de usuarios que el usuario 1 sigue

        when(userRepository.exists(userId)).thenReturn(true);
        when(userRepository.findAll()).thenReturn(usersMock);

        List<Integer> followedByUser = MockFactoryUtils.getFollowedsByUserId(usersMock, userId);
        followedByUser.forEach(followedUserId ->
                when(postRepository.findByUserId(followedUserId)).
                        thenReturn(MockFactoryUtils.filterPostsByUserId(postsMock, followedUserId))
        );

        //ACT
        FollowedSellerPostsDto result = postService.getFollowedSellersPosts(userId, order);

        // ASSERT
        assertNotNull(result, "El resultado no puede ser nulo");
        assertNotNull(result.getPosts(), "La lista de posteos tiene que existir");
        assertFalse(result.getPosts().isEmpty(), "Tiene que haber posts");
        List<PostDto> sortedPosts = result.getPosts();
        assertTrue(MockFactoryUtils.isSortedByDate(sortedPosts, false),
                "La lista no está ordenada descendentemente por fecha");
    }
    //endregion
    //endregion
}
