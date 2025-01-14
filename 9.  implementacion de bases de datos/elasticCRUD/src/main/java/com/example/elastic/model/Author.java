package com.example.elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

public class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
