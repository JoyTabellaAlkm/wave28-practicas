package com.example.movies_api.service.impl;

import com.example.movies_api.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;


}
