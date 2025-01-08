package com.mercadolibre.social.unit;

import com.mercadolibre.social.dto.response.*;
import com.mercadolibre.social.entity.User;
import com.mercadolibre.social.exception.BadRequestException;
import com.mercadolibre.social.exception.NotFoundException;
import com.mercadolibre.social.repository.impl.UserRepository;
import com.mercadolibre.social.service.impl.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("UT-01 Verificar que el usuario a seguir exista.")
    public void givenUser_whenCheckFollowUser_thenUserExists() {
        //ARRANGE
        FollowUserResponseDto expectedResponse = new FollowUserResponseDto(2, 1);
        // el seguidor.
        int userFollowerIdParam = 2;
        // el seguido.
        int userFollowedIdParam = 1;
        //mock del seguido
        User followedMock = new User(1, "john_doe_test", new HashSet<>(Set.of(3)), new HashSet<>());
        //mock del seguidor
        User followerMock = new User(2, "alice_smith_test", new HashSet<>(Set.of(3)), new HashSet<>());

        //ACT
        Mockito.when(userRepository.findById(userFollowedIdParam)).thenReturn(followedMock);
        Mockito.when(userRepository.findById(userFollowerIdParam)).thenReturn(followerMock);
        FollowUserResponseDto responseObtained = userService.followUser(userFollowerIdParam, userFollowedIdParam);

        //ASSERT
        assertEquals(expectedResponse, responseObtained);
    }

    @Test
    @DisplayName("UT-01 Verificar que el usuario a seguir no exista.")
    public void givenUser_whenCheckFollowUser_thenUserDoesNotExist() {
        //ARRANGE

        // el seguidor.
        int userFollowerIdParam = 2;
        // el seguido.
        int userFollowedIdParam = 10;

        String expectedResponse = "User not found with ID: " + userFollowedIdParam;
        //mock del seguido
        int followedMockId = userFollowedIdParam;
        //mock del seguidor
        User followerMock = new User(2, "alice_smith_test", new HashSet<>(Set.of(3)), new HashSet<>());

        //ACT
        Mockito.when(userRepository.findById(userFollowedIdParam)).thenThrow(new NotFoundException("User not found with ID: " + followedMockId));
        Mockito.when(userRepository.findById(userFollowerIdParam)).thenReturn(followerMock);
        NotFoundException exceptionObtained = assertThrows(NotFoundException.class, () -> userService.followUser(userFollowerIdParam, userFollowedIdParam));

        //ASSERT
        assertEquals(expectedResponse, exceptionObtained.getMessage());
    }

    @Test
    @DisplayName("UT-03: Verificar que el tipo de ordenamiento alfabético ascendente exista")
    void givenUser_whenGetCountFollowersSorted_thenReturnCorrectFollowersCountSorted() {
        //ARRANGE
        int id = 1;
        String order = "name_asc";

        User user = new User(1, "Pedro", new HashSet<>(789, 126), new HashSet<>(123, 456));

        List<User> users = new ArrayList<>(List.of(new User(123, "juan", new HashSet<>(789, 126), new HashSet<>(123, 456))));

        //ACT
        when(userRepository.findById(anyInt())).thenReturn(user);
        when(userRepository.findUsersByIds(anySet())).thenReturn(users);

        FollowersByUserDto result = userService.followersByUser(id, order);

        //ASSERT
        assertNotNull(result, "El resultado no debe de ser nulo");

        verify(userRepository, times(1)).findById(anyInt());
        verify(userRepository, times(1)).findUsersByIds(anySet());
    }

    @Test
    @DisplayName("UT-03: Verificar que el tipo de ordenamiento alfabético descendente exista")
    void givenUser_whenGetCountFollowersSorted_thenReturnCorrectFollowersCountSortedDesc() {
        //ARRANGE
        int id = 1;
        String order = "name_desc";

        User user = new User(1, "Pedro", new HashSet<>(789, 126), new HashSet<>(123, 456));

        List<User> users = new ArrayList<>(List.of(new User(123, "juan", new HashSet<>(789, 126), new HashSet<>(123, 456))));

        //ACT
        when(userRepository.findById(anyInt())).thenReturn(user);
        when(userRepository.findUsersByIds(anySet())).thenReturn(users);

        FollowersByUserDto result = userService.followersByUser(id, order);

        //ASSERT
        assertNotNull(result, "El resultado no debe de ser nulo");

        verify(userRepository, times(1)).findById(anyInt());
        verify(userRepository, times(1)).findUsersByIds(anySet());
    }

    @Test
    @DisplayName("UT-03: Verificar que el tipo de ordenamiento alfabético no exista y lance una excepción")
    void givenUser_whenGetCountFollowersSortedIncorrect_thenReturnBadRequestException() {
        //ARRANGE
        int id = 1;
        String order = "incorrect";

        User user = new User(1, "Pedro", new HashSet<>(789, 126), new HashSet<>(123, 456));

        List<User> users = new ArrayList<>(Arrays.asList(new User(123, "juan", new HashSet<>(789, 126), new HashSet<>(123, 456)),
                new User(456, "pepito", new HashSet<>(789, 126), new HashSet<>(123, 456)),
                new User(789, "ana", new HashSet<>(789, 126), new HashSet<>(123, 456))));

        //ACT
        when(userRepository.findById(anyInt())).thenReturn(user);
        when(userRepository.findUsersByIds(anySet())).thenReturn(users);

        //ASSERT
        assertThrows(BadRequestException.class, () -> userService.followersByUser(id, order), "Debería lanzar una excepción");

        verify(userRepository, times(1)).findById(anyInt());
        verify(userRepository, times(1)).findUsersByIds(anySet());
    }

    @Test
    @DisplayName("UT-02: Verificar que el usuario a dejar de seguir exista")
    void givenUserAndUserToUnfollow_whenUnfollow_thenReturnCorrectMessage() {
        // ARRANGE
        int userId = 1;
        int userIdToUnfollow = 2;

        User existingUser = new User(1, "John Doe", new HashSet<>(Set.of(2)), new HashSet<>());
        User userToUnfollow = new User(2, "Jane Smith", new HashSet<>(), new HashSet<>(Set.of(1)));

        MessageDto messageExpected = new MessageDto("User " + userId + " successfully unfollowed User " + userIdToUnfollow);
        when(userRepository.findById(userId)).thenReturn(existingUser);
        when(userRepository.findById(userIdToUnfollow)).thenReturn(userToUnfollow);

        // ACT
        MessageDto actualMessage = userService.unfollowUser(userId, userIdToUnfollow);

        // ASSERT
        assertEquals(messageExpected, actualMessage);
    }

    @Test
    @DisplayName("UT-02: Verificar que se lance una excepción si el usuario a dejar de seguir no existe.")
    void givenUserAndNonExistentUserToUnfollow_whenUnfollow_thenThrowException() {

        // ARRANGE
        int userId = 1;
        int userIdToUnfollow = 2;

        User existingUser = new User(1, "John Doe", new HashSet<>(Set.of(2)), new HashSet<>());

        String messageExpected = "User not found with ID: " + userIdToUnfollow;
        when(userRepository.findById(userId)).thenReturn(existingUser);
        when(userRepository.findById(userIdToUnfollow))
                .thenThrow(new NotFoundException("User not found with ID: " + userIdToUnfollow));

        // ACT
        Exception exception = assertThrows(
                NotFoundException.class,
                () -> userService.unfollowUser(userId, userIdToUnfollow)
        );

        // ASSERT
        assertEquals(messageExpected, exception.getMessage());
    }

    @Test
    @DisplayName("UT-07: Verifica que la cantidad de seguidores de un usuario sea correcta.")
    void givenUser_whenGetCountFollowers_thenReturnCorrectFollowersCount() {
        // ARRANGE
        UserCountFollowersDto expectedFollowerCount = new UserCountFollowersDto(
                "1",
                "John Doe",
                2
        );

        User expectedUser = new User(1, "John Doe", Set.of(), Set.of(2, 3));

        when(userRepository.findById(1)).thenReturn(expectedUser);

        // ACT
        UserCountFollowersDto actualFollowerCount = userService.getCountFollowers(1);

        // ASSERT
        assertEquals(expectedFollowerCount, actualFollowerCount);
    }

    @Test
    @DisplayName("UT-07: Verifica que la cantidad de seguidores de un usuario no sea incorrecta.")
    void givenUser_whenGetCountFollowers_thenReturnIncorrectFollowersCount() {
        // ARRANGE
        UserCountFollowersDto expectedFollowerCount = new UserCountFollowersDto(
                "1",
                "John Doe",
                0
        );

        User expectedUser = new User(1, "John Doe", Set.of(), Set.of(2, 3));

        when(userRepository.findById(1)).thenReturn(expectedUser);

        // ACT
        UserCountFollowersDto actualFollowerCount = userService.getCountFollowers(1);

        // ASSERT
        assertNotEquals(expectedFollowerCount, actualFollowerCount);
    }

    @Test
    @DisplayName("UT-04: Verificar el correcto ordenamiento ascendente por nombre.")
    void givenUser_whenGetCountFollowedSortedAsc_thenReturnCorrectFollowedCountSortedAsc() {
        //ARRANGE
        int id = 1;
        String order = "name_asc";

        User user = new User(1, "Pedro", new HashSet<>(789, 126), new HashSet<>(123, 456));

        List<User> users = new ArrayList<>(Arrays.asList(new User(123, "juan", new HashSet<>(789, 126), new HashSet<>(123, 456)),
                new User(456, "pepito", new HashSet<>(789, 126), new HashSet<>(123, 456)),
                new User(789, "ana", new HashSet<>(789, 126), new HashSet<>(123, 456))));

        FollowedByUserDto expected = new FollowedByUserDto(1, "Pedro",
                List.of(new UserDto(123, "juan"),
                        new UserDto(456, "pepito"),
                        new UserDto(789, "ana")));

        //ACT
        when(userRepository.findById(anyInt())).thenReturn(user);
        when(userRepository.findUsersByIds(anySet())).thenReturn(users);

        FollowedByUserDto result = userService.followedByUser(id, order);

        //ASSERT
        assertNotNull(result, "El resultado no debe de ser nulo");
        assertEquals(expected.getFollowed().size(), result.getFollowed().size(), "No coincide la cantidad de seguidores");
        assertEquals(expected.getUserName(), result.getUserName(), "No coincide el nombre de los usuarios");
        assertEquals("ana", result.getFollowed().getFirst().getUserName(), "No se esta ordenando correctamente la lista de seguidores");

        verify(userRepository, times(1)).findById(anyInt());
        verify(userRepository, times(1)).findUsersByIds(anySet());
    }

    @Test
    @DisplayName("UT-04: Verificar el correcto ordenamiento descendente por nombre.")
    void givenUser_whenGetCountFollowedSortedDesc_thenReturnCorrectFollowedCountSortedDesc() {
        //ARRANGE
        int id = 1;
        String order = "name_desc";

        User user = new User(1, "Pedro", new HashSet<>(789, 126), new HashSet<>(123, 456));

        List<User> users = new ArrayList<>(Arrays.asList(new User(123, "juan", new HashSet<>(789, 126), new HashSet<>(123, 456)),
                new User(456, "pepito", new HashSet<>(789, 126), new HashSet<>(123, 456)),
                new User(789, "ana", new HashSet<>(789, 126), new HashSet<>(123, 456))));

        FollowedByUserDto expected = new FollowedByUserDto(1, "Pedro",
                List.of(new UserDto(123, "juan"),
                        new UserDto(456, "pepito"),
                        new UserDto(789, "ana")));

        //ACT
        when(userRepository.findById(anyInt())).thenReturn(user);
        when(userRepository.findUsersByIds(anySet())).thenReturn(users);

        FollowedByUserDto result = userService.followedByUser(id, order);

        //ASSERT
        assertNotNull(result, "El resultado no debe de ser nulo");
        assertEquals(expected.getFollowed().size(), result.getFollowed().size(), "No coincide la cantidad de seguidores");
        assertEquals(expected.getUserName(), result.getUserName(), "No coincide el nombre de los usuarios");
        assertEquals("pepito", result.getFollowed().getFirst().getUserName(), "No se esta ordenando correctamente la lista de seguidores");

        verify(userRepository, times(1)).findById(anyInt());
        verify(userRepository, times(1)).findUsersByIds(anySet());
    }
}