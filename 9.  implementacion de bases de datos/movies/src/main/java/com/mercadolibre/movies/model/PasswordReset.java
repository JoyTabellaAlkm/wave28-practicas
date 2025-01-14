package com.mercadolibre.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "password_resets")
@Setter
@Getter
public class PasswordReset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String token;
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;
}

