package com.example.elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "blog")
@Getter @Setter
public class Article {
    @Id
    private int id;
    private String title;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authorsList;

}
