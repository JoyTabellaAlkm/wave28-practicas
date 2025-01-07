package com.mercadolibre.sprint1.repository.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mercadolibre.sprint1.entity.Post;
import com.mercadolibre.sprint1.repository.IRepository;
import com.mercadolibre.sprint1.repository.impl.PostRepositoryImpl;

import util.TestUtilGenerator;

public class PostRepositoryTest {

    IRepository<Post> postRepository = new PostRepositoryImpl();

    @Test
    @DisplayName("Cuando se llama findAll debe retornar todos los Posts")
    void whereFindAllShouldReturnAllPosts() {
        // arrange

        // act
        List<Post> posts = postRepository.findAll();

        // assert
        assertFalse(posts.isEmpty());
    }

    @Test
    @DisplayName("Cuando se guarda debe retornar el nuevo Post creado")
    void whenSaveShouldReturnNewPost() {
        // arrange
        Post newPost = TestUtilGenerator.generatePosts().get(0);
        // act
        Post savedPost = postRepository.save(newPost);

        // assert
        assertNotNull(savedPost.getId());
        assertEquals(newPost.getUserId(), savedPost.getUserId());
        assertEquals(newPost.getDate(), savedPost.getDate());
        assertEquals(newPost.getCategory(), savedPost.getCategory());
        assertEquals(newPost.getPrice(), savedPost.getPrice());
        assertEquals(newPost.isHasPromo(), savedPost.isHasPromo());
        assertEquals(newPost.getDiscount(), savedPost.getDiscount());
        assertEquals(newPost.getProduct(), savedPost.getProduct());
    }

    @Test
    @DisplayName("Cuando se elimina por un Id existente debe retornar true")
    void whenDeleteByIdPostExistsShouldReturnTrue() {
        // arrange
        int id = 1;
        // act
        boolean result = postRepository.delete(id);

        // assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Cuando se elimina por un Id no existente debe retornar false")
    void whenDeleteByIdPostNotExistsShouldReturnFalse() {
        // arrange
        int id = 0;
        // act
        boolean result = postRepository.delete(id);

        // assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Cuando se elimina por una entidad existente debe retornar true")
    void whenDeleteByEntityPostExistsShouldReturnTrue() {
        // arrange
        Post post = TestUtilGenerator.generatePosts().get(0);

        // act
        postRepository.save(post);
        boolean result = postRepository.delete(post);

        // assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Cuando se elimina por una entidad no existente debe retornar false")
    void whenDeleteByEntityPostNotExistsShouldReturnFalse() {
        // arrange
        Post post = TestUtilGenerator.generatePosts().get(0);

        // act
        boolean result = postRepository.delete(post);

        // assert
        assertFalse(result);
    }

}
