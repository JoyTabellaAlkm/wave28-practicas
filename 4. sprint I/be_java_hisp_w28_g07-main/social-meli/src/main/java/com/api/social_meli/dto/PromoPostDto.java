package com.api.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDto {
    @JsonProperty("post_id")
    private int postId;
    @JsonProperty("user_id")
    private Integer seller;
    @JsonProperty("date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate publishDate;
    private ProductDto product;
    @JsonProperty("category")
    private int categoryId;
    private double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;

 // @JsonSetter("date")
 // public void setDateFromJSON(String date){
 //     try {
 //         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
 //         publishDate = LocalDate.parse(date, formatter);
 //     }catch (NumberFormatException e){
 //         this.publishDate = null;
 //     }
 // }
}
