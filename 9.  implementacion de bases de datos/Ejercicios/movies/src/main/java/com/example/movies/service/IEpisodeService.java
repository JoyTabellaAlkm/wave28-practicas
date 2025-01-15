package com.example.movies.service;

import com.example.movies.entity.Episode;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IEpisodeService {
    List<Episode> listEpisodesByActor(String firstName, String lastName);
}
