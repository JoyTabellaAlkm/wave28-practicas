package com.api.social_meli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Identifiable {
    @JsonProperty("post_id")
    private int postId;
    @JsonProperty("seller")
    private User seller;
    @JsonProperty("date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate publishDate;
    private Product product;
    @JsonProperty("category")
    private int categoryId;
    private double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
    @JsonProperty("user_id")
    public int getUserId() { return seller.getUserId(); }

    @Override
    public int getId() {
        return this.postId;
    }

    @Override
    public void setId(int id) { this.postId = id; }
}
