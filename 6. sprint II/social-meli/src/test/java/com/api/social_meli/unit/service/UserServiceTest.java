package com.api.social_meli.unit.service;
import com.api.social_meli.dto.*;
import com.api.social_meli.exception.BadRequestException;
import com.api.social_meli.exception.NotFoundException;
import com.api.social_meli.model.User;
import com.api.social_meli.service.impl.UserServiceImpl;
import com.api.social_meli.util.MockFactoryUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.api.social_meli.repository.IUserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepository;

    @Mock
    ObjectMapper mapper;

    @InjectMocks
    UserServiceImpl userService;

    //region UNFOLLOW USER
    @Test
    void unfollowValidUsersSuccessfullyUnfollows() {
        // ARRANGE
        int userId = 1;
        int userIdToUnfollow = 2;
        User user = MockFactoryUtils.createUserWithOnlyFollowersAndFolloweds(userId, new ArrayList<>(List.of(userIdToUnfollow)), new ArrayList<>());
        User userToUnfollow = MockFactoryUtils.createUserWithOnlyFollowersAndFolloweds(userIdToUnfollow, new ArrayList<>(),  new ArrayList<>(List.of(userId)));
        when(userRepository.findById(userId)).thenReturn(user);
        when(userRepository.findById(userIdToUnfollow)).thenReturn(userToUnfollow);

        //ACT
        MessageDto response = userService.unfollowUser(userId, userIdToUnfollow);

        //ASSERT
        assertEquals("El usuario se dejo de seguir exitosamente", response.getMessage());
        assertFalse(user.getFollowed().contains(userIdToUnfollow));
        assertFalse(userToUnfollow.getFollowers().contains(userId));
    }

    @Test
    void unfollowNotExistentUserThrowsNotFoundEx() {
        //ARRANGE
        int userId = 1;
        int userIdToUnfollow = 23232;
        User user = new User();
        user.setId(userId);
        when(userRepository.findById(userId)).thenReturn(user);
        when(userRepository.findById(userIdToUnfollow)).thenReturn(null);

        //ACT & ASSERT
        assertThrows(NotFoundException.class, () -> userService.unfollowUser(userId, userIdToUnfollow));
    }
    //endregion

    //region VERIFY FOLLOWER COUNT
    @Test
    void getFollowerCountValidUserReturnsCorrectCount(){
        //ARRANGE
        User user = new User();
        user.setId(1);
        user.setFollowers(new ArrayList<>(List.of(2,3,4)));
        when(userRepository.findById(1)).thenReturn(user);

        //ACT
        GetFollowerCountDto getFollowerCountDto = userService.getFollowerCount(1);

        //ASSERT
        assertEquals(3,getFollowerCountDto.getFollowers_count());
    }
    //endregion

    //region FOLLOW USER
    @Test
    @DisplayName("Intentar seguir a usuario existente")
    void shouldFollowUserSuccessfullyWhenUserExists(){
        // ARRANGE
        int userId = 2;
        int userIdToFollow = 3;
        User userFollower = MockFactoryUtils.createUserWithIdAndFollowed(userId);
        User userToFollow = MockFactoryUtils.createUserWithFollowersAndPost(userIdToFollow);

        when(userRepository.findById(userId)).thenReturn(userFollower);
        when(userRepository.findById(userIdToFollow)).thenReturn(userToFollow);

        //ACT
        MessageDto response = userService.followUser(userId, userIdToFollow);

        //ASSERT
        assertEquals("El usuario se comenzo a seguir exitosamente", response.getMessage());
        assertTrue(userFollower.getFollowed().contains(userIdToFollow), "El usuario debería estar en la lista de seguidos.");
        assertTrue(userToFollow.getFollowers().contains(userId), "El usuario seguidor debería estar en la lista de seguidores.");
    }

    @Test
    @DisplayName("Intentar seguir a usuario no existente")
    void shouldNotFollowUserWhenNonexistentUser(){
        // ARRANGE
        int userId = 2;
        int userIdToFollow = 3000;
        User userFollower = MockFactoryUtils.createUserWithIdAndFollowed(userId);

        when(userRepository.findById(userId)).thenReturn(userFollower);
        when(userRepository.findById(userIdToFollow)).thenReturn(null);

        // ACT & ASSERT
        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            userService.followUser(userId, userIdToFollow);
        });

        assertEquals("Usuario o vendedor no encontrado", thrown.getMessage());
    }
    //endregion

    //region GET FOLLOWS ORDER ERROR
    //region FOLLOWEDS
    @Test
    @DisplayName("Obtener Followeds orden inválido.")
    public void getFollowedsOrderedByNameInvalidOrderThrowException(){
        //Arrange
        String order = "Ordenar A-Z";
        User userAna = MockFactoryUtils.createUserWithIdNameAndFolloweds(1, "Ana Martínez", List.of(3,5,4));

        //Act
        Mockito.when(userRepository.findById(userAna.getUserId())).thenReturn(userAna);
        Mockito.when(userRepository.exists(userAna.getUserId())).thenReturn(true);

        //Assert
        Assertions.assertThrows(BadRequestException.class, ()->userService.getFollowedsOrderedByName(userAna.getUserId(), order));
    }

    @Test
    @DisplayName("Obtener Followeds orden válido.")
    public void getFollowedsOrderedByNameValidOrderReturnList(){
        //Arrange
        String order = "name_asc";
        User userAna = MockFactoryUtils.createUserWithIdNameAndFolloweds(1, "Ana Martínez", List.of(3,5,4));

        //Act
        Mockito.when(userRepository.findById(userAna.getUserId())).thenReturn(userAna);
        Mockito.when(userRepository.exists(userAna.getUserId())).thenReturn(true);
        Mockito.when(mapper.convertValue(userRepository.findById(2), FollowDto.class)).thenReturn(new FollowDto(2,""));
        FollowedListDto result = userService.getFollowedsOrderedByName(userAna.getUserId(), order);

        //Assert
        Assertions.assertEquals(3, result.getFollowed().size());
    }
    //endregion

    //region FOLLOWERS
    @Test
    @DisplayName("Obtener Followers orden inválido.")
    public void getFollowersOrderedByNameInvalidOrderThrowException(){
        //Arrange
        String order = "Ordenar Z-A";
        User userMaria = MockFactoryUtils.createUserWithIdNameFollowersAndPost(3, "María López", List.of(1,5,6), List.of(2,4,5));

        //Act
        Mockito.when(userRepository.findById(userMaria.getUserId())).thenReturn(userMaria);
        Mockito.when(userRepository.exists(userMaria.getUserId())).thenReturn(true);

        //Assert
        Assertions.assertThrows(BadRequestException.class, ()->userService.getFollowersOrderedByName(userMaria.getUserId(), order));
    }

    @Test
    @DisplayName("Obtener Followers orden válido.")
    public void getFollowersOrderedByNameValidReturnList(){
        //Arrange
        String order = "name_desc";
        User userMaria = MockFactoryUtils.createUserWithIdNameFollowersAndPost(3, "María López", List.of(1,5,6), List.of(2,4,5));

        //Act
        Mockito.when(userRepository.findById(userMaria.getUserId())).thenReturn(userMaria);
        Mockito.when(userRepository.exists(userMaria.getUserId())).thenReturn(true);
        Mockito.when(mapper.convertValue(userRepository.findById(1), FollowDto.class)).thenReturn(new FollowDto(1,""));
        FollowerListDto result = userService.getFollowersOrderedByName(userMaria.getUserId(), order);

        //Assert
        Assertions.assertEquals(3, result.getFollowers().size());
    }
    //endregion
    //endregion

    //region GET FOLLOWS SORTED BY NAME
    //region FOLLOWEDS
    @Test
    @DisplayName("Obtener Followeds ordenados por nombre de manera ascendente.")
    public void getFollowedsOrderedByNameValidOrderReturnSortedListAsc(){
        // Arrange
        String order = "name_asc";
        User userAna = MockFactoryUtils.createUserWithIdNameAndFolloweds(1, "Ana Martínez", List.of(3,5,4));

        User userMaria = MockFactoryUtils.createUserWithIdNameFollowersAndPost(3, "María López", List.of(1,6,5), List.of(2,4,5));
        User userLucia = MockFactoryUtils.createUserWithIdNameFollowersAndPost(5, "Lucía Fernández", List.of(1), List.of(8,9));
        User userJuan = MockFactoryUtils.createUserWithIdNameFollowersAndPost(4, "Juan Pérez", List.of(1), List.of(6,7));

        FollowDto mariaDto = MockFactoryUtils.convertUserToFollowDto(userMaria);
        FollowDto luciaDto = MockFactoryUtils.convertUserToFollowDto(userLucia);
        FollowDto juanDto = MockFactoryUtils.convertUserToFollowDto(userJuan);

        List<FollowDto> expectedList = List.of(juanDto, luciaDto, mariaDto);

        //Act
        Mockito.when(userRepository.findById(1)).thenReturn(userAna);
        Mockito.when(userRepository.exists(1)).thenReturn(true);

        Mockito.when(userRepository.findById(3)).thenReturn(userMaria);
        Mockito.when(userRepository.findById(5)).thenReturn(userLucia);
        Mockito.when(userRepository.findById(4)).thenReturn(userJuan);

        Mockito.when(mapper.convertValue(userMaria, FollowDto.class)).thenReturn(mariaDto);
        Mockito.when(mapper.convertValue(userLucia, FollowDto.class)).thenReturn(luciaDto);
        Mockito.when(mapper.convertValue(userJuan, FollowDto.class)).thenReturn(juanDto);

        FollowedListDto result = userService.getFollowedsOrderedByName(1, order);

        // Assert
        Assertions.assertEquals(expectedList, result.getFollowed());
    }

    @Test
    @DisplayName("Obtener Followeds ordenados por nombre de manera descendente.")
    public void getFollowedsOrderedByNameValidOrderReturnSortedListDesc(){
        // Arrange
        String order = "name_desc";
        User userAna = MockFactoryUtils.createUserWithIdNameAndFolloweds(1, "Ana Martínez", List.of(3,5,4));

        User userMaria = MockFactoryUtils.createUserWithIdNameFollowersAndPost(3, "María López", List.of(1,6,5), List.of(2,4,5));
        User userLucia = MockFactoryUtils.createUserWithIdNameFollowersAndPost(5, "Lucía Fernández", List.of(1), List.of(8,9));
        User userJuan = MockFactoryUtils.createUserWithIdNameFollowersAndPost(4, "Juan Pérez", List.of(1), List.of(6,7));

        FollowDto mariaDto = MockFactoryUtils.convertUserToFollowDto(userMaria);
        FollowDto luciaDto = MockFactoryUtils.convertUserToFollowDto(userLucia);
        FollowDto juanDto = MockFactoryUtils.convertUserToFollowDto(userJuan);

        List<FollowDto> expectedList = List.of(mariaDto, luciaDto, juanDto);

        //Act
        Mockito.when(userRepository.findById(1)).thenReturn(userAna);
        Mockito.when(userRepository.exists(1)).thenReturn(true);

        Mockito.when(userRepository.findById(3)).thenReturn(userMaria);
        Mockito.when(userRepository.findById(5)).thenReturn(userLucia);
        Mockito.when(userRepository.findById(4)).thenReturn(userJuan);

        Mockito.when(mapper.convertValue(userMaria, FollowDto.class)).thenReturn(mariaDto);
        Mockito.when(mapper.convertValue(userLucia, FollowDto.class)).thenReturn(luciaDto);
        Mockito.when(mapper.convertValue(userJuan, FollowDto.class)).thenReturn(juanDto);

        FollowedListDto result = userService.getFollowedsOrderedByName(1, order);

        // Assert
        Assertions.assertEquals(expectedList, result.getFollowed());
    }

    @Test
    @DisplayName("Ordenar lista de Followeds vacía.")
    public void getFollowedsOrderedByNameEmptyListNotFoundException(){
        //Arrange
        int userId = 2;
        String order = "name_asc";
        User user = new User();
        user.setId(userId);
        user.setFollowed(new ArrayList<>());

        //Act
        Mockito.when(userRepository.findById(userId)).thenReturn(user);
        Mockito.when(userRepository.exists(userId)).thenReturn(true);

        //Assert
        Assertions.assertThrows(NotFoundException.class, ()->userService.getFollowedsOrderedByName(userId, order));
    }

    @Test
    @DisplayName("Ordenar lista de Followeds de usuario inexistente.")
    public void getFollowedsOrderedByNameInvalidUserIdNotFoundException(){
        //Arrange
        int userId = 1000;
        String order = "name_asc";
        User user = new User();
        user.setId(userId);

        //Act
        Mockito.when(userRepository.findById(userId)).thenReturn(user);
        Mockito.when(userRepository.exists(userId)).thenReturn(false);

        //Assert
        Assertions.assertThrows(NotFoundException.class, ()->userService.getFollowedsOrderedByName(userId, order));
    }
    //endregion

    //region FOLLOWERS
    @Test
    @DisplayName("Obtener Followers ordenados por nombre de manera ascendente.")
    public void getFollowersOrderedByNameValidOrderReturnSortedListAsc(){
        // Arrange
        String order = "name_asc";
        User userMaria = MockFactoryUtils.createUserWithIdNameFollowersAndPost(3, "María López", List.of(1,6,5), List.of(2,4,5));

        User userAna = MockFactoryUtils.createUserWithIdNameAndFolloweds(1, "Ana Martínez", List.of(3,4,5));
        User userLucia = MockFactoryUtils.createUserWithIdNameFollowersAndPost(5, "Lucía Fernández", List.of(1), List.of(8,9));
        User userMiguel = MockFactoryUtils.createUserWithIdNameAndFolloweds(1, "Miguel Rodríguez", List.of(2,3));

        FollowDto anaDto = MockFactoryUtils.convertUserToFollowDto(userAna);
        FollowDto luciaDto = MockFactoryUtils.convertUserToFollowDto(userLucia);
        FollowDto miguelDto = MockFactoryUtils.convertUserToFollowDto(userMiguel);

        List<FollowDto> expectedList = List.of(anaDto, luciaDto, miguelDto);

        //Act
        Mockito.when(userRepository.findById(3)).thenReturn(userMaria);
        Mockito.when(userRepository.exists(3)).thenReturn(true);

        Mockito.when(userRepository.findById(1)).thenReturn(userAna);
        Mockito.when(userRepository.findById(5)).thenReturn(userLucia);
        Mockito.when(userRepository.findById(6)).thenReturn(userMiguel);

        Mockito.when(mapper.convertValue(userAna, FollowDto.class)).thenReturn(anaDto);
        Mockito.when(mapper.convertValue(userLucia, FollowDto.class)).thenReturn(luciaDto);
        Mockito.when(mapper.convertValue(userMiguel, FollowDto.class)).thenReturn(miguelDto);

        FollowerListDto result = userService.getFollowersOrderedByName(3, order);

        // Assert
        Assertions.assertEquals(expectedList, result.getFollowers());
    }

    @Test
    @DisplayName("Obtener Followers ordenados por nombre de manera descendente.")
    public void getFollowersOrderedByNameValidOrderReturnSortedListDesc(){
        // Arrange
        String order = "name_desc";
        User userMaria = MockFactoryUtils.createUserWithIdNameFollowersAndPost(3, "María López", List.of(1,6,5), List.of(2,4,5));

        User userAna = MockFactoryUtils.createUserWithIdNameAndFolloweds(1, "Ana Martínez", List.of(3,4,5));
        User userLucia = MockFactoryUtils.createUserWithIdNameFollowersAndPost(5, "Lucía Fernández", List.of(1), List.of(8,9));
        User userMiguel = MockFactoryUtils.createUserWithIdNameAndFolloweds(1, "Miguel Rodríguez", List.of(2,3));

        FollowDto anaDto = MockFactoryUtils.convertUserToFollowDto(userAna);
        FollowDto luciaDto = MockFactoryUtils.convertUserToFollowDto(userLucia);
        FollowDto miguelDto = MockFactoryUtils.convertUserToFollowDto(userMiguel);

        List<FollowDto> expectedList = List.of(miguelDto, luciaDto, anaDto);

        //Act
        Mockito.when(userRepository.findById(3)).thenReturn(userMaria);
        Mockito.when(userRepository.exists(3)).thenReturn(true);

        Mockito.when(userRepository.findById(1)).thenReturn(userAna);
        Mockito.when(userRepository.findById(5)).thenReturn(userLucia);
        Mockito.when(userRepository.findById(6)).thenReturn(userMiguel);

        Mockito.when(mapper.convertValue(userAna, FollowDto.class)).thenReturn(anaDto);
        Mockito.when(mapper.convertValue(userLucia, FollowDto.class)).thenReturn(luciaDto);
        Mockito.when(mapper.convertValue(userMiguel, FollowDto.class)).thenReturn(miguelDto);

        FollowerListDto result = userService.getFollowersOrderedByName(3, order);

        // Assert
        Assertions.assertEquals(expectedList, result.getFollowers());
    }

    @Test
    @DisplayName("Ordenar lista de Followers de usuario inexistente.")
    public void getFollowersOrderedByNameInvalidUserIdNotFoundException(){
        //Arrange
        int userId = 1000;
        String order = "name_desc";
        User user = new User();
        user.setId(userId);

        //Act
        Mockito.when(userRepository.findById(userId)).thenReturn(user);
        Mockito.when(userRepository.exists(userId)).thenReturn(false);

        //Assert
        Assertions.assertThrows(NotFoundException.class, ()->userService.getFollowersOrderedByName(userId, order));
    }

    @Test
    @DisplayName("Ordenar lista de Followers de usuario que no es vendedor.")
    public void getFollowersOrderedByNameIsNotSellerBadRequestException(){
        //Arrange
        int userId = 1;
        String order = "name_desc";
        User user = new User();
        user.setId(userId);
        user.setPosts(new ArrayList<>());

        //Act
        Mockito.when(userRepository.findById(userId)).thenReturn(user);
        Mockito.when(userRepository.exists(userId)).thenReturn(true);

        //Assert
        Assertions.assertThrows(BadRequestException.class, ()->userService.getFollowersOrderedByName(userId, order));
    }
    //endregion
    //endregion
}
