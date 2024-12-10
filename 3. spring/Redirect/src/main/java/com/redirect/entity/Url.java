package com.redirect.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Url {
    private String id;
    private String url;
    private int opens;
    private boolean active;
}
