package com.bootcamp.socialmeli.factory;

import com.bootcamp.socialmeli.entity.Post;
import com.bootcamp.socialmeli.entity.Product;

import java.time.LocalDate;

public class PostFactory {
    public static Post generatePostWithIdXDaysAgo(int id, int userId, int minusDays) {
        LocalDate creationDate = LocalDate.now().minusDays(minusDays);
        return new Post(id, userId, creationDate, createMouse(), 20, false, 0.0);
    }

    public static Post generateRecentPostByUserXDaysAgo(int userId, int minusDays) {
        LocalDate creationDate = LocalDate.now().minusDays(minusDays);
        return new Post(1, userId, creationDate, createMouse(), 20, false, 0.0);
    }

    private static Product createMouse() {
        Product product = new Product();
        product.setId(1);
        product.setName("Mouse");
        product.setType("Gamer");
        product.setBrand("Logitech");
        product.setColor("Blue");
        product.setNotes("Mouse con 5000 dpi");
        product.setPrice(40500);
        return product;
    }

    private static Product createKeyboard() {
        Product product = new Product();
        product.setId(2);
        product.setName("Keyboard");
        product.setType("Gamer");
        product.setBrand("Razer");
        product.setColor("Red");
        product.setNotes("Teclado mecanico");
        product.setPrice(90000);
        return product;
    }

}