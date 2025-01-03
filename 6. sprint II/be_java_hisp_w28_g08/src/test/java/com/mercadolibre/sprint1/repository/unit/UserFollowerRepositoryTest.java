package com.mercadolibre.sprint1.repository.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mercadolibre.sprint1.entity.UserFollower;
import com.mercadolibre.sprint1.repository.impl.UserFollowerRepositoryImpl;

import util.TestUtilGenerator;

public class UserFollowerRepositoryTest {

    UserFollowerRepositoryImpl userFollowerRepository = new UserFollowerRepositoryImpl();

    @Test
    @DisplayName("Cuando se llama findAll debe retornar todos los UserFollowers")
    void whereFindAllShouldReturnAllUserFollowers() {
        // arrange

        // act
        List<UserFollower> userFollowers = userFollowerRepository.findAll();

        // assert
        assertFalse(userFollowers.isEmpty());
    }

    @Test
    @DisplayName("Cuando se guarda debe retornar el nuevo UserFollower creado")
    void whenSaveShouldReturnNewUserFollower() {
        // arrange
        UserFollower newUserFollower = TestUtilGenerator.generateFollowers().get(0);
        // act
        UserFollower savedUserFollower = userFollowerRepository.save(newUserFollower);

        // assert
        assertNotNull(savedUserFollower.getUserFollowed());
        assertNotNull(savedUserFollower.getUserFollower());
        assertEquals(newUserFollower.getUserFollowed(), savedUserFollower.getUserFollowed());
        assertEquals(newUserFollower.getUserFollower(), savedUserFollower.getUserFollower());
    }

    @Test
    @DisplayName("Cuando se elimina por un Id existente debe retornar false")
    void whenDeleteByIdUserFollowerExistsShouldReturnTrue() {
        // arrange
        int id = 1;
        // act
        boolean result = userFollowerRepository.delete(id);

        // assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Cuando se elimina por un Id no existente debe retornar false")
    void whenDeleteByIdUserFollowerNotExistsShouldReturnFalse() {
        // arrange
        int id = 0;
        // act
        boolean result = userFollowerRepository.delete(id);

        // assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Cuando se elimina por una entidad existente debe retornar true")
    void whenDeleteByEntityUserFollowerExistsShouldReturnTrue() {
        // arrange
        UserFollower post = TestUtilGenerator.generateFollowers().get(0);

        // act
        userFollowerRepository.save(post);
        boolean result = userFollowerRepository.delete(post);

        // assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Cuando se elimina por una entidad no existente debe retornar false")
    void whenDeleteByEntityUserFollowerNotExistsShouldReturnFalse() {
        // arrange
        UserFollower post = TestUtilGenerator.generateFollowers().get(0);

        // act
        boolean result = userFollowerRepository.delete(post);

        // assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Cuando se busca si un usuario sigue a otro deberia regresar un Optional de UserFollower")
    void whenFindByFollowerIdAndFollowedIdShouldReturnUserFollowerOptional() {
        // arrange
        int userId = 2;
        int sellerId = 1;
        UserFollower userFollower = new UserFollower(sellerId, userId);
        // act
        Optional<UserFollower> result = userFollowerRepository.findByFollowerIdAndFollowedId(userId, sellerId);

        // assert
        assertEquals(Optional.of(userFollower), result);
    }

}
