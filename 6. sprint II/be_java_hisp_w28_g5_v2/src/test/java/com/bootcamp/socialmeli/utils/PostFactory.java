package com.bootcamp.socialmeli.utils;

import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class PostFactory {
    public static List<Post> createPost(){
        Product product1 = new Product(1L, "Product 1", "Type 1", "Brand A", "Red", "Notes about product 1");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return List.of(
                new Post(1L, LocalDate.now().minusDays(1), product1, 1, 100.0, false, 0.0),
                new Post(2L, LocalDate.now().minusDays(1), product1, 1, 100.0, false, 0.0),
                new Post(3L, LocalDate.now().minusDays(1), product1, 1, 100.0, false, 0.0),
                new Post(4L, LocalDate.parse("2024-11-13", formatter), product1, 1, 100.0, false, 0.0),
                new Post(5L, LocalDate.parse("2024-10-13", formatter), product1, 1, 100.0, false, 0.0),
                new Post(6L, LocalDate.parse("2024-09-13", formatter), product1, 1, 100.0, false, 0.0),
                new Post(7L, LocalDate.parse("2024-08-13", formatter), product1, 1, 100.0, false, 0.0),
                new Post(8L, LocalDate.parse("2024-07-13", formatter), product1, 1, 100.0, false, 0.0)
        );
    }
}
