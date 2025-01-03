package com.mercadolibre.sprint1.service.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.sprint1.dto.response.FollowersCountDto;
import com.mercadolibre.sprint1.dto.response.UnfollowResponseDto;
import com.mercadolibre.sprint1.entity.UserFollower;
import com.mercadolibre.sprint1.exception.NotFoundException;
import com.mercadolibre.sprint1.repository.impl.UserFollowerRepositoryImpl;
import com.mercadolibre.sprint1.repository.impl.UserRepositoryImpl;
import com.mercadolibre.sprint1.service.impl.UserFollowerServiceImpl;

import util.TestUtilGenerator;

@ExtendWith(MockitoExtension.class)
public class UserFollowerServiceTest {

    @Mock
    UserRepositoryImpl userRepository;

    @Mock
    UserFollowerRepositoryImpl userFollowerRepository;

    @InjectMocks
    UserFollowerServiceImpl userFollowerService;

    @Test
    @DisplayName("T-0002 - Cuándo se está siguiendo al vendedor debe dejar de seguirlo")
    void whenSellerIsFollowedShouldUnfollow() {
        // arrange
        int userId = 1;
        int sellerId = 2;
        UnfollowResponseDto expectedResponse = new UnfollowResponseDto("Se ha dejado de seguir al usuario " + sellerId);
        UserFollower userFollower = new UserFollower(userId, sellerId);

        // act
        when(userFollowerRepository.findByFollowerIdAndFollowedId(userId, sellerId))
                .thenReturn(Optional.of(userFollower));
        when(userFollowerRepository.delete(userFollower)).thenReturn(true);

        UnfollowResponseDto result = userFollowerService.unfollow(userId, sellerId);

        // assert
        verify(userFollowerRepository, atLeast(1)).findByFollowerIdAndFollowedId(userId, sellerId);
        verify(userFollowerRepository, atLeast(1)).delete(userFollower);
        assertThat(expectedResponse).isEqualTo(result);
    }

    @Test
    @DisplayName("T-0002 - Cuándo no se está siguiendo al vendedor debe arrojar una NotFoundException")
    void whenSellerIsNotFollowedShouldThrowsNotFoundException() {
        // arrange
        int userId = 1;
        int sellerId = 100;

        // act
        when(userFollowerRepository.findByFollowerIdAndFollowedId(userId, sellerId)).thenReturn(Optional.empty());

        // assert
        assertThrows(NotFoundException.class, () -> {
            userFollowerService.unfollow(userId, sellerId);
        });
    }

    @Test
    @DisplayName("T-0007 Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.")
    public void whenUserExistsShouldReturnCount() {
        // Arrange
        int idUser = 1;
        when(userFollowerRepository.findAll()).thenReturn(TestUtilGenerator.generateFollowers());
        when(userRepository.findAll()).thenReturn(TestUtilGenerator.generateUsers());

        // act
        FollowersCountDto outputFollowerCount = userFollowerService.followersCount(idUser);

        // assert
        verify(userFollowerRepository, atLeastOnce()).findAll();
        verify(userRepository, atLeastOnce()).findAll();
        assertEquals(TestUtilGenerator.expectedResponseFollowerCount(), outputFollowerCount);

    }

}
