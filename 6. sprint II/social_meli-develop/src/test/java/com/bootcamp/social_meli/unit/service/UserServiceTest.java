package com.bootcamp.social_meli.unit.service;

import com.bootcamp.social_meli.dto.response.MostFollowersResponseDTO;
import com.bootcamp.social_meli.dto.response.FollowedListResponseDTO;
import com.bootcamp.social_meli.dto.response.FollowersListResponseDTO;
import com.bootcamp.social_meli.dto.response.SimpleUserResponseDTO;
import com.bootcamp.social_meli.dto.response.UserDetailsResponseDTO;
import com.bootcamp.social_meli.exception.BadRequestException;
import com.bootcamp.social_meli.exception.NotFoundException;
import com.bootcamp.social_meli.model.User;
import com.bootcamp.social_meli.repository.IPostRepository;
import com.bootcamp.social_meli.repository.IUserRepository;
import com.bootcamp.social_meli.service.impl.UserServiceImpl;
import com.bootcamp.social_meli.helpers.UserGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    IUserRepository userRepository;
    @Mock
    IPostRepository postRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void findAll() {
    }

    @Test
    @DisplayName("El usuario debe poder seguir a otros.")
    void followUser() {
        // Arrange
        Long userId = 1L;
        Long userIdToFollow = 3L;
        User user = new User(1L, "Robert", "Firminho", "firminho10", new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(3L, "Alexander", "Arnold", "aarnold", new ArrayList<>(), new ArrayList<>());
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.of(userToFollow));
        String expectedReturnMessage = "¡El usuario " + user.getUsername() + " ha comenzado a seguir a " + userToFollow.getUsername() + " exitosamente!";
        // Act
        String returnedMessage = userService.followUser(userId, userIdToFollow);
        // Assert
        assertEquals(expectedReturnMessage, returnedMessage);
        assertEquals(1, user.getFollowed().size());
        assertEquals(1, userToFollow.getFollowers().size());
    }

    @Test
    @DisplayName("El usuario no puede seguirse a si mismo")
    void followUserThrowsExceptionIfUsersTriesToAutofollow() {
        // Arrange
        Long userId = 1L;
        // Act & Assert
        assertThrows(BadRequestException.class, () -> {
            userService.followUser(userId, userId);
        });
    }

    @Test
    @DisplayName("El usuario no puede seguir a alguien 2 veces")
    void followUserThrowsExceptionIfUsersTriesToFollowTwice() {
        // Arrange
        Long userId = 1L;
        Long userIdToFollow = 3L;
        User user = new User(1L, "Robert", "Firminho", "firminho10", new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(3L, "Alexander", "Arnold", "aarnold", new ArrayList<>(), new ArrayList<>());
        user.getFollowed().add(userToFollow);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.of(userToFollow));
        // Act & Assert
        assertThrows(BadRequestException.class, () -> {
            userService.followUser(userId, userIdToFollow);
        });
    }

    @Test
    @DisplayName("El usuario no puede ser seguido 2 veces por la misma persona")
    void followUserThrowsExceptionIfUserIsFollowedTwice() {
        // Arrange
        Long userId = 1L;
        Long userIdToFollow = 3L;
        User user = new User(1L, "Robert", "Firminho", "firminho10", new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(3L, "Alexander", "Arnold", "aarnold", new ArrayList<>(), new ArrayList<>());
        userToFollow.getFollowers().add(user);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.of(userToFollow));
        // Act & Assert
        assertThrows(BadRequestException.class, () -> {
            userService.followUser(userId, userIdToFollow);
        });
    }

    @Test
    @DisplayName("Debe arrojar NotFoundException si no encuentra al usuario")
    void followUserThrowsExceptionIfUserNotFound() {
        // Arrange
        Long userId = 1L;
        Long userToFollowId = 3L;
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());
        // Act & Assert
        assertThrows(NotFoundException.class, () -> {
            userService.followUser(userId, userToFollowId);
        });
    }

    @Test
    @DisplayName("Debe arrojar NotFoundException si no encuentra al usuario a seguir")
    void followUserThrowsExceptionIfUserToFollowNotFound() {
        // Arrange
        Long userId = 1L;
        Long userToFollowId = 3L;
        User user = new User(1L, "Robert", "Firminho", "firminho10", new ArrayList<>(), new ArrayList<>());
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.empty());
        // Act & Assert
        assertThrows(NotFoundException.class, () -> {
            userService.followUser(userId, userToFollowId);
        });
    }

    @Test
    @DisplayName("El usuario debe poder dejar de seguir a otros.")
    void unfollowUser() {
        // Arrange
        Long userId = 1L;
        Long userIdToFollow = 3L;
        User user = new User(1L, "Robert", "Firminho", "firminho10", new ArrayList<>(), new ArrayList<>());
        User userToUnfollow = new User(3L, "Alexander", "Arnold", "aarnold", new ArrayList<>(), new ArrayList<>());
        user.getFollowed().add(userToUnfollow);
        userToUnfollow.getFollowers().add(user);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.of(userToUnfollow));
        String expectedReturnMessage = "¡El usuario " + user.getUsername() + " ha dejado de seguir a " + userToUnfollow.getUsername() + " exitosamente!";
        // Act
        String returnedMessage = userService.unfollowUser(userId, userIdToFollow);
        // Assert
        assertEquals(expectedReturnMessage, returnedMessage);
        assertEquals(0, user.getFollowed().size());
        assertEquals(0, userToUnfollow.getFollowers().size());
    }

    @Test
    @DisplayName("El usuario no puede dejar de seguirse a si mismo")
    void unfollowUserThrowsExceptionIfUsersTriesToAutoUnfollow() {
        // Arrange
        Long userId = 1L;
        // Act & Assert
        assertThrows(BadRequestException.class, () -> {
            userService.unfollowUser(userId, userId);
        });
    }

    @Test
    @DisplayName("El usuario no puede dejar de seguir a alguien que no sigue")
    void unfollowUserThrowsExceptionIfUsersTriesToUnfollowsUnfollowedAccount() {
        // Arrange
        Long userId = 1L;
        Long userToUnfollowId = 3L;
        User user = new User(1L, "Robert", "Firminho", "firminho10", new ArrayList<>(), new ArrayList<>());
        User userToUnfollow = new User(3L, "Alexander", "Arnold", "aarnold", new ArrayList<>(), new ArrayList<>());
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.of(userToUnfollow));

        // Act & Assert
        assertThrows(BadRequestException.class, () -> {
            userService.unfollowUser(userId, userToUnfollowId);
        });
    }

    @Test
    @DisplayName("El usuario no puede dejar de seguir a si no se encuentra en su lista de seguidores")
    void unfollowUserThrowsExceptionIfUsersTriesToUnfollowsAUserThatDoesntHaveItAsFollower() {
        // Arrange
        Long userId = 1L;
        Long userToUnfollowId = 3L;
        User user = new User(1L, "Robert", "Firminho", "firminho10", new ArrayList<>(), new ArrayList<>());
        User userToUnfollow = new User(3L, "Alexander", "Arnold", "aarnold", new ArrayList<>(), new ArrayList<>());
        user.getFollowed().add(userToUnfollow);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.of(userToUnfollow));

        // Act & Assert
        assertThrows(BadRequestException.class, () -> {
            userService.unfollowUser(userId, userToUnfollowId);
        });
    }

    @Test
    @DisplayName("Debe arrojar NotFoundException si no encuentra al usuario")
    void unfollowUserThrowsExceptionIfUserNotFound() {
        // Arrange
        Long userId = 1L;
        Long userToFollowId = 3L;
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());
        // Act & Assert
        assertThrows(NotFoundException.class, () -> {
            userService.unfollowUser(userId, userToFollowId);
        });
    }

    @Test
    @DisplayName("Debe arrojar NotFoundException si no encuentra al usuario a dejar de seguir")
    void unfollowUserThrowsExceptionIfUserToUnfollowNotFound() {
        // Arrange
        Long userId = 1L;
        Long userToFollowId = 3L;
        User user = new User(1L, "Robert", "Firminho", "firminho10", new ArrayList<>(), new ArrayList<>());
            Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.empty());
        // Act & Assert
        assertThrows(NotFoundException.class, () -> {
            userService.unfollowUser(userId, userToFollowId);
        });
    }

    @Test
    @DisplayName("findFollowersList: El usuario debe poder obtener la lista de seguidores")
    void testFindFollowersList() {
        // Arrange
        Long userId = 1L;
        User user = UserGenerator.userWithFollowersAndFollowed(userId);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        // Act
        FollowersListResponseDTO followersList = userService.findFollowersList(userId);
        // Assert
        Assertions.assertEquals(3, followersList.getFollowers().size());
    }

    @Test
    @DisplayName("findFollowersList: Debe arrojar NotFoundException si no encuentra al usuario")
    void testFindFollowersListUserNotFound() {
        // Arrange
        Long userId = 3L;
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.empty());
        // Act & Assert
        Assertions.assertThrows(NotFoundException.class, () -> {
            userService.findFollowersList(userId);
        });
    }

    @Test
    @DisplayName("findFollowersListOrdered: El usuario debe poder obtener la lista de seguidores " +
            "ordenada ascendente")
    void findFollowersListOrderedAsc() {
        Long userId = 1L;
        User user = UserGenerator.userWithFollowersAndFollowed(userId);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        // Act
        FollowersListResponseDTO followersList = userService.findFollowersList(userId, "name_asc");
        // Assert
        Assertions.assertEquals(3, followersList.getFollowers().size());
        Assertions.assertEquals("aarnold", followersList.getFollowers().get(0).getUser_name());
        Assertions.assertEquals("msalah", followersList.getFollowers().get(1).getUser_name());
        Assertions.assertEquals("tarnold", followersList.getFollowers().get(2).getUser_name());
    }

    @Test
    @DisplayName("findFollowersListOrdered: El usuario debe poder obtener la lista de seguidores " +
            "ordenada descendente")
    void findFollowersListOrderedDesc() {
        // Arrange
        Long userId = 1L;
        User user = UserGenerator.userWithFollowersAndFollowed(userId);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        // Act
        FollowersListResponseDTO followersList = userService.findFollowersList(userId, "name_desc");
        // Assert
        Assertions.assertEquals(3, followersList.getFollowers().size());
        Assertions.assertEquals("tarnold", followersList.getFollowers().get(0).getUser_name());
        Assertions.assertEquals("msalah", followersList.getFollowers().get(1).getUser_name());
        Assertions.assertEquals("aarnold", followersList.getFollowers().get(2).getUser_name());
    }

    @Test
    @DisplayName("findFollowersListOrdered: Debe arrojar NotFoundException si no " +
            "encuentra al usuario")
    void findFollowersListOrderedUserNotFound() {
        // Arrange
        Long userId = 3L;
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.empty());
        // Act & Assert
        Assertions.assertThrows(NotFoundException.class, () -> {
            userService.findFollowersList(userId, "name_asc");
        });
    }

    @Test
    @DisplayName("findFollowersListOrdered: Debe arrojar BadRequestException si el parametro order es incorrecto")
    void findFollowersListOrderedInvalidOrderParameter() {
        // Arrange
        Long userId = 1L;
        User user = UserGenerator.userWithFollowersAndFollowed(userId);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> {
            userService.findFollowersList(userId, "ascendente");
        });
    }

    @Test
    @DisplayName("findFollowedList: El usuario debe poder obtener la lista de seguidos")
    void findFollowedList() {
        // Arrange
        Long userId = 1L;
        User user = UserGenerator.userWithFollowersAndFollowed(userId);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        // Act
        FollowedListResponseDTO followedList = userService.findFollowedList(userId);
        // Assert
        Assertions.assertEquals(3, followedList.getFollowed().size());
    }

    @Test
    @DisplayName("findFollowedList: Debe arrojar NotFoundException si no " +
            "encuentra al usuario")
    void findFollowedListUserNotFound() {
        // Arrange
        Long userId = 3L;
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.empty());
        // Act & Assert
        Assertions.assertThrows(NotFoundException.class, () -> {
            userService.findFollowedList(userId);
        });
    }

    @Test
    @DisplayName("findFollowedListOrdered: El usuario debe poder obtener la lista de seguidos " +
            "ordenada ascendente")
    void findFollowedListOrderedAsc() {
        Long userId = 1L;
        User user = UserGenerator.userWithFollowersAndFollowed(userId);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        // Act
        FollowedListResponseDTO followedList = userService.findFollowedList(userId, "name_asc");
        // Assert
        Assertions.assertEquals(3, followedList.getFollowed().size());
        Assertions.assertEquals("aarnold", followedList.getFollowed().get(0).getUser_name());
        Assertions.assertEquals("msalah", followedList.getFollowed().get(1).getUser_name());
        Assertions.assertEquals("smane", followedList.getFollowed().get(2).getUser_name());
    }

    @Test
    @DisplayName("findFollowedListOrdered: El usuario debe poder obtener la lista de seguidos " +
            "ordenada descendente")
    void findFollowedListOrderedDesc() {
        // Arrange
        Long userId = 1L;
        User user = UserGenerator.userWithFollowersAndFollowed(userId);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        // Act
        FollowedListResponseDTO followedList = userService.findFollowedList(userId, "name_desc");
        // Assert
        Assertions.assertEquals(3, followedList.getFollowed().size());
        Assertions.assertEquals("smane", followedList.getFollowed().get(0).getUser_name());
        Assertions.assertEquals("msalah", followedList.getFollowed().get(1).getUser_name());
        Assertions.assertEquals("aarnold", followedList.getFollowed().get(2).getUser_name());
    }

    @Test
    @DisplayName("findFollowedListOrdered: Debe arrojar NotFoundException si no " +
            "encuentra al usuario")
    void findFollowedListOrderedUserNotFound() {
        // Arrange
        Long userId = 3L;
        Mockito.when(userRepository.findById(3L)).thenReturn(Optional.empty());
        // Act & Assert
        Assertions.assertThrows(NotFoundException.class, () -> {
            userService.findFollowedList(userId, "name_asc");
        });
    }

    @Test
    @DisplayName("findFollowedListOrdered: Debe arrojar BadRequestException si el parametro order es incorrecto")
    void findFollowedListOrderedInvalidOrderParameter() {
        // Arrange
        Long userId = 1L;
        User user = UserGenerator.userWithFollowersAndFollowed(userId);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        // Act & Assert
        Assertions.assertThrows(BadRequestException.class, () -> {
            userService.findFollowedList(userId, "ascendente");
        });
    }

    @Test
    @DisplayName("La cantidad de seguidores de un usuario sin seguidores es 0")
    void getFollowerCountOfUserWithoutFollowersReturnsZero() {
        Long expectedAmount = 0L;
        User user = new User(1L, "Juan", "Juan", "juancito", List.of(), List.of());
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));

        Long amount = userService.getFollowerCount(1L).getFollowers_count();

        assertEquals(expectedAmount, amount);
    }

    @Test
    @DisplayName("La cantidad de seguidores de un usuario con dos seguidores es 2")
    void getFollowerCountOfUserWithTwoFollowersReturnsTwo() {
        Long expectedAmount = 2L;
        User follower1 = new User(3L, "Tom", "Tom", "tomito", List.of(), List.of());
        User follower2 = new User(2L, "Mati", "Mati", "mati123", List.of(), List.of());
        User user = new User(1L, "Juan", "Juan", "juancito", List.of(), List.of(follower1, follower2));
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));

        Long amount = userService.getFollowerCount(1L).getFollowers_count();

        assertEquals(expectedAmount, amount);
    }

    @Test
    @DisplayName("Se arroja una excepcion al no se encontrar al usuario")
    void getFollowerCountOfInexistentUserThrowsException() {
        Long userId = 0L;
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> {
            userService.getFollowerCount(userId);
        });
    }

    @Test
    void mostFollowersTestWithRankParam() {
        // ARR
        Integer rankParam = 2;

        // Crear usuarios con sus seguidores
        User user1 = new User(1L, "Francol43", "Franco", "Colapinto", List.of(), new ArrayList<>());
        User user2 = new User(2L, "MartinG24", "Martín", "Gómez", new ArrayList<>(), List.of(user1));
        User user3 = new User(3L, "AnaPerezzzz", "Ana", "Pérez", new ArrayList<>(), List.of(user1, user2));
        User user4 = new User(4L, "CarlosSainz_33", "Carlos", "Sainz", new ArrayList<>(), List.of(user1, user2, user3));

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2, user3, user4));

        // ACT
        MostFollowersResponseDTO result = userService.mostFollowers(rankParam);

        // ASS
        assertEquals(2, result.getMost_followers().size(), "La lista debe contener los dos usuarios con más seguidores.");
        assertEquals("Sainz", result.getMost_followers().get(0).getUser_name(), "El primer " +
                "usuario " +
                "debería ser Sainz.");
        assertEquals("Pérez", result.getMost_followers().get(1).getUser_name(), "El segundo usuario debería ser Pérez.");
    }

    @Test
    void mostFollowersTest() {
        // Crear usuarios con sus seguidores
        User user1 = new User(1L, "Francol43", "Franco", "Colapinto", List.of(), new ArrayList<>());
        User user2 = new User(2L, "MartinG24", "Martín", "Gómez", new ArrayList<>(), List.of(user1));
        User user3 = new User(3L, "AnaPerezzzz", "Ana", "Pérez", new ArrayList<>(), List.of(user1, user2));
        User user4 = new User(4L, "CarlosSainz_33", "Carlos", "Sainz", new ArrayList<>(), List.of(user1, user2, user3));

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2, user3, user4));

        // ACT
        MostFollowersResponseDTO result = userService.mostFollowers();

        // ASS
        assertEquals(4, result.getMost_followers().size(), "La lista debe contener los dos usuarios con más seguidores.");
        assertEquals("Sainz", result.getMost_followers().get(0).getUser_name(), "El primer " +
                "usuario " +
                "debería ser Sainz.");
        assertEquals("Pérez", result.getMost_followers().get(1).getUser_name(), "El segundo usuario debería ser Pérez.");
        assertEquals("Gómez", result.getMost_followers().get(2).getUser_name(), "El tercer usuario debería ser Gómez.");
        assertEquals("Colapinto", result.getMost_followers().get(3).getUser_name(), "El cuarto usuario debería ser Colapinto.");
    }

    @Test
    @DisplayName("Debería lanzar BadRequestException si rank es 0 o menor")
    public void testMostFollowersWithRankZeroOrNegative() {
        // ARR
        Integer rankParam = -1;

        // ACT & ASSERT
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            userService.mostFollowers(rankParam);
        });

        assertEquals("'rank' no puede ser <= 0", exception.getMessage());

        // Repetir para cero
        exception = assertThrows(BadRequestException.class, () -> {
            userService.mostFollowers(0);
        });

        assertEquals("'rank' no puede ser <= 0", exception.getMessage());
    }

    @Test
    @DisplayName("Debe retornar los detalles del usuario con sus metricas cuando existe")
    void metricsUserDetails() {
        //Arrange
        Long userId = 5L;
        User mockUser = new User(userId, "Laura", "López", "LauLopez87", new ArrayList<>(),
                new ArrayList<>(List.of(new User(4L, "Carlos", "Sánchez", "CarlosSan_15", new ArrayList<>(), new ArrayList<>()))));

        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));
        when(postRepository.findAmountOfPromosByUserId(mockUser)).thenReturn(List.of());

        UserDetailsResponseDTO expectedResult = new UserDetailsResponseDTO(5L, "LauLopez87", mockUser.getFollowers().size(),
                mockUser.getFollowed().size(), 0, new ArrayList<>(), new ArrayList<>(List.of(new SimpleUserResponseDTO(4L, "CarlosSan_15"))));
        //Act

        UserDetailsResponseDTO result = userService.metricsUserDetails(userId);
        //Assert
        Assertions.assertNotNull(result);
        assertEquals(result,expectedResult);
        Assertions.assertEquals(result, expectedResult);

    }

    @Test
    @DisplayName("Debe arrojar NotFoundException si no encuentra al usuario")
    void testMetricsUserDetailsUserNotFound() {
        // Configurar el mock para que no encuentre al usuario
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Verificar que lanza la excepción
        assertThrows(NotFoundException.class, () -> {
            userService.metricsUserDetails(userId);
        });
    }

    @Test
    void createUser() {
    }
}