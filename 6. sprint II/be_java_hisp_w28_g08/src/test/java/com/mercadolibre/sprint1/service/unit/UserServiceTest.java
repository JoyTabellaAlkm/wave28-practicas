package com.mercadolibre.sprint1.service.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.sprint1.dto.UserDto;
import com.mercadolibre.sprint1.dto.response.FollowedListByUserDto;
import com.mercadolibre.sprint1.dto.response.FollowersListByUserDto;
import com.mercadolibre.sprint1.entity.UserFollower;
import com.mercadolibre.sprint1.exception.BadRequestException;
import com.mercadolibre.sprint1.exception.NotFoundException;
import com.mercadolibre.sprint1.repository.impl.PostRepositoryImpl;
import com.mercadolibre.sprint1.repository.impl.UserFollowerRepositoryImpl;
import com.mercadolibre.sprint1.repository.impl.UserRepositoryImpl;
import com.mercadolibre.sprint1.service.impl.UserServiceImpl;

import util.TestUtilGenerator;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepositoryImpl userRepository;

    @Mock
    UserFollowerRepositoryImpl userFollowerRepository;

    @Mock
    PostRepositoryImpl postRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("T-0001 - Cuándo el usuario a seguir existe y es vendedor debe retornar true")
    public void followUserWhenUserExistsAndIsSellerShouldReturnTrue() {
        // Arrange
        int userId = 1;
        int userIdToFollow = 2;
        UserFollower userFollower = new UserFollower(userIdToFollow, userId);
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());
        when(userFollowerRepository.save(userFollower)).thenReturn(userFollower);

        // Act
        boolean result = userService.followUser(userId, userIdToFollow);

        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("T-0001 - Cuándo el usuario a seguir no existe debe retornar una NotFoundException")
    public void followUserWhenUserToFollowDoesNotExistShouldThrowNotFoundException() {
        // Arrange
        int userId = 1;
        int userIdToFollow = 999;
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());
        // Act
        Exception exception = assertThrows(NotFoundException.class, () -> {
            userService.followUser(userId, userIdToFollow);
        });
        // Assert
        assertEquals("No existe el usuario " + userIdToFollow, exception.getMessage());
    }

    @Test
    @DisplayName("T-0003 - Cuándo el orden enviado es NAME_ASC, debe listar todos los seguidores ordenados por nombre de forma ascendente")
    public void whenOrderSendedIsNameAscShouldListFollowersSortedByNameDesc() {
        // arrange
        int userId = 2;
        when(userFollowerRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());

        // act
        FollowersListByUserDto res = userService.findAllFollowersByUser(userId, "NAME_ASC");

        // assert
        assertNotNull(res);
    }

    @Test
    @DisplayName("T-0003 - Cuándo el orden enviado es NAME_DESC, debe listar todos los seguidores ordenados por nombre de forma descendente")
    public void whenOrderSendedIsNameDescShouldListFollowersSortedByNameAsc() {
        // arrange
        int userId = 2;
        when(userFollowerRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());

        // act
        FollowersListByUserDto res = userService.findAllFollowersByUser(userId, "NAME_DESC");

        // assert
        assertNotNull(res);
    }

    @Test
    @DisplayName("T-0003 - Cuándo el orden enviado no es ascendente ni descendente, debe arrojar una excepción BadRequestException")
    public void whenOrderSendedIsNotAscAndIsNotDescShouldThrowsBadRequestException() {
        // arrange
        int userId = 2;
        when(userFollowerRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());

        // act
        // assert
        assertThrows(BadRequestException.class, () -> userService.findAllFollowersByUser(userId, "INVALID_ORDER"));
    }

    @Test
    @DisplayName("T-0003 - Cuando se consultan los seguidos por orden ascendente debe regresar todos los seguidos")
    void whenFindAllFollowedsByUserOrderAscShouldReturnAllFollowedsInAscOrder() {
        // arrange
        int userId = 1;
        String order = "name_asc";
        List<UserDto> expectedFolloweds = List.of(new UserDto(2, "Cristhian"), new UserDto(5, "María"));

        // act
        when(userFollowerRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());
        FollowedListByUserDto result = userService.findUsersFollowedByUser(userId, order);

        // assert
        assertThat(result.getId()).isEqualTo(userId);
        assertThat(result.getFollowed()).isEqualTo(expectedFolloweds);
    }

    @Test
    @DisplayName("T-0003 - Cuando se consultan los seguidos por orden descendente debe regresar todos los seguidos")
    void whenFindAllFollowedsByUserOrderDescShouldReturnAllFollowedsInDescOrder() {
        // arrange
        int userId = 1;
        String order = "name_desc";
        List<UserDto> expectedFolloweds = List.of(new UserDto(5, "María"), new UserDto(2, "Cristhian"));

        // act
        when(userFollowerRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());
        FollowedListByUserDto result = userService.findUsersFollowedByUser(userId, order);

        // assert
        assertThat(result.getId()).isEqualTo(userId);
        assertThat(result.getFollowed()).isEqualTo(expectedFolloweds);
    }

    @Test
    @DisplayName("T-0003 - Cuando se consultan los seguidos por un orden invalido debe arrojar BadRequestException")
    void whenFindAllFollowedsByUserOrderInvalidShouldReturnBadRequestException() {
        // arrange
        int userId = 1;
        String order = "invalid_order";

        // act
        when(userFollowerRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());

        // assert
        assertThrows(BadRequestException.class, () -> {
            userService.findUsersFollowedByUser(userId, order);
        });
    }

    @Test
    @DisplayName("T-0004 - Cuando se consultan los seguidores por orden ascendente debe regresar todos los seguidores")
    void whenFindAllFollowersByUserOrderAscShouldReturnAllFollowersInAscOrder() {
        // arrange
        int userId = 4;
        String order = "name_asc";
        List<UserDto> expectedFollowers = List.of(new UserDto(2, "Cristhian"), new UserDto(3, "Daniel"));

        // act
        when(userFollowerRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());
        FollowersListByUserDto result = userService.findAllFollowersByUser(userId, order);

        // assert
        assertThat(result.getId()).isEqualTo(userId);
        assertThat(result.getFollowers()).isEqualTo(expectedFollowers);
    }

    @Test
    @DisplayName("T-0004 - Cuando se consultan los seguidores por orden descendente debe regresar todos los seguidores")
    void whenFindAllFollowersByUserOrderDescShouldReturnAllFollowersInDescOrder() {
        // arrange
        int userId = 4;
        String order = "name_desc";
        List<UserDto> expectedFollowers = List.of(new UserDto(3, "Daniel"), new UserDto(2, "Cristhian"));

        // act
        when(userFollowerRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());
        FollowersListByUserDto result = userService.findAllFollowersByUser(userId, order);

        // assert
        assertThat(result.getId()).isEqualTo(userId);
        assertThat(result.getFollowers()).isEqualTo(expectedFollowers);
    }

    @Test
    @DisplayName("T-0009 - Cuándo el usuario a seguir existe y no es vendedor debe retornar una Exception")
    public void followUserWhenUserToFollowIsNotSellerShouldThrowBadRequestExceptions() {
        // Arrange
        int userId = 2;
        int userIdToFollow = 1;
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());

        // Act
        Exception exception = assertThrows(BadRequestException.class, () -> {
            userService.followUser(userId, userIdToFollow);
        });

        // Assert
        assertEquals("El usuario " + userIdToFollow + " no es un vendedor.", exception.getMessage());
    }

    // ------------------- US0001 -------------------

    // @Test
    // @DisplayName("US-0001 - Cuándo el usuario seguidor no existe debe retornar una NotFoundException")
    // public void followUserWhenUserIdDoesNotExistShouldThrowNotFoundException() {
    //     // TODO: Revisar
    //     // Arrange
    //     int userId = 999;
    //     int userIdToFollow = 1;
    //     when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());
    //     // Act
    //     Exception exception = assertThrows(NotFoundException.class, () -> {
    //         userService.followUser(userId, userIdToFollow);
    //     });
    //     // Assert
    //     assertEquals("No existe el usuario " + userId, exception.getMessage());
    // }

    // ------------------- US0004 -------------------

    // @Test
    // @DisplayName("US0004 - Cuándo el orden enviado es NAME_ASC, debe listar todos los usuarios seguidos ordenados por nombre de forma ascendente")
    // public void whenOrderSendedIsNameAscInFollowedPeopleShouldListFollowedSortedByNameAsc() {
    //     // arrange
    //     int userId = 1;
    //     String order = "NAME_ASC";

    //     // Lista esperada
    //     List<UserDto> expectedFollowed = List.of(
    //             new UserDto(2, "Cristhian"),
    //             new UserDto(5, "María"));

    //     // Mock de los repositorios
    //     when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());
    //     when(userFollowerRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());

    //     // act
    //     FollowedListByUserDto result = userService.findUsersFollowedByUser(userId, order);

    //     // assert
    //     assertThat(result.getId()).isEqualTo(userId);
    //     assertThat(result.getFollowed()).isEqualTo(expectedFollowed);
    // }

    // @Test
    // @DisplayName("US0004 - Cuándo el orden enviado es NAME_DESC, debe listar todos los usuarios seguidos ordenados por nombre de forma ascendente")
    // public void whenOrderSendedIsNameDescInFollowedPeopleShouldListFollowedSortedByNameAsc() {
    //     // arrange
    //     int userId = 1;
    //     String order = "NAME_DESC";

    //     // Lista esperada
    //     List<UserDto> expectedFollowed = List.of(
    //             new UserDto(5, "María"),
    //             new UserDto(2, "Cristhian"));

    //     // Mock de los repositorios
    //     when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());
    //     when(userFollowerRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());

    //     // act
    //     FollowedListByUserDto result = userService.findUsersFollowedByUser(userId, order);

    //     // assert
    //     assertThat(result.getId()).isEqualTo(userId);
    //     assertThat(result.getFollowed()).isEqualTo(expectedFollowed);
    // }

    // @Test
    // @DisplayName("US0004 - Cuándo el orden enviado no es ascendente ni descendente, debe arrojar una excepción BadRequestException")
    // public void whenOrderSendedIsNotAscAndIsNotDescInFollowedPeopleShouldThrowsBadRequestException() {
    //     // arrange
    //     int userId = 2;

    //     // act
    //     // assert
    //     assertThrows(BadRequestException.class, () -> userService.findUsersFollowedByUser(userId, "INVALID_ORDER"));
    // }
}
