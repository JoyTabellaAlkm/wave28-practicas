package com.example.blog.DTO;

import lombok.Data;

@Data
public class EntryBlogDTO {
    private int id;
    private String title;
    private String author;
    private String date;
}
