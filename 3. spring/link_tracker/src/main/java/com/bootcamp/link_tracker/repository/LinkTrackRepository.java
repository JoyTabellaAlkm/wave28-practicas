package com.bootcamp.link_tracker.repository;

import com.bootcamp.link_tracker.dto.LinkTrackDTO;

import java.util.List;

public interface LinkTrackRepository {
    List<LinkTrackDTO> findAll();
    LinkTrackDTO save(LinkTrackDTO linkTrack);
    LinkTrackDTO findById(Long id);
    LinkTrackDTO update(LinkTrackDTO linkTrack);
}
