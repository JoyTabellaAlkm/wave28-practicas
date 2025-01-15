package com.bootcamp.movies_hql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Serie {
    @Id
    Long id;
    @OneToMany
    List<Season> seasons;
}
