package com.example.movies.service;

import com.example.movies.entity.Episode;
import com.example.movies.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EpisodeServiceImpl implements IEpisodeService{
    @Autowired
    EpisodeRepository episodeRepository;
    @Override
    public List<Episode> listEpisodesByActor(String firstName, String lastName) {
        return episodeRepository.findEpisodesByActor(firstName,lastName);
    }
}
