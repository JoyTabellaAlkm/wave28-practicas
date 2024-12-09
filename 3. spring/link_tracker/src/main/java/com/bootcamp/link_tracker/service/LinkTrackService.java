package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.LinkTrackDTO;

import java.util.List;

public interface LinkTrackService {

    LinkTrackDTO createLinkTrack(LinkTrackDTO linkTrackDTO);
    List<LinkTrackDTO> findAll();
    LinkTrackDTO findById(Long id);

    String redirectById(Long linkId);
}
