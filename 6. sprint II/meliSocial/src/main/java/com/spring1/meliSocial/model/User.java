package com.spring1.meliSocial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String userName;
    private boolean seller;
    private List<Integer> followers;
    private List<Integer> followed;
    private List<Integer> products;
    private Set<Integer> favouritesPosts;

    public User() {
        this.userName = "";
        this.seller = false;
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.products = new ArrayList<>();
        this.favouritesPosts = new HashSet<>();
    }

}


