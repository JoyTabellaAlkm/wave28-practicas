package com.example.ropa_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clothes")
@NoArgsConstructor
@AllArgsConstructor
public class Cloth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column
    @JsonProperty("code")
    private Long code;

    @Column
    @JsonProperty("name")
    private String name;

    @Column
    @JsonProperty("type")
    private String type;

    @Column
    @JsonProperty("brand")
    private String brand;

    @Column
    @JsonProperty("color")
    private String color;

    @Column
    @JsonProperty("size")
    private String size;

    @Column
    @JsonProperty("amount")
    private Integer amount;

    @Column
    @JsonProperty("price")
    private Double price;

    @JsonIgnore
    @ManyToMany(mappedBy = "clothes", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Sale> sales;
}
