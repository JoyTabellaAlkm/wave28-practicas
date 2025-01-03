package com.mercadolibre.sprint1.repository.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mercadolibre.sprint1.entity.User;
import com.mercadolibre.sprint1.repository.IRepository;
import com.mercadolibre.sprint1.repository.impl.UserRepositoryImpl;

import util.TestUtilGenerator;

public class UserRepositoryTest {

    IRepository<User> userRepository = new UserRepositoryImpl();

    @Test
    @DisplayName("Cuando se llama findAll debe retornar todos los Users")
    void whereFindAllShouldReturnAllUsers() {
        // arrange

        // act
        List<User> user = userRepository.findAll();

        // assert
        assertFalse(user.isEmpty());
    }

    @Test
    @DisplayName("Cuando se guarda debe retornar el nuevo User creado")
    void whenSaveShouldReturnNewUser() {
        // arrange
        User newUser = TestUtilGenerator.generateUsers().get(0);
        // act
        User savedUser = userRepository.save(newUser);

        // assert
        assertNotNull(savedUser.getId());
        assertEquals(newUser.getId(), savedUser.getId());
        assertEquals(newUser.getName(), savedUser.getName());
    }

    @Test
    @DisplayName("Cuando se elimina por un Id existente debe retornar true")
    void whenDeleteByIdUserExistsShouldReturnTrue() {
        // arrange
        int id = 1;
        // act
        boolean result = userRepository.delete(id);

        // assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Cuando se elimina por un Id no existente debe retornar false")
    void whenDeleteByIdUserNotExistsShouldReturnFalse() {
        // arrange
        int id = 0;
        // act
        boolean result = userRepository.delete(id);

        // assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Cuando se elimina por una entidad existente debe retornar true")
    void whenDeleteByEntityUserExistsShouldReturnTrue() {
        // arrange
        User post = TestUtilGenerator.generateUsers().get(0);

        // act
        userRepository.save(post);
        boolean result = userRepository.delete(post);

        // assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Cuando se elimina por una entidad no existente debe retornar false")
    void whenDeleteByEntityUserNotExistsShouldReturnFalse() {
        // arrange
        User post = TestUtilGenerator.generateUsers().get(0);

        // act
        boolean result = userRepository.delete(post);

        // assert
        assertFalse(result);
    }

}
