package com.bootcamp.Movies.service;

import com.bootcamp.Movies.dto.SerieSeasonsCountDto;

import java.util.List;

public interface ISerieService {
    List<SerieSeasonsCountDto> seriesWithSeasonsNumberGreaterThan(Integer seasonsNumber);
}
