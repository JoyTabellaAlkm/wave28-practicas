package com.mercadolibre.social.repository.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mercadolibre.social.entity.Post;
import com.mercadolibre.social.repository.IPostRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository {

    private static Integer nextId = 100;  // Variable estática para generar ID únicos
    private final List<Post> posts;

    public PostRepository() throws IOException {
        posts = loadDataBase();
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post save(Post post) {
        post.setId(nextId++);
        posts.add(post);
        return post;
    }

    @Override
    public List<Post> findByProductId(Integer id) {
        return posts.stream().filter(post -> post.getProductId().equals(id)).toList();
    }

    private List<Post> loadDataBase() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new JsonDeserializer<>() {
            @Override
            public LocalDate deserialize(JsonParser p, DeserializationContext text) throws IOException {
                String date = p.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                return LocalDate.parse(date, formatter);
            }
        });

        objectMapper.registerModule(module);

        try (InputStream inputStream = getClass().getResourceAsStream("/posts.json")) {
            if (inputStream == null) {
                throw new IOException("El archivo JSON no se encontró: " + "/posts.json");
            }
            return objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        }
    }
}
