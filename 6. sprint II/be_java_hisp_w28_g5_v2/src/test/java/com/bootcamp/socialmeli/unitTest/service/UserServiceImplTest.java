package com.bootcamp.socialmeli.unitTest.service;

import com.bootcamp.socialmeli.dto.response.*;
import com.bootcamp.socialmeli.exception.*;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.UserRepository;
import com.bootcamp.socialmeli.service.impl.UserServiceImpl;
import com.bootcamp.socialmeli.util.mapper.UserMapper;
import com.bootcamp.socialmeli.utils.FollowedFactory;
import com.bootcamp.socialmeli.utils.FollowersFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    final private Long ID_1 = 1L;
    final private Long ID_2 = 2L;
    private User user1;
    private User user2;

    @BeforeEach
    public void setUp(){
        user1 = new User(ID_1,"user1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        user2 = new User(ID_2,"user2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    }

    @Test
    @DisplayName("T-0002: El usuario a dejar de seguir existe")
    void unfollowUserTest() {
        //arrange
        user1.getFollowed().add(user2);
        user2.getFollowers().add(user1);
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findById(ID_2)).thenReturn(Optional.of(user2));

        //act
        UnfollowResponseDTO resultado = userService.unfollowUser(ID_1, ID_2);

        //assert
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(ID_1, resultado.getId());
        Assertions.assertEquals(user1.getFollowed().size(),resultado.getFollowed().size());
    }

    @Test
    @DisplayName("T-0002: El usuario a dejar de seguir no existe")
    void unfollowNonExistingUserTest (){
        //arrange
        user1.getFollowed().add(user2);
        user2.getFollowers().add(user1);
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findById(ID_2)).thenReturn(Optional.empty());

        //act && assert
        Assertions.assertThrows(NotFoundException.class,()->userService.unfollowUser(ID_1, ID_2));
    }

    @Test
    void unfollowFromNonExistingUserTest (){
        //arrange
        user1.getFollowed().add(user2);
        user2.getFollowers().add(user1);
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.empty());

        //act && assert
        Assertions.assertThrows(NotFoundException.class,()->userService.unfollowUser(ID_1, ID_2));
    }

    @Test
    void unfollowUserNotFollowedTest() {
        //arrange
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findById(ID_2)).thenReturn(Optional.of(user2));

        //act && assert
        Assertions.assertThrows(UserNotFollowedException.class,()->userService.unfollowUser(ID_1, ID_2));

    }

    @Test
    @DisplayName("T-0001: El usuario a seguir existe")
    void followUserTest(){
        //arrange
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findById(ID_2)).thenReturn(Optional.of(user2));
        //act
        FollowUserDto result =  userService.followUser(ID_1,ID_2);

        //assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(ID_1,result.getId());
        Assertions.assertEquals(1,result.getFollowed().size());
        Assertions.assertTrue(result.getFollowed().stream().anyMatch(u->u.getId().equals(ID_2)));
    }

    @Test
    @DisplayName("T-0001: El usuario a seguir no existe")
    void followNonExistingUserTest(){
        //arrange
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findById(ID_2)).thenReturn(Optional.empty());
        //act && assert
        Assertions.assertThrows(NotFoundException.class,()->userService.followUser(ID_1,ID_2));
    }
    @Test
    void followFromNonExistingUserTest(){
        //arrange
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.empty());
        //act && assert
        Assertions.assertThrows(NotFoundException.class,()->userService.followUser(ID_1,ID_2));
    }
    @Test
    void followMyselfTest(){
        //act && assert
        Assertions.assertThrows(IllegalFollowException.class,()->userService.followUser(ID_1,ID_1));
    }
    @Test
    void followAlreadyFollowedUserTest(){
        //arrange
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        Mockito.when(userRepository.findById(ID_2)).thenReturn(Optional.of(user2));
        //act
        userService.followUser(ID_1,ID_2);
        //assert
        Assertions.assertThrows(ExistingFollowException.class,()->userService.followUser(ID_1,ID_2));
    }

    @Test
    @DisplayName("T-0007: la cantidad de seguidores de un usuario con 1 seguidor es 1")
    void getFollowersCount_ValidUser(){
        //arrange
        user1.getFollowers().add(user2);
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        //act
        FollowerCountDTO result = userService.getFollowersCount(ID_1);
        //assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(ID_1,result.getUserId());
        Assertions.assertEquals("user1",result.getUserName());
        Assertions.assertEquals(1,result.getFollowersCount());
    }
    @Test
    void getFollowerCount_UserNotFound() {
        //arrange
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.empty());
        //act y assert
        Assertions.assertThrows(NotFoundException.class, ()->userService.getFollowersCount(ID_1));
    }

    @Test
    @DisplayName("T-0007: la cantidad de seguidores de un usuario sin seguidores es 0")
    void getFollowersCount_NoFollowers(){
        //arrange
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));

        //act
        FollowerCountDTO result = userService.getFollowersCount(ID_1);

        //assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(ID_1,result.getUserId());
        Assertions.assertEquals("user1",result.getUserName());
        Assertions.assertEquals(0,result.getFollowersCount());

    }

    @Test
    @DisplayName("T-0003: (followers) el tipo de ordenamiento ascendente existe")
    void getFollowersByUserIdOrderByNameAscExists(){
        // Arrange
        List<User> followers = FollowersFactory.createFollowers();
        user1.setFollowers(followers);
        // Act
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        GetFollowersDTO getFollowersDTO = userService.getFollowersByUserId(ID_1, "name_asc");
        // Assert
        Assertions.assertNotNull(getFollowersDTO);
        Assertions.assertEquals(user1.getName(), getFollowersDTO.getUserName());
        Assertions.assertEquals(user1.getId(), getFollowersDTO.getUserId());
    }

    @Test
    @DisplayName("T-0003: (followers) el tipo de ordenamiento descendente existe")
    void getFollowersByUserIdOrderByNameDescExists(){
        // Arrange
        List<User> followers = FollowersFactory.createFollowers();
        user1.setFollowers(followers);
        // Act
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        GetFollowersDTO getFollowersDTO = userService.getFollowersByUserId(ID_1, "name_desc");
        // Assert
        Assertions.assertNotNull(getFollowersDTO);
        Assertions.assertEquals(user1.getName(), getFollowersDTO.getUserName());
        Assertions.assertEquals(user1.getId(), getFollowersDTO.getUserId());
    }

    @Test
    @DisplayName("T-0004: (followers) se ordena ascendentemente por nombre correctamente")
    void getFollowersByUserIdAsc(){
        // Arrange
        List<User> followers = FollowersFactory.createFollowers();
        user1.setFollowers(followers);
        // Act
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        GetFollowersDTO getFollowersDTO = userService.getFollowersByUserId(ID_1, "name_asc");
        // Assert
        Assertions.assertEquals(UserMapper.toUserDto(followers.get(1)), getFollowersDTO.getFollowers().get(0));
        Assertions.assertEquals(UserMapper.toUserDto(followers.get(2)), getFollowersDTO.getFollowers().get(2));
    }

    @Test
    @DisplayName("T-0004: (followers) se ordena descendentemente por nombre correctamente")
    void getFollowersByUserIdDesc(){
        // Arrange
        List<User> followers = FollowersFactory.createFollowers();
        user1.setFollowers(followers);
        // Act
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        GetFollowersDTO getFollowersDTO = userService.getFollowersByUserId(ID_1, "name_desc");
        // Assert
        Assertions.assertEquals(UserMapper.toUserDto(followers.get(2)), getFollowersDTO.getFollowers().get(0));
        Assertions.assertEquals(UserMapper.toUserDto(followers.get(1)), getFollowersDTO.getFollowers().get(2));
    }

    @Test
    @DisplayName("T-0003: (followed) el tipo de ordenamiento ascendente existe")
    void getFollowedByUserIdOrderByNameAscExists(){
        // Arrange
        List<User> followed = FollowedFactory.createFollowed();
        user1.setFollowed(followed);
        // Act
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        GetFollowedDTO getFollowersDTO = userService.getFollowedByUserId(ID_1, "name_asc");
        // Assert
        Assertions.assertNotNull(getFollowersDTO);
        Assertions.assertEquals(user1.getName(), getFollowersDTO.getUserName());
        Assertions.assertEquals(user1.getId(), getFollowersDTO.getUserId());
    }

    @Test
    @DisplayName("T-0003: (followed) el tipo de ordenamiento descendente existe")
    void getFollowedByUserIdOrderByNameDescExists(){
        // Arrange
        List<User> followed = FollowedFactory.createFollowed();
        user1.setFollowed(followed);
        // Act
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        GetFollowedDTO getFollowersDTO = userService.getFollowedByUserId(ID_1, "name_desc");
        // Assert
        Assertions.assertNotNull(getFollowersDTO);
        Assertions.assertEquals(user1.getName(), getFollowersDTO.getUserName());
        Assertions.assertEquals(user1.getId(), getFollowersDTO.getUserId());
    }

    @Test
    @DisplayName("T-0004: (followed) se ordena ascendentemente por nombre correctamente")
    void getFollowedByUserIdAsc(){
        // Arrange
        List<User> followed = FollowedFactory.createFollowed();
        user1.setFollowed(followed);
        // Act
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        GetFollowedDTO getFollowersDTO = userService.getFollowedByUserId(ID_1, "name_asc");
        // Assert
        Assertions.assertEquals(UserMapper.toUserDto(followed.get(0)), getFollowersDTO.getFollowed().get(0));
        Assertions.assertEquals(UserMapper.toUserDto(followed.get(1)), getFollowersDTO.getFollowed().get(2));
    }

    @Test
    @DisplayName("T-0004: (followed) se ordena descendentemente por nombre correctamente")
    void getFollowedByUserIdDesc(){
        // Arrange
        List<User> followed = FollowedFactory.createFollowed();
        user1.setFollowed(followed);
        // Act
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        GetFollowedDTO getFollowersDTO = userService.getFollowedByUserId(ID_1, "name_desc");
        // Assert
        Assertions.assertEquals(UserMapper.toUserDto(followed.get(1)), getFollowersDTO.getFollowed().get(0));
        Assertions.assertEquals(UserMapper.toUserDto(followed.get(0)), getFollowersDTO.getFollowed().get(2));
    }
    @Test
    @DisplayName("T-0003: (followed) el tipo de ordenamiento no existe")
    void getFollowedByUserIdOrderInvalid(){
        // Arrange
        List<User> followed = FollowedFactory.createFollowed();
        user1.setFollowed(followed);
        // Act
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        // Assert
        Assertions.assertThrows(OrderInvalidException.class,
                () -> userService.getFollowedByUserId(ID_1, "someting")
        );
    }

    @Test
    @DisplayName("T-0003: (followers) el tipo de ordenamiento no existe")
    void getFollowersByUserIdOrderInvalid(){
        // Arrange
        List<User> followed = FollowedFactory.createFollowed();
        user1.setFollowed(followed);
        // Act
        Mockito.when(userRepository.findById(ID_1)).thenReturn(Optional.of(user1));
        // Assert
        Assertions.assertThrows(OrderInvalidException.class,
                () -> userService.getFollowersByUserId(ID_1, "someting")
        );
    }
}
