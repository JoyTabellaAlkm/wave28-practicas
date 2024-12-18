package com.api.social_meli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Identifiable{
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String name;
    private List<Integer> followed;
    private List<Integer> followers;
    private List<Integer> posts;
    private List<Integer> favourites;

    @Override
    public int getId() { return this.userId; }

    @Override
    public void setId(int id) { this.userId = id; }

    public boolean isSeller() { return !posts.isEmpty(); }
}
