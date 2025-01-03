package com.bootcamp.socialmeli.factory;

import com.bootcamp.socialmeli.entity.Product;

import java.util.List;

public class ProductFactory {
    public static List<Product> getTwoGamerProducts() {
        Product mouse = new Product();
        mouse.setId(1);
        mouse.setName("Mouse");
        mouse.setType("Gamer");
        mouse.setBrand("Logitech");
        mouse.setColor("Blue");
        mouse.setNotes("Mouse con 5000 dpi");
        mouse.setPrice(40500);

        Product keyboard = new Product();
        keyboard.setId(2);
        keyboard.setName("Keyboard");
        keyboard.setType("Gamer");
        keyboard.setBrand("Razer");
        keyboard.setColor("Red");
        keyboard.setNotes("Teclado mecanico");
        keyboard.setPrice(90000);

        return List.of(mouse, keyboard);
    }
}
