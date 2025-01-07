package com.api.social_meli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostCategory implements Identifiable{
    @JsonProperty("post_category_id")
    private int postCategoryId;
    private String description;

    @Override
    public int getId() {
        return this.postCategoryId;
    }

    @Override
    public void setId(int id) { this.postCategoryId = id; }
}
